package DataAccess.Models.Tasks;


public class TaskBuilder {
	
	private String userJmbg;
	
	private String name;
	
	private String description;
	
	public String getUserJmbg() {
		return this.userJmbg;
	}
	
	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}
	
	public TaskBuilder buildTask(String name, String description) {
		
		this.name = name;
		this.description = description;
		
		return this;
	}
	
	public TaskBuilder buildTask(String userJmbg, String name, String description) {
		
		this.userJmbg = userJmbg;
		this.name = name;
		this.description = description;
		
		return this;
	}
	
	public TaskBuilder buildTask(String name) {
		
		this.name = name;
		
		return this;
	}
}
