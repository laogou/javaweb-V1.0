package bean.checkServlet;

import java.io.IOException;
//import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.checkService.NoticeCheckService;
import common.NoticeG;

/**
 * 通过条件查询
 * @author 张志远
 *
 */
@SuppressWarnings("serial")
public class NoticeCheckSerchServlet extends HttpServlet{

	/**
	 * 获得前台参数交给后台处理
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		NoticeG notice = new NoticeG();     //记录查询条件
		
		String cityCode = request.getParameter("local");
		String productCode = request.getParameter("goods");
		String noticeCode = request.getParameter("notice");

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
		
		notice.setNoticeCityCode(cityCode);
		notice.setNoticeProductCode(productCode);
		notice.setNoticeNoticeCode(noticeCode);
		notice.setNoticedate(time);
	
		NoticeCheckService  cs = new NoticeCheckService();
		cs.doSearch(notice);
		request.getSession().setAttribute("noticeSear", notice);     //返回查询条件给jsp页面
		request.getSession().setAttribute("checkList", cs.doSearch(notice));      //返回查询结果给jsp页面
		request.getRequestDispatcher("/check/notice_check.jsp").forward(request, response);
	}
}
