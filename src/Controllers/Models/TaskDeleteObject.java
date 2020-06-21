package Controllers.Models;

import DataAccess.Models.Tasks.TaskBuilder;

public class TaskDeleteObject {
	
	private String _name;
	
	public String getName() {
		return _name;
	}
	
	public TaskDeleteObject(TaskBuilder taskBuilder) {
		
		this._name = taskBuilder.getName();
	}
}
