package com.itheima.controller.preIncome;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.Dao.Pre.Pre;
import com.itheima.service.PreServiceImpl;

/**
 * Servlet implementation class GetAllPreServlet
 */
@WebServlet("/GetAllPreServlet")
public class GetAllPreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllPreServlet() {
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
		String[] params=new String[7];
		String  service=request.getParameter("service");
		System.out.println(service);
		if("select".equals(service))
		{
			Pre pre=(Pre) request.getAttribute("pre");
			int serial=pre.getSerial();
			Date date=pre.getDate();
			String city_code=pre.getCity_code();
			String product_code=pre.getProduct_code();
			String cancel_code=pre.getCancel_code();
			
			double amount=pre.getAmount();
			String state=pre.getState();
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
		params[4]=cancel_code;
		if(amount==-1)
		{
			params[5]=null;
		}else
			params[5]=String.valueOf(amount);
		params[6]=state;
		}
		PreServiceImpl preservice1= new PreServiceImpl();
		List<Pre> pres=preservice1.getAllPre(params);
		request.setAttribute("pres", pres);
		
		
		//3进入getall
		System.out.println("进入getall页面");
		if("allDeleteUpdate".equals(service)) {
			request.getRequestDispatcher("Income_entry/PreIncome/DeleteUpdate.jsp").forward(request, response);
		}
		else if("allaccount".equals(service))
		{
			request.getRequestDispatcher("Income_entry/PreIncome/account.jsp").forward(request, response);
		}
		else if("allselect".equals(service)||"select".equals(service))
		{
			request.getRequestDispatcher("Income_entry/PreIncome/select.jsp").forward(request, response);
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
