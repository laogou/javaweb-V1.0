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

import com.itheima.Dao.Card.Card;
import com.itheima.Dao.Net.Net;
import com.itheima.service.NetService;
import com.itheima.service.NetServiceImpl;

/**
 * Servlet implementation class NetSelectServlet
 */
@WebServlet("/NetSelectServlet")
public class NetSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NetSelectServlet() {
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
		NetService netservice=new NetServiceImpl();
		String serial1=request.getParameter("serial");
		String time=request.getParameter("date");
		String city_name= new String(request.getParameter("country_name"));  
		System.out.println("city_name="+city_name);
		String city_code=netservice.getCity_code(city_name);
		String product_name= new String(request.getParameter("product_name"));
		String product_code=netservice.getProduct_code(product_name);
		String operator_name= new String(request.getParameter("operator_name"));  
		String operator_code=netservice.getOperator_code(operator_name);
		String settle_name= new String(request.getParameter("settle_name"));
		String settle_code=netservice.getSettle_code(settle_name);
		String amount1=request.getParameter("amount");
		String state=request.getParameter("state");
		Net net=new Net();
		if(!"".equals(serial1))
		{
			int serial=Integer.parseInt(serial1);
			net.setSerial(serial);
		}
		else
			net.setSerial(-1);
		if(!"yyyy-mm-dd".equals(time) && !"".equals(time))
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
			net.setDate(date);
		}else
			net.setDate(null);
		if(!"��ѡ�����".equals(city_code) && !" ".equals(city_code))
		{
			net.setCity_code(city_code);
		}
		else
			net.setCity_code(null);
		if(!"��ѡ���Ʒ".equals(product_code) && !" ".equals(product_code))
		{
			net.setProduct_code(product_code);
		}else
			net.setProduct_code(null);
		if(!"��ѡ�������Ӫ��".equals(operator_code) && !" ".equals(operator_code))
		{
			net.setOperator_code(operator_code);
		}else
			net.setOperator_code(null);
		if(!"��ѡ���������".equals(settle_code) && !" ".equals(settle_code))
		{
			net.setSettle_code(settle_code);
		}else
			net.setSettle_code(null);
		if(!"".equals(amount1))
		{
			double amount=Double.parseDouble(amount1);
			net.setAmount(amount);
		}else
			net.setAmount(-1);
		
		if(!"".equals(state))
			net.setState(state);
		else
			net.setState(null);
		
		System.out.println("city_code="+city_code);
		//2.���������ҵ�ĳ��ҵ���߼�����
		
		
		request.setAttribute("net",net);
		//3.���ݴ������ҵ�ĳ����ͼ��Ӧ
		request.getRequestDispatcher("GetAllNetsServlet?service=select").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
