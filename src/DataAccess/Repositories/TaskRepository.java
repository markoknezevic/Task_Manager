package DataAccess.Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import DataAccess.Models.Tasks.Task;
import DataAccess.Models.Tasks.TaskBuilder;


public class TaskRepository extends Repository implements ITaskRepository{

	public TaskRepository(Connection databaseConnection) {
		super(databaseConnection);
	}

	@Override
	public boolean addTask(Task task) {
		
		String sql = "INSERT INTO task VALUES(?, ?, ?)";
		
		try {
			
			PreparedStatement preparedStatement = databaseConnection.prepareStatement(sql);
			
			preparedStatement.setString(1, task.getUserJmbg());
			preparedStatement.setString(2, task.getName());
			preparedStatement.setString(3, task.getDescription());

			preparedStatement.executeUpdate();
		    
		} catch (SQLException e) {
			e.printStackTrace();
			
			return false;
		}	
		
		return true;
	}

	@Override
	public boolean deleteTask(String userJmbg, String taskName) {
		
		String sql = "DELETE FROM task WHERE user_jmbg = ? AND name = ? ";
		
		try {
			
			PreparedStatement preparedStatement = databaseConnection.prepareStatement(sql);
			
			preparedStatement.setString(1, userJmbg);
			preparedStatement.setString(2, taskName);

			preparedStatement.executeUpdate();
		    
		} catch (SQLException e) {
			e.printStackTrace();
			
			return false;
		}	
		
		return true;
	}

	@Override
	public ArrayList<Task> getAllTasks(String userJmbg) {
		
		String sqlCommand = "SELECT * FROM task WHERE user_jmbg = '" +userJmbg+"'";
		
		ArrayList<Task> tasks = new ArrayList<Task>();
		
		try {
			
			Statement statement = databaseConnection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sqlCommand);
			
			while (resultSet.next()){
				
				String taskName = resultSet.getString("name");
				String taskDescription = resultSet.getString("description");
			
				tasks.add(new Task(new TaskBuilder().buildTask(userJmbg, taskName, taskDescription)));
		    }
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return tasks;
	}
	
	@Override
	public boolean isTaskExists(String userJmbg, String taskName) {
		
		String sqlCommand = "SELECT COUNT(*) as task_count FROM task WHERE user_jmbg = '" +userJmbg+"' AND name = '" +taskName+"'";
		
		boolean result = false;
		
		try {
			
			Statement statement = databaseConnection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sqlCommand);
			
			if(resultSet.getInt("task_count") != 0) {
				
				result = true;
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return result;
	}
}	
