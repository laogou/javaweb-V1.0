package com.itheima.controller.NetIncome;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.Dao.Net.Net;
import com.itheima.service.NetService;
import com.itheima.service.NetServiceImpl;


/**
 * Servlet implementation class GetAllNetsServlet
 */
@WebServlet("/GetAllNetsServlet")
public class GetAllNetsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllNetsServlet() {
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
		System.out.println("getAll");
		String[] params=new String[8];
		String  service=request.getParameter("service");
		System.out.println(service);
		if("select".equals(service))
		{
			Net net=(Net)request.getAttribute("net");
			int serial=net.getSerial();
			Date date=net.getDate();
			String city_code=net.getCity_code();
			String product_code=net.getProduct_code();
			String operator_code=net.getOperator_code();
			String settle_code=net.getSettle_code();
			double amount=net.getAmount();
			String state=net.getState();
			if(serial==-1)
			{
				params[0]=null;
			}
			else
				params[0]=Integer.toString(serial);
			if(date!=null)
			{
				SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		        params[1]=ft.format(date);
			}else
				params[1]=null;
		params[2]=city_code;
		params[3]=product_code;
		params[4]=operator_code;
		params[5]=settle_code;
		if(amount==-1)
		{
			params[6]=null;
		}else
		{
			params[6]=String.valueOf(amount);
		}
		params[7]=state;
		} 
		NetService netservice=new NetServiceImpl();
		List<Net> nets=netservice.getAllNet(params);
		request.setAttribute("nets", nets);
		
		System.out.println("数据库提取全部数据成功");
		//3.找到页面响应
		if("allDeleteUpdate".equals(service)) {
			request.getRequestDispatcher("Income_entry/NetIncome/Net_delete_update.jsp").forward(request, response);
		}
		else if("alladd".equals(service))
		{
			request.getRequestDispatcher("Income_entry/NetIncome/Net_input.jsp").forward(request, response);
		}
		else if("allselect".equals(service)||"select".equals(service))
		{
			request.getRequestDispatcher("Income_entry/NetIncome/Net_select.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
