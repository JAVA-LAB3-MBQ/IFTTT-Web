package domain;

public abstract class IfThis {
	public final static int thisReceiveMailTypeValue = 1;
	public final static int thisTimeTypeValue = 2;
	public final static int thisListenWeiboTypeValue = 3; 
	String thisId;
	int thisType;
	
	public String getThisId() {
		return thisId;
	}
	
	public void setThisId(String id) {
		thisId = id;
	}
	
	public int getThisType() {
		return thisType;
	}
	
	public void setThisType(int ty) {
		thisType = ty;
	}
	
	abstract boolean ifHappened(); // must be override
}
