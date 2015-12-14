package service.impl;

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
}
