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
import com.itheima.service.NoticeService;
import com.itheima.service.NoticeServiceImpl;

/**
 * Servlet implementation class UpdateNoticeServlet
 */
@WebServlet("/UpdateNoticeServlet")
public class UpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NoticeServiceImpl noticeservice=new NoticeServiceImpl();
		int serial=Integer.parseInt(request.getParameter("serial"));
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String time=request.getParameter("cz_month");
		String city_name= new String(request.getParameter("country_name").getBytes("iso-8859-1"), "utf-8");  
		System.out.println("通知单城市名字"+city_name);
		String city_code=noticeservice.getCity_code(city_name);
		System.out.println("通知单城市代码"+city_code);
		String product_name= new String(request.getParameter("product_name").getBytes("iso-8859-1"), "utf-8");
		System.out.println("通知单产品名字"+product_name);
		String product_code=noticeservice.getProduct_code(product_name);
		System.out.println("通知单名字"+product_code);
		String notice_name= new String(request.getParameter("notice_name").getBytes("iso-8859-1"), "utf-8");  
		System.out.println("通知单名字"+notice_name);
		String notice_code=noticeservice.getNotice_code(notice_name);
		System.out.println("通知单代码"+notice_code);
		String amount1=request.getParameter("input_money");
		//String state=request.getParameter("state");
		java.sql.Date date=null;
		Date date1=null;
		try {
			date1=(Date) ft.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		date=new java.sql.Date(date1.getTime());
		double amount=Double.parseDouble(amount1.toString());
		Notice notice=new Notice();
		notice.setSerial(serial);
		notice.setDate(date);
		notice.setCity_code(city_code);
		notice.setProduct_code(product_code);
		notice.setNotice_code(notice_code);
		notice.setAmount(amount);
		//notice.setState(state);
		noticeservice.updateNotice(notice);
		
		//3.���ݴ������ҵ�ĳ����ͼ��Ӧ
		request.getRequestDispatcher("GetAllNoticeServlet?service=allDeleteUpdate").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
