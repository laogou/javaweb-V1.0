<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="common.CardG" %>
<%@ page import="common.City" %>
<%@ page import="common.Product" %>
<%@ page import="common.Page" %>
<%@page import="service.CardSelectService"%>
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
<title>card_check</title>
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

/*清空查询条件*/
 function clearSearch(from,to,local,goods){
	 var tempMsg = '执行清空查询按钮';
		console.log(tempMsg);
	 document.getElementById(from).value=""; 
     document.getElementById(to).value="";
     document.getElementById(local).options[0].selected=true;
     document.getElementById(goods).options[0].selected=true;
 } 

/*稽核通过，*/
function needUpdate(id,hiddenId){
	var tempMsg = '执行稽核通过按钮';
	console.log(tempMsg);
  document.getElementById(id).bgColor="green";
  document.getElementById(hiddenId).value="1";
}
/*稽核未通过，*/
function needDelete(id,hiddenId){
	var tempMsg = '执行稽核不通过按钮';
	console.log(tempMsg);
  document.getElementById(id).bgColor="red";
  document.getElementById(hiddenId).value="0";
}


/*确认是否稽核完毕*/
function checkOver(){
  if(confirm("稽核完毕，确认提交吗？")){
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
				<li><a href='check/account_check.jsp'>出账收入稽核</a></li>
				<li><a href='check/card_check.jsp'>卡销售稽核</a></li>
				<li><a href='check/net_check.jsp'>网间结算稽核</a></li>
				<li><a href='check/prestore_check.jsp'>预存转稽核</a></li>
				<li><a href='check/notice_check.jsp'>通知单稽核</a></li>
			</ul>
		</li>
	   
	   <li class='nav-has-sub'><a href='#'>财务人员</a>
			<ul>
				<li><a href='#'>出账收入归集</a></li>
				<li><a href='#'>卡销售归集</a></li>
				<li><a href='#'>网间结算归集</a></li>
				<li><a href='#'>预存转归集</a></li>
				<li><a href='#'>通知单归集</a></li>
			</ul>
		</li>
	</ul>
</div>
</div>


<center>
  <form action="CardCheckSerchServlet" method="post" onSubmit="return checkTime(document.getElementById('from').value,document.getElementById('to').value)">
  <%
   CardG cardSelect = new CardG();
   try{
       cardSelect=(CardG)request.getSession().getAttribute("cardSear");
   }catch(Exception e){
   }
   if(cardSelect == null){
	   cardSelect = new CardG();
	   cardSelect.setCardCityCode("-1");
	   cardSelect.setCardProductCode("-1");
	   cardSelect.setCardNum(-1);
	   cardSelect.setCardPrice(-1);
	   cardSelect.setCardAmount(-1);
	   cardSelect.setCardDisamount(-1);
	   cardSelect.setCarddate(" / ");
   } 
   String[] timeSelect=cardSelect.getCarddate().split("/");
%>
  
    地市名:
     <select name="local">
      <option value="-1">请选择</option>
       <%
      CardSelectService ssC = new CardSelectService();
      ArrayList<City> listC = ssC.getCity();
      String cityCode = "";
      String cityName = "";
      if(listC.size()==0||listC==null){}
      else{
         for(int i=0;i<listC.size();i++){
            cityCode = (String)listC.get(i).getCityCode();
            cityName = (String)listC.get(i).getCityName();
      %>
      <option value ="<%=cityCode%>"<%if(cityCode.equals(cardSelect.getCardCityCode())){ %> selected <%} %>>
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
      CardSelectService ssP = new CardSelectService();
      ArrayList<Product> listP = ssP.getProduct();
      String productCode = "";
      String productName = "";
      if(listP.size()==0||listP==null){}
      else{
         for(int i=0;i<listP.size();i++){
            productCode = (String)listP.get(i).getProductCode();
            productName = (String)listP.get(i).getProductName();
      %>
      <option value ="<%=productCode%>"<%if(productCode.equals(cardSelect.getCardProductCode())){ %> selected <%} %>>
      <%=productName%>
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
  
  <table width="399" height="22" border="0">
   <tr>
      <td width="21" bgcolor="red"></td>
      <td width="162" align="left">代表稽核未通过</td>
      <td width="21" bgcolor="green"></td>
      <td width="177" align="left">代表稽核通过</td>
    </tr>
  </table>
</center>


<center>
  <form action="CardCheckServlet" method="post" >
    <table width="900" border="1" bordercolor="lightblue">
    
    <%
      CardSelectService css = new CardSelectService();
      CardG cardSearch = null;
      ArrayList<CardG> cardList = null;
      CardG card = null;
      int i = 1;
      int iNum;
      try{
         cardList = (ArrayList<CardG>)request.getSession().getAttribute("checkList");
         cardSearch = (CardG)request.getSession().getAttribute("cardSear");
         request.getSession().setAttribute("cardSear",cardSearch);
         iNum = cardList.size();
         if(cardList.size()==0||cardList==null){
             out.println("<font color='red'>没有你要的数据！</font>");
         }else{
        %>
    
        <tr>
          <td width="80" align="center" bgcolor="#6699FF">录入编号</td>
          <td width="80" align="center" bgcolor="#6699FF">录入日期</td>
          <td width="80" align="center" bgcolor="#6699FF">城市名字</td>
          <td width="85" align="center" bgcolor="#6699FF">产品名字</td>
          <td width="88" align="center" bgcolor="#6699FF">单卡金额</td>
          <td width="80" align="center" bgcolor="#6699FF">销售数量</td>
          <td width="85" align="center" bgcolor="#6699FF">折扣后金额</td>
          <td colspan="2" align="center" bgcolor="#6699FF">核实操作</td>
        </tr>
        <%
             for(;i<=cardList.size();i++){
                card = cardList.get(i-1);
                
                //String cardSerial = "cardId"+i;
                //String cardType = "cardType"+i;
                //Integer cardID = css.get
                
                //Integer serial = card.getCardserial();
                String cardId = "cardId"+i;
                String cardType = "cardType"+i;
                String dates = card.getCarddate();
                String cityN = css.getCityName(card.getCardCityCode());
                String productN = css.getProductName(card.getCardProductCode());
                int price = card.getCardPrice();
                int num = card.getCardNum();
                float amount = card.getCardDisamount();
                //String outKindN = css.getOutKindName(card.getCardOutKindCode());
       %>
      <tr id="<%=i%>">
      <%System.out.println("你好，下面是信息：");
      System.out.println(cardId);
      System.out.println(productN);
      System.out.println(cityN);
      %>
      	
      	<td><input name="<%=cardId%>" type="text" size="10" value="<%=card.getCardserial()%>" readonly="readonly" />
      	    <input name="<%=cardType%>" type="hidden" id="<%=cardType%>" value="0"/>
      	</td>
        <td><input name="inTime" type="text" size="10" value="<%=dates%>" readonly="readonly" /></td>
        <td><input name="cityName" type="text" size="10" value="<%=cityN%>" readonly="readonly" /></td>
        <td><input name="productName" type="text" size="20" value="<%=productN%>" readonly="readonly" /></td>
        <td><input name="Price" type="text" size="10" value="<%=price%>" readonly="readonly" /></td>
        <td><input name="saleNum" type="text" size="10" value="<%=num%>" readonly="readonly" /></td>
        <td><input name="disamount" type="text" size="10" value="<%=amount%>" readonly="readonly" /></td>
      	<td><input name="update" value="通    过" type="button" onclick="needUpdate(<%=i%>,'<%=cardType%>')"/></td>
        <td><input name="delete" value="不通过" type="button" onclick="needDelete(<%=i%>,'<%=cardType%>')"/></td>
      </tr>
      <%
          }
        }
      %>
       <tr>
        <td colspan="9" align="center">
        <input name="iNum" type="hidden" value="<%=iNum%>"/>
        <input name="checkOverName" value="稽 核 完 毕" type="submit" onClick="return checkOver()"/>
        </td>
      </tr>
      <%
      }catch(Exception e){
      }
     %>
    </table>
  </form>
</center>


</body>
</html>



