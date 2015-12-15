package domain;

public class ThenThatSendWeibo extends ThenThat{
	private String thatWeiboId;
	private String thatWeiboAccessToken;
	private String thatWeiboPwd;
	private String thatWeiboContent;

	public ThenThatSendWeibo(String userId, String c) {
		// todo: get user's weiboId and accessToken, weibopwd
		thatWeiboContent = c;
		
		this.setThatType(ThenThat.thatSendWeiboTypeValue);
	}
	
	public boolean doIt() {
		// todo:
		return false;
	}
}
