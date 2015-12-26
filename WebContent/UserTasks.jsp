<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String tasksId[] = new String[3];
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script>
// global variables
var nextTaskNo = 0;
var tasksInCurPage = 0;
var tasksThisImg = new Array("task1ThisImg", "task2ThisImg", "task3ThisImg");
var tasksThatImg = new Array("task1ThatImg", "task2ThatImg", "task3ThatImg");
var tasksThisInfo = new Array("task1ThisInfo", "task2ThisInfo", "task3ThisInfo");
var tasksThatInfo = new Array("task1ThatInfo", "task2ThatInfo", "task3ThatInfo");
var tasksName = new Array("task1Name", "task2Name", "task3Name");
var tasksCreateTime = new Array("task1CreateTime", "task2CreateTime", "task3CreateTime");
var tasksEdit = new Array("task1Edit", "task2Edit", "task3Edit");
var tasksDelete = new Array("task1Delete", "task2Delete", "task3Delete");
var tasksStart = new Array("task1Start", "task2Start", "task3Start");
var tasksStop = new Array("task1Stop", "task2Stop", "task3Stop");
var tasksIf = new Array("task1If", "task2If", "task3If");
var tasksThen = new Array("task1Then", "task2Then", "task3Then");

function showTasks() {
	var userTs = '${formbean.userTasks}';
	var tasksLen = '${formbean.userTasks.size()}';
	if(nextTaskNo >= tasksLen || nextTaskNo < 0) return;
	
	var i;
	tasksInCurPage = 0;
	for(i = 0; i < 3; i ++) {
		var thisImgEle = document.getElementById(tasksThisImg[i]);
		var thatImgEle = document.getElementById(tasksThatImg[i]);
		var thisInfoEle = document.getElementById(tasksThisInfo[i]);
		var thatInfoEle = document.getElementById(tasksThatInfo[i]);
		var createTimeEle = document.getElementById(tasksCreateTime[i]);
		var nameEle = document.getElementById(tasksName[i]);
		
		if(nextTaskNo < tasksLen) {
			'tasksId[i] = ${formbean.userTasks.get(nextTaskNo).getTaskId()}';
			
			// about task's information
			thisImgEle.style.visibility = "visible";
			thisImgEle.src = '${formbean.userTasks.get(nextTaskNo).getThisIconPath()}';
			//alert(thisImgEle.src);
			
			thatImgEle.style.visibility = "visible";
			thatImgEle.src = '${formbean.userTasks.get(nextTaskNo).getThatIconPath()}';
			//alert(thatImgEle.src);
			
			thisInfoEle.style.visibility = "visible";
			thisInfoEle.innerHTML = '${formbean.userTasks.get(nextTaskNo).getThisInfo()}';
			//alert(thisInfoEle.innerHTML);
			
			thatInfoEle.style.visibility = "visible";
			thatInfoEle.innerHTML = '${formbean.userTasks.get(nextTaskNo).getThatInfo()}';
			//alert(thatInfoEle.innerHTML);
			
			createTimeEle.style.visibility = "visible";
			createTimeEle.innerHTML = '${formbean.userTasks.get(nextTaskNo).getCreateTime()}';
			//alert(createTimeEle.innerHTML);
			
			nameEle.style.visibility = "visible";
			nameEle.innerHTML = '${formbean.userTasks.get(nextTaskNo).getTaskName()}' + ":";
			//alert(nameEle.innerHTML);
			
			// operations about task
			document.getElementById(tasksEdit[i]).style.visibility = "visible";
			document.getElementById(tasksDelete[i]).style.visibility = "visible";
			document.getElementById(tasksStart[i]).style.visibility = "visible";
			document.getElementById(tasksStop[i]).style.visibility = "visible";
			document.getElementById(tasksIf[i]).style.visibility = "visible";
			document.getElementById(tasksThen[i]).style.visibility = "visible";
			
			// nextTaskNo
			nextTaskNo ++;
			tasksInCurPage ++;
		}
		else { // hide elements
			thisImgEle.style.visibility = "hidden";
		    thatImgEle.style.visibility = "hidden";
		    thisInfoEle.style.visibility = "hidden";
		    thatInfoEle.style.visibility = "hidden";
		    createTimeEle.style.visibility = "hidden";
		    nameEle.style.visibility = "hidden";
		    
			document.getElementById(tasksEdit[i]).style.visibility = "hidden";
			document.getElementById(tasksDelete[i]).style.visibility = "hidden";
			document.getElementById(tasksStart[i]).style.visibility = "hidden";
			document.getElementById(tasksStop[i]).style.visibility = "hidden";
			document.getElementById(tasksIf[i]).style.visibility = "hidden";
			document.getElementById(tasksThen[i]).style.visibility = "hidden";
		}
	}
	document.getElementById("taskNum").innerHTML = (nextTaskNo) + "/" + tasksLen;
}

