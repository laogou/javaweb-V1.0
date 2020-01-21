package bean.collectServlet;

import java.io.IOException;
//import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.collectService.PreCollectService;
import common.PreG;

/**
 * 通过条件查询
 * @author 郑拓
 *
 */
@SuppressWarnings("serial")
public class PreCollectSerchServlet extends HttpServlet{

	/**
	 * 获得前台参数交给后台处理
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PreG pre = new PreG();     //记录查询条件
		
		String cityCode = request.getParameter("local");
		String productCode = request.getParameter("goods");
		String cancelCode = request.getParameter("cancel");

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
		
		
		pre.setPreCityCode(cityCode);
		pre.setPreProductCode(productCode);
		pre.setPreCancelCode(cancelCode);
		pre.setPredate(time);
		
		System.out.println(cityCode);
		System.out.println(productCode);
		System.out.println(cancelCode);
		System.out.println(time);
		
		PreCollectService  cs = new PreCollectService();
		cs.doSearch(pre);
		request.getSession().setAttribute("preSear", pre);     //返回查询条件给jsp页面
		request.getSession().setAttribute("preList", cs.doSearch(pre));      //返回查询结果给jsp页面
		request.getRequestDispatcher("/collect/pre_collect.jsp").forward(request, response);
	}
}
