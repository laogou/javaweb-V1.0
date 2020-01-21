<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="common.NoticeG" %>
<%@ page import="common.City" %>
<%@ page import="common.Product" %>
<%@ page import="common.Notice" %>
<%@ page import="common.Settle" %>
<%@ page import="service.NoticeSelectService" %>
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
<title>notice_check</title>
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
  if(confirm("数据归集完毕？")){
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
  <form action="NoticeCollectSerchServlet" method="post" onSubmit="return checkTime(document.getElementById('from').value,document.getElementById('to').value)">
  <%
   NoticeG noticeSelect = new NoticeG();
   try{
       noticeSelect=(NoticeG)request.getSession().getAttribute("noticeSear");
   }catch(Exception e){
   }
   if(noticeSelect == null){
	   noticeSelect = new NoticeG();
	   noticeSelect.setNoticeCityCode("-1");
	   noticeSelect.setNoticeProductCode("-1");
	   noticeSelect.setNoticeNoticeCode("-1");
	   noticeSelect.setNoticeAmount(-1);
	   noticeSelect.setNoticedate(" / ");
   } 
   String[] timeSelect=noticeSelect.getNoticedate().split("/");
%>
  
    地市名:
     <select name="local">
      <option value="-1">请选择</option>
       <%
      NoticeSelectService ssC = new NoticeSelectService();
      ArrayList<City> listC = ssC.getCity();
      String cityCode = "";
      String cityName = "";
      if(listC.size()==0||listC==null){}
      else{
         for(int i=0;i<listC.size();i++){
            cityCode = (String)listC.get(i).getCityCode();
            cityName = (String)listC.get(i).getCityName();
      %>
      <option value ="<%=cityCode%>"<%if(cityCode.equals(noticeSelect.getNoticeCityCode())){ %> selected <%} %>>
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
      NoticeSelectService ssP = new NoticeSelectService();
      ArrayList<Product> listP = ssP.getProduct();
      String productCode = "";
      String productName = "";
      if(listP.size()==0||listP==null){}
      else{
         for(int i=0;i<listP.size();i++){
            productCode = (String)listP.get(i).getProductCode();
            productName = (String)listP.get(i).getProductName();
      %>
      <option value ="<%=productCode%>"<%if(productCode.equals(noticeSelect.getNoticeProductCode())){ %> selected <%} %>>
      <%=productName%>
      </option>
      <%  
         }
      }
       %>
    </select>
    &nbsp;
    通知单类型:
     <select name="notice">
      <option value="-1">请选择</option>
       <%
      NoticeSelectService ssN = new NoticeSelectService();
      ArrayList<Notice> listN = ssP.getNotice();
      String noticeCode = "";
      String noticeName = "";
      if(listN.size()==0||listN==null){}
      else{
         for(int i=0;i<listN.size();i++){
            noticeCode = (String)listN.get(i).getNoticeCode();
            noticeName = (String)listN.get(i).getNoticeName();
      %>
      <option value ="<%=noticeCode%>"<%if(noticeCode.equals(noticeSelect.getNoticeNoticeCode())){ %> selected <%} %>>
      <%=noticeName%>
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
      NoticeSelectService css = new NoticeSelectService();
      NoticeG noticeSearch = null;
      ArrayList<NoticeG> noticeList = null;
      NoticeG notice = null;
      int i = 1;
      int iNum;
      try{
         noticeList = (ArrayList<NoticeG>)request.getSession().getAttribute("noticeList");
         noticeSearch = (NoticeG)request.getSession().getAttribute("noticeSear");
         request.getSession().setAttribute("noticeSear",noticeSearch);
         iNum = noticeList.size();
         if(noticeList.size()==0||noticeList==null){
             out.println("<font color='red'>没有你要的数据！</font>");
         }else{
        %>
    
        <tr>
          <td width="80" align="center" bgcolor="#6699FF">录入编号</td>
          <td width="80" align="center" bgcolor="#6699FF">录入日期</td>
          <td width="80" align="center" bgcolor="#6699FF">城市名字</td>
          <td width="85" align="center" bgcolor="#6699FF">产品名字</td>
          <td width="88" align="center" bgcolor="#6699FF">通知单类型</td>
          <td width="80" align="center" bgcolor="#6699FF">通知单金额</td>
        </tr>
        <%
             for(;i<=noticeList.size();i++){
                notice = noticeList.get(i-1);
                
                //String noticeSerial = "noticeId"+i;
                //String noticeType = "noticeType"+i;
                //Integer noticeID = css.get
                
                //Integer serial = notice.getNoticeserial();
                String noticeId = "noticeId"+i;
                String noticeType = "noticeType"+i;
                String dates = notice.getNoticedate();
                String cityN = css.getCityName(notice.getNoticeCityCode());
                String productN = css.getProductName(notice.getNoticeProductCode());
                String noticeN = css.getNoticeName(notice.getNoticeNoticeCode());
                float amount = notice.getNoticeAmount();
                //String outKindN = css.getOutKindName(notice.getNoticeOutKindCode());
       %>
      <tr id="<%=i%>">
      <%System.out.println("你好，下面是信息：");
      System.out.println(noticeId);
      System.out.println(productN);
      System.out.println(cityN);
      %>
      	
      	<td><input name="<%=noticeId%>" type="text" size="10" value="<%=notice.getNoticeserial()%>" readonly="readonly" />
      	    <input name="<%=noticeType%>" type="hidden" id="<%=noticeType%>" value="0"/>
      	</td>
        <td><input name="inTime" type="text" size="10" value="<%=dates%>" readonly="readonly" /></td>
        <td><input name="cityName" type="text" size="10" value="<%=cityN%>" readonly="readonly" /></td>
        <td><input name="productName" type="text" size="20" value="<%=productN%>" readonly="readonly" /></td>
        <td><input name="noticeName" type="text" size="10" value="<%=noticeN%>" readonly="readonly" /></td>
        <td><input name="amount" type="text" size="10" value="<%=amount%>" readonly="readonly" /></td>
      </tr>
      <%
          }
        }
      %>
       <tr>
        <td colspan="9" align="center">
        <input name="iNum" type="hidden" value="<%=iNum%>"/>
        <input name="checkOverName" value="数据归集完 毕" type="submit" onClick="return checkOver()"/>
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



