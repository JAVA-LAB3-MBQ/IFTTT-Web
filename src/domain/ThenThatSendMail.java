package domain;

public class ThenThatSendMail extends ThenThat{
	private String thatSrcEmailId;
	private String thatSrcEmailPwd;
	private String thatDestEmailId;
	private String thatEmailContent;

	public ThenThatSendMail(String sid, String pwd, String did, String c) {
		thatSrcEmailId = sid;
		thatSrcEmailPwd = pwd;
		thatDestEmailId = did;
		thatEmailContent = c;
	}
	
	public boolean doIt() {
		// todo:
		return false;
	}
}
