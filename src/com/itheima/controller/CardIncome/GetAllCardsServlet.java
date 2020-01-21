package com.itheima.controller.CardIncome;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.Dao.Card.Card;
import com.itheima.Dao.Outkind.Outkind;
import com.itheima.service.CardService;
import com.itheima.service.CardServiceImpl;
import com.itheima.service.OutkindServiceImpl;

/**
 * Servlet implementation class GetAllCardServlet
 */
@WebServlet("/GetAllCardsServlet")
public class GetAllCardsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllCardsServlet() {
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
				String[] params=new String[9];
				String  service=request.getParameter("service");
				System.out.println(service);
				if("select".equals(service))
				{
					Card card=(Card)request.getAttribute("card");
					int serial=card.getSerial();
					Date date=card.getDate();
					String city_code=card.getCity_code();
					String product_code=card.getProduct_code();
					int number=card.getNumber();
					double price=card.getPrice();
					double amount=card.getAmount(true);
					double discount=card.getDiscount();
					String state=card.getState();
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
				if(number==-1)
				{
					params[4]=null;
				}else
				{
					params[4]=Integer.toString(number);
				}
				if(price==-1)
				{
					params[5]=null;
				}else
				{
					params[5]=String.valueOf(price);
				}
				if(amount==-1)
				{
					params[6]=null;
				}else
				{
					params[6]=String.valueOf(amount);
				}
				if(discount==-1)
				{
					params[7]=null;
				}else
				{
					params[7]=String.valueOf(discount);
				}
				params[8]=state;
				} 
				CardService cardservice=new CardServiceImpl();
				List<Card> cards=cardservice.getAllCard(params);
				request.setAttribute("cards", cards);
				
				System.out.println("数据库提取全部数据成功");
				//3.找到页面响应
				if("allDeleteUpdate".equals(service)) {
					request.getRequestDispatcher("Income_entry/CardIncome/card_delete_update.jsp").forward(request, response);
				}
				else if("alladd".equals(service))
				{
					request.getRequestDispatcher("Income_entry/CardIncome/card_input.jsp").forward(request, response);
				}
				else if("allselect".equals(service)||"select".equals(service))
				{
					request.getRequestDispatcher("Income_entry/CardIncome/card_select.jsp").forward(request, response);
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
