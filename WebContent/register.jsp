<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册界面</title>
<style type = "text/css">
	#id  {width:300px;height:25px;}
	#pwd {width:300px;height:25px;}
	#mail {width:300px;height:25px;}
	.button {font-size:125%;font-family:"宋体";background-color:#CCFFFF;}
	#sign_in_btn {font-family:"宋体";background-color:#F8F8F8;}
	#tips {font-size:125%;}
	label {font-size:125%;}
	body {
		  background-repeat: no-repeat;
		  background-attachment:fixed;
		  background-size:100% 100%;}
	div#login-inner {position:absolute;
	                 left:100px;
	                 top:160px;
	                 width:400px;}
	div#title_pic {position:absolute;
	                 left:30px;
	                 top:35px;
	                 width:400px;}
    div#copyright {position:absolute;
	                 left:50%;
	                 top:95%;
	                 text-align:center;}
	span#sign_in_tip{position:absolute;
	                 left:60%;
	                 top:85px;
	                 font-size:100%;}
</style>
</head>
	<body style = "text-align: center">
		<div id="title_pic">
			<img src="d:\\imag\\title.png">
			<img src="d:\\imag\\line.png">
		</div>
		<span id="sign_in_tip">
			<label id="tips">已有账号   请</label>
			<a href = "/IFTTT-Web/login.jsp">
			<button type="button" class="button" id="sign_in_btn">登录</button>
			</a>
		</span>
		<div id = "login-inner">
		<form action = "${pageContext.request.contextPath}/RegisterServlet" method = "post">
			<p>
				<label>&nbsp;用&nbsp;&nbsp;户&nbsp;名：</label>
				<input type = "text" name = "userName"  value = "${formbean.userName}">${formbean.errors.userName}
			</p>
				<br>
			<p>
				<label>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
				<input type = "password" name = "userPwd"  value = "${formbean.userPwd}">${formbean.errors.userPwd}
			</p>
				<br>
			<p>
				<label>确认密码：</label>
				<input type = "password" name = "confirmPwd"  value = "${formbean.confirmPwd}">${formbean.errors.confirmPwd}
			</p>
				<br>
			<p id = "login_btn">
				<span id = "button">
				<input type = "button"  class = "button" id = "reset" value = "重置" 
						onclick = "window.location.href = '/IFTTT-Web/register.jsp'">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type = "submit" class = "button" id = "register" value = "注册" >
				</span>	
			</p>
		</form>
		</div>	
		<div id="copyright">2015©MBQ</div>
	</body>
</html>