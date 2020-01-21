package bean.collectServlet;

import java.io.IOException;
//import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.collectService.NetCollectService;
import common.NetG;

/**
 * 通过条件查询
 * @author 郑拓
 *
 */
@SuppressWarnings("serial")
public class NetCollectSerchServlet extends HttpServlet{

	/**
	 * 获得前台参数交给后台处理
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		NetG net = new NetG();     //记录查询条件
		
		String cityCode = request.getParameter("local");
		String productCode = request.getParameter("goods");
		String operatorCode = request.getParameter("operator");
		String settleCode = request.getParameter("settle");
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
		
		net.setNetCityCode(cityCode);
		net.setNetProductCode(productCode);
		net.setNetOperatorCode(operatorCode);
		net.setNetSettleCode(settleCode);
		net.setNetdate(time);
		
		NetCollectService  cs = new NetCollectService();
		cs.doSearch(net);
		request.getSession().setAttribute("netSear", net);     //返回查询条件给jsp页面
		request.getSession().setAttribute("netList", cs.doSearch(net));      //返回查询结果给jsp页面
		request.getRequestDispatcher("/collect/net_collect.jsp").forward(request, response);
	}
}
