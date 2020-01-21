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
 * Servlet implementation class GetCardServlet
 */
@WebServlet("/GetCardServlet")
public class GetCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int serial=Integer.parseInt(request.getParameter("serial"));
		System.out.println(serial);
		CardService cardservice=new CardServiceImpl();
		Card card=cardservice.getBySerial(serial);
		request.setAttribute("card", card);
		request.getRequestDispatcher("Income_entry/CardIncome/card_update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
