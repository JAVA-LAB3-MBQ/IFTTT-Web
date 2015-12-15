package domain;

public class Task {
	public final static int pausedStatus = 0;
	public final static int startedStatus = 1;
	
	String userId;
	String taskId;
	String taskName;
	String thisId, thatId;
	int thisType, thatType;
	String thisIconPath;
	String thatIconPath;
	String createTime;
	int taskStatus;

}
