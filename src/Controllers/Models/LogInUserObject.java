package Controllers.Models;

import DataAccess.Models.Users.UserBuilder;

public class LogInUserObject {

	private String _username;
	
	private String _password;
	
	public String getUsername() {
		return _username;
	}

	public String getPassword() {
		return _password;
	}

	public LogInUserObject(UserBuilder userBuilder) {
		
		this._username = userBuilder.getUsername();
		this._password = userBuilder.getPassword();
	}
}
