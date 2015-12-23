package domain;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;


import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;

public class ThenThatSendMail extends ThenThat{
	private String thatSrcEmailId;
	private String thatSrcEmailPwd;
	private String thatDestEmailId;
	private String thatEmailContent;

	public ThenThatSendMail() {
		this.setThatType(ThenThat.thatSendMailTypeValue);
	}
	
	public ThenThatSendMail(String userId, String did, String c) {
		// todo : get user's email and id
		thatSrcEmailId = userId;
		thatDestEmailId = did;
		thatEmailContent = c;
		
		this.setThatType(ThenThat.thatSendMailTypeValue);
	}
	public ThenThatSendMail(String thatSrcEmailId, String thatSrcEmailPwd, String thatDestEmailId, String thatEmailContent){
		this.thatSrcEmailId = thatSrcEmailId;
		this.thatSrcEmailPwd = thatSrcEmailPwd;
		this.thatDestEmailId = thatDestEmailId;
		this.thatEmailContent = thatEmailContent;
		this.setThatType(ThenThat.thatSendMailTypeValue);
	}
	
	public boolean doIt(){
		// todo:
		// get host by separating the 'from'
		String[] temp = thatSrcEmailId.split("@");
		String host = "smtp." + temp[1];
		try {
			Properties props = new Properties();  
		    // debug  
		    //props.setProperty("mail.debug", "true");  
		    // Authenticate
		    props.setProperty("mail.smtp.auth", "true");  
		    // Setup mail server
		    props.setProperty("mail.host", host);  
		    // protocol name  
		    props.setProperty("mail.transport.protocol", "smtp");  
		    // port
		    props.setProperty("mail.smtp.port", "25");
		
		    // Get session
		    Session session = Session.getInstance(props); 
		
		    // Define message
		    MimeMessage message = new MimeMessage(session);
		    message.setFrom(new InternetAddress(thatSrcEmailId));
		    message.addRecipient(Message.RecipientType.TO, new InternetAddress(thatDestEmailId));
		    message.setSubject("Java lab3");
		    message.setText(thatEmailContent);
		
	        // Send message
	        Transport transport = session.getTransport("smtp");
	        transport.connect(host, thatSrcEmailId, thatSrcEmailPwd);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
		}
	    catch(NoSuchProviderException e) {
			JOptionPane.showMessageDialog(null, "邮箱地址有误: 发件人 " + thatSrcEmailId + "收件人 " + thatDestEmailId);
		}
		catch(MessagingException e) {
			JOptionPane.showMessageDialog(null, "发送邮件失败: 发件人 " + thatSrcEmailId + "收件人 " + thatDestEmailId);
		}
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
//	    	String query = "select * from ThenThatSendMail;";
//	    	ResultSet res = statement.executeQuery(query);
//	    	while(res.next()){
//	    		if(thatSrcEmailId.equals(res.getString(1)) && thatSrcEmailPwd.equals(res.getString(2)) && thatDestEmailId.equals(res.getString(3)) && thatEmailContent.equals(res.getString(4))){
//	    			System.out.println("一样");
//	    			return false;//如果像数据库插入了重复内容，返回false
//	    		}
//	    	}
    	
	    	String update = "insert into ThenThatSendMail values(\"" + thatSrcEmailId + "\",\"" + thatSrcEmailPwd + "\",\"" + thatDestEmailId + "\",\"" + thatEmailContent + "\");" ;
	    	statement.executeUpdate(update);
	     }
	     catch(SQLException se){    
	    	System.out.println("Connection to Database Failed！");    
	    	se.printStackTrace();    
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
	    	String queryString = "select * from ThenThatSendMail where thatSrcEmailId = " + "\"" + thatSrcEmailId + "\" && thatDestEmailId = " + "\"" + thatDestEmailId + "\" && thatEmailContent = " + thatEmailContent;
	    	if(statement.executeQuery(queryString) == null)
	    		return false;
	    	String statementString = "delete "
	    			+ "from ThenThatSendMail "
	    			+ "where thatSrcEmailId = " + "\"" + thatSrcEmailId + "\" && thatDestEmailId = " + "\"" + thatDestEmailId + "\" && thatEmailContent = " + thatEmailContent;
	    	statement.executeUpdate(statementString);
	     }
	     catch(SQLException se){    
	    	System.out.println("Connection to Database Failed！");    
	    	se.printStackTrace() ;    
	     }  
		return true;
	}
}
