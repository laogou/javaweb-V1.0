<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.util.List,java.util.ArrayList,com.itheima.utils.DbUtils,
    com.itheima.Dao.Outkind.Outkind,com.itheima.Dao.Outkind.OutkindDao,com.itheima.Dao.Outkind.OutkindDaoImpl"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>出账</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/nav_menu3.css" type="text/css" media="all" />
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
</div>


<center>
<span style="font-size: small;">
	<form name="QuerryUserFrom" method="post">
	
		<table align="center">
		<%
           Outkind outkind=(Outkind)request.getAttribute("outkind");
        %>
		    <tr>
		        <td>流水号：</td>
		        <td nmae="serial" value="serial"><%=outkind.getSerial() %></td>
		    </tr>
		    <tr>
		        <td>录入月份：</td><td><input type="date" name="cz_month" value=<%=outkind.getDate()%> /></td>
		    </tr>
			<tr>
				<td>城市编码：</td>
				<td>
					<select name="country_name">
					<option value=<%=outkind.getCity_code()%>><%=outkind.getCity_code()%></option>
					<%
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
				
					try {
						//Connection conn = null;
						//PreparedStatement pstmt = null;
						//ResultSet rs = null;
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
					<option value=<%=outkind.getProduct_code()%>><%=outkind.getProduct_code()%></option>
					<% 
					Connection conn1 = null;
					PreparedStatement pstmt1 = null;
					ResultSet rs1 = null;
				
					try {
						//Connection conn = null;
						//PreparedStatement pstmt = null;
						//ResultSet rs = null;
					//加载数据库驱动
						conn1=DbUtils.getConnection();
			
			            String sql = "select product_name from product";
			            pstmt1 = conn1.prepareStatement(sql);
			            rs1 = pstmt1.executeQuery();
			            System.out.println(sql);
						rs1=pstmt1.executeQuery();
						while(rs1.next())
						{
							%>
							<option value="<%=rs1.getString("product_name")%>"><%=rs1.getString("product_name") %></option>
							<%
						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("数据库链接不成功");
						e.printStackTrace();
					} finally {
						// 4.关闭数据库
						conn1.close();
					}
					
					%>
					</select>
				</td>
			</tr>
			<tr>
				<td>出账类型编码：</td>
				<td>
					<select name="outkind_name">
					<option value=<%=outkind.getOutkind_code()%>><%=outkind.getOutkind_code()%></option>
						<% 
						Connection conn2 = null;
						PreparedStatement pstmt2 = null;
						ResultSet rs2 = null;
					
						try {
						//加载数据库驱动
							conn2=DbUtils.getConnection();
				
				            String sql = "select outkind_name from outkind";
				            pstmt2 = conn2.prepareStatement(sql);
				            rs2 = pstmt2.executeQuery();
				            System.out.println(sql);
							rs2=pstmt2.executeQuery();
							while(rs2.next())
							{
								%>
								<option value="<%=rs2.getString("outkind_name")%>"><%=rs2.getString("outkind_name")%></option>
								<%
							}

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							System.out.println("数据库链接不成功");
							e.printStackTrace();
						} finally {
							// 4.关闭数据库
							conn2.close();
						}
					
					%>
					</select>
				</td>
			</tr>
			<tr>
				<td>录入金额：</td><td><input type="text" name="input_money" value=<%=outkind.getAmount()%> /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input  type="submit" value="修改" 
				onClick= "QuerryUserFrom.action='UpdateOutkindServlet?serial=<%=outkind.getSerial() %>';QuerryUserFrom.submit()"></td>
			</tr>
			
		</table>

	</form>
	</span>
</center>

</body>
</html>