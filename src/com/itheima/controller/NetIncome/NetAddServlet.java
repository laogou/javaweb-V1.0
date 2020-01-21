package com.itheima.controller.NetIncome;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.Dao.Card.Card;
import com.itheima.Dao.Net.Net;
import com.itheima.Dao.Net.NetDao;
import com.itheima.Dao.Net.NetDaoImpl;
import com.itheima.service.CardService;
import com.itheima.service.CardServiceImpl;
import com.itheima.service.NetService;
import com.itheima.service.NetServiceImpl;

/**
 * Servlet implementation class NetAddServlet
 */
@WebServlet("/NetAddServlet")
public class NetAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NetAddServlet() {
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
				int serial=netservice.getMaxSerial();
				System.out.println("MaxSerial="+serial);
				java.sql.Date date=null;
				String city_name= new String(request.getParameter("country_name"));  
				System.out.println("网间结算城市名字"+city_name);
				String city_code=netservice.getCity_code(city_name);
				System.out.println("网间结算城市代码"+city_code);
				String product_name= new String(request.getParameter("product_name"));
				System.out.println("网间结算产品名字"+product_name);
				String product_code=netservice.getProduct_code(product_name);
				System.out.println("网间结算产品代码"+product_code);
				String operator_name= new String(request.getParameter("operator_name"));  
				String operator_code=netservice.getOperator_code(operator_name);
				String settle_name= new String(request.getParameter("settle_name"));
				String settle_code=netservice.getSettle_code(settle_name);
				double amount=0;
				if("".equals(request.getParameter("amount")))
					amount=0;
				else
					amount=Double.parseDouble(request.getParameter("amount"));
				String state="0";
				Net net=new Net();
				net.setSerial(++serial);
				net.setDate(date);
				net.setCity_code(city_code);
				net.setProduct_code(product_code);
				net.setOperator_code(operator_code);
				net.setSettle_code(settle_code);
				net.setAmount(amount);
				net.setState(state);
				
				//2.���������ҵ�ĳ��ҵ���߼�����
				NetService netservice1=new NetServiceImpl();
				netservice1.addNet(net);
				System.out.println("���ݿ����ɹ�");
				
				//3.���ݴ������ҵ�ĳ����ͼ��Ӧ
				request.getRequestDispatcher("GetAllNetsServlet?service=alladd").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
