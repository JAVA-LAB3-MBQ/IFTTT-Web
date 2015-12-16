package dao;

import domain.Task;
import java.util.ArrayList;

public interface ITaskDao {
	public boolean addTask(Task t);
	public boolean removeTask(Task t);
	public ArrayList<Task> getTasks(String userId);
}
