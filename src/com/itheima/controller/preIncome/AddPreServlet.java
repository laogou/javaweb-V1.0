package com.itheima.controller.preIncome;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.Dao.Pre.Pre;
import com.itheima.service.PreServiceImpl;



/**
 * Servlet implementation class AddPreServlet
 */
@WebServlet("/AddPreServlet")
public class AddPreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPreServlet() {
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
		PreServiceImpl preservice=new PreServiceImpl();
		int serial=preservice.getMaxSerial();
		System.out.println("MaxSerial="+serial);
		
		String city_name= new String(request.getParameter("country_name"));  
		System.out.println("city_name="+city_name);
		String city_code=preservice.getCity_code(city_name);
		String product_name= new String(request.getParameter("product_name"));
		String product_code=preservice.getProduct_code(product_name);
		String cancel_name= new String(request.getParameter("cancel_name"));  
		String cancel_code=preservice.getCancel_code(cancel_name);
		String amount1=request.getParameter("input_money");
		String state="0";
		java.sql.Date date=null;
		double amount=0;
		if(!"".equals(amount1))
			amount=Double.parseDouble(amount1.toString());
		Pre pre=new Pre();
		pre.setSerial(++serial);
		pre.setDate(date);
		pre.setCity_code(city_code);
		pre.setProduct_code(product_code);
		pre.setCancel_code(cancel_code);
		pre.setAmount(amount);
		pre.setState(state);
		
		//���outkind�е�����
		System.out.println(pre.getSerial());
		System.out.println(pre.getDate());
		System.out.println(pre.getCity_code());
		System.out.println(pre.getProduct_code());
		System.out.println(pre.getCancel_code());
		
		//2.���������ҵ�ĳ��ҵ���߼�����
		PreServiceImpl preservice1=new PreServiceImpl();
		preservice1.addPre(pre);
		System.out.println("���ݿ����ɹ�");
		
		//3.���ݴ������ҵ�ĳ����ͼ��Ӧ
		request.getRequestDispatcher("GetAllPreServlet?service=allaccount").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
