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
 * Servlet implementation class AddNoticeServlet
 */
@WebServlet("/AddNoticeServlet")
public class AddNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNoticeServlet() {
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
		int serial=noticeservice.getMaxSerial();
		System.out.println("MaxSerial="+serial);
		
		String city_name= new String(request.getParameter("country_name"));  
		System.out.println("城市名字"+city_name);
		String city_code=noticeservice.getCity_code(city_name);
		System.out.println("城市代码"+city_code);
		String product_name= new String(request.getParameter("product_name"));
		System.out.println("产品名字"+product_name);
		String product_code=noticeservice.getProduct_code(product_name);
		System.out.println("产品代码"+product_code);
		String notice_name= new String(request.getParameter("notice_name"));  
		String notice_code=noticeservice.getNotice_code(notice_name);
		String amount1="null";
		amount1=request.getParameter("input_money");
		String state="0";
		java.sql.Date date=null;
		double amount=0;
		if(!"".equals(amount1))
			amount=Double.parseDouble(amount1.toString());
		Notice notice=new Notice();
		notice.setSerial(++serial);
		notice.setDate(date);
		notice.setCity_code(city_code);
		notice.setProduct_code(product_code);
		notice.setNotice_code(notice_code);
		notice.setAmount(amount);
		notice.setState(state);
		
		//���outkind�е�����
		System.out.println(notice.getSerial());
		System.out.println(notice.getDate());
		System.out.println(notice.getCity_code());
		System.out.println(notice.getProduct_code());
		System.out.println(notice.getNotice_code());
		
		//2.���������ҵ�ĳ��ҵ���߼�����
		NoticeServiceImpl noticeservice1=new NoticeServiceImpl();
		noticeservice1.addNotice(notice);
		System.out.println("���ݿ����ɹ�");
		
		//3.���ݴ������ҵ�ĳ����ͼ��Ӧ
		request.getRequestDispatcher("GetAllNoticeServlet?service=allaccount").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
