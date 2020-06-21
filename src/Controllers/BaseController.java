package Controllers;

import DataAccess.IUnitOfWork;

public abstract class BaseController {
	
	IUnitOfWork unitOfWork;
	
	public BaseController(IUnitOfWork unitOfWork) {
		this.unitOfWork = unitOfWork;
	}
}
