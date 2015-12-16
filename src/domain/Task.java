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
