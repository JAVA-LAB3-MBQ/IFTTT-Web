package domain;

public class IfThisReceiveMail extends IfThis{
	public String thisEmailId;
	public String thisEmailPwd;

	public IfThisReceiveMail() {
		this.setThisType(IfThis.thisReceiveMailTypeValue);
	}
	
	public IfThisReceiveMail(String userId) {
		// todo: get user's email and emailpwd
		
		this.setThisType(IfThis.thisReceiveMailTypeValue);
		
	}
	
	public void setThisEmailId(String ea) {
		thisEmailId = ea;
	}
	
	public void setThisEmailPwd(String ep) {
		thisEmailPwd = ep;
	}
	
	public boolean ifHappened() {
		// todo:
		return false;
	}
	
	public boolean add2Db() {
		// todo: call method about Db(in dao) to insert this to Db
		return false;
	}
	
	public boolean removeFromDb() {
		// todo: call method about Db(in dao) to remove this from Db
		return false;
	}
}
