package com.itheima.controller.CardIncome;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.CardService;
import com.itheima.service.CardServiceImpl;
import com.itheima.service.OutkindServiceImpl;

/**
 * Servlet implementation class CardDeleteServlet
 */
@WebServlet("/CardDeleteServlet")
public class CardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.��������
				response.setContentType("text/html;charset=utf-8");
				request.setCharacterEncoding("utf-8");
				int serial=Integer.parseInt(request.getParameter("serial"));

			//2.���������ҵ�ĳ��ҵ���߼�����
				CardService cardservice=new CardServiceImpl();
				cardservice.deleteCard(serial);
				
			//3.���ݴ������ҵ�ĳ����ͼ��Ӧ
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
