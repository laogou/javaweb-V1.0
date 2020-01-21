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
import com.itheima.service.OutkindServiceImpl;

/**
 * Servlet implementation class GetAllOutkindsServlet
 */
@WebServlet("/GetAllOutkindsServlet")
public class GetAllOutkindsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllOutkindsServlet() {
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
			Outkind outkind=(Outkind) request.getAttribute("outkind");
			int serial=outkind.getSerial();
			Date date=outkind.getDate();
			String city_code=outkind.getCity_code();
			String product_code=outkind.getProduct_code();
			String outkind_code=outkind.getOutkind_code();
			double amount=outkind.getAmount();
			String state=outkind.getState();
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
		params[4]=outkind_code;
		if(amount==-1)
		{
			params[5]=null;
		}else
			params[5]=String.valueOf(amount);
		params[6]=state;
		}
		OutkindServiceImpl outkindservice= new OutkindServiceImpl();
		List<Outkind> outkinds=outkindservice.getAllOutkind(params);
		request.setAttribute("outkinds", outkinds);
		
		//System.out.println("���ݿ���ȡȫ�����ݳɹ�");
		//3.�ҵ�ҳ����Ӧ
		if("allDeleteUpdate".equals(service)) {
			request.getRequestDispatcher("Income_entry/AccountIncome/DeleteUpdate.jsp").forward(request, response);
		}
		else if("allaccount".equals(service))
		{
			request.getRequestDispatcher("Income_entry/AccountIncome/account.jsp").forward(request, response);
		}
		else if("allselect".equals(service)||"select".equals(service))
		{
			request.getRequestDispatcher("Income_entry/AccountIncome/select.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
