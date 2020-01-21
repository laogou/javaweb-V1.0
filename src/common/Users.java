package common;

/**
 * 用户信息表
 * @author new
 *
 */
public class Users {

	private String userName = "";      //用户登录时的名字
	private String userPassWd = "";    //用户登录密码
	private int userRole;        //权限1表示卡信息录入人员，2表示稽查人员，3表示财务人员

	/**
	 * 无参构造函数
	 */
	public Users(){
		
	}
	/**
	 * 有参构造函数
	 */
    public Users(String userName,String userPassWd,int userRole,String userRealName,int userSex,String userContact,int userState){
		this.userName = userName;
		this.userPassWd = userPassWd;
		this.userRole = userRole;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userPassWd
	 */
	public String getUserPassWd() {
		return userPassWd;
	}
	/**
	 * @param userPassWd the userPassWd to set
	 */
	public void setUserPassWd(String userPassWd) {
		this.userPassWd = userPassWd;
	}
	/**
	 * @return the userRole
	 */
	public int getUserRole() {
		return userRole;
	}
	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
		
	
	
}
