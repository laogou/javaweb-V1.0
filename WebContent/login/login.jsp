<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css" />
</head>

<body>
<%
	String user="";
 %>
<div class="header" id="head">
  <div class="title">电信报表系统</div>
</div>

<form action="${pageContext.request.contextPath}/LoginCheckServlet" method="post" >
<div class="wrap" id="wrap">
	<div class="logGet">
			<!-- 头部提示信息 -->
			<div class="logD logDtip">
				<p class="p1">登录</p>
			</div>
			<!-- 输入框 -->
			<div class="lgD">
				<img src="${pageContext.request.contextPath}/image/logName.png" width="20" height="20" alt=""/>
				<input type="text" name="user_name" value="<%=user %>"  /></td>
				
				
			</div>
			<div class="lgD">
				<img src="${pageContext.request.contextPath}/image/logPwd.png" width="20" height="20" alt=""/>
				<input type="password" name="user_password" value=""  />
			</div>
			<div class="logC">
				<a href="LoginCheckServlet" target="_self"><button>登 录</button></a>
			</div>
		</div>
</div>
</form>
<div class="footer" id="foot">
  <div class="copyright">
    <p>Copyright © 2019 Qunar.com Inc. All Rights Reserved.</p>
    <div class="img">
		<i class="icon"></i><span>联系邮箱：cihiyuanzhang@gmail.com</span>
	</div>
	
	<div class="img">
		<i class="icon1"></i><span>联系地址：青岛理工大学</span>
	</div>
	  
	<div class="img">
	  <i class="icon2"></i><span>联系电话：17865426269</span>
	</div>
  </div>
</div>
	
	
</body>
</html>