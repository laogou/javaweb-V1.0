package com.itheima.controller.NetIncome;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.Dao.Net.Net;
import com.itheima.service.NetService;
import com.itheima.service.NetServiceImpl;


/**
 * Servlet implementation class GetNetServlet
 */
@WebServlet("/GetNetServlet")
public class GetNetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNetServlet() {
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
				NetService netservice=new NetServiceImpl();
				Net net=netservice.getBySerial(serial);
				request.setAttribute("net", net);
				request.getRequestDispatcher("Income_entry/NetIncome/Net_update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
