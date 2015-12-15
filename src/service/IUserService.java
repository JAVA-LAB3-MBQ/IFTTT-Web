package service;

import domain.*;
import java.util.ArrayList;

public interface IUserService {
	public User registerUser(User user)throws Exception;
	public User loginUser(String userName, String userPwd);
	
	public Task addTask(String userId, String tId, String tName, IfThis this_, ThenThat that_);
	
	public Task editTask(String userId, Task task, String tName, IfThis this_, ThenThat that_);
	
	public Task removeTask(String userId, Task task);
	
	public User getUser(String uId);
	
	public ArrayList<Task> getUserTasks(String userId);
}
