package domain;

public class IfThisReceiveMail extends IfThis{
	public String thisEmailId;
	public String thisEmailPwd;

	public IfThisReceiveMail(String id, String pwd) {
		thisEmailId = id;
		thisEmailPwd = pwd;
	}
	
	public boolean ifHappened() {
		// todo:
		return false;
	}
}
