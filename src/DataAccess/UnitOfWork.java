package DataAccess;

import java.sql.Connection;

import DataAccess.Repositories.ITaskRepository;
import DataAccess.Repositories.IUserRepository;
import DataAccess.Repositories.TaskRepository;
import DataAccess.Repositories.UserRepository;

public class UnitOfWork implements IUnitOfWork {
	
	private static UnitOfWork unitOfWork;
	
	private IUserRepository userRepository;
	private ITaskRepository taskRepository;
	
	private UnitOfWork() {
		Connection databaseConnection = DatabaseConnection.getConnection();
			
		userRepository =  new UserRepository(databaseConnection);
		taskRepository =  new TaskRepository(databaseConnection);
	}
	
	public static UnitOfWork getUnitOfWorkInstance() {
		
		if(unitOfWork == null) {
			unitOfWork = new UnitOfWork();
		}
		
		return unitOfWork;
	}
	
	@Override
	public IUserRepository userRepository() {
		
		return userRepository;
	}

	@Override
	public ITaskRepository taskRepository() {
		
		return taskRepository;
	}
}
