package dao.impl;
import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;

import dao.ITaskDao;
import domain.DatabaseInfo;
import domain.Task;

public class TaskDaoImpl implements ITaskDao {
	public boolean addTask(Task t) {
		// todo : add A Task to db
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =
					DriverManager.getConnection(domain.DatabaseInfo.url,domain.DatabaseInfo.username,domain.DatabaseInfo.password);
			Statement statement = con.createStatement();
			String update = "insert into task values(\""+t.getUserId()+"\",\""+t.getTaskId()+"\",\""+t.getTaskName()+"\",\""+t.getThisId()+"\",\""+t.getThatId()
				+"\",\""+t.getThisType()+"\",\""+t.getThatType()+"\",\""
				+t.getThisIconPath()+"\",\"" + t.getThatIconPath() +"\",\""
				+ t.getCreateTime()+"\""+t.getTaskStatus()+"\"";
			statement.executeUpdate(update);
		}
		catch(ClassNotFoundException e){
			
		}
		catch(SQLException ee){
			
		}
		return false;
	}
	
	public boolean removeTask(Task t) {
		// todo : remove the Task from db
		try{
			Class.forName("com.sql.jdbc.Driver");
			Connection con =
					DriverManager.getConnection(DatabaseInfo.url, DatabaseInfo.username, DatabaseInfo.password);
			Statement statement = con.createStatement();
			String update = "delete * from task where taskId = \"" + t.getTaskId() + "\"";
			statement.executeUpdate(update);
		}
		catch(ClassNotFoundException e){
			
		}
		catch(SQLException ee){
			
		}
		return false;
	}
	
	public ArrayList<Task> getTasks(String userId) {
		// todo : get the tasks of the user together
		ArrayList<Task> tasks = new ArrayList<Task>();
		try{
			Class.forName("com.sql.jdbc.Driver");
			Connection con =
					DriverManager.getConnection(DatabaseInfo.url, DatabaseInfo.username, DatabaseInfo.password);
			Statement statement = con.createStatement();
			String query = "select * from task";
			ResultSet res = statement.executeQuery(query);
			while(res.next()){
				Task t = new Task(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getInt(6),res.getInt(7),res.getString(8),res.getString(9),res.getString(10),res.getInt(11));
				tasks.add(t);
			}
			return tasks;
		}
		catch(ClassNotFoundException e){
			
		}
		catch(SQLException ee){
			
		}
		return null; 
	}
	
	public boolean startTask(String taskId) {
		// todo: change the task's status
		try{
			Class.forName("com.sql.jdbc.Driver");
			Connection con =
					DriverManager.getConnection(DatabaseInfo.url, DatabaseInfo.username, DatabaseInfo.password);
			Statement statement = con.createStatement();
			statement.executeUpdate("SET SQL_SAFE_UPDATES = 0");
			String update = "update task set taskStatus = 1 where taskId = \"" + taskId + "\"";
			statement.executeUpdate(update);
			return true;
		}
		catch(ClassNotFoundException e){
			return false;
		}
		catch(SQLException ee){
			return false;
			
		}
	}
	
	public boolean pauseTask(String taskId) {
		// todo: change the task's status
		try{
			Class.forName("com.sql.jdbc.Driver");
			Connection con =
					DriverManager.getConnection(DatabaseInfo.url, DatabaseInfo.username, DatabaseInfo.password);
			Statement statement = con.createStatement();
			statement.executeUpdate("SET SQL_SAFE_UPDATES = 0");
			String update = "update task set taskStatus = 0 where taskId = \"" + taskId + "\"";
			statement.executeUpdate(update);
			return true;
		}
		catch(ClassNotFoundException e){
			return false;
		}
		catch(SQLException ee){
			return false;
			
		}
	}
}
