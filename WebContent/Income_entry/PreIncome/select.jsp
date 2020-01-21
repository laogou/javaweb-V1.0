<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.sql.*,java.util.List,java.util.ArrayList,com.itheima.utils.DbUtils,
   com.itheima.Dao.Pre.Pre,com.itheima.Dao.Pre.PreDao,com.itheima.Dao.Pre.PreDaoImpl"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>通知单</title>
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


<form action="${pageContext.request.contextPath }/SelectPreServlet" method="post">

	<center>
		<table align="center">
		    <tr>
		        <td>流水号：</td><td><input type="text" name="serial" /></td>
		    </tr>
	
		    <tr>
		        <td>销账日期：</td><td><input type="date" name="cz_month"  /></td>
		    </tr>
			<tr>
				<td>城市编码：</td>
				<td>
					<select name="country_name">
					<option value=" ">请选择城市</option>
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
							%>
							<option value="<%=rs.getString("city_name")%>"><%=rs.getString("city_name") %></option>
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
					<option value=" ">请选择产品类型</option>
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
				<td>销账类型编码：</td>
				<td>
					<select name="cancel_name">
					<option value=" ">请选择出账类型</option>
						<% 
					
						try {
									//加载数据库驱动
							conn=DbUtils.getConnection();
				
				            String sql = "select cancel_name from cancel";
				            pstmt = conn.prepareStatement(sql);
				            rs = pstmt.executeQuery();
				            System.out.println(sql);
							rs=pstmt.executeQuery();
						while(rs.next())
						{
							%>
							<option value="<%=rs.getString("cancel_name")%>"><%=rs.getString("cancel_name")%></option>
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
				<td>销账金额：</td><td><input type="text" name="input_money" /></td>
			</tr>
			<tr>
				<td>稽核情况：</td><td><input type="text" name="state" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input  type="submit" value="查询""></td>
			</tr>
			<tr>
				<table border="1" align="center">
					<tr>
					    <th align="center" bgcolor="cadetblue" width="100">流水号</th>
					    <th align="center" bgcolor="cadetblue" width="100">销账日期</th>
						<th align="center" bgcolor="cadetblue" width="100">城市编码</th>
						<th align="center" bgcolor="cadetblue" width="100">产品编码</th>
						<th align="center" bgcolor="cadetblue" width="100">销账类型编码</th>
						<th align="center" bgcolor="cadetblue" width="100">销账金额</th>
						<th align="center" bgcolor="cadetblue" width="100">稽核情况</th>
					</tr>
					<%
					List<Pre> pres=(List<Pre>)request.getAttribute("pres");
					if(pres==null)
					{
					%>
					<tr><td colspan="7"><font color="red">没有符合条件的数据</font></td></tr>
					<%
					}else{
						for(Pre pre:pres){
							%>
							<tr>
							<td><%=pre.getSerial() %></td>
							<td><%=pre.getDate() %></td>
							<td><%=pre.getCity_code() %></td>
							<td><%=pre.getProduct_code() %></td>
							<td><%=pre.getCancel_code() %></td>
							<td><%=pre.getAmount() %></td>
							<td><%=pre.getState() %></td>
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