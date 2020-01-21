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
 * Servlet implementation class AddOutkindServlet
 */
@WebServlet("/AddOutkindServlet")
public class AddOutkindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOutkindServlet() {
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
				OutkindServiceImpl outkindservice=new OutkindServiceImpl();
				int serial=outkindservice.getMaxSerial();
				System.out.println("MaxSerial="+serial);
				
				
				String city_name= new String(request.getParameter("country_name"));  
				System.out.println("city_name="+city_name);
				String city_code=outkindservice.getCity_code(city_name);
				String product_name= new String(request.getParameter("product_name"));
				String product_code=outkindservice.getProduct_code(product_name);
				String outkind_name= new String(request.getParameter("outkind_name"));
				String outkind_code=outkindservice.getOutkind_code(outkind_name);
				String amount1=request.getParameter("input_money");
				String state="0";
				java.sql.Date date=null;
				double amount;
				if(!"".equals(amount1))
				{
					amount=Double.parseDouble(amount1.toString());
				}else
					amount=0;
				Outkind outkind=new Outkind();
				outkind.setSerial(++serial);
				outkind.setDate(date);
				outkind.setCity_code(city_code);
				outkind.setProduct_code(product_code);
				outkind.setOutkind_code(outkind_code);
				outkind.setAmount(amount);
				outkind.setState(state);
				
				//���outkind�е�����
				System.out.println(outkind.getSerial());
				System.out.println(outkind.getDate());
				System.out.println(outkind.getCity_code());
				System.out.println(outkind.getProduct_code());
				System.out.println(outkind.getOutkind_code());
				
				//2.���������ҵ�ĳ��ҵ���߼�����
				OutkindServiceImpl outkindservice1=new OutkindServiceImpl();
				outkindservice1.addOutkind(outkind);
				System.out.println("���ݿ����ɹ�");
				
				//3.���ݴ������ҵ�ĳ����ͼ��Ӧ
				request.getRequestDispatcher("GetAllOutkindsServlet?service=allaccount").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
