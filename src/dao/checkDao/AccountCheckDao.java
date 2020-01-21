package dao.checkDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import bean.SqlBean;

import common.AccountG;

/**
 * 收款稽核底层操作
 * @author 张志远
 *
 */
public class AccountCheckDao {
/**
 * 实现多条件查询account信息
 * @param account
 * @return
 */
	public ArrayList<AccountG> doSearch(AccountG account){
		ArrayList<AccountG> list = new ArrayList<AccountG>();
		AccountG a = null;
		//boolean flag = false;
		boolean flag1 = true;
		Connection conn = SqlBean.getConn();
		PreparedStatement pst = null;
		
		ResultSet rs = null;
		try{
			String sql = "select * from outkind_input where outkind_input_state = 0";
			if(account==null){
				System.out.println("kong");
			}
			if(!account.getAccountCityCode().equals("-1")){
				sql += " and outkind_input_city_code = '"+account.getAccountCityCode()+"'";
				flag1 = false;
			}
			if(!account.getAccountProductCode().equals("-1")){
				sql += " and outkind_input_product_code = '"+account.getAccountProductCode()+"'";
				flag1 = false;
			}
			
			String[] time=account.getAccountdate().split("/");
			if(!time[0].equals(" ")){
				//sql=sql+" and card_input_date>=('"+time[0]+"','yyyy-mm-dd')";
				sql=sql+" and outkind_input_date>='"+time[0]+"'";
				flag1 = false;
			}
			if(!time[1].equals(" ")){
				//sql=sql+" and card_input_date<=('"+time[1]+"','yyyy-mm-dd')";
				sql=sql+" and outkind_input_date<='"+time[1]+"'";
				flag1 = false;
			}
			if(flag1){
				sql = "select * from outkind_input where outkind_input_state = 0";
			}
			sql += " order by serial";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next())
			{ 		
				a = new AccountG();
				//给Staff对象给数据库中的值

				a.setAccountserial(rs.getInt("serial"));
				a.setAccountdate(rs.getDate("outkind_input_date").toString());
				a.setAccountCityCode(rs.getString("outkind_input_city_code"));
				a.setAccountProductCode(rs.getString("outkind_input_product_code"));
				a.setAccountOutKindCode(rs.getString("outkind_input_outkind_code"));
				a.setAccountNum(rs.getFloat("outkind_input_amount"));
				
				list.add(a);
			}
		}catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	/**
	 * 实现稽核返回稽核情况
	 * @param card
	 */
	public void doUpdate(ArrayList<AccountG> list){
		Connection conn = SqlBean.getConn();
		PreparedStatement pstmt = null;
		String sql = "Update outkind_input set outkind_input_state = ? where serial = ? ";
		pstmt = SqlBean.getPstmt(conn, sql);
		try {
			for(int i=0;i<list.size();i++){
				pstmt.setInt(1, list.get(i).getAccountType());
				pstmt.setInt(2, list.get(i).getAccountserial());
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
