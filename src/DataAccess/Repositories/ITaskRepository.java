package DataAccess.Repositories;

import java.util.ArrayList;

import DataAccess.Models.Tasks.Task;

public interface ITaskRepository {
	
	public boolean addTask(Task task);
	
	public boolean deleteTask(String userJmbg, String taskName);
	
	public ArrayList<Task> getAllTasks(String jmbg);
	
	public boolean isTaskExists(String userJmbg, String taskName);
}
