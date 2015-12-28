package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
	
	public ThenThatSendWeibo(String userId, String weiboContent) {
		// todo: get user's weiboId and accessToken, weibopwd
		thatWeiboContent = weiboContent;
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
	    	
	    	String statementString1 = "select userWeiboId,userWeiboAccessToken,userWeiboPwd from User where userId = \"" + userId + "\";" ;
	    	ResultSet res = 
	    			statement.executeQuery(statementString1);
    		
	    	if(res.next()){
	    		thatWeiboId = res.getString("userWeiboId");
	    		thatWeiboAccessToken = res.getString("userWeiboAccessToken");
	    		thatWeiboPwd = res.getString("userWeiboPwd");
	    	}
	     }
	     catch(SQLException se){    
	    	System.out.println("Connection to Database Failed！");    
	    	se.printStackTrace() ;    
	     } 
		
		this.setThatType(ThenThat.thatSendWeiboTypeValue);
		this.setThatInfo("Send a weibo: WeiboId-" + thatWeiboId + ";content-" + thatWeiboContent);
		
	}
	
	public String getThatWeiboId(){
		return thatWeiboId;
	}
	public String getThatWeiboAccessToken(){
		return thatWeiboAccessToken;
	}
	public String getThatWeiboPwd(){
		return thatWeiboPwd;
	}
	public String getThatWeiboContent(){
		return thatWeiboContent;
	}
	
	public void setThatWeiboId(String thatWeiboId){
		this.thatWeiboId = thatWeiboId;
	}
	public void setThatWeiboAccessToken(String thatWeiboAccessToken){
		this.thatWeiboAccessToken = thatWeiboAccessToken;
	}
	public void setThatWeiboPwd(String thatWeiboPwd){
		this.thatWeiboPwd = thatWeiboPwd;
	}
	public void setThatWeiboContent(String thatWeiboContent){
		this.thatWeiboContent = thatWeiboContent;
	}
	public boolean doIt() {
		// todo:
		return false;
	}
	
	public boolean add2Db() {
		// todo: call method about Db(in dao) to insert this to Db
		dao.impl.ThatDaoImpl t = new dao.impl.ThatDaoImpl();
		return t.addThat(this);
	}
	
	public boolean removeFromDb() {
		// todo: call method about Db(in dao) to remove this from Db
		dao.impl.ThatDaoImpl t = new dao.impl.ThatDaoImpl();
		return t.removeThat(this);
	}
}
