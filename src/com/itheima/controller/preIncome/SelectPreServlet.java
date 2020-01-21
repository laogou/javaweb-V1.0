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
 * Servlet implementation class SelectPreServlet
 */
@WebServlet("/SelectPreServlet")
public class SelectPreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectPreServlet() {
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
		String serial1=request.getParameter("serial");
		String time=request.getParameter("cz_month");
		PreServiceImpl preservice= new PreServiceImpl();
		
		String city_name= new String(request.getParameter("country_name"));  
		System.out.println("预存转城市名字"+city_name);
		String city_code=preservice.getCity_code(city_name);
		System.out.println("预存转城市代码"+city_code);
		
		String product_name= new String(request.getParameter("product_name"));
		System.out.println("预存转产品名字"+product_name);
		String product_code=preservice.getProduct_code(product_name);
		System.out.println("预存转产品代码"+product_code);
		
		String cancel_name= new String(request.getParameter("cancel_name"));  
		String cancel_code=preservice.getCancel_code(cancel_name);
		
		System.out.println("预存转销账代码"+cancel_code);
		System.out.println("预存转销账代码"+cancel_code);
		
		String amount1=request.getParameter("input_money");
		String state=request.getParameter("state");
		Pre pre=new Pre();
		if(!"".equals(serial1))
		{
			int serial=Integer.parseInt(serial1);
			pre.setSerial(serial);
		}
		else
			pre.setSerial(-1);
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
			pre.setDate(date);
		}else
			pre.setDate(null);
		if(" ".equals(city_code))
			city_code=null;
		if(" ".equals(product_code))
			product_code=null;
		if(" ".equals(cancel_code))
			cancel_code=null;
		if(amount1!="")
		{
			double amount=Double.parseDouble(amount1.toString());
			pre.setAmount(amount);
		}
		else
			pre.setAmount(-1);
		pre.setCity_code(city_code);
		pre.setProduct_code(product_code);
		pre.setCancel_code(cancel_code);
		if(!"".equals(state))
			pre.setState(state);
		else
			pre.setState(null);
		
		
		request.setAttribute("pre", pre);
		//3.���ݴ������ҵ�ĳ����ͼ��Ӧ
		request.getRequestDispatcher("GetAllPreServlet?service=select").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
