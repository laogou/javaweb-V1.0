<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="common.NetG" %>
<%@ page import="common.City" %>
<%@ page import="common.Product" %>
<%@ page import="common.Operator" %>
<%@ page import="common.Settle" %>
<%@ page import="service.NetSelectService" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/nav_menu3.css" type="text/css" media="all" />
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>net_check</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wpCalendar.js"></script>

<script language="javascript">
/*时间核查*/
function checkTime(from,to){
   var flag = true;
   if(to=="")
   		return true;
   else{
        if(from.localeCompare(to)>0){
  		     alert("日期范围不合法");
  		     flag=0;
  		}
		}
   if(!flag){
      return false;
   }
}


/*确认是否归集完毕*/
function checkOver(){
  if(confirm("数据归集完毕")){
       return true;
  }else{
       return false;
  }
}
</script>


</head>
  
<body bgcolor="#FFFFFF">

  <div class="header" id="head">
  <div class="title">电信报表系统</div>
  </div>
<div class ="warp" id= "warp">
<div class="nav_menu3" >
	<ul>
		<li class='nav-has-sub'><a href='#'>录入人员</a>
		  <ul>
			<li class='nav-has-sub'><a href='#'>出账收入管理</a></li>
			 <li class='nav-has-sub'><a href='#'>卡销售管理</a></li>		 
			 <li class='nav-has-sub'><a href='#'>网间结算管理</a></li>	
			 <li class='nav-has-sub'><a href='#'>预存转管理</a></li>	 
			 <li class='nav-has-sub'><a href='#'>通知单管理</a></li>
		  </ul>
	   </li>
	   
	   <li class='nav-has-sub'><a href='#'>稽核人员</a>
			<ul>
				<li><a href='#'>出账收入稽核</a></li>
				<li><a href='#'>卡销售稽核</a></li>
				<li><a href='#'>网间结算稽核</a></li>
				<li><a href='#'>预存转稽核</a></li>
				<li><a href='#'>通知单稽核</a></li>
			</ul>
		</li>
	   
	   <li class='nav-has-sub'><a href='#'>财务人员</a>
			<ul>
				<li><a href='collect/account_collect.jsp'>出账收入归集</a></li>
				<li><a href='collect/card_collect.jsp'>卡销售归集</a></li>
				<li><a href='collect/net_collect.jsp'>网间结算归集</a></li>
				<li><a href='collect/pre_collect.jsp'>预存转归集</a></li>
				<li><a href='collect/notice_collect.jsp'>通知单归集</a></li>
			</ul>
		</li>
	</ul>
</div>
</div>


<center>
  <form action="NetCollectSerchServlet" method="post" onSubmit="return checkTime(document.getElementById('from').value,document.getElementById('to').value)">
  <%
   NetG netSelect = new NetG();
   try{
       netSelect=(NetG)request.getSession().getAttribute("netSear");
   }catch(Exception e){
   }
   if(netSelect == null){
	   netSelect = new NetG();
	   netSelect.setNetCityCode("-1");
	   netSelect.setNetProductCode("-1");
	   netSelect.setNetOperatorCode("-1");
	   netSelect.setNetSettleCode("-1");
	   netSelect.setNetAmount(-1);
	   netSelect.setNetdate(" / ");
   } 
   String[] timeSelect=netSelect.getNetdate().split("/");
