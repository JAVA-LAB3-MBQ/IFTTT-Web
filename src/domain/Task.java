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
	public Task(String userId, String taskId, String taskName, String thisID, String thatId, int thisType, int thatType){
		this.userId = userId;
		this.taskId = taskId;
		this.taskId = taskId;
		this.thisId = thisId;
		this.thisType = thisType;
		this.thatType = thatType;
		createTime = DateStringUtil.date2String(new Date());
	}
	public Task(String userId, String taskId, String taskName, String thisId, String thatId, int thisType, int thatType, String thisIconPath, String thatIconPath, String createTime, int taskStatus){
		this.userId = userId;
		this.taskId = taskId;
		this.taskId = taskId;
		this.thisId = thisId;
		this.thisType = thisType;
		this.thatType = thatType;
		this.thisIconPath = thisIconPath;
		this.thatIconPath = thatIconPath;
		this.createTime = createTime;
		this.taskStatus = taskStatus;
	}
	public String getUserId() {
		return userId;
	}
	public String getTaskId(){
		return taskId;
	}
	public String getTaskName(){
		return taskName;
	}
	public String getThisId(){
		return thisId;
	}
	public String getThatId(){
		return thatId;
	}
	public int getThisType(){
		return thisType;
	}
	public int getThatType(){
		return thatType;
	}
	public String getThisIconPath(){
		return thisIconPath;
	}
	public String getThatIconPath(){
		return thatIconPath;
	}
	public String getCreateTime(){
		return createTime;
	}
	public int getTaskStatus(){
		return taskStatus;
	}
	public void setUserId(String uid) {
		userId = uid;
	}
	public void setTaskId(String tid){
		taskId = tid;
	}
	public void setThisId(String thisId){
		this.thisId = thisId;
	}
	public void setThatId(String thatId){
		this.thatId = thatId;
	}
	public void setThisType(int t){
		thisType = t;
	}
	public void setThatType(int t){
		thatType = t;
	}
}
