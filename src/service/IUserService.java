package service;

import domain.*;
import java.util.ArrayList;

public interface IUserService {
	public User registerUser(User user)throws Exception;
	
	public User loginUser(String userName, String userPwd);
	
	public User getUserInfo(String uId);
	
	public ArrayList<Task> getUserTasks(String userId);
	
	public User editUserInfo(String uId, String mail, String mailPwd, String weiboId, String weiboPwd);

	public void signOut(String userId);
}
