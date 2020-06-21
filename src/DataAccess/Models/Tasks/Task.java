package DataAccess.Models.Tasks;

public class Task {
	
	private String _userJmbg;
	
	private String _name;
	
	private String _description;
	
	public String getUserJmbg() {
		return this._userJmbg;
	}
	
	public String getName() {
		return this._name;
	}

	public String getDescription() {
		return this._description;
	}
	
	public Task(TaskBuilder taskBuilder) {
		
		this._userJmbg = taskBuilder.getUserJmbg();
		this._name = taskBuilder.getName();
		this._description = taskBuilder.getDescription();
	}
	
	@Override
	public String toString() {
		
		return _name + " " + this._description + " \n";
	}
}
