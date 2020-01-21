package dao.loginDao;


import java.sql.*;

import bean.SqlBean;
/*
 * 登录数据库检索
 */
public class LoginDao {
	/**
	 * 
	 * @param users_name   用户名

	 * @param users_passwd 密码
	 * @param role         角色
	 * @return 整         返回角色值   
	 */
	public int doQuery(String users_name,String users_passwd) {
		int i = 99999 ;
		SqlBean ob = new SqlBean();//建立链接数据库对象
		Connection con = ob.getConn();   //加载驱动
		ResultSet rs = null;
		String sql = "Select * from user where user_name =? and user_password = ?";//查询语句
		PreparedStatement pst = null;
		//Statement st = ob.getStmt(con);
		
		try {
		    pst = con.prepareStatement(sql) ;
			pst.setString(1, users_name);
			pst.setString(2, users_passwd);
			rs = pst.executeQuery();//获取查询结果
			
			//角色赋值返回
			if(rs.next()){
				i=rs.getInt("user_role");					
			}
			
	}catch (SQLException e) {
		
		e.printStackTrace();
	}finally{
		try {
			con.close();
			rs.close();
			pst.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
		return i;//返回角色
}
}
