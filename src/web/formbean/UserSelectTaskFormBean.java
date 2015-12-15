package web.formbean;

public class UserSelectTaskFormBean {
	String userId;
    Task selectedTask;
    
    public String getUserId() {
    	return userId;
    }
    
    public void setUserId(String ui) {
    	userId = ui;
    }
    
    public Task getSelectedTask() {
    	return selectedTask;
    }
    
    public void setSelectedTask(Task t) {
    	selectedTask = t;
    }

}
