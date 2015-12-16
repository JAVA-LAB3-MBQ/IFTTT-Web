package domain;

public abstract class ThenThat {
	public final static int thatSendWeiboTypeValue = 1;
	public final static int thatSendMailTypeValue = 2; 
	private String thatId;
	private int thatType;
	private String thatIconPath;
	
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
	
	public String getThatIconPath() {
		return thatIconPath;
	}
	
	public void setThatIconPath(String iconp) {
		thatIconPath = iconp;
	}
	
	abstract public boolean doIt();
    abstract public boolean add2Db();
    abstract public boolean removeFromDb();
}
