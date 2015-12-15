package web.formbean;

public class UserMainFormBean {
	String userId, userName;
	int userScore, userLevel;

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String ui) {
		userId = ui;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String un) {
		userName = un;
	}
	
	public int getUserScore() {
		return userScore;
	}
	
	public void serUserScore(int s) {
		userScore = s;
	}
	
	public int getUserLevel() {
		return userLevel;
	}
	
	public void setUserLevel(int l) {
		userLevel = l;
	}
}
