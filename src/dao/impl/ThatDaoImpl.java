package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import dao.IThatDao;
import domain.ThenThatSendMail;
import domain.ThenThatSendWeibo;

public class ThatDaoImpl implements IThatDao {
	public boolean addThat(ThenThatSendWeibo that_) {
		// todo: add ThenThatSendWeibo to db
		try{
		    Class.forName("com.mysql.jdbc.Driver") ; 
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		    System.out.println("Driver Class Not Found, Loader Failure!");  //找不到驱动程序类 ，加载驱动失败
		}  
	    try{ 
	    	Connection con =     
	    			DriverManager.getConnection(domain.DatabaseInfo.url , domain.DatabaseInfo.username , domain.DatabaseInfo.password ) ; 
	    
	    	Statement statement = con.createStatement();
	    	
	    	String update = "insert into ThenThatSendMail values(\" " + that_.getThatId() + "\",\""+ that_.getThatWeiboId() + "\",\"" + that_.getThatWeiboAccessToken() + "\",\"" + that_.getThatWeiboPwd() + "\",\"" + that_.getThatWeiboContent() + "\");" ;
	    	statement.executeUpdate(update);
	    	con.close();
	     }
	     catch(SQLException se){    
	    	System.out.println("Connection to Database Failed!");    
	    	se.printStackTrace() ;    
	     }  
		return true;
	}
	public boolean addThat(ThenThatSendMail that_) {
		// todo: add ThenThatSendMail to db
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
	
	    	String update = "insert into ThenThatSendMail values(\"" + that_.getThatId() + "\",\""+ that_.getThatSrcEmailId() + "\",\"" + that_.getThatSrcEmailPwd() + "\",\"" + that_.getThatDestEmailId() + "\",\"" + that_.getThatEmailContent() + "\");" ;
	    	statement.executeUpdate(update);
	    	con.close();
	     }
	     catch(SQLException se){    
	    	System.out.println("Connection to Database Failed！");    
	    	se.printStackTrace();    
	     }  
		return true;
	}
	
	public boolean removeThat(ThenThatSendWeibo that_) {
		// todo: remove ThenThatSendWeibo from db
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("Driver Class Not Found, Loader Failure!");
		}
		try{
			Connection con =
					DriverManager.getConnection(domain.DatabaseInfo.url, domain.DatabaseInfo.username, domain.DatabaseInfo.password);
			Statement statement = con.createStatement();
			String query = "select * from ThenThatSendMail where thatWeiboId = \"" + that_.getThatWeiboId() + "\"" + " && thatWeiboPwd = " + "\"" + that_.getThatWeiboPwd() + "\"" + " && thatWeiboContent = \"" + that_.getThatWeiboContent() + "\"";
			if(statement.executeQuery(query) == null)return false;
			String statementString = "delete from ThenThatSendMail where thatWeiboId = \"" + that_.getThatWeiboId() + "\" && thatWeiboPwd = " + "\"" + that_.getThatWeiboPwd() + "\"" + " && thatWeiboContent = \"" + that_.getThatWeiboContent() + "\"" ;
			statement.executeUpdate(statementString);
			con.close();
		}
		catch(SQLException se){
			System.out.println("Connection to Database Failed!");
			se.printStackTrace();
		}
		return true;
	}
	public boolean removeThat(ThenThatSendMail that_) {
		// todo: remove ThenThatSendMail from db
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
	    	String queryString = "select * from ThenThatSendMail where thatSrcEmailId = " + "\"" + that_.getThatSrcEmailId() + "\" && thatDestEmailId = " + "\"" + that_.getThatDestEmailId() + "\" && thatEmailContent = " + that_.getThatEmailContent();
	    	if(statement.executeQuery(queryString) == null)
	    		return false;
	    	String statementString = "delete "
	    			+ "from ThenThatSendMail "
	    			+ "where thatSrcEmailId = " + "\"" + that_.getThatSrcEmailId() + "\" && thatDestEmailId = " + "\"" + that_.getThatDestEmailId() + "\" && thatEmailContent = " + that_.getThatEmailContent();
	    	statement.executeUpdate(statementString);
	    	con.close();
	     }
	     catch(SQLException se){    
	    	System.out.println("Connection to Database Failed！");    
	    	se.printStackTrace() ;    
	     }  
		return true;
	}
	
}
