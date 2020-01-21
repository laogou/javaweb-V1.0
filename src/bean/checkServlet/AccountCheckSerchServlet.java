package bean.checkServlet;

import java.io.IOException;
//import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.checkService.AccountCheckService;
import common.AccountG;

/**
 * 通过条件查询
 * @author 张志远
 *
 */
@SuppressWarnings("serial")
public class AccountCheckSerchServlet extends HttpServlet{

	/**
	 * 获得前台参数交给后台处理
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		AccountG account = new AccountG();     //记录查询条件
		
		String cityCode = request.getParameter("local");
		String productCode = request.getParameter("goods");
		String outKindCode = request.getParameter("outkind");
		String time = "";
		String fromTime = request.getParameter("from").trim();
		fromTime = new String(fromTime.getBytes("ISO-8859-1"),"UTF-8");
		String toTime = request.getParameter("to").trim();
		toTime = new String(toTime.getBytes("ISO-8859-1"),"UTF-8");
		if((!request.getParameter("from").equals(""))&&(!request.getParameter("to").equals(""))){
			fromTime=request.getParameter("from");
			toTime=request.getParameter("to");
			time = fromTime+"/"+toTime;
		}
		else if((!request.getParameter("from").equals(""))&&request.getParameter("to").equals("")){
			fromTime = request.getParameter("from");
			time = fromTime+"/ ";
		}
		else if(request.getParameter("from").equals("")&&(!request.getParameter("to").equals(""))){
			toTime=request.getParameter("to");
			time = " /"+toTime;
		}
		else{
			time = " / ";
		}
		
		System.out.println(time);
		
		account.setAccountCityCode(cityCode);
		account.setAccountProductCode(productCode);
		account.setAccountOutKindCode(outKindCode);
		account.setAccountdate(time);
	
		AccountCheckService  cs = new AccountCheckService();
		cs.doSearch(account);
		request.getSession().setAttribute("accountSear", account);     //返回查询条件给jsp页面
		request.getSession().setAttribute("checkList", cs.doSearch(account));      //返回查询结果给jsp页面
		request.getRequestDispatcher("/check/account_check.jsp").forward(request, response);
	}
}
