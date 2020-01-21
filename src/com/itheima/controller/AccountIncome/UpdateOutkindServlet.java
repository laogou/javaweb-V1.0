package com.itheima.controller.AccountIncome;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.Dao.Outkind.Outkind;
import com.itheima.service.OutkindService;
import com.itheima.service.OutkindServiceImpl;

/**
 * Servlet implementation class UpdateOutkindServlet
 */
@WebServlet("/UpdateOutkindServlet")
public class UpdateOutkindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOutkindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OutkindService outkindservice=new OutkindServiceImpl();
		int serial=Integer.parseInt(request.getParameter("serial"));
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String time=request.getParameter("cz_month");
		String city_name= new String(request.getParameter("country_name").getBytes("iso-8859-1"), "utf-8");
		System.out.println("城市名字="+city_name);
		String city_code=outkindservice.getCity_code(city_name);
		System.out.println("城市编码="+city_code);
		String product_name= new String(request.getParameter("product_name").getBytes("iso-8859-1"), "utf-8");
		String product_code=outkindservice.getProduct_code(product_name);
		String outkind_name= new String(request.getParameter("outkind_name").getBytes("iso-8859-1"), "utf-8");
		System.out.println("出账名称="+outkind_name);
		
		String outkind_code=outkindservice.getOutkind_code(outkind_name);
		System.out.println("出账编码="+outkind_code);
		
		String amount1=request.getParameter("input_money");
		//String state=request.getParameter("state");
		System.out.println("product_code:"+product_code);
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
		Outkind outkind=new Outkind();
		outkind.setSerial(serial);
		outkind.setDate(date);
		outkind.setCity_code(city_code);
		outkind.setProduct_code(product_code);
		outkind.setOutkind_code(outkind_code);
		outkind.setAmount(amount);
		//outkind.setState(state);
		outkindservice.updateOutkind(outkind);
		
		//3.
		request.getRequestDispatcher("GetAllOutkindsServlet?service=allDeleteUpdate").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
