// JavaScript Document
/*校验时间*/
function checkTime(from,to){
   var year1 = parseInt(from.substring(0,4));
   var month1 = parseInt(from.substring(5,7));
   var day1 = parseInt(from.substring(8,10));
   var year2 = parseInt(to.substring(0,4));
   var month2 = parseInt(to.substring(5,7));
   var day2 = parseInt(to.substring(8,10));  
   if(year1>year2){
       alert("日期范围不合法");
   }else if(year1 == year2){
        if(month1>month2){
		    alert("日期范围不合法");
		}else if(month1==month2){
		     if(day1>day2){
			      alert("日期范围不合法！");
			 }
		}
   }
}
