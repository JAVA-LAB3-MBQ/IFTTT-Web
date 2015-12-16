package dao;

import domain.*;

public interface IUserDao {
	public User find(String userName, String userPwd);
	public void add(User user);
	public User find(String userId);
}
