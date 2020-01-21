package bean.logoutServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LogoutCheckServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 安全退出： 删除掉session对象中指定的loginName属性即可
		// 1.得到session对象
		HttpSession session = request.getSession(false);
		if (session != null) {
			// 2.删除属性
			session.removeAttribute("user");
		}
		// 2.返回登录页面
		response.sendRedirect(request.getContextPath() + "/login/login.jsp");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
