package domain;

public class IfThisListenWeibo extends IfThis{
	private String thisWeiboId;
	private String thisWeiboContent;
	private String thisTimeLen;
	
	public IfThisListenWeibo(String id, String text, String time) {
		thisWeiboId = id;
		thisWeiboContent = text;
		thisTimeLen = time;
	}
	
	public boolean ifHappened() {
		// todo:
		return false;
	}
}