%>
  
    地市名:
     <select name="local">
      <option value="-1">请选择</option>
       <%
      NetSelectService ssC = new NetSelectService();
      ArrayList<City> listC = ssC.getCity();
      String cityCode = "";
      String cityName = "";
      if(listC.size()==0||listC==null){}
      else{
         for(int i=0;i<listC.size();i++){
            cityCode = (String)listC.get(i).getCityCode();
            cityName = (String)listC.get(i).getCityName();
      %>
      <option value ="<%=cityCode%>"<%if(cityCode.equals(netSelect.getNetCityCode())){ %> selected <%} %>>
      <%=cityName%>
      </option>
      <%  
         }
      }
       %>
    </select>
    &nbsp;
    产品名:
     <select name="goods">
      <option value="-1">请选择</option>
       <%
      NetSelectService ssP = new NetSelectService();
      ArrayList<Product> listP = ssP.getProduct();
      String productCode = "";
      String productName = "";
      if(listP.size()==0||listP==null){}
      else{
         for(int i=0;i<listP.size();i++){
            productCode = (String)listP.get(i).getProductCode();
            productName = (String)listP.get(i).getProductName();
      %>
      <option value ="<%=productCode%>"<%if(productCode.equals(netSelect.getNetProductCode())){ %> selected <%} %>>
      <%=productName%>
      </option>
      <%  
         }
      }
       %>
    </select>
    &nbsp;
    运营商名:
     <select name="operator">
      <option value="-1">请选择</option>
       <%
      NetSelectService ssN = new NetSelectService();
      ArrayList<Operator> listN = ssP.getOperator();
      String operatorCode = "";
      String operatorName = "";
      if(listN.size()==0||listN==null){}
      else{
         for(int i=0;i<listN.size();i++){
            operatorCode = (String)listN.get(i).getOperatorCode();
            operatorName = (String)listN.get(i).getOperatorName();
      %>
      <option value ="<%=operatorCode%>"<%if(operatorCode.equals(netSelect.getNetOperatorCode())){ %> selected <%} %>>
      <%=operatorName%>
      </option>
      <%  
         }
      }
       %>
    </select>
    &nbsp;
     结算类型：
     <select name="settle">
      <option value="-1">请选择</option>
       <%
      NetSelectService ssS = new NetSelectService();
      ArrayList<Settle> listS = ssS.getSettle();
      String settleCode = "";
      String settleName = "";
      if(listS.size()==0||listS==null){}
      else{
         for(int i=0;i<listS.size();i++){
            settleCode = (String)listS.get(i).getSettleCode();
            settleName = (String)listS.get(i).getSettleName();
      %>
      <option value ="<%=settleCode%>"<%if(settleCode.equals(netSelect.getNetSettleCode())){ %> selected <%} %>>
      <%=settleName%>
      </option>
      <%  
         }
      }
       %>
    </select>
    &nbsp;
	  起始日期:
    <%
    if(!timeSelect[0].equals(" ")){
    %>
    <input name="from" type="text" size="10" readonly="readonly" onfocus="showCalendar(this)" value="<%=timeSelect[0] %>" />
    <%
    }else{
    %>
    <input name="from" type="text" size="10" readonly="readonly" onfocus="showCalendar(this)" />
    <%
    } 
    %>
    <input name="image1" type="image" src="${pageContext.request.contextPath}/image/date.png"  onclick="showCalendar(this,document.all.from)" />
 	截止日期:
    <%
    if(!timeSelect[1].equals(" ")){
    %>
    <input name="to" type="text" size="10" readonly="readonly" onfocus="showCalendar(this)" value="<%=timeSelect[1] %>" />
    <%
    }else{
    %>
    <input name="to" type="text" size="10" readonly="readonly" onfocus="showCalendar(this)" />
    <%
    } 
    %>
	<input name="image1" type="image" src="${pageContext.request.contextPath}/image/date.png" onclick="showCalendar(this,document.all.to)" />
	

    <input name="search" value="查  询" type="submit" />
  </form>
</center>


<center>

    <table width="900" border="1" bordercolor="lightblue">
    
    <%
      NetSelectService css = new NetSelectService();
      NetG netSearch = null;
      ArrayList<NetG> netList = null;
      NetG net = null;
      int i = 1;
      int iNum;
      try{
         netList = (ArrayList<NetG>)request.getSession().getAttribute("netList");
         netSearch = (NetG)request.getSession().getAttribute("netSear");
         request.getSession().setAttribute("netSear",netSearch);
         iNum = netList.size();
         if(netList.size()==0||netList==null){
             out.println("<font color='red'>没有你要的数据！</font>");
         }else{
        %>
    
        <tr>
          <td width="80" align="center" bgcolor="#6699FF">录入编号</td>
          <td width="80" align="center" bgcolor="#6699FF">录入日期</td>
          <td width="80" align="center" bgcolor="#6699FF">城市名字</td>
          <td width="85" align="center" bgcolor="#6699FF">产品名字</td>
          <td width="88" align="center" bgcolor="#6699FF">运营商</td>
          <td width="80" align="center" bgcolor="#6699FF">结算类型</td>
          <td width="85" align="center" bgcolor="#6699FF">结算金额</td>
        </tr>
        <%
             for(;i<=netList.size();i++){
                net = netList.get(i-1);
                String netId = "netId"+i;
                String netType = "netType"+i;
                String dates = net.getNetdate();
                String cityN = css.getCityName(net.getNetCityCode());
                String productN = css.getProductName(net.getNetProductCode());
                String operatorN = css.getOperatorName(net.getNetOperatorCode());
                String settleN = css.getSettleName(net.getNetSettleCode());
                float amount = net.getNetAmount();
                //String outKindN = css.getOutKindName(net.getNetOutKindCode());
       %>
      <tr id="<%=i%>">
      <%System.out.println("你好，下面是信息：");
      System.out.println(netId);
      System.out.println(productN);
      System.out.println(cityN);
      %>
      	
      	<td><input name="<%=netId%>" type="text" size="10" value="<%=net.getNetserial()%>" readonly="readonly" />
      	    <input name="<%=netType%>" type="hidden" id="<%=netType%>" value="0"/>
      	</td>
        <td><input name="inTime" type="text" size="10" value="<%=dates%>" readonly="readonly" /></td>
        <td><input name="cityName" type="text" size="10" value="<%=cityN%>" readonly="readonly" /></td>
        <td><input name="productName" type="text" size="20" value="<%=productN%>" readonly="readonly" /></td>
        <td><input name="operatorName" type="text" size="10" value="<%=operatorN%>" readonly="readonly" /></td>
        <td><input name="settleName" type="text" size="10" value="<%=settleN%>" readonly="readonly" /></td>
        <td><input name="amount" type="text" size="10" value="<%=amount%>" readonly="readonly" /></td>
      </tr>
      <%
          }
        }
      %>
       <tr>
        <td colspan="9" align="center">
        <input name="iNum" type="hidden" value="<%=iNum%>"/>
        <input name="checkOverName" value="归集完 毕" type="submit" onClick="return checkOver()"/>
        </td>
      </tr>
      <%
      }catch(Exception e){
      }
     %>
    </table>

</center>

</body>
</html>



