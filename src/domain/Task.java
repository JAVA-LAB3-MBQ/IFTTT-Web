package domain;
import java.util.Date;
import util.DateStringUtil;
public class Task {
	public final static int pausedStatus = 0;
	public final static int startedStatus = 1;
	
	private String userId;  //任务所属的用户的id
	private String taskId;  //任务id
	private String taskName;//任务名称
	
	private String thisId, thatId;
	private int thisType, thatType;
	private String thisIconPath;
	private String thatIconPath;
	
	private String createTime;
	
	private int taskStatus;

	public Task(){
		createTime = (DateStringUtil.date2String(new Date()));
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String uid) {
		userId = uid;
	}
}
