package dao.collectDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import bean.SqlBean;

import common.NetG;

/**
 * 收款稽核底层操作
 * @author 张志远
 *
 */
public class NetCollectDao {
/**
 * 实现多条件查询net信息
 * @param net
 * @return
 */
	public ArrayList<NetG> doSearch(NetG net){
		ArrayList<NetG> list = new ArrayList<NetG>();
		NetG a = null;
		//boolean flag = false;
		boolean flag1 = true;
		Connection conn = SqlBean.getConn();
		PreparedStatement pst = null;
		
		ResultSet rs = null;
		try{
			String sql = "select * from net_input where net_input_state = 1";
			if(net==null){
				System.out.println("kong");
			}
			if(!net.getNetCityCode().equals("-1")){
				sql += " and net_input_city_code = '"+net.getNetCityCode()+"'";
				flag1 = false;
			}
			if(!net.getNetProductCode().equals("-1")){
				sql += " and net_input_product_code = '"+net.getNetProductCode()+"'";
				flag1 = false;
			}
			if(!net.getNetOperatorCode().equals("-1")){
				sql += " and net_input_operator_code = '"+net.getNetOperatorCode()+"'";
				flag1 = false;
			}
			if(!net.getNetSettleCode().equals("-1")){
				sql += " and net_input_settle_code = '"+net.getNetSettleCode()+"'";
				flag1 = false;
			}
			
			String[] time=net.getNetdate().split("/");
			if(!time[0].equals(" ")){
				sql=sql+" and net_input_date>='"+time[0]+"'";
				flag1 = false;
			}
			if(!time[1].equals(" ")){
				sql=sql+" and net_input_date<='"+time[1]+"'";
				flag1 = false;
			}
			if(flag1){
				sql = "select * from net_input where net_input_state = 1";
			}
			sql += " order by serial";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next())
			{ 		
				a = new NetG();
				//给Staff对象给数据库中的值

				a.setNetserial(rs.getInt("serial"));
				a.setNetdate(rs.getDate("net_input_date").toString());
				a.setNetCityCode(rs.getString("net_input_city_code"));
				a.setNetProductCode(rs.getString("net_input_product_code"));
				a.setNetOperatorCode(rs.getString("net_input_operator_code"));
				a.setNetSettleCode(rs.getString("net_input_settle_code"));
				a.setNetAmount(rs.getFloat("net_input_amount"));
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
	
}
