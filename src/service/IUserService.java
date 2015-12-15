package service;

import domain.*;

public interface IUserService {
	public User registerUser(User user)throws Exception;
	public User loginUser(String userName, String userPwd);
	
	public Task addTask(User user, String tId, String tName, IfThis this_, ThenThat that_);
	
	public Task editTask(User user, Task task, String tName, IfThis this_, ThenThat that_);
	
	public Task removeTask(User user, Task task);
	
	public User getUser(String uId);
}
