package com.itheima.controller.noticeIncome;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.Dao.Notice.Notice;
import com.itheima.service.NoticeServiceImpl;;

/**
 * Servlet implementation class SelectNoticeServlet
 */
@WebServlet("/SelectNoticeServlet")
public class SelectNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectNoticeServlet() {
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
		NoticeServiceImpl noticeservice=new NoticeServiceImpl();
		String serial1=request.getParameter("serial");
		String time=request.getParameter("cz_month");
		String city_name= new String(request.getParameter("country_name"));  
		System.out.println("city_name="+city_name);
		String city_code=noticeservice.getCity_code(city_name);
		String product_name= new String(request.getParameter("product_name"));
		String product_code=noticeservice.getProduct_code(product_name);
		String notice_name= new String(request.getParameter("notice_name"));  
		String notice_code=noticeservice.getNotice_code(notice_name);
		String amount1=request.getParameter("input_money");
		String state=request.getParameter("state");
		Notice notice=new Notice();
		if(!"".equals(serial1))
		{
			int serial=Integer.parseInt(serial1);
			notice.setSerial(serial);
		}
		else
			notice.setSerial(-1);
		if(time != "")
		{
			System.out.println("time != null");
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date date=null;
			Date date1=null;
			try {
				date1=(Date) ft.parse(time);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			date=new java.sql.Date(date1.getTime());
			notice.setDate(date);
		}else
			notice.setDate(null);
		if(" ".equals(city_code))
			city_code=null;
		if(" ".equals(product_code))
			product_code=null;
		if(" ".equals(notice_code))
			notice_code=null;
		if(amount1!="")
		{
			double amount=Double.parseDouble(amount1.toString());
			notice.setAmount(amount);
		}
		else
			notice.setAmount(-1);
		notice.setCity_code(city_code);
		notice.setProduct_code(product_code);
		notice.setNotice_code(notice_code);
		if(!"".equals(state))
			notice.setState(state);
		else
			notice.setState(null);
		

		//2.���������ҵ�ĳ��ҵ���߼�����
		
		
		request.setAttribute("notice", notice);
		//3.���ݴ������ҵ�ĳ����ͼ��Ӧ
		request.getRequestDispatcher("GetAllNoticeServlet?service=select").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
