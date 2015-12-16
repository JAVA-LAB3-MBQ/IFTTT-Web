package domain;

public class IfThisListenWeibo extends IfThis{
	private String thisWeiboId;
	private String thisWeiboContent;
	private String thisTimeLen;
	
	public IfThisListenWeibo() {
		this.setThisType(IfThis.thisListenWeiboTypeValue);
	}
	
	public IfThisListenWeibo(String weiboId, String content, String t) {
		setThisWeiboId(weiboId);
		setThisWeiboContent(content);
		setThisTimeLen(t);
		
		this.setThisType(IfThis.thisListenWeiboTypeValue);
	}
	
	public String getThisWeiboId() {
		return thisWeiboId;
	}
	
	public void setThisWeiboId(String s) {
		thisWeiboId = s;
	}
	
	public String getThisWeiboContent() {
		return thisWeiboContent;
	}
	
	public void setThisWeiboContent(String c) {
		thisWeiboContent = c;
	}
	
	public String getThisTimeLen() {
		return thisTimeLen;
	}
	
	public void setThisTimeLen(String l) {
		thisTimeLen = l;
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
