package com.itheima.controller.CardIncome;

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
import com.itheima.Dao.Outkind.Outkind;
import com.itheima.service.CardService;
import com.itheima.service.CardServiceImpl;

/**
 * Servlet implementation class CardSelectServlet
 */
@WebServlet("/CardSelectServlet")
public class CardSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardSelectServlet() {
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
				CardService cardservice=new CardServiceImpl();
				String serial1=request.getParameter("serial");
				String time=request.getParameter("cz_month");
				String city_name= new String(request.getParameter("country_name"));  
				System.out.println("查询卡城市名字"+city_name);
				String city_code=cardservice.getCity_code(city_name);
				System.out.println("查询卡城市代码"+city_code);
				
				String product_name= new String(request.getParameter("product_name"));
				System.out.println("查询卡产品名字"+city_name);
				
				String product_code=cardservice.getProduct_code(product_name);
				System.out.println("查询卡产品代码"+product_code);
				
				String number1=request.getParameter("card_number");
				String price1=request.getParameter("card_price");
				String amount1=request.getParameter("card_amount");
				String discount1=request.getParameter("discount");
				String state=request.getParameter("state");
				Card card=new Card();
				if(!"".equals(serial1))
				{
					int serial=Integer.parseInt(serial1);
					card.setSerial(serial);
				}
				else
					card.setSerial(-1);
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
					card.setDate(date);
				}else
					card.setDate(null);
				if(!"��ѡ�����".equals(city_code) && !" ".equals(city_code))
				{
					card.setCity_code(city_code);
				}
				else
					card.setCity_code(null);
				if(!"��ѡ���Ʒ����".equals(product_code) && !" ".equals(product_code))
				{
					card.setProduct_code(product_code);
				}else
					card.setProduct_code(null);
				if(!"".equals(number1))
				{
					int number=Integer.parseInt(number1);
					card.setNumber(number);
				}else
					card.setNumber(-1);
				if(!"".equals(price1))
				{
					double price=Double.parseDouble(price1);
					card.setPrice(price);
				}else
					card.setPrice(-1);
				if(!"".equals(amount1))
				{
					double amount=Double.parseDouble(amount1);
					card.setAmount(amount);
				}else
					card.setAmount(-1);
				if(!"".equals(discount1))
				{
					double discount=Double.parseDouble(discount1);
					card.setDiscount(discount);
				}else
					card.setDiscount(-1);
				
				if(!"".equals(state))
					card.setState(state);
				else
					card.setState(null);
				
				System.out.println("city_code="+city_code);
				//2.���������ҵ�ĳ��ҵ���߼�����
				
				
				request.setAttribute("card",card);
				//3.���ݴ������ҵ�ĳ����ͼ��Ӧ
				request.getRequestDispatcher("GetAllCardsServlet?service=select").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
