package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IfThisListenWeibo extends IfThis{
	private String thisWeiboId;
	private String thisWeiboContent;
	private String thisTimeLen;
	private String thisWeiboPwd;
	
	public IfThisListenWeibo() {
		this.setThisType(IfThis.thisListenWeiboTypeValue);
	}
	
	public IfThisListenWeibo(String weiboId, String content, String t) {
		setThisWeiboId(weiboId);
		setThisWeiboContent(content);
		setThisTimeLen(t);
		
		this.setThisType(IfThis.thisListenWeiboTypeValue);
	}
	
	public String getThisWeiboId() {
		return thisWeiboId;
	}
	
	public void setThisWeiboId(String s) {
		thisWeiboId = s;
	}
	
	public String getThisWeiboContent() {
		return thisWeiboContent;
	}
	
	public void setThisWeiboContent(String c) {
		thisWeiboContent = c;
	}
	
	public String getThisTimeLen() {
		return thisTimeLen;
	}
	
	public void setThisTimeLen(String l) {
		thisTimeLen = l;
	}
	
	public boolean ifHappened() {
		// todo:
		return false;
	}
	
	public boolean add2Db() {
		// todo: call method about Db(in dao) to insert this to Db
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
	    	
	    	String statementString = "insert into IfThisListenWeibo values(\"" + thisWeiboId + "\",\"" + thisWeiboContent + "\",\"" + thisTimeLen + "\");" ;
	    	statement.executeUpdate(statementString);
	     }
	     catch(SQLException se){    
	    	System.out.println("Connection to Database Failed！");    
	    	se.printStackTrace() ;    
	     }  
		return true;
	}
	
	public boolean removeFromDb() {
		// todo: call method about Db(in dao) to remove this from Db
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
	    	
	    	String statementString = "delete "
	    			+ "from IfThisListenWeibo "
	    			+ "where thisWeiboId = \"" + thisWeiboId + "\"";
	    	statement.executeUpdate(statementString);
	     }
	     catch(SQLException se){    
	    	System.out.println("Connection to Database Failed！");    
	    	se.printStackTrace() ;    
	     }  
		return true;
	}
}
