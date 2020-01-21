package com.itheima.controller.AccountIncome;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.Dao.Outkind.Outkind;
import com.itheima.service.OutkindServiceImpl;

/**
 * Servlet implementation class GetOutkindServlet
 */
@WebServlet("/GetOutkindServlet")
public class GetOutkindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOutkindServlet() {
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
				OutkindServiceImpl outkindservice=new OutkindServiceImpl();
				Outkind outkind=outkindservice.getBySerial(serial);
				request.setAttribute("outkind",outkind);
				request.getRequestDispatcher("Income_entry/AccountIncome/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
