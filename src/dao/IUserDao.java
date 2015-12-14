package dao;

import domain.User;
public interface IUserDao {
	public User find(String userName, String userPwd);
	public void add(User user);
}
