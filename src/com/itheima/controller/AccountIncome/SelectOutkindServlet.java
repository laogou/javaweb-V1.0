package com.itheima.controller.AccountIncome;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.Dao.Outkind.Outkind;
import com.itheima.service.OutkindService;
import com.itheima.service.OutkindServiceImpl;

/**
 * Servlet implementation class SelectOutkindServlet
 */
@WebServlet("/SelectOutkindServlet")
public class SelectOutkindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOutkindServlet() {
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
		OutkindService outkindservice=new OutkindServiceImpl();
		String serial1=request.getParameter("serial");
		String time=request.getParameter("cz_month");
		String city_name= new String(request.getParameter("country_name"));  
		System.out.println("city_name="+city_name);
		String city_code=outkindservice.getCity_code(city_name);
		String product_name= new String(request.getParameter("product_name"));
		String product_code=outkindservice.getProduct_code(product_name);
		String outkind_name= new String(request.getParameter("outkind_name"));
		String outkind_code=outkindservice.getOutkind_code(outkind_name);
		String amount1=request.getParameter("input_money");
		String state=request.getParameter("state");
		System.out.println("outkindcode="+outkind_code);
		Outkind outkind=new Outkind();
		if(!"".equals(serial1))
		{
			int serial=Integer.parseInt(serial1);
			outkind.setSerial(serial);
		}
		else
			outkind.setSerial(-1);
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
			outkind.setDate(date);
		}else
			outkind.setDate(null);
		if(" ".equals(city_code))
			city_code=null;
		if(" ".equals(product_code))
			product_code=null;
		if(" ".equals(outkind_code))
			outkind_code=null;
		if(amount1!="")
		{
			double amount=Double.parseDouble(amount1.toString());
			outkind.setAmount(amount);
		}
		else
			outkind.setAmount(-1);
		outkind.setCity_code(city_code);
		outkind.setProduct_code(product_code);
		outkind.setOutkind_code(outkind_code);
		if(!"".equals(state))
			outkind.setState(state);
		else
			outkind.setState(null);
		

		//2.���������ҵ�ĳ��ҵ���߼�����
		
		
		request.setAttribute("outkind", outkind);
		//3.���ݴ������ҵ�ĳ����ͼ��Ӧ
		request.getRequestDispatcher("GetAllOutkindsServlet?service=select").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletReques t request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
