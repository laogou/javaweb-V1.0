package com.itheima.controller.noticeIncome;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.Dao.Notice.Notice;
import com.itheima.service.NoticeService;
import com.itheima.service.NoticeServiceImpl;



/**
 * Servlet implementation class GetAllNoticeServlet
 */
@WebServlet("/GetAllNoticeServlet")
public class GetAllNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		System.out.println("getAll");
		String[] params=new String[7];
		String  service=request.getParameter("service");
		System.out.println(service);
		if("select".equals(service))
		{
			Notice notice=(Notice) request.getAttribute("notice");
			int serial=notice.getSerial();
			Date date=notice.getDate();
			String city_code=notice.getCity_code();
			String product_code=notice.getProduct_code();
			String notice_code=notice.getNotice_code();
			double amount=notice.getAmount();
			String state=notice.getState();
			if(serial==-1)
			{
				params[0]=null;
			}
			else
				params[0]=Integer.toString(serial);
			if(date!=null)
			{
				SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		        params[1]=ft.format(date);
			}else
				params[1]=null;
		params[2]=city_code;
		params[3]=product_code;
		params[4]=notice_code;
		if(amount==-1)
		{
			params[5]=null;
		}else
			params[5]=String.valueOf(amount);
		params[6]=state;
		}
		NoticeServiceImpl noticeservice= new NoticeServiceImpl();
		
		List<Notice> notices=noticeservice.getAllNotice(params);
		request.setAttribute("notices", notices);
		
		System.out.println("���ݿ���ȡȫ�����ݳɹ�");
		//3.�ҵ�ҳ����Ӧ
		if("allDeleteUpdate".equals(service)) {
			request.getRequestDispatcher("Income_entry/NoticeIncome/DeleteUpdate.jsp").forward(request, response);
		}
		else if("allaccount".equals(service))
		{
			request.getRequestDispatcher("Income_entry/NoticeIncome/account.jsp").forward(request, response);
		}
		else if("allselect".equals(service)||"select".equals(service))
		{
			request.getRequestDispatcher("Income_entry/NoticeIncome/select.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
