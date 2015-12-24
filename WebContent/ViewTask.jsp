<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>View Task</title>
    <link rel="stylesheet" type="text/css" href="taskmain.css" />
    <script type="text/javascript" src="jquery-2.1.4.js"></script>   
</head>
<body>
    <div id="logo">
        <img src="imag/logo.jpg">
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
        <img src="image/line.jpg">
        <div id="title_tips">
            &nbsp;&nbsp;&nbsp;&nbsp;Your Tasks&nbsp;&nbsp;<label id="taskNum">3/3 enabled</label>
        </div>
    </div>
    <div id="TaskContatiner">
        <ul id="taskList">
            <li>
                    <div id="Taskinfo">
                        <span id="taskId">1.</span>
                        <span>
                            &nbsp;if&nbsp;
                            <!--<div id="primaryObj" style="position: absolute; left:15%;">-->
                            <img src="imag/clock.png" style="padding-top:6px;width:80px;height:70px;" />
                            &nbsp;then
                            <img src="imag/weibo.jpg" style="width:80px;height:70px;" />
                        </span>
                        <span style="font-size:12px;position:absolute;top:100%;left:16%; text-align:center;width:80px;height:auto;">every day 7:00 pm</span>
                        <span style="font-size:12px;position:absolute;top:100%;left:45%;text-align:center;width:80px;">MyDarlinghh send a weibo </span>
                        <div id="edit_icons">
                            <a href="#"><img src="${pageContext.request.contextPath}/imag/edit_task_icon.png" width="60" height="50" /></a>
                            <a href="#"><img src="${pageContext.request.contextPath}/imag/delete_icon.png" width="60" height="50" /></a>
                            <a href="#"><img src="${pageContext.request.contextPath}/imag/start_task_icon.png" width="60" height="50" /></a>
                            <a href="#" id=""><img src="${pageContext.request.contextPath}/imag/stop_task_icon.png" width="60" height="50" /></a>
                        </div>
                        <span id="taskTimetip">created about 1 hours ago</span>
                    </div>
            </li>
            <li>
                <div id="Taskinfo_1">
                    <span id="taskId">2.</span>
                    <span>
                        &nbsp;if&nbsp;
                        <img src="imag/mail.png" style="padding-top:6px;width:80px;height:70px;" />
                        &nbsp;then
                        <img src="imag/weibo.jpg" style="width:80px;height:70px;" />
                    </span>
                    <span style="font-size:12px;position:absolute;top:95%;left:16%; text-align:center;width:80px;">nj_txh@163.com recieved a mail</span>
                    <span style="font-size:12px;position:absolute;top:95%;left:45%;text-align:center;width:80px;">MyDarlinghh send a weibo </span>
                    <div id="edit_icons">
                        <a href="#"><img src="${pageContext.request.contextPath}/imag/edit_task_icon.png" width="60" height="50" /></a>
                        <a href="#"><img src="${pageContext.request.contextPath}/imag/delete_icon.png" width="60" height="50" /></a> 
                    	<a href="#"><img src="${pageContext.request.contextPath}/imag/start_task_icon.png" width="60" height="50" /></a>
                    	<a href="#" id=""><img src="${pageContext.request.contextPath}/imag/stop_task_icon.png" width="60" height="50" /></a>
                    </div>
                    <span id="taskTimetip">created about 2 hours ago</span>
                </div>
            </li>
            <li>
                <div id="Taskinfo_2">
                    <span id="taskId">3.</span>
                    <span>
                        &nbsp;if&nbsp;
                        <img src="imag/weibo.jpg" style="padding-top:6px;width:80px;height:70px;" />
                        &nbsp;then
                        <img src="imag/mail.png" style="width:80px;height:70px;" />
                    </span>
                    <span style="font-size:12px;position:absolute;top:95%;left:16%; text-align:center;width:80px;">MyDarlinghh send a weibo:"hello world"</span>
                    <span style="font-size:12px;position:absolute;top:95%;left:45%;text-align:center;width:80px;">send a mail to nj_txh@163.com </span>
                    <div id="edit_icons">
                        <a href="#"><img src="${pageContext.request.contextPath}/imag/edit_task_icon.png" width="60" height="50" /></a>
                        <a href="#"><img src="${pageContext.request.contextPath}/imag/delete_icon.png" width="60" height="50" /></a>
                      	<a href="#"><img src="${pageContext.request.contextPath}/imag/start_task_icon.png" width="60" height="50" /></a>
                    	<a href="#" id=""><img src="${pageContext.request.contextPath}/imag/stop_task_icon.png" width="60" height="50" /></a>
                    </div>
                      <span id="taskTimetip">created about 3 hours ago</span>
                </div>
            </li>
        </ul>
    </div>
    <span id="page_tip">
        <button id="pre_page" disabled="disabled">上一页</button>
        <button id="next_page" disabled="disabled">下一页</button>
    </span>
    <div style="position:absolute;top:30%;right:1%;">
        <a><img src="${pageContext.request.contextPath}/imag/createTask.png" id="createTask_img"/></a>
    </div>
</body>
</html>