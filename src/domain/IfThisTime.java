package domain;

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
