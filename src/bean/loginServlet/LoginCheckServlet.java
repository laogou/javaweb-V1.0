package bean.loginServlet;

import java.io.UnsupportedEncodingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.loginService.LoginService;


/**
 * 登录验证
 * @author 张志远
 *
 */


@SuppressWarnings("serial")
public class LoginCheckServlet extends  HttpServlet {

	/**
	 * 对页面的post请求做出响应
	 */
public void doPost (HttpServletRequest request,HttpServletResponse response) throws ServletException, UnsupportedEncodingException{
		/**
		 * 接收从jsp里传来的值

		 */
		String s1 = request.getParameter("user_name");//获取用户名
		String s2 = (new String(s1.getBytes("ISO-8859-1"),"UTF-8"));//转换字符类型，防止产生乱码
		String s3 = request.getParameter("user_password");//获取用户密码
		String s4 = (new String(s3.getBytes("ISO-8859-1"),"UTF-8"));//转换字符类型，防止产生乱码

		//String s5 = request.getParameter("role");
		//int role =Integer.parseInt(s5);//获取角色
		
		LoginService ls = new LoginService();//建立LoginService对象
		int i = ls.doQuery(s2, s4);//查询
			
			try {
				request.setAttribute("loginer", s1);
				request.getSession().setAttribute("user", s1);
					switch(i){//根据返回的i值判断用户角色，输入是否正确，进入相应界面

					case 1:
					{
						request.setAttribute("nav", "input.jsp");  //
						request.getRequestDispatcher("/homePage.jsp").forward(request, response); //请求转发
						break;
					}	
					case 2:
					{
						request.setAttribute("nav", "audit.jsp");
						request.getRequestDispatcher("/homePage.jsp").forward(request, response);
						break;
					}
					case 3:
					{
						request.setAttribute("nav", "finance.jsp");
						request.getRequestDispatcher("/homePage.jsp").forward(request, response);
						break;
					}
					default:{
						request.getRequestDispatcher("/login/error.jsp").forward(request, response);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
/**
 * 对页面的get请求做出响应
 */
public void doGet (HttpServletRequest request,HttpServletResponse response) throws ServletException, UnsupportedEncodingException{
	/*
	 * 调用dopost方法
	 */
	doPost(request,response);
}

}

