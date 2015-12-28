package domain;
import java.util.Date;
import util.DateStringUtil;
public class Task {
	public final static int pausedStatus = 0;
	public final static int startedStatus = 1;
	
	private String userId;  //�����������û���id
	private String taskId;  //����id
	private String taskName;//��������
	
	private String thisId, thatId;
	private int thisType, thatType;
	private String thisIconPath;
	private String thatIconPath;
	private String thisInfo, thatInfo;
	
	private String createTime;
	
	private int taskStatus;

	public Task(){
		createTime = (DateStringUtil.date2String(new Date()));
		taskStatus = Task.pausedStatus;
	}
	
	public Task(String userId, String taskId, String taskName, String thisId, String thatId, int thisType, int thatType){
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
	public String getThisInfo() {
		return thisInfo;
	}
	public void setThisInfo(String info) {
		thisInfo = info;
	}
	public String getThatInfo() {
		return thatInfo;
	}
	public void setThatInfo(String info) {
		thatInfo = info;
	}
	public void setThisIconPath(String p) {
		thisIconPath = p;
	}
	public void setThatIconPath(String p) {
		thatIconPath = p;
	}
	public void setTaskStatus(int st) {
		taskStatus = st;
	}
	public void setTaskName(String s) {
		taskName = s;
	}
}
