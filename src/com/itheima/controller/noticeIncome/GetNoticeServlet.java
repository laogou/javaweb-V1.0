package com.itheima.controller.noticeIncome;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.itheima.Dao.Notice.Notice;
import com.itheima.service.NoticeServiceImpl;


/**
 * Servlet implementation class GetNoticeServlet
 */
@WebServlet("/GetNoticeServlet")
public class GetNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int serial=Integer.parseInt(request.getParameter("serial"));
		System.out.println(serial);
		NoticeServiceImpl noticeservice=new NoticeServiceImpl();
		Notice notice=noticeservice.getBySerial(serial);
		request.setAttribute("notice",notice);
		request.getRequestDispatcher("Income_entry/NoticeIncome/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
