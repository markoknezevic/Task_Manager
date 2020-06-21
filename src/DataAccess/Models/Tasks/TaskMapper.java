package DataAccess.Models.Tasks;

import Controllers.Models.TaskPostObject;
import DataAccess.Models.Users.User;

public class TaskMapper {

	public static Task taskPostObjectToTask(TaskPostObject taskPostObject) {
		
		Task task = new Task(new TaskBuilder().buildTask(User.getLoggedUser().getJmbg(),
							 							 taskPostObject.getName(),
							                             taskPostObject.getDescription()));
		
		return task;
	}
}
