package web.formbean;

import java.util.ArrayList;

public class UserTasksFormBean {
	String userId;
    ArrayList<Task> userTasks;
    
    public String getUserId() {
    	return userId;
    }
    
    public void setUserId(String ui) {
    	userId = ui;
    }
    
    public ArrayList<Task> getUserTasks() {
    	return userTasks;
    }
    
    public void setArrayList<Task> setUserTasks(ArrayList<Task> ts) {
    	userTasks = ts;
    }

}
