package Controllers.Models;

import DataAccess.Models.Tasks.TaskBuilder;

public class TaskPostObject {

	private String _name;
	
	private String _description;
	
	public String getName() {
		return _name;
	}

	public String getDescription() {
		return _description;
	}
	
	public TaskPostObject(TaskBuilder taskBuilder) {
		
		this._name = taskBuilder.getName();
		this._description = taskBuilder.getDescription();
	}

}
