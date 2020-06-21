package Views;

import Controllers.TaskController;
import Controllers.UserController;
import Controllers.Models.LogInUserObject;
import Controllers.Models.TaskDeleteObject;
import Controllers.Models.TaskPostObject;
import DataAccess.UnitOfWork;
import DataAccess.Models.Tasks.TaskBuilder;
import DataAccess.Models.Users.User;
import DataAccess.Models.Users.UserBuilder;

public class Test {

	public static void main(String[] args) {
		
		UserController us = new UserController(UnitOfWork.getUnitOfWorkInstance());
		
		LogInUserObject logInUserObject = new LogInUserObject(new UserBuilder().buildUser("asd", "da"));
		
		boolean t = us.logInUser(logInUserObject);
		
		System.out.println(t);
		
		TaskController taskController = new TaskController(UnitOfWork.getUnitOfWorkInstance());
		
		//TaskDeleteObject taskDeleteObject = new TaskDeleteObject(new TaskBuilder().buildTask("test1"));
		//taskController.deleteTask(taskDeleteObject)	;
	}

}
