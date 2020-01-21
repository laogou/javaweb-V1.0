package com.itheima.controller.AccountIncome;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.OutkindService;
import com.itheima.service.OutkindServiceImpl;

/**
 * Servlet implementation class DeleteOutkindServlet
 */
@WebServlet("/DeleteOutkindServlet")
public class DeleteOutkindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOutkindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				//1.接受请求
						response.setContentType("text/html;charset=utf-8");
						request.setCharacterEncoding("utf-8");
						int serial=Integer.parseInt(request.getParameter("serial"));

						
					//2.根据请求找到某个业务逻辑处理
					OutkindServiceImpl outkindservice=new OutkindServiceImpl();
					outkindservice.deleteOutkind(serial);
					//3.根据处理结果找到某个视图响应
					request.getRequestDispatcher("GetAllOutkindsServlet?service=allDeleteUpdate").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
