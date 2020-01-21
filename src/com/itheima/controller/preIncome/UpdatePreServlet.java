package com.itheima.controller.preIncome;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.Dao.Pre.Pre;
import com.itheima.service.PreServiceImpl;


/**
 * Servlet implementation class UpdatePreServlet
 */
@WebServlet("/UpdatePreServlet")
public class UpdatePreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int serial=Integer.parseInt(request.getParameter("serial"));
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String time=request.getParameter("cz_month");
		PreServiceImpl preservice= new PreServiceImpl();
		String city_name= new String(request.getParameter("country_name").getBytes("iso-8859-1"), "utf-8");  
		System.out.println("city_name="+city_name);
		String city_code=preservice.getCity_code(city_name);
		String product_name= new String(request.getParameter("product_name").getBytes("iso-8859-1"), "utf-8");
		String product_code=preservice.getProduct_code(product_name);
		String cancel_name= new String(request.getParameter("cancel_name").getBytes("iso-8859-1"), "utf-8");  
		String cancel_code=preservice.getCancel_code(cancel_name);
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
		Pre pre=new Pre();
		pre.setSerial(serial);
		pre.setDate(date);
		pre.setCity_code(city_code);
		pre.setProduct_code(product_code);
		pre.setCancel_code(cancel_code);
		pre.setAmount(amount);
		//pre.setState(state);
		
		preservice.updatePre(pre);
		
		//3.���ݴ������ҵ�ĳ����ͼ��Ӧ
		request.getRequestDispatcher("GetAllPreServlet?service=allDeleteUpdate").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
