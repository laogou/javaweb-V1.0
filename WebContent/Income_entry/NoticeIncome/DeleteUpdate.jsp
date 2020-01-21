<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.util.List,java.util.ArrayList,com.itheima.utils.DbUtils,
   com.itheima.Dao.Notice.Notice,com.itheima.Dao.Notice.NoticeDao,com.itheima.Dao.Notice.NoticeDaoImpl"
    %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>通知单收入</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/nav_menu3.css" type="text/css" media="all" />
<div class="header" id="head">
  <div class="title">电信报表系统</div>
</div>

</head>
<body>


<div class="nav_menu3">
	<ul>
		
		<li class='nav-has-sub'><a href='#'>录入人员</a>
		  <ul>
			<li class='nav-has-sub'><a href='#'>出账收入</a>
				<ul>
				   <li><a href='${pageContext.request.contextPath }/GetAllOutkindsServlet?service=allaccount'>出账收入录入</a></li>
				   <li><a href='${pageContext.request.contextPath }/GetAllOutkindsServlet?service=allselect'>出账收入查询</a></li>
				   <li><a href='${pageContext.request.contextPath }/GetAllOutkindsServlet?service=allDeleteUpdate'>出账收入修改</a></li>
				   <li><a href='${pageContext.request.contextPath }/GetAllOutkindsServlet?service=allDeleteUpdate'>出账收入删除</a></li>
				</ul>
			 </li>
			 
			 <li class='nav-has-sub'><a href='${pageContext.request.contextPath }/GetAllCardsServlet?service=allDeleteUpdate'>卡销售收入</a>
				<ul>
				   <li><a href='${pageContext.request.contextPath }/GetAllCardsServlet?service=alladd'>卡销售录入</a></li>
				   <li><a href='${pageContext.request.contextPath }/GetAllCardsServlet?service=allselect'>卡销售查询</a></li>
				   <li><a href='${pageContext.request.contextPath }/GetAllCardsServlet?service=allDeleteUpdate'>卡销售修改</a></li>
				   <li><a href='${pageContext.request.contextPath }/GetAllCardsServlet?service=allDeleteUpdate'>卡销售删除</a></li>
				</ul>
			 </li>
			 
			 <li class='nav-has-sub'><a href='${pageContext.request.contextPath }/GetAllNetsServlet?service=allDeleteUpdate'>网间结算收入</a>
				<ul>
				   <li><a href='${pageContext.request.contextPath }/GetAllNetsServlet?service=alladd'>网间结算录入</a></li>
				   <li><a href='${pageContext.request.contextPath }/GetAllNetsServlet?service=allselect'>网间结算查询</a></li>
				   <li><a href='${pageContext.request.contextPath }/GetAllNetsServlet?service=allDeleteUpdate'>网间结算修改</a></li>
				   <li><a href='${pageContext.request.contextPath }/GetAllNetsServlet?service=allDeleteUpdate'>网间结算删除</a></li>
				</ul>
			 </li>
			
			 <li class='nav-has-sub'><a href='${pageContext.request.contextPath }/GetAllPreServlet?service=allDeleteUpdate'>预存转收入</a>
				<ul>
				    <li><a href='${pageContext.request.contextPath }/GetAllPreServlet?service=allaccount'>预存转录入</a></li>
				   <li><a href='${pageContext.request.contextPath }/GetAllPreServlet?service=allselect'>预存转查询</a></li>
				   <li><a href='${pageContext.request.contextPath }/GetAllPreServlet?service=allDeleteUpdate'>预存转修改</a></li>
				   <li><a href='${pageContext.request.contextPath }/GetAllPreServlet?service=allDeleteUpdate'>预存转删除</a></li>
				</ul>
			 </li>
			 
			 <li class='nav-has-sub'><a href='${pageContext.request.contextPath }/GetAllNoticeServlet?service=allDeleteUpdate'>通知单收入</a>
				<ul>
				   <li><a href='${pageContext.request.contextPath }/GetAllNoticeServlet?service=allaccount'>通知单录入</a></li>
				   <li><a href='${pageContext.request.contextPath }/GetAllNoticeServlet?service=allselect'>通知单查询</a></li>
				   <li><a href='${pageContext.request.contextPath }/GetAllNoticeServlet?service=allDeleteUpdate'>通知单修改</a></li>
				   <li><a href='${pageContext.request.contextPath }/GetAllNoticeServlet?service=allDeleteUpdate'>通知单删除</a></li>
				</ul>
			 </li>
		  </ul>
	   </li>
	   
	   <li class='nav-has-sub'><a href='#'>稽核人员</a>
			<ul>
				<li><a href='#'>出账收入稽核</a></li>
				<li><a href='#'>卡销售收入稽核</a></li>
				<li><a href='#'>网间结算收入稽核</a></li>
				<li><a href='#'>预存转收入稽核</a></li>
				<li><a href='#'>通知单收入稽核</a></li>
			</ul>
		</li>
	   
	   <li class='nav-has-sub'><a href='#'>财务人员</a>
			<ul>
				<li><a href='#'>出账收入归集</a></li>
				<li><a href='#'>卡销售收入归集</a></li>
				<li><a href='#'>网间结算归集</a></li>
				<li><a href='#'>预存转归集</a></li>
				<li><a href='#'>通知单归集</a></li>
			</ul>
		</li>
	   
	   
	  </ul>
</div>


<span style="font-size: small;">
<form name="QuerryUserFrom" method="post"> 
	<center>
				<table border="1" align="center">
					<tr>
					    <th align="center" bgcolor="cadetblue" width="100">流水号</th>
					    <th align="center" bgcolor="cadetblue" width="100">营业收款日期</th>
						<th align="center" bgcolor="cadetblue" width="100">城市编码</th>
						<th align="center" bgcolor="cadetblue" width="100">产品编码</th>
						<th align="center" bgcolor="cadetblue" width="100">通知单收入编码</th>
						<th align="center" bgcolor="cadetblue" width="100">营业收入金额</th>
						<th align="center" bgcolor="cadetblue" width="100">稽核情况</th>
						<th align="center" bgcolor="cadetblue" width="100">操作</th>
					</tr>
					<%
					List<Notice> notices=(List<Notice>)request.getAttribute("notices");
					if(notices==null)
					{
					%>
					<tr><td colspan="8"><font color="red">没有符合条件的数据</font></td></tr>
					<%
					}else{
						for(Notice notice:notices){
							%>
							<tr>
							<td name="serial" value="serial"><%=notice.getSerial() %></td>
							<td value="date"><%=notice.getDate() %></td>
							<td value="city_code"><%=notice.getCity_code() %></td>
							<td value="product_code"><%=notice.getProduct_code() %></td>
							<td value="notice_code"><%=notice.getNotice_code() %></td>
							<td value="amount"><%=notice.getAmount() %></td>
							<td value="state"><%=notice.getState() %></td>
							<td align="center">
							<input  type="button" value="修改" 
							onclick="QuerryUserFrom.action='GetNoticeServlet?serial=<%=notice.getSerial() %>';QuerryUserFrom.submit()">
							<input  type="submit" value="删除" 
							onClick= "QuerryUserFrom.action='DeleteNoticeServlet?serial=<%=notice.getSerial() %>';QuerryUserFrom.submit()"></td>
							</tr> 
							<%
						}
					}
					%>
				</table>
</center>
</form>
</span>
	
</body>
</html>