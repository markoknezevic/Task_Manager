package DataAccess.Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DataAccess.DatabaseConnection;
import DataAccess.Models.Users.User;
import DataAccess.Models.Users.UserBuilder;

public class UserRepository extends Repository implements IUserRepository{

	public UserRepository(Connection databaseConnection) {
		super(databaseConnection);
	}

	@Override
	public boolean registerUser(User user) {
		
		String sql = "INSERT INTO user VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			
			PreparedStatement preparedStatement = databaseConnection.prepareStatement(sql);
			
			preparedStatement.setString(1, user.getJmbg());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getName());
			preparedStatement.setString(6, user.getLastname());
		  
			preparedStatement.executeUpdate();
		    
		} catch (SQLException e) {
			e.printStackTrace();
			
			return false;
		}	
		
		return true;
	}
	
	@Override
	public synchronized boolean isEmailTaken(String email) {
		
		String sqlCommand = "SELECT COUNT(*) as email_count FROM user WHERE email = '" +email+"'";
		
		boolean result = false;
		
		try {
			
			Statement statement = databaseConnection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sqlCommand);
			
			if(resultSet.getInt("email_count") != 0) {
				
				result = true;
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public synchronized boolean isUsernameTaken(String username) {
		
		String sqlCommand = "SELECT COUNT(*) as username_count FROM user WHERE username = '" +username+"'";
		
		boolean result = false;
		
		try {
			
			Statement statement = databaseConnection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sqlCommand);
			
			if(resultSet.getInt("username_count") != 0) {
				
				result = true;
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public User logUser(String username, String password) {
		
		String sqlCommand = "SELECT * FROM user WHERE username = '" +username+"' AND password = '" + password+"'";
		
		User user = null;
		
		try {
			
			Statement statement = databaseConnection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sqlCommand);
			
			String jmbg = resultSet.getString("jmbg");
			String uname = resultSet.getString("username");
			String email = resultSet.getString("email");
			String pass = resultSet.getString("password");
			String name = resultSet.getString("name");
			String lastname = resultSet.getString("lastname");
			
			user = new User(new UserBuilder().buildUser(jmbg,uname, email, pass, name, lastname));
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		String sqlCommand = "SELECT * FROM user WHERE username = '" +username+"'";
		
		User user = null;
		
		try {
			
			Statement statement = databaseConnection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sqlCommand);
			
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public boolean isJmbgTaken(String jmbg) {

		String sqlCommand = "SELECT COUNT(*) as jmbg_count FROM user WHERE jmbg = '" +jmbg+"'";
		
		boolean result = false;
		
		try {
			
			Statement statement = databaseConnection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sqlCommand);
			
			if(resultSet.getInt("jmbg_count") != 0) {
				
				result = true;
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return result;
	}
}
