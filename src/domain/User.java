package domain;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
	final static int superUserTypeValue = 0; // 管理员
	final static int generalUserTypeValue = 1; // 普通用户
	
	private String userId;
	private String userName;
	private String userPwd;
	private String registerTime;
	
	private int userLevel;
	private int userScore;
	private int userRole;
	private int userStatus; // logged in or not logged in
	private int userMoney;
	private String userEmailAddr;
	private String userEmailPwd;
	private String userWeiboId;
	private String userWeiboAccessToken;
	private String userWeiboPwd;

	private ArrayList<Task> userTasks;
	
	public User(String name, String pwd){
		this.userName = name;
		this.userPwd = pwd;
	}
	
	public User() { }
	
	// todo: add a task into userTasks
	public void addATask(Task t) {
		
	}
	
	public int getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(int l) {
		userLevel = l;
	}
	public int getUserScore() {
		return userScore;
	}
	public void setUserScore(int s) {
		userScore = s;
	}
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int r) {
		userRole = r;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int s) {
		userStatus = s;
	}
	public int getUserMoney() {
		return userMoney;
	}
	
	public void  setUserMoney(int m ) {
		userMoney = m;
	}
	public String getUserEmailAddr() {
		return userEmailAddr;
	}
	public void setUserEmailAddr(String addr) {
		userEmailAddr = addr;
	}
	public String getUserEmailPwd() {
		return userEmailPwd;
	}
	public void setUserEmailPwd(String p) {
		userEmailPwd = p;
	}
	
	public String getUserWeiboId() {
		return userWeiboId;
	}
	public void setUserWeiboId(String id) {
		userWeiboId = id;
	}
	public String getUserWeiboAccessToken() {
		return userWeiboAccessToken;
	}
	public void setUserWeiboAccessToken(String token) {
		userWeiboAccessToken = token;
	}
	public String getUserWeiboPwd() {
		return userWeiboPwd;
	}
	public void setUserWeiboPwd(String pwd) {
		userWeiboPwd = pwd;
	}
 	public ArrayList<Task> getUserTasks() {
		return userTasks;
	}

	
	public User(String id, String name, String pwd){
		this.userId = id;
		this.userName = name;
		this.userPwd = pwd;
	}
	public User(String id, String name, String pwd, String registerTime){
		this.userId = id;
		this.userName = name;
		this.userPwd = pwd;
		this.registerTime = registerTime;
	}
	
	public void setId(String id){
		this.userId = id;
	}
	public void setName(String name){
		this.userName = name;
	}
	public void setPwd(String pwd){
		this.userPwd = pwd;
	}
	public void setRegisterTime(String registerTime){
		this.registerTime = registerTime;
	}
	public String getId(){
		return userId;
	}
	public String getName(){
		return userName;
	}
	public String getPwd(){
		return userPwd;
	}
	public String getRegisterTime(){
		return registerTime;
	}
}
