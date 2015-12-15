package web.formbean;

public class UserInfoFormBean {
	String userId, userName, userMail, userMailPwd, userWeiboId, userWeiboPwd;
    int userScore, userLevel, userMoney;
    
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
    
    public String getUserMail() {
    	return userMail;
    }
    
    public void setUserMail(String m) {
    	userMail = m;
    }
    
    public String getUserMailPwd() {
    	return userMailPwd;
    }
    
    public void setUserMailPwd(String mp) {
    	userMailPwd = mp;
    }
    
    public String getUserWeiboId() {
    	return userWeiboId;
    }
    
    public void setUserWeiboId(String wbi) {
    	userWeiboId = wbi;
    }
    
    public String getUserWeiboPwd() {
    	return userWeiboPwd;
    }
    
    public void setUserWriboPwd(String w) {
    	userWeiboPwd = w;
    }
    
    public int getUserScore() {
    	return userScore;    
    }
    
    public void setUserScore(int i) {
    	userScore = i;
    }
    
    public int getUserLevel() {
    	return userLevel;
    }
    
    public void setUserLevel(int l ) {
    	userLevel = l;
    }
    
    public int getUserMoney() {
    	return userMoney;
    }
    
    public void setUserMoney(int i) {
    	userMoney = i;
    }
}
