package DataAccess.Models.Users;

public class User {
	
	private static User loggedUser;

	private  String _jmbg;
	private  String _username;
	private  String _email;
	private  String _password;
	private  String _name;
	private  String _lastname;
	
	public static User getLoggedUser() {
		return loggedUser;
	}

	public static void setLoggedUser(User loggedUser) {
		User.loggedUser = loggedUser;
	}
	
	public String getJmbg() {
		return _jmbg;
	}
	
	public String getUsername() {
		return _username;
	}

	public String getEmail() {
		return _email;
	}

	public String getPassword() {
		return _password;
	}

	public String getName() {
		return _name;
	}

	public String getLastname() {
		return _lastname;
	}
	
	public User(UserBuilder userBuilder) {
		this._jmbg = userBuilder.getJMBG();
		this._username = userBuilder.getJMBG();
		this._username = userBuilder.getUsername();
		this._email = userBuilder.getEmail();
		this._password = userBuilder.getPassword();
		this._name = userBuilder.getName();
		this._lastname = userBuilder.getLastname();
	}
}
