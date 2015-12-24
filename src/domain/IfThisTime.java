package domain;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import util.DateStringUtil;
public class IfThisTime extends IfThis{
	String goalTime;
	
	public IfThisTime() {
		this.setThisType(IfThis.thisTimeTypeValue);
	}
	
	public IfThisTime(String t) {
		setGoalTime(t);
		
		this.setThisType(IfThis.thisTimeTypeValue);
	}
	
	public void setGoalTime(String t) {
		goalTime = t;
	}
	
	public String getGoalTime() {
		return goalTime;
	}
	
	public boolean ifHappened() {
		// todo:
		String t = DateStringUtil.date2String(new Date());
//		System.out.println(goalTime);
//		System.out.println(t);
//		System.out.println(goalTime.equals(t));
		if(goalTime.equals(t))return true;
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
	    	
	    	String statementString = "insert into IfThisTime values( " + goalTime + ");" ;
	    	statement.executeUpdate(statementString);
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
			System.out.println("Driver Class Not Found, Loader Failure! ");
		}
		try{
			Connection con =
					DriverManager.getConnection(domain.DatabaseInfo.url, domain.DatabaseInfo.username, domain.DatabaseInfo.password);
			Statement statement = con.createStatement();
			String statementString1 = "select * from IfThisTime where goalTime = " + "\"" + goalTime + "\"";
			if(statement.executeQuery(statementString1) == null ) return false;
			
			String statementString = "delete from IfThisTime where goalTime = " + "\"" + goalTime + "\"";
			statement.executeUpdate(statementString);
		}
		catch(SQLException se){
			System.out.println("Connection to Database Failed!");
			se.printStackTrace();
		}
		return true;
	}
}
