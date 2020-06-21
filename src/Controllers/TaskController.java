package Controllers;

import java.util.ArrayList;

import Controllers.Models.TaskDeleteObject;
import Controllers.Models.TaskPostObject;
import DataAccess.IUnitOfWork;
import DataAccess.Models.Tasks.Task;
import DataAccess.Models.Tasks.TaskMapper;
import DataAccess.Models.Users.User;

public class TaskController extends BaseController {

	public TaskController(IUnitOfWork unitOfWork) {
		super(unitOfWork);
	}

	public boolean addTask(TaskPostObject taskPostObject) {
		
		Task task = TaskMapper.taskPostObjectToTask(taskPostObject);
		
		boolean result = unitOfWork.taskRepository().addTask(task);
		
		return result;
	}
	
	public boolean deleteTask(TaskDeleteObject taskDeleteObject) {
		
		if(User.getLoggedUser() == null) {
			
			return false;
		}
		
		if(!unitOfWork.taskRepository().isTaskExists(User.getLoggedUser().getJmbg(), taskDeleteObject.getName())) {
			
			return false;
		}

		boolean result = unitOfWork.taskRepository().deleteTask(User.getLoggedUser().getJmbg(), taskDeleteObject.getName());
		
		return result;
	}
	
	public ArrayList<Task> getAllTasks(String userJmbg) {
		
		return unitOfWork.taskRepository().getAllTasks(userJmbg);
	}

}
