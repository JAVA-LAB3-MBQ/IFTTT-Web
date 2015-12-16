package dao.impl;

import domain.User;
import dao.IUserDao;
import java.sql.*;

public class UserDaoImpl implements IUserDao{
	String url = "jdbc:mysql://localhost:3306/java" ;   
    String username = "root" ;    
    String password = "5555" ;  
	public User find(String userName, String userPwd){
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
	    	ResultSet resultSet = 
	    			statement.executeQuery("select * from user where name = \"" + userName + "\" && pwd = \"" + userPwd + "\"");
	    	if(resultSet.next()){
	    		String id = resultSet.getString(1);
	    		String registerTime = resultSet.getString(4);
	    		User t = new User(id, userName, userPwd, registerTime);
	    		return t;
	    	}	
	    }
	    catch(SQLException se){    
	    	System.out.println("Connection to Database Failed！");    
	    	se.printStackTrace() ;    
	    }  
	    return null;
	}
	
	public User find(String userId) {
		// todo : get the user 
		return null;
	}
	public void add(User user){
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
	    		System.out.println("The user name has already exists!");
	    		return;
	    	}
	    	
	    	System.out.println("IUserDaoImpl 59" + user.getId());	
	    	String statementString2 = "insert into user values(\"" + user.getId() + "\",\"" + user.getName() + "\",\"" + user.getPwd() + "\",\"" + user.getRegisterTime() + "\")";
	    //	System.out.println(statementString);
	    	statement.executeUpdate(statementString2);
	     }
	     catch(SQLException se){    
	    	System.out.println("Connection to Database Failed！");    
	    	se.printStackTrace() ;    
	     }   
	}
}
