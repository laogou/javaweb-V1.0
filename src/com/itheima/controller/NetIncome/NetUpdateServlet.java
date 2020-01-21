package com.itheima.controller.NetIncome;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.Dao.Net.Net;
import com.itheima.service.NetService;
import com.itheima.service.NetServiceImpl;

/**
 * Servlet implementation class NetUpdate
 */
@WebServlet("/NetUpdateServlet")
public class NetUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NetUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NetService netservice=new NetServiceImpl();
		int serial=Integer.parseInt(request.getParameter("serial"));
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String time=request.getParameter("date");
		String city_name= new String(request.getParameter("country_name").getBytes("iso-8859-1"), "utf-8");  
		System.out.println("网间结算城市名称"+city_name);
		String city_code=netservice.getCity_code(city_name);
		System.out.println("网间结算城市代码"+city_code);
		
		String product_name= new String(request.getParameter("product_name").getBytes("iso-8859-1"), "utf-8");
		System.out.println("网间结算产品名称"+product_name);
		
		String product_code=netservice.getProduct_code(product_name);
		System.out.println("网间结算产品代码"+product_code);
		
		String operator_name= new String(request.getParameter("operator_name").getBytes("iso-8859-1"), "utf-8");  
		String operator_code=netservice.getOperator_code(operator_name);
		String settle_name= new String(request.getParameter("settle_name").getBytes("iso-8859-1"), "utf-8");
		String settle_code=netservice.getSettle_code(settle_name);
		double amount=Double.parseDouble(request.getParameter("amount"));
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
		Net net=new Net();
		net.setSerial(serial);
		net.setDate(date);
		net.setCity_code(city_code);
		net.setProduct_code(product_code);
		net.setOperator_code(operator_code);
		net.setSettle_code(settle_code);
		net.setAmount(amount);
		//net.setState(state);
		
		//2.
		netservice.updateNet(net);
		
		//3.
		request.getRequestDispatcher("GetAllNetsServlet?service=allDeleteUpdate").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
