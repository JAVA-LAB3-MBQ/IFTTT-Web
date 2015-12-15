package domain;

public abstract class ThenThat {
	public final static int thatSendWeiboTypeValue = 1;
	public final static int thatSendMailTypeValue = 2; 
	String thatId;
	int thatType;
	
	public String getThatId() {
		return thatId;
	}
	
	public void setThatId(String id) {
		thatId = id;
	}
	
	public int getThatType() {
		return thatType;
	}
	
	public void setThatType(int ty) {
		thatType = ty;
	}
	
	abstract boolean doIt();
}
