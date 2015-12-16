package service.impl;

import domain.IfThis;
import domain.Task;
import domain.ThenThat;
import service.ITaskService;
import dao.impl.TaskDaoImpl;

public class TaskServiceImpl implements ITaskService {
	public Task addTask(String userId, String tId, String tName, IfThis this_, ThenThat that_) {
		// todo:
		// construct a task, 
		Task task = new Task();
				
		// add this_ into database
		this_.add2Db();
	    // add that_ into database
        this_.add2Db();
		// add task into database
		
        
        return task;
	}
	
	public Task editTask(String userId, String tId, String tName, IfThis this_, ThenThat that_) {
		// todo:
		// change task
		// remove oldThis and oldThat from DataBase
		// insert new this_ and new that_
		return null;
	}

	public Task removeTask(String userId, Task task) {
		// todo:
		// remove from database 
		// remove from user
		return null;
	}
	
	public boolean startTask(String taskId) {
		// todo: start it
		TaskDaoImpl tdb = new TaskDaoImpl();
		return tdb.startTask(taskId);
	}
	
	public boolean pauseTask(String taskId) {
		// todo: start it
	    TaskDaoImpl tdb = new TaskDaoImpl();
		return tdb.pauseTask(taskId);
	}
}
