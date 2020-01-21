<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="common.PreG" %>
<%@ page import="common.City" %>
<%@ page import="common.Product" %>
<%@ page import="common.Cancel" %>
<%@ page import="common.Settle" %>
<%@ page import="service.PreSelectService" %>
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
<title>pre_check</title>
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

/*确认是否数据归集完毕*/
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
  <form action="PreCollectSerchServlet" method="post" onSubmit="return checkTime(document.getElementById('from').value,document.getElementById('to').value)">
  <%
   PreG preSelect = new PreG();
   try{
       preSelect=(PreG)request.getSession().getAttribute("preSear");
   }catch(Exception e){
   }
   if(preSelect == null){
	   preSelect = new PreG();
	   preSelect.setPreCityCode("-1");
	   preSelect.setPreProductCode("-1");
	   preSelect.setPreCancelCode("-1");
	   preSelect.setPreamount(-1);
	   preSelect.setPredate(" / ");
   } 
   String[] timeSelect=preSelect.getPredate().split("/");
%>
  
    地市名:
     <select name="local">
      <option value="-1">请选择</option>
       <%
      PreSelectService ssC = new PreSelectService();
      ArrayList<City> listC = ssC.getCity();
      String cityCode = "";
      String cityName = "";
      if(listC.size()==0||listC==null){}
      else{
         for(int i=0;i<listC.size();i++){
            cityCode = (String)listC.get(i).getCityCode();
            cityName = (String)listC.get(i).getCityName();
      %>
      <option value ="<%=cityCode%>"<%if(cityCode.equals(preSelect.getPreCityCode())){ %> selected <%} %>>
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
      PreSelectService ssP = new PreSelectService();
      ArrayList<Product> listP = ssP.getProduct();
      String productCode = "";
      String productName = "";
      if(listP.size()==0||listP==null){}
      else{
         for(int i=0;i<listP.size();i++){
            productCode = (String)listP.get(i).getProductCode();
            productName = (String)listP.get(i).getProductName();
      %>
      <option value ="<%=productCode%>"<%if(productCode.equals(preSelect.getPreProductCode())){ %> selected <%} %>>
      <%=productName%>
      </option>
      <%  
         }
      }
       %>
    </select>
    &nbsp;
    销账类型:
     <select name="cancel">
      <option value="-1">请选择</option>
       <%
      PreSelectService ssN = new PreSelectService();
      ArrayList<Cancel> listN = ssP.getCancel();
      String cancelCode = "";
      String cancelName = "";
      if(listN.size()==0||listN==null){}
      else{
         for(int i=0;i<listN.size();i++){
            cancelCode = (String)listN.get(i).getCancelCode();
            cancelName = (String)listN.get(i).getCancelName();
      %>
      <option value ="<%=cancelCode%>"<%if(cancelCode.equals(preSelect.getPreCancelCode())){ %> selected <%} %>>
      <%=cancelName%>
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
      PreSelectService css = new PreSelectService();
      PreG preSearch = null;
      ArrayList<PreG> preList = null;
      PreG pre = null;
      int i = 1;
      int iNum;
      try{
         preList = (ArrayList<PreG>)request.getSession().getAttribute("preList");
         preSearch = (PreG)request.getSession().getAttribute("preSear");
         request.getSession().setAttribute("preSear",preSearch);
         iNum = preList.size();
         if(preList.size()==0||preList==null){
             out.println("<font color='red'>没有你要的数据！</font>");
         }else{
        %>
    
        <tr>
          <td width="80" align="center" bgcolor="#6699FF">录入编号</td>
          <td width="80" align="center" bgcolor="#6699FF">录入日期</td>
          <td width="80" align="center" bgcolor="#6699FF">城市名字</td>
          <td width="85" align="center" bgcolor="#6699FF">产品名字</td>
          <td width="88" align="center" bgcolor="#6699FF">销账类型</td>
          <td width="80" align="center" bgcolor="#6699FF">销账金额</td>
        </tr>
        <%
             for(;i<=preList.size();i++){
                pre = preList.get(i-1);
                String preId = "preId"+i;
                String preType = "preType"+i;
                String dates = pre.getPredate();
                String cityN = css.getCityName(pre.getPreCityCode());
                String productN = css.getProductName(pre.getPreProductCode());
                String cancelN = css.getCancelName(pre.getPreCancelCode());
                float amount = pre.getPreamount();
                //String outKindN = css.getOutKindName(pre.getPreOutKindCode());
       %>
      <tr id="<%=i%>">
      <%System.out.println("你好，下面是信息：");
      System.out.println(preId);
      System.out.println(productN);
      System.out.println(cityN);
      %>
      	
      	<td><input name="<%=preId%>" type="text" size="10" value="<%=pre.getPreserial()%>" readonly="readonly" />
      	    <input name="<%=preType%>" type="hidden" id="<%=preType%>" value="0"/>
      	</td>
        <td><input name="inTime" type="text" size="10" value="<%=dates%>" readonly="readonly" /></td>
        <td><input name="cityName" type="text" size="10" value="<%=cityN%>" readonly="readonly" /></td>
        <td><input name="productName" type="text" size="20" value="<%=productN%>" readonly="readonly" /></td>
        <td><input name="cancelName" type="text" size="10" value="<%=cancelN%>" readonly="readonly" /></td>
        <td><input name="amount" type="text" size="10" value="<%=amount%>" readonly="readonly" /></td>
      </tr>
      <%
          }
        }
      %>
       <tr>
        <td colspan="9" align="center">
        <input name="iNum" type="hidden" value="<%=iNum%>"/>
        <input name="checkOverName" value="稽数据归集 完 毕" type="submit" onClick="return checkOver()"/>
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



