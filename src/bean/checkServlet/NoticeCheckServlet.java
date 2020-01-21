package bean.checkServlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.checkService.NoticeCheckService;
import common.NoticeG;

/**
 * 稽核servlet
 * @author 张志远
 *
 */

@SuppressWarnings("serial")
public class NoticeCheckServlet extends HttpServlet{

	/**
	 * 获得前台参数交给后台处理
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String checkU = (String)request.getSession().getAttribute("user");  //用户验证
		ArrayList<NoticeG> list = new ArrayList<NoticeG>();      //用于集体修改稽核情况
		NoticeG notice = null;
		NoticeG cSearch = null;    //传递查询条件的
		int i;
		
		//要传给后台的参数
		int id;                      //notice表单编号
		int type;                    //稽查后结果（1通过、0不通过）
		
		//连接页面的获取参数的名字
		String noticeId = "";
		String noticeType = "";

		//一共稽查的数目
		String s = "";
	    s = request.getParameter("iNum");
		i = Integer.parseInt(s);
		for(int j=1;j<=i;j++){
			notice = new NoticeG();
			noticeId = "noticeId" + j;
			noticeType = "noticeType" + j;
			//noticeCheckInfo = "noticeCheckInfo" + j;
			
			id = Integer.parseInt(request.getParameter(noticeId));
			System.out.println(request.getParameter(noticeId));
			System.out.println("表单第几个数据");
			System.out.println(id);
			type = Integer.parseInt(request.getParameter(noticeType));
			System.out.println(request.getParameter(noticeType));
			System.out.println("表单数据的稽核状态");
			System.out.println(type);
			//checkInfo = request.getParameter(noticeCheckInfo);
			//checkInfo = new String(checkInfo.getBytes("ISO-8859-1"),"UTF-8");
			notice.setNoticeserial(id);
			notice.setNoticeType(type);
			//notice.setNoticeCheckInfo(checkInfo);
			//notice.setNoticeCheManager(checkU);
			list.add(notice);
		}
		try {
			cSearch = (NoticeG) request.getSession().getAttribute("noticeSear");
		} catch (Exception e) {
		}
		NoticeCheckService cs = new NoticeCheckService();
		cs.doUpdate(list);
		//返回修改后的查询结果（一直保留上级查询条件）
		cs.doSearch(cSearch);
		request.getSession().setAttribute("checkList", cs.doSearch(cSearch));      //返回查询结果给jsp页面
		request.getRequestDispatcher("/check/notice_check.jsp").forward(request, response);
	}
}
