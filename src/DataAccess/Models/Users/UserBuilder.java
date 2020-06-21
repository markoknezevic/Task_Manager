package DataAccess.Models.Users;

public class UserBuilder {
	private String _jmbg;
	private String _username;
	private String _email;
	private  String _password;
	private String _name;
	private String _lastname;
	
	public String getJMBG() {
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

	public UserBuilder buildUser(String username, String email, String password, String name, String lastname) {
		
		this._username = username;
		this._email = email;
		this._password = password;
		this._name = name;
		this._lastname = lastname;
		
		return this;
	}
	
	public UserBuilder buildUser(String jmbg,String username, String email, String password, String name, String lastname) {
		
		this._jmbg = jmbg;
		this._username = username;
		this._email = email;
		this._password = password;
		this._name = name;
		this._lastname = lastname;
		
		return this;
	}
	
	public UserBuilder buildUser(String username, String password) {
		
		this._username = username;
		this._password = password;
		
		return this;
	}
}
