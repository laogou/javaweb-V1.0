package dao.checkDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import bean.SqlBean;

import common.PreG;

/**
 * 收款稽核底层操作
 * @author 张志远
 *
 */
public class PreCheckDao {
/**
 * 实现多条件查询pre信息
 * @param pre
 * @return
 */
	public ArrayList<PreG> doSearch(PreG pre){
		ArrayList<PreG> list = new ArrayList<PreG>();
		PreG a = null;
		//boolean flag = false;
		boolean flag1 = true;
		Connection conn = SqlBean.getConn();
		PreparedStatement pst = null;
		
		ResultSet rs = null;
		try{
			String sql = "select * from pre_input where pre_input_state = 0";
			if(pre==null){
				System.out.println("kong");
			}
			if(!pre.getPreCityCode().equals("-1")){
				sql += " and pre_input_city_code = '"+pre.getPreCityCode()+"'";
				flag1 = false;
			}
			if(!pre.getPreProductCode().equals("-1")){
				sql += " and pre_input_product_code = '"+pre.getPreProductCode()+"'";
				flag1 = false;
			}
			if(!pre.getPreCancelCode().equals("-1")){
				sql += " and pre_input_cancel_code = '"+pre.getPreCancelCode()+"'";
				flag1 = false;
			}
			
			
			String[] time=pre.getPredate().split("/");
			if(!time[0].equals(" ")){
				sql=sql+" and pre_input_date>='"+time[0]+"'";
				flag1 = false;
			}
			if(!time[1].equals(" ")){
				sql=sql+" and pre_input_date<='"+time[1]+"'";
				flag1 = false;
			}
			if(flag1){
				sql = "select * from pre_input where pre_input_state = 0";
			}
			sql += " order by serial";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next())
			{ 		
				a = new PreG();
				//给Staff对象给数据库中的值

				a.setPreserial(rs.getInt("serial"));
				a.setPredate(rs.getDate("pre_input_date").toString());
				a.setPreCityCode(rs.getString("pre_input_city_code"));
				a.setPreProductCode(rs.getString("pre_input_product_code"));
				a.setPreCancelCode(rs.getString("pre_input_cancel_code"));
				a.setPreamount(rs.getFloat("pre_input_amount"));
				
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
	public void doUpdate(ArrayList<PreG> list){
		Connection conn = SqlBean.getConn();
		PreparedStatement pstmt = null;
		String sql = "Update pre_input set pre_input_state = ? where serial = ? ";
		pstmt = SqlBean.getPstmt(conn, sql);
		try {
			for(int i=0;i<list.size();i++){
				pstmt.setInt(1, list.get(i).getPreType());
				pstmt.setInt(2, list.get(i).getPreserial());
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
