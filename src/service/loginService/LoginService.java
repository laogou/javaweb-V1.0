package service.loginService;
import dao.loginDao.LoginDao;

/**
 * 登录
 * @author 张志远
 *
 */
public class LoginService {
/**
 * 
 * @param users_name      用户名

 * @param users_passwd    密码
 * @param role            角色
 * @return                返回角色
 */
	public int doQuery(String users_name,String users_passwd){
		LoginDao usersDao = new LoginDao();
		return usersDao.doQuery(users_name, users_passwd);
	}
}
