package domain;

public class ThenThatSendMail extends ThenThat{
	private String thatSrcEmailId;
	private String thatSrcEmailPwd;
	private String thatDestEmailId;
	private String thatEmailContent;

	public ThenThatSendMail() {
		this.setThatType(ThenThat.thatSendMailTypeValue);
	}
	
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
	
	public boolean add2Db() {
		// todo: call method about Db(in dao) to insert this to Db
		return false;
	}
	
	public boolean removeFromDb() {
		// todo: call method about Db(in dao) to remove this from Db
		return false;
	}
}
