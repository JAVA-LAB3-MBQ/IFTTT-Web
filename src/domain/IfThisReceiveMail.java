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
	
	public boolean ifHappened() {
		// todo:
		return false;
	}
}
