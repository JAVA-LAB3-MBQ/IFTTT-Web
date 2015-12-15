package domain;

public class ThenThatSendMail extends ThenThat{
	private String thatSrcEmailId;
	private String thatSrcEmailPwd;
	private String thatDestEmailId;
	private String thatEmailContent;

	public ThenThatSendMail(String userId, String did, String c) {
		// todo : get user's email and id
		thatDestEmailId = did;
		thatEmailContent = c;
		
		this.setThatType(ThenThat.thatSendMailTypeValue);
	}
	
	public boolean doIt() {
		// todo:
		return false;
	}
}
