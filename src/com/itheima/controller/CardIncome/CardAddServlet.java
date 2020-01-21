package com.itheima.controller.CardIncome;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.Dao.Card.Card;
import com.itheima.service.CardService;
import com.itheima.service.CardServiceImpl;

/**
 * Servlet implementation class CardAddServlet
 */
@WebServlet("/CardAddServlet")
public class CardAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardAddServlet() {
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
		int serial=cardservice.getMaxSerial();
		System.out.println("MaxSerial="+serial);
		java.sql.Date date=null;
		String city_name= new String(request.getParameter("country_name"));  
		System.out.println("卡销售城市名字"+city_name);
		String city_code=cardservice.getCity_code(city_name);
		System.out.println("卡销售城市代码"+city_code);

		String product_name= new String(request.getParameter("product_name"));
		String product_code=cardservice.getProduct_code(product_name);
		int number;
		if("".equals(request.getParameter("card_number")))
			number=0;
		else
			number=Integer.parseInt(request.getParameter("card_number"));
		double price;
		if("".equals(request.getParameter("card_money")))
			price=0;
		else
			price=Double.parseDouble(request.getParameter("card_money"));
		double amount=number*price;
		double discount;
		if("".equals(request.getParameter("discount")))
			discount=0;
		else
			discount=Double.parseDouble(request.getParameter("discount"));
		String state="0";
		Card card=new Card();
		card.setSerial(++serial);
		card.setDate(date);
		card.setCity_code(city_code);
		card.setProduct_code(product_code);
		card.setNumber(number);
		card.setPrice(price);
		card.setAmount(amount);
		card.setDiscount(discount);
		card.setState(state);
		
		//2.���������ҵ�ĳ��ҵ���߼�����
		CardService cardservice1=new CardServiceImpl();
		cardservice1.addCard(card);
		System.out.println("���ݿ����ɹ�");
		
		//3.���ݴ������ҵ�ĳ����ͼ��Ӧ
		request.getRequestDispatcher("GetAllCardsServlet?service=alladd").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
