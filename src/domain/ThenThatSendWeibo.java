package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ThenThatSendWeibo extends ThenThat{
	private String thatWeiboId;
	private String thatWeiboAccessToken;
	private String thatWeiboPwd;
	private String thatWeiboContent;

	public ThenThatSendWeibo() {
		this.setThatType(ThenThat.thatSendWeiboTypeValue);
	}
	
	public ThenThatSendWeibo(String userId, String c) {
		// todo: get user's weiboId and accessToken, weibopwd
		thatWeiboContent = c;
		
		this.setThatType(ThenThat.thatSendWeiboTypeValue);
	}
	
	public boolean doIt() {
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
		    System.out.println("Driver Class Not Found, Loader Failure!");  //找不到驱动程序类 ，加载驱动失败
		}  
	    try{ 
	    	Connection con =     
	    			DriverManager.getConnection(domain.DatabaseInfo.url , domain.DatabaseInfo.username , domain.DatabaseInfo.password ) ; 
	    
	    	Statement statement = con.createStatement();
	    	
	    	String update = "insert into ThenThatSendMail values( " + thatWeiboId + "," + thatWeiboAccessToken + "," + thatWeiboPwd + "," + thatWeiboContent + ");" ;
	    	statement.executeUpdate(update);
	     }
	     catch(SQLException se){    
	    	System.out.println("Connection to Database Failed!");    
	    	se.printStackTrace() ;    
	     }  
		return true;
	}
	
	public boolean removeFromDb() {
		// todo: call method about Db(in dao) to remove this from Db
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
			String query = "select * from ThenThatSendMail where thatWeiboId = \"" + thatWeiboId + "\"" + " && thatWeiboPwd = " + "\"" + thatWeiboPwd + "\"" + " && thatWeiboContent = \"" + thatWeiboContent + "\"";
			if(statement.executeQuery(query) == null)return false;
			String statementString = "delete * from ThenThatSendMail where thatWeiboId = \"" + thatWeiboId + "\" && thatWeiboPwd = " + "\"" + thatWeiboPwd + "\"" + " && thatWeiboContent = \"" + thatWeiboContent + "\"" ;
			statement.executeUpdate(statementString);
		}
		catch(SQLException se){
			System.out.println("Connection to Database Failed!");
			se.printStackTrace();
		}
		return true;
	}
}
