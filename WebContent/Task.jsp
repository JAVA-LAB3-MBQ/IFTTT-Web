<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Look Task</title>
    <link rel="stylesheet" type="text/css" href="taskmain.css" />
    <script type="text/javascript" src="jquery-2.1.4.js"></script>
    <style type = "text/css">
    div#title_icon{
         position:absolute;
         left:6%;
         top:2%;
     }
     div#menus {position:absolute;
                left:66%;
                top:2%;
                }
        #menus ul {
            list-style: none;
        }
        #menus ul li {
                float: left;
            }
            #menus ul li a:link, #menus ul li a:visited {
                display: block;
                width: 120px;
                height:25px;
                font-weight: bold;
                color: black;
                background-color: white;
                text-align: center;
                padding: 4px;
                line-height:25px;
                text-decoration: none;
                text-transform: none;
            }

            #menus ul li a:hover, #menus ul li a:active {
                background-color: white;
            }
            #menus ul li:hover ul {
                display: block;
                position: absolute;
                width: 100px;
                /*left:0;*/
                z-index: 10000;
                             
            }
          #menus ul li ul {
                display: none;
            }
            #menus ul li:hover ul li a {
                display: block;
                background-color: white;
                color: black;
                width: 100px;
                text-align: center;
                border-bottom: 1px solid #f2f2f2;
                border-right: none;
                border: #666 solid 1px;
            }
                #menus ul li:hover ul li a:hover {
                    background: #6dc7ec;
                    color: black;
                }
            
            #menus ul li ul li {
                float: none;
                width: 100%;
                line-height: 12px;
                display: block;
            }
        
        #menus ul li ul li a {
                font-size: 12px;
                width: 100%;
                padding: 3px 0;
                text-align: center;
                line-height: 18px;
            }
    </style>
</head>
<body>
	<div class ="logo" >
    <img src="${pageContext.request.contextPath}/imag/7.jpg">
    <span class="head_tips">| Your Tasks</span>
	</div>
	<div class ="line">
        <img src="${pageContext.request.contextPath}/imag/line.jpg" />
    </div>
	<div id="menus">
            <ul>
                <li><a href="a.jsp">Task</a>
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
                <li><a href="b.jsp">Account</a>
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
</body>
</html>