package web.formbean;

public class ATaskFormBean {
	private String userId;
	private String thisIconPath, thatIconPath;
	private String listenWbId, listenWbText, listenTimeLen;
	private String destMailAddr, sendContent;
    private String goalTime;
    private int thisType, thatType;
    private Task selectedTask;
    
    public String getUserId() { 
    	return userId; 
    }
    
    public void setUserId(String uId) {
    	userId = uId;
    }
    
    public String getThisIconPath() { 
    	return thisIconPath;
    }
    
    public void setThisIconPath(String thisIP) {
    	thisIconPath = thisIP;
    }
    
    public String getThatIconPath() {
    	return thatIconPath;
    }
    
    public void setThatIconPath(String thatIP) {
    	thatIconPath = thatIP;
    }
    
    public String getListenWbId() {
    	return listenWbId;
    }
    
    public void setListenWbId(String wbid) {
    	listenWbId = wbid;
    }
    
    public String getListenWbText() {
    	return listenWbText;
    }
    
    public void setListenWbText(String wbt) {
    	listenWbText = wbt;
    }
    
    public String getDestMailAddr() {
    	return destMailAddr;
    }
    
    public void setDestMailAddr(String dma) {
    	destMailAddr = dma;
    }
    
    public String getSendContent() {
    	return sendContent;
    }
    
    public void setSendContent(String sc) {
    	sendContent = sc;
    }

    public String getGoalTime() {
    	return goalTime;
    }
    
    public void setGoalTime(String gt) {
    	goalTime = gt;
    }
    
    public int getThisType() {
    	return thisType;
    }
    
    public void setThisType(int tt) {
    	thisType = tt;
    }
    
    public int getThatType() {
    	return thatType;
    }
    
    public void setThatType(int tt) {
    	thatType = tt;
    }
    
    public String getListenTimeLen() {
    	return listenTimeLen;
    }
    
    public void setListenTimeLen(String ltl) {
    	listenTimeLen = ltl;
    }
    
    public Task getSelectedTask() {
    	return selectedTask;
    }
    
    public void setSelectedTask(Task t) {
    	selectedTask = t;
    }
}
