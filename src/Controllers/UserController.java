package Controllers;

import Controllers.Models.LogInUserObject;
import Controllers.Models.RegisterUserObject;
import DataAccess.IUnitOfWork;
import DataAccess.Models.Users.User;
import DataAccess.Models.Users.UserMapper;

public class UserController extends BaseController {

	public UserController(IUnitOfWork unitOfWork) {
		super(unitOfWork);
	}
	
	public boolean registerUser(RegisterUserObject registerUserObject) {
		
		final boolean[] registrationValidation = new boolean[3];
		
		Thread emailCheck = new Thread() {
			@Override
			public void run() {
				
				registrationValidation[0] = unitOfWork.userRepository().isEmailTaken(registerUserObject.getEmail());
			}
		};
		emailCheck.start();
		
		Thread usernameCheck = new Thread() {
			@Override
			public void run() {
				
				registrationValidation[1] = unitOfWork.userRepository().isUsernameTaken(registerUserObject.getUsername());
			}
		};
		usernameCheck.start();
		
		Thread jmbgCheck = new Thread() {
			@Override
			public void run() {
				
				registrationValidation[2] = unitOfWork.userRepository().isJmbgTaken(registerUserObject.getJmbg());
			}
		};
		jmbgCheck.start();
		
		try {
			emailCheck.join();
			usernameCheck.join();
			jmbgCheck.join();
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		
		if(registrationValidation[0] || registrationValidation[1] || registrationValidation[2]) {
			return false;
		}
		
		User user = UserMapper.registerUserToUserEntity(registerUserObject);
		
		boolean isUserRegistered = unitOfWork.userRepository().registerUser(user);
		
		return isUserRegistered;
	}
	
	public boolean logInUser(LogInUserObject logInUserObject) {
		
		boolean isUsernameExists = unitOfWork.userRepository().isUsernameTaken(logInUserObject.getUsername());
		
		if(!isUsernameExists) {
			return false;
		}
		
		User user = unitOfWork.userRepository().logUser(logInUserObject.getUsername(), logInUserObject.getPassword());
		if(user == null) {
			return false;
		}
		
		User.setLoggedUser(user);
		
		return true;
	}
}
