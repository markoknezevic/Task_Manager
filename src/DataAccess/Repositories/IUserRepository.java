package DataAccess.Repositories;

import DataAccess.Models.Users.User;

public interface IUserRepository {
	
	public boolean registerUser(User user);
	
	public boolean isEmailTaken(String email);
	
	public boolean isUsernameTaken(String username);
	
	public User logUser(String username, String password);
	
	public User getUserByUsername(String username);

	public boolean isJmbgTaken(String jmbg);
}
