package dao.impl;

import java.util.ArrayList;

import dao.ITaskDao;
import domain.Task;

public class TaskDaoImpl implements ITaskDao {
	public boolean addTask(Task t) {
		// todo : add A Task to db
		return false;
	}
	
	public boolean removeTask(Task t) {
		// todo : remove the Task from db
		return false;
	}
	
	public ArrayList<Task> getTasks(String userId) {
		// todo : get the tasks of the user together
		ArrayList<Task> tasks = new ArrayList<Task>();
		
		return tasks; 
	}
}
