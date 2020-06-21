package DataAccess.Models.Users;

import Controllers.Models.RegisterUserObject;

public class UserMapper {

	public static User registerUserToUserEntity(RegisterUserObject registerUserObject) {
		
		User user = new User(new UserBuilder().buildUser(registerUserObject.getJmbg(),
														 registerUserObject.getUsername(),
														 registerUserObject.getEmail(), 
														 registerUserObject.getPassword(), 
														 registerUserObject.getName(), 
														 registerUserObject.getLastname()));
		
		return user;
	}
}
