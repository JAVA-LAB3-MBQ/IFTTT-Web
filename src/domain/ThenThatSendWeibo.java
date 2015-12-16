package domain;

public class ThenThatSendWeibo extends ThenThat{
	private String thatWeiboId;
	private String thatWeiboAccessToken;
	private String thatWeiboPwd;
	private String thatWeiboContent;

	public ThenThatSendWeibo() {
		this.setThatType(ThenThat.thatSendWeiboTypeValue);
	}
	
	public ThenThatSendWeibo(String userId, String c) {
		// todo: get user's weiboId and accessToken, weibopwd
		thatWeiboContent = c;
		
		this.setThatType(ThenThat.thatSendWeiboTypeValue);
	}
	
	public boolean doIt() {
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
