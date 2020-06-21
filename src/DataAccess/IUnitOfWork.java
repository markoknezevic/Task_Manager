package DataAccess;

import DataAccess.Repositories.ITaskRepository;
import DataAccess.Repositories.IUserRepository;

public interface IUnitOfWork {

	IUserRepository userRepository();
	
	ITaskRepository taskRepository();
}