function lastPage() {
	alert("106");
	nextTaskNo = nextTaskNo - tasksInCurPage - 3;
	alert(nextTaskNo);
	showTasks();
}

function nextPage() {
	showTasks();
}
</script>
    <title>View Task</title>
    <link rel="stylesheet" type="text/css" href="taskmain.css" />
    <script type="text/javascript" src="jquery-2.1.4.js"></script>   
</head>
<body>
    <div id="logo">
        <img src="${pageContext.request.contextPath}/imag/logo.jpg">
        <span class="head_tips" style="font-size:21px;">Do Some Services for You</span>
    </div>
    <div id="menus">
        <ul>
            <li>
                <a href="a.jsp">Task</a>
                <ul>
                    <li>
                        <a href="a1.jsp">View Task</a>
                    </li>
                    <li>
                        <a href="a1.jsp">Create Task</a>
                    </li>
                    <li>
                        <a href="a1.jsp">Edit Task</a>
                    </li>
                    <li>
                        <a href="a1.jsp">Delete Task</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="b.jsp">Account</a>
                <ul>
                    <li>
                        <a href="a2.jsp">View</a>
                    </li>
                    <li>
                        <a href="a2.jsp">Edit</a>
                    </li>
                    <li>
                        <a href="a2.jsp">Sign out</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="title_pics">
        <img src="${pageContext.request.contextPath}/imag/line.jpg">
        <div id="title_tips">
            &nbsp;&nbsp;&nbsp;&nbsp;Your Tasks&nbsp;&nbsp;<label id="taskNum">3/3 enabled</label>
        </div>
    </div>
    <div id="TaskContatiner">
        <ul id="taskList">
            <li>
                    <div id="Taskinfo">
                        <span id="task1Name">1.</span>
                        <span>
                            &nbsp;<font id="task1If">if</font>&nbsp;
                            <!--<div id="primaryObj" style="position: absolute; left:15%;">-->
                            <img src="${pageContext.request.contextPath}/imag/clock.png" id="task1ThisImg" style="padding-top:6px;width:80px;height:70px;" />
                            &nbsp;<font id="task1Then">then</font>
                            <img src="${pageContext.request.contextPath}/imag/weibo.jpg" id="task1ThatImg" style="width:80px;height:70px;" />
                        </span>
                        <span id="task1ThisInfo" style="font-size:12px;position:absolute;top:100%;left:16%; text-align:center;width:80px;height:auto;">every day 7:00 pm</span>
                        <span id="task1ThatInfo" style="font-size:12px;position:absolute;top:100%;left:45%;text-align:center;width:80px;">MyDarlinghh send a weibo </span>
                        <div id="edit_icons">
                            <a href="#"><img src="${pageContext.request.contextPath}/imag/edit_task_icon.png" id="task1Edit" width="60" height="50" /></a>
                            <a href="#"><img src="${pageContext.request.contextPath}/imag/delete_icon.png" id="task1Delete" width="60" height="50" /></a>
                            <a href="#"><img src="${pageContext.request.contextPath}/imag/start_task_icon.png" id="task1Start" width="60" height="50" /></a>
                            <a href="#"><img src="${pageContext.request.contextPath}/imag/stop_task_icon.png" id="task1Stop" width="60" height="50" /></a>
                        </div>
                        <span id="taskTimetip">
                        	<font id="task1CreateTime">created about 1 hours ago</font>
                        </span>
                    </div>
            </li>
            <li>
                <div id="Taskinfo_1">
                    <span id="task2Name">2.</span>
                    <span>
                        &nbsp;<font id="task2If">if</font>&nbsp;
                        <img src="${pageContext.request.contextPath}/imag/mail.png" id="task2ThisImg" style="padding-top:6px;width:80px;height:70px;" />
                        &nbsp;<font id="task2Then">then</font>
                        <img src="${pageContext.request.contextPath}/imag/weibo.jpg" id="task2ThatImg" style="width:80px;height:70px;" />
                    </span>
                    <span id="task2ThisInfo" style="font-size:12px;position:absolute;top:95%;left:16%; text-align:center;width:80px;">nj_txh@163.com recieved a mail</span>
                    <span id="task2ThatInfo" style="font-size:12px;position:absolute;top:95%;left:45%;text-align:center;width:80px;">MyDarlinghh send a weibo </span>
                    <div id="edit_icons">
                        <a href="#"><img src="${pageContext.request.contextPath}/imag/edit_task_icon.png" id="task2Edit" width="60" height="50" /></a>
                        <a href="#"><img src="${pageContext.request.contextPath}/imag/delete_icon.png" id="task2Delete" width="60" height="50" /></a> 
                    	<a href="#"><img src="${pageContext.request.contextPath}/imag/start_task_icon.png" id="task2Start" width="60" height="50" /></a>
                    	<a href="#" id=""><img src="${pageContext.request.contextPath}/imag/stop_task_icon.png" id="task2Stop" width="60" height="50" /></a>
                    </div>
                    <span id="taskTimetip">
                    	<font id="task2CreateTime">created about 2 hours ago</font>
                    </span>
                </div>
            </li>
            <li>
                <div id="Taskinfo_2">
                    <span id="task3Name">3.</span>
                    <span>
                        &nbsp;<font id="task3If">if</font>&nbsp;
                        <img src="${pageContext.request.contextPath}/imag/weibo.jpg" id="task3ThisImg" style="padding-top:6px;width:80px;height:70px;" />
                        &nbsp;<font id="task3Then">then</font>
                        <img src="${pageContext.request.contextPath}/imag/mail.png" id="task3ThatImg" style="width:80px;height:70px;" />
                    </span>
                    <span id="task3ThisInfo" style="font-size:12px;position:absolute;top:95%;left:16%; text-align:center;width:80px;">MyDarlinghh send a weibo:"hello world"</span>
                    <span id="task3ThatInfo" style="font-size:12px;position:absolute;top:95%;left:45%;text-align:center;width:80px;">send a mail to nj_txh@163.com </span>
                    <div id="edit_icons">
                        <a href="">
                        	<img src="${pageContext.request.contextPath}/imag/edit_task_icon.png" id="task3Edit" width="60" height="50" />
                        </a>
                        <a href="#"><img src="${pageContext.request.contextPath}/imag/delete_icon.png" id="task3Delete" width="60" height="50" /></a>
                      	<a href="#"><img src="${pageContext.request.contextPath}/imag/start_task_icon.png" id="task3Start" width="60" height="50" /></a>
                    	<a href="#" id=""><img src="${pageContext.request.contextPath}/imag/stop_task_icon.png" id="task3Stop" width="60" height="50" /></a>
                    </div>
                      <span id="taskTimetip">
                      	<font id="task3CreateTime">created about 3 hours ago</font>
                      </span>
                </div>
            </li>
        </ul>
        <script>showTasks()</script>
    </div>
    <span id="page_tip">
        <button id="pre_page" onclick="lastPage()">上一页</button>
        <button id="next_page" onclick="nextPage()">下一页</button>
    </span>
    <div style="position:absolute;top:13%;right:4%;">
        <a href="#"><img src="${pageContext.request.contextPath}/imag/createTask.png" id="createTask_img"/></a>
    </div>
</body>
</html>