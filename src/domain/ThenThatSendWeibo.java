package domain;

public class ThenThatSendWeibo extends ThenThat{
	private String thatWeiboId;
	private String thatWeiboAccessToken;
	private String thatWeiboPwd;
	private String thatWeiboContent;

	public ThenThatSendWeibo(String id, String at, String pwd, String c) {
		thatWeiboId = id;
		thatWeiboAccessToken = at;
		thatWeiboPwd = pwd;
		thatWeiboContent = c;
	}
	
	public boolean doIt() {
		// todo:
		return false;
	}
}
