package service.impl;

import domain.IfThis;

import domain.Task;
import domain.ThenThat;
import domain.User;
import service.IUserService;
import util.WeiboAccessToken;
import dao.impl.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.IfThisTime;
import domain.ThenThatSendMail;
public class UserServiceImpl implements IUserService {
    public static void main(String args[]){
    	try{
    		
		    Class.forName("com.mysql.jdbc.Driver") ;    
	    	Connection con =     
	    			DriverManager.getConnection(domain.DatabaseInfo.url , domain.DatabaseInfo.username , domain.DatabaseInfo.password ) ; 
	    	
//	    	String temp1 = "create table User(userId char(32), userName char(32), userPwd char(32), registerTime char(32), userLevel int, userScore int, userRole int, userStatus int, userMoney int, userEmailAddr char(32), userEmailPwd char(32), userWeiboId char(32), userWeiboAccessToken char(32), userWeiboPwd char(32));";
//	    	String temp2 = "create table Task(userId char(32), taskId char(32), taskName char(32), thisId char(32), thatId char(32), thisType int, thatType int, thisIconPath char(32), thatIconPath char(32), createTime char(32), taskStatus int);" ;
//	    	String temp3 = "create table IfThisListenWeibo(thisWeiboId char(32), thisWeiboContent char(32), thisTimeLen char(32));";
//	    	String temp4 = "create table IfThisReceiveMail(thisEmailId char(32), thisEmailPwd char(32));";
//	    	String temp5 = "create table IfThisTime(goalTime char(32));";
//	    	String temp6 = "create table ThenThatSendMail(thatSrcEmailId char(32), thatSrcEmailPwd char(32), thatDestEmailId char(32), thatEmailContent char(32));";				
//	        String temp7 = "create table ThenThatSendWeibo(thatWeiboId char(32), thatWeiboPwd char(32), thatWeiboContent char(32))";
	    	
	    	
	        Statement statement = con.createStatement();
			IfThisTime temp = new IfThisTime("2015-12-19 13:59");
			ThenThatSendMail t = new ThenThatSendMail("547504175@qq.com","cozzrzxvntiebcdh","547504175@qq.com","hello");
			t.add2Db();
			while(true){
				if(temp.ifHappened() == true){
					t.doIt();
					break;
				}
			}
			statement.close();
			con.close();
//          statement.executeUpdate(temp1);
//			statement.executeUpdate(temp2);
//			statement.executeUpdate(temp3);
//			statement.executeUpdate(temp4);
//			statement.executeUpdate(temp5);
//			statement.executeUpdate(temp6);
//			statement.executeUpdate(temp7);
	    	
	     }
	    catch(ClassNotFoundException e){
			e.printStackTrace();
		    System.out.println("Driver Class Not Found, Loader Failure！");  //找不到驱动程序类 ，加载驱动失败
		} 
	    catch(SQLException se){    
	    	System.out.println("Connection to Database Failed！");    
	    	se.printStackTrace() ;    
	    }  
    }
	public User registerUser(User user)throws Exception{
		try{
		    Class.forName("com.mysql.jdbc.Driver") ; 
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		    System.out.println("Driver Class Not Found, Loader Failure！");  //找不到驱动程序类 ，加载驱动失败
		}  
	    try{ 
	    	Connection con =     
	    			DriverManager.getConnection(domain.DatabaseInfo.url , domain.DatabaseInfo.username , domain.DatabaseInfo.password ) ; 
	    
	    	Statement statement = con.createStatement();
	    	
	    	String statementString1 = "select * from user where name = \"" + user.getName() + "\"" ;
	    	ResultSet resultSet = 
	    			statement.executeQuery(statementString1);
	    	if(resultSet.next()){
	    		System.out.println(" in register The user name has already exists!");
	    		return null;
	    	}
	     }
	     catch(SQLException se){    
	    	System.out.println("Connection to Database Failed！");    
	    	se.printStackTrace() ;    
	     }  
	    UserDaoImpl m = new UserDaoImpl();
		m.add(user);
		return user;
		
	}
	
	public User loginUser(String userName, String userPwd){
		UserDaoImpl t = new UserDaoImpl();
		User user = t.find(userName, userPwd);
		if(user != null) {
			t.changeUserStatus(user.getId(), User.loggedIn); // from User.loggedOut to User.loggedIn
		}
		
		return user;
	}	
	
	public User getUserInfo(String uId) {
		UserDaoImpl udb = new UserDaoImpl();
		User user = udb.find(uId);
		
		return user;
	}
	
	public ArrayList<Task> getUserTasks(String userId) {
		TaskDaoImpl tdb = new TaskDaoImpl();
		ArrayList<Task> tasks = tdb.getTasks(userId);
		
		return tasks;
	}
	
	public User editUserInfo(String uId, String mail, String mailPwd, String weiboId, String weiboPwd) {
		UserDaoImpl udb = new UserDaoImpl();
		User user = udb.find(uId);
		String new_access_token;
		
		// get a new weibo access_token ?
		if(weiboId.equals(user.getUserWeiboId()) ) {
			new_access_token = WeiboAccessToken.getAccessToken(weiboId, weiboPwd);
		}
		else {
			new_access_token = WeiboAccessToken.refreshAccessToken(weiboId, weiboPwd);
		}
		
		// don't change user's id, money, level score
		// change user's information, constructing a new user
		user.setUserEmailAddr(mail);
		user.setUserEmailPwd(mailPwd);
		user.setUserWeiboPwd(weiboId);
		user.setUserWeiboPwd(weiboPwd);
		user.setUserWeiboAccessToken(new_access_token);
		
		// remove old user
		udb.remove(uId);
		// add new user
		udb.add(user);
		
		return user;
	}
	
	public void signOut(String userId) {
		// change user's status from loggedIn to loggedOut in database
		UserDaoImpl udb = new UserDaoImpl();
		udb.changeUserStatus(userId, User.loggedOut);
	}
}
