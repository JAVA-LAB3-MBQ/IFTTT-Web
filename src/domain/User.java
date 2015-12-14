package domain;

import java.io.Serializable;

public class User implements Serializable{
	private String userId;
	private String userName;
	private String userPwd;
	private String registerTime;
	public User(String name, String pwd){
		this.userName = name;
		this.userPwd = pwd;
	}
	
	public User() { }
	
	public User(String id, String name, String pwd){
		this.userId = id;
		this.userName = name;
		this.userPwd = pwd;
	}
	public User(String id, String name, String pwd, String registerTime){
		this.userId = id;
		this.userName = name;
		this.userPwd = pwd;
		this.registerTime = registerTime;
	}
	
	public void setId(String id){
		this.userId = id;
	}
	public void setName(String name){
		this.userName = name;
	}
	public void setPwd(String pwd){
		this.userPwd = pwd;
	}
	public void setRegisterTime(String registerTime){
		this.registerTime = registerTime;
	}
	public String getId(){
		return userId;
	}
	public String getName(){
		return userName;
	}
	public String getPwd(){
		return userPwd;
	}
	public String getRegisterTime(){
		return registerTime;
	}
}
