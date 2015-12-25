package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Properties;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Folder;
import javax.mail.Store;
import javax.mail.Message;
import javax.swing.JOptionPane;

import java.util.Date;

public class IfThisReceiveMail extends IfThis{
	public String thisEmailId;
	public String thisEmailPwd;

	public IfThisReceiveMail() {
		this.setThisType(IfThis.thisReceiveMailTypeValue);
		this.setThisInfo("Receive a new mail");
	}
	
	public IfThisReceiveMail(String userId) {
		// todo: get user's email and emailpwd
		
		this.setThisType(IfThis.thisReceiveMailTypeValue);
		this.setThisInfo("Receive a new mail");
	}
	
	public boolean ifHappened() {
		// todo:
		Date originTime = new Date();
		return checkIfReceiveMail(thisEmailId, thisEmailPwd, originTime);
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
	    	
	    	String statementString = "insert into IfThisReceiveMail values(\"" + thisEmailId + "\",\"" + thisEmailPwd + "\");" ;
	    	statement.executeUpdate(statementString);
	     }
	     catch(SQLException se){    
	    	System.out.println("Connection to Database Failed！");    
	    	se.printStackTrace() ;    
	     }  
		return true;
	}
	public static boolean checkIfReceiveMail(String username, String password, Date originTime) {
		boolean flag = false;
		
		// get host
		String[] temp = username.split("@");
		String host = "pop." + temp[1];
		
		try {
		    // Create empty properties
			Properties props = System.getProperties();  
			// debug  
			//props.setProperty("mail.debug", "true");  
		    props.put("mail.pop3.ssl.enable", "true");
		    // setup mail server
		    props.put("mail.pop3.host", host);
		    //port
		    props.put("mail.pop3.port", "995");
		    // Authenticate
			props.setProperty("mail.pop3.auth", "true");  
			// protocol name  
			props.setProperty("mail.transport.protocol", "pop3");  
		
		   // Get session
		   Session session = Session.getDefaultInstance(props, null);
		   // Get the store
		   Store store = session.getStore("pop3");
		   store.connect(host, username, password);
		
		   // Get folder
		   Folder folder = store.getFolder("INBOX");
		   folder.open(Folder.READ_ONLY);
		
		   // Get the latest received mail
		   int messages_count = folder.getMessageCount();
		   Message message = folder.getMessage(messages_count);
		   // check
		   Date latestTime = message.getSentDate();
		   if( latestTime.compareTo(originTime) > 0) flag = true;
		   else flag = false;
		
		   //Close connection 
		   folder.close(false);
		   store.close();
		   
		   // return result
		   return flag;
		}
		catch(NoSuchProviderException e) {
			JOptionPane.showMessageDialog(null, "邮箱地址有误");
			return false;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "接收邮件途中出现失败： 收件人 " + username);
		    return false;
		}
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
	    			+ "from IfthisReceiveMail "
	    			+ "where thisEmailId = \"" + thisEmailId + "\"";
	    	statement.executeUpdate(statementString);
	     }
	     catch(SQLException se){    
	    	System.out.println("Connection to Database Failed！");    
	    	se.printStackTrace() ;    
	     }  
		return true;
	}
	
	public void setThisEmailId(String ea) {
		thisEmailId = ea;
	}
	
	public String getThisEmailId() {
		return thisEmailId;
	}
	
	public void setThisEmailPwd(String ep) {
		thisEmailPwd = ep;
	}
	
	public String getThisEmailPwd() {
		return thisEmailPwd;
	}
}
