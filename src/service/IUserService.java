package service;

import domain.User;
public interface IUserService {
	public User registerUser(User user)throws Exception;
	public User loginUser(String userName, String userPwd);
}
