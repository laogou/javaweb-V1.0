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
import com.itheima.service.CardService;
import com.itheima.service.CardServiceImpl;

/**
 * Servlet implementation class CardUpdateServlet
 */
@WebServlet("/CardUpdateServlet")
public class CardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		        CardService cardservice=new CardServiceImpl(); 
				int serial=Integer.parseInt(request.getParameter("serial"));
				SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
				String time=request.getParameter("cz_month");
				String city_name= new String(request.getParameter("country_name").getBytes("iso-8859-1"), "utf-8");  
				System.out.println("卡信息修改城市名字"+city_name);
				String city_code=cardservice.getCity_code(city_name);
				System.out.println("卡信息修改城市代码"+city_code);
				String product_name= new String(request.getParameter("product_name").getBytes("iso-8859-1"), "utf-8");
				System.out.println("卡信息修改产品名字"+product_name);
				String product_code=cardservice.getProduct_code(product_name);
				System.out.println("卡信息修改产品代码"+product_code);
				int number=Integer.parseInt(request.getParameter("card_number"));
				double price=Double.parseDouble(request.getParameter("card_price"));
				double amount=number*price;
				double discount=Double.parseDouble(request.getParameter("discount"));
				//String state=request.getParameter("state");
				java.sql.Date date=null;
				Date date1=null;
				try {
					date1=(Date) ft.parse(time);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				date=new java.sql.Date(date1.getTime());
				Card card=new Card();
				card.setSerial(serial);
				card.setDate(date);
				card.setCity_code(city_code);
				card.setProduct_code(product_code);
				card.setNumber(number);
				card.setPrice(price);
				card.setAmount(amount);
				card.setDiscount(discount);
				//card.setState(state);
				
				//2.
				cardservice.updateCard(card);
				
				
				//3.
				request.getRequestDispatcher("GetAllCardsServlet?service=allDeleteUpdate").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
