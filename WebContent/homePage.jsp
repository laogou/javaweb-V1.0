<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>导航</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/homepage.css">
  </head>
<body>
<div id="container"> 

	<div id="head">
		<span>
		<%
			String loginer=request.getAttribute("loginer").toString();
			String nav=request.getAttribute("nav").toString();
			if(loginer!=null)
			{
		 %>
			欢迎您：<%=loginer %>
		<%
		}
		 %>
		</span>
		<form action = "LogoutCheckServlet" method = "post" >
		<span><input name = "logout" value = "安全退出"  type = "submit" /></span>
		</form>
		
	</div>
	
	<div>
		<iframe name="navIframe" id="navIframe" src="<%=nav %>" frameborder="0"></iframe>
	</div>
</div>
</body>
</html>
