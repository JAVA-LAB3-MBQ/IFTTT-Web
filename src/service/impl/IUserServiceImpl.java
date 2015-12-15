package service.impl;

import domain.IfThis;
import domain.Task;
import domain.ThenThat;
import domain.User;
import service.IUserService;
import dao.impl.IUserDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IUserServiceImpl implements IUserService {
	String url = "jdbc:mysql://localhost:3306/java" ;   
    String username = "root" ;    
    String password = "5555" ;  
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
	    			DriverManager.getConnection(url , username , password ) ;    
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
	    IUserDaoImpl m = new IUserDaoImpl();
		m.add(user);
		return user;
		
	}
	public User loginUser(String userName, String userPwd){
		IUserDaoImpl t = new IUserDaoImpl();
		return t.find(userName, userPwd);
	}
	
	public Task removeTask(User user, Task task) {
		// todo:
		// remove from database 
		// remove from user
		return null;
	}
	
	public User getUser(String uId) {
	   // todo:
	   // construct a user
		User user = new User();
		
		return user;
	}
	
	public Task addTask(User user, String tId, String tName, IfThis this_, ThenThat that_) {
		// todo:
		// construct a task, 
		Task task = new Task();
				
		// add this_ into database
	    // add that_ into database

		// add task into user
		return task;
	}
	
	public Task editTask(User user, Task task, String tName, IfThis this_, ThenThat that_) {
		// todo:
		// change task
		// remove oldThis and oldThat from DataBase
		// insert new this_ and new that_
		return task;
	}
}
