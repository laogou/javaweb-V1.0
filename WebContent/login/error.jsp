<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>电信报表系统</title>
<style type="text/css">
div
{
	margin-left: 35%;
	margin-top: 20%;
}
</style>


<script language="javascript">
function testTime(){
 setTimeout("show()",1000);
}
function show(){
 var second = document.getElementById('time').innerText;
 second --;
 document.getElementById('time').innerText = second;
 
 if(document.getElementById('time').innerText>0){
    setTimeout("show()",1000);
 }else{
   next();
 }
}
function next(){
	window.history.back(-1);
  //location.href(request.getContextPath() + "/login/login.jsp");
}
</script>

</head>

<body onload="testTime()" bgcolor="lightblue">
<div>
<font color="#FF0000" size="+3" face="幼圆">用户名或密码错误</font>
<table width="61" border="0">
  <tr>
    <td width="16" id="time" align="right">3</td>
	<td width="25" align="left">秒</td>
  </tr>
</table>
<table width="200" border="0">
  <tr>
    <td><font color="#FF0000">3秒后自动跳转...</font></td>
  </tr>
</table>
</div>
</body>
</html>

