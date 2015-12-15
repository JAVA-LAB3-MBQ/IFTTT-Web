package domain;

public class IfThisTime extends IfThis{
	String goalTime;
	
	public IfThisTime(String t) {
		goalTime = t;
		
		this.setThisType(IfThis.thisTimeTypeValue);
	}
	
	public boolean ifHappened() {
		// todo:
		return false;
	}
}
