package service.impl;

import domain.IfThis;
import domain.Task;
import domain.ThenThat;
import domain.User;
import service.IUserService;
import dao.impl.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserServiceImpl implements IUserService {
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
	    UserDaoImpl m = new UserDaoImpl();
		m.add(user);
		return user;
		
	}
	public User loginUser(String userName, String userPwd){
		UserDaoImpl t = new UserDaoImpl();
		return t.find(userName, userPwd);
	}	
	
	public User getUserInfo(String uId) {
	   // todo:
	   // construct a user, Tasks and messages....can be null
		UserDaoImpl udb = new UserDaoImpl();
		User user = udb.find(uId);
		
		return user;
	}
	
	public ArrayList<Task> getUserTasks(String userId) {
		// todo: get tasks from the DataBase
		TaskDaoImpl tdb = new TaskDaoImpl();
		ArrayList<Task> tasks = tdb.getTasks(userId);
		
		return tasks;
	}
}
