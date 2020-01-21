<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.util.List,java.util.ArrayList,com.itheima.utils.DbUtils,
    com.itheima.Dao.Net.NetDao,com.itheima.Dao.Net.NetDaoImpl,com.itheima.Dao.Net.Net" %>

 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>网间结算</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/nav_menu3.css" type="text/css" media="all" />
</head>
<body>

<div class="header" id="head">
  <div class="title">电信报表系统</div>
</div>
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

<form action="${pageContext.request.contextPath }/NetAddServlet" method="post">
	<center>
		<table align="center">
		    
			<tr>
				<td>城市编码：</td>
				<td>
					<select name="country_name">
					<% 
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
				
					try {
						//加载数据库驱动
						conn=DbUtils.getConnection();
			
			            String sql = "select city_name from city";
			
			            pstmt = conn.prepareStatement(sql);
			            rs = pstmt.executeQuery();
			            System.out.println(sql);
			            System.out.println("getCity_name数据库创建成功");
						rs=pstmt.executeQuery();
						while(rs.next())
						{
							System.out.println("city_name="+rs.getString("city_name"));
							%>
							<option value="<%=rs.getString("city_name") %>"><%=rs.getString("city_name") 
							%></option>
							<%
						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("数据库链接不成功");
						e.printStackTrace();
					} finally {
						// 4.关闭数据库
						conn.close();
					}
					
					%>
					</select>
				</td>
			</tr>
			<tr>
				<td>产品编码：</td>
				<td>
					<select name="product_name">
					<% 
					
					try {
						//加载数据库驱动
						conn=DbUtils.getConnection();
			
			            String sql = "select product_name from product";
			            pstmt = conn.prepareStatement(sql);
			            rs = pstmt.executeQuery();
			            System.out.println(sql);
						rs=pstmt.executeQuery();
						while(rs.next())
						{
							%>
							<option value="<%=rs.getString("product_name")%>"><%=rs.getString("product_name") %></option>
							<%
						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("数据库链接不成功");
						e.printStackTrace();
					} finally {
						// 4.关闭数据库
						conn.close();
					}
					
					%>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>结算运营商编码：</td>
				<td>
					<select name="operator_name">
					<% 
					
					try {
						
					//加载数据库驱动
						conn=DbUtils.getConnection();
			
			            String sql = "select operator_name from operator";
			            pstmt = conn.prepareStatement(sql);
			            rs = pstmt.executeQuery();
			            System.out.println(sql);
						rs=pstmt.executeQuery();
						while(rs.next())
						{
							System.out.println("operator_name"+rs.getString("operator_name"));
							%>
							<option value="<%=rs.getString("operator_name")%>"><%=rs.getString("operator_name") %></option>
							<%
						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("数据库链接不成功");
						e.printStackTrace();
					} finally {
						// 4.关闭数据库
						conn.close();
					}
					
					%>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>结算类型编码：</td>
				<td>
					<select name="settle_name">
					<% 
					
					try {
						//加载数据库驱动
						conn=DbUtils.getConnection();
			
			            String sql = "select settle_name from settle";
			            pstmt = conn.prepareStatement(sql);
			            rs = pstmt.executeQuery();
			            System.out.println(sql);
						rs=pstmt.executeQuery();
						while(rs.next())
						{
							%>
							<option value="<%=rs.getString("settle_name")%>"><%=rs.getString("settle_name") %></option>
							<%
						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("数据库链接不成功");
						e.printStackTrace();
					} finally {
						// 4.关闭数据库
						conn.close();
					}
					
					%>
					</select>
				</td>
			</tr>
			<tr>
				<td>结算金额：</td><td><input type="text" name="amount" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input  type="submit" value="录入""></td>
			</tr>
			<tr>
				<table border="1" align="center">
					<tr>
					    <th align="center" bgcolor="cadetblue" width="100">流水号</th>
					    <th align="center" bgcolor="cadetblue" width="100">录入月份</th>
						<th align="center" bgcolor="cadetblue" width="100">城市编码</th>
						<th align="center" bgcolor="cadetblue" width="100">产品编码</th>
						<th align="center" bgcolor="cadetblue" width="100">结算运营商编码</th>
						<th align="center" bgcolor="cadetblue" width="100">结算类型编码</th>
						<th align="center" bgcolor="cadetblue" width="100">结算金额</th>
						<th align="center" bgcolor="cadetblue" width="100">稽核情况</th>
					</tr>
					<%
					List<Net> nets=(List<Net>)request.getAttribute("nets");
					if(nets==null)
					{
					%>
					<tr><td colspan="8"><font color="red">没有符合条件的数据</font></td></tr>
					<%
					}else{
						for(Net net:nets){
							%>
							<tr>
							<td><%=net.getSerial() %></td>
							<td><%=net.getDate() %></td>
							<td><%=net.getCity_code() %></td>
							<td><%=net.getProduct_code() %></td>
							<td><%=net.getOperator_code() %></td>
							<td><%=net.getSettle_code() %></td>
							<td><%=net.getAmount() %></td>
							<td><%=net.getState() %></td>
							</tr>
							<%
						}
					}
					%>
				</table>
				
			</tr>
			
		</table>
</center>
	</form>
	




</body>
</html>