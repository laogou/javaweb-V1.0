package com.itheima.Dao.Net;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itheima.Dao.Card.Card;
import com.itheima.utils.DbUtils;

public class NetDaoImpl implements NetDao {

	public void addNet(Net net)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "insert into net_input(serial,net_input_date,net_input_city_code"
					+ ",net_input_product_code,net_input_operator_code,net_input_settle_code,net_input_amount,"
					+ "net_input_state)  values(?,curdate(),?,?,?,?,?,'0')";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, net.getSerial());
			pstmt.setString(2, net.getCity_code());
			pstmt.setString(3, net.getProduct_code());
			pstmt.setString(4, net.getOperator_code());
			pstmt.setString(5, net.getSettle_code());
			pstmt.setDouble(6, net.getAmount());
			pstmt.executeUpdate();

			//System.out.println("���ݿⴴ���ɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			// 4.�ر����ݿ�
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);
		}
	}
	public void updateNet(Net net)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 3.
			conn=DbUtils.getConnection();
			
			String sql = "update net_input set "
					+ "net_input_date=?,net_input_city_code=?,net_input_product_code=?,"
					+ "net_input_operator_code=?,net_input_settle_code=?,net_input_amount=?"
					+ " where serial=?";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setDate(1, net.getDate());
			pstmt.setString(2, net.getCity_code());
			pstmt.setString(3, net.getProduct_code());
			pstmt.setString(4, net.getOperator_code());
			pstmt.setString(5, net.getSettle_code());
			pstmt.setDouble(6, net.getAmount());
			pstmt.setInt(7, net.getSerial());
			pstmt.executeUpdate();

			//System.out.println("���ݿⴴ���ɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("���ݿ����ʧ��");
			
		} finally {
			// 4.�ر����ݿ�
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);
		}
	}
	public void deleteNet(int serial)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "delete from net_input where serial=?;";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, serial);
			
			pstmt.executeUpdate();

			System.out.println("���ݿⴴ���ɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			// 4.�ر����ݿ�
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);
		}
	}
	public int getMaxSerial()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int serial=1;
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "select max(serial) from net_input";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
				serial=rs.getInt("max(serial)");
			System.out.println("���ݿⴴ���ɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			// 4.�ر����ݿ�
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);
		}
		return serial;
	}
	public List<Net> getAllNet(String[] params)
	{
		// TODO Auto-generated method stub
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				List<Net>  nets=new ArrayList<>();
				List<String> listParams = new ArrayList<>();// ������Ž���sql����й��м�������
				try {
					
					// 3.�������ݿ�
					// String sql="select  *  from  net_input";
					conn=DbUtils.getConnection();
					StringBuffer sql = new StringBuffer(
							"select  *  from net_input,city,product,operator,settle  where  1=1 "
							+ " and net_input_city_code=city_code"
							+ " and net_input_product_code=product_code"
							+ " and net_input_operator_code=operator_code"
							+ " and net_input_settle_code=settle_code");
					if (!"".equals(params[0]) && params[0] != null) {
						
						sql.append(" and  serial=?");
						listParams.add(params[0]);
					}
					if (!"".equals(params[1]) && params[1] != null) {
						sql.append("  and  net_input_date=?");
						listParams.add(params[1]);
					}
					if (!"".equals(params[2]) && params[2] != null) {
						sql.append("  and  net_input_city_code=?");
						listParams.add(params[2]);
					}
					if (!"".equals(params[3]) && params[3] != null) {
						sql.append("  and  net_input_product_code=?");
						listParams.add(params[3]);
					}
					if (!"".equals(params[4]) && params[4] != null) {
						sql.append("  and  net_input_operator_code=?");
						listParams.add(params[4]);
					}
					if (!"".equals(params[5]) && params[5] != null) {
						sql.append("  and  net_input_settle_code=?");
						listParams.add(params[5]);
					}
					if (!"".equals(params[6]) && params[6] != null) {
						sql.append("  and  net_input_amount=?");
						listParams.add(params[6]);
						System.out.println(params[6]);
					}
					if (!"".equals(params[7]) && params[7] != null) {
						sql.append("  and  net_input_state=?");
						listParams.add(params[7]);
					}
					System.out.println("sql:" + sql.toString());
					pstmt = conn.prepareStatement(sql.toString());
					for (int i = 0; i < listParams.size(); i++) {
						pstmt.setString(i + 1, listParams.get(i));
					}

					rs = pstmt.executeQuery();
					System.out.println("���ݿ��ѯ�ɹ�");
					while (rs.next()) {
						Net net=new Net();
		 				net.setSerial(rs.getInt("serial"));
		 				net.setDate(rs.getDate("net_input_date"));
		 				net.setCity_code(rs.getString("city_name"));
		 				net.setProduct_code(rs.getString("product_name"));
		 				net.setOperator_code(rs.getString("operator_name"));
		 				net.setSettle_code(rs.getString("settle_name"));
		 				net.setAmount(rs.getDouble("net_input_amount"));
		 				net.setState(rs.getString("net_input_state"));
		 				nets.add(net);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("���ݿ�����ʧ��");
				} finally {
					// 4.�ر����ݿ�
		            DbUtils.closeResultSet(rs);
		            DbUtils.closePreparedStatement(pstmt);
		            DbUtils.closeConnection(conn);
				}
				System.out.println(nets);
				return nets;
	}
	public Net getBySerial(int serial)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Net net=null;
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "select * from net_input,city,product,operator,settle  where serial=?"
					+ " and net_input_city_code=city_code"
					+ " and net_input_product_code=product_code"
					+ " and net_input_operator_code=operator_code"
					+ " and net_input_settle_code=settle_code";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, serial);
			rs = pstmt.executeQuery();
			System.out.println(sql);
			System.out.println(serial);
			System.out.println("getBy���ݿⴴ���ɹ�");
			while (rs.next()) {
				Net net1=new Net();
 				net1.setSerial(rs.getInt("serial"));
 				net1.setDate(rs.getDate("net_input_date"));
 				net1.setCity_code(rs.getString("city_name"));
 				net1.setProduct_code(rs.getString("product_name"));
 				net1.setOperator_code(rs.getString("operator_name"));
 				net1.setSettle_code(rs.getString("settle_name"));
 				net1.setAmount(rs.getDouble("net_input_amount"));
 				net1.setState(rs.getString("net_input_state"));
 				net=net1;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("outkind.set����ʧ��");
			
		} finally {
			// 4.�ر����ݿ�
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);
		}
		return net;
	}
	public String getCity_code(String city_name)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String city_code=null;
		System.out.println("city_name="+city_name);
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "select city_code from city where city_name=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, city_name);
			rs = pstmt.executeQuery();
			System.out.println(sql);
			System.out.println("getCity_code���ݿⴴ���ɹ�");
			while (rs.next()) {
				city_code=rs.getString("city_code");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getCity_codeʧ��");
			
		} finally {
			// 4.�ر����ݿ�
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);
		}
		return city_code;
	}
	public String getProduct_code(String product_name)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String product_code=null;
		System.out.println("product_name="+product_name);
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "select product_code from product where product_name=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product_name);
			rs = pstmt.executeQuery();
			System.out.println(sql);
			System.out.println("getProduct_code���ݿⴴ���ɹ�");
			while (rs.next()) {
				product_code=rs.getString("product_code");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getCity_codeʧ��");
			
		} finally {
			// 4.�ر����ݿ�
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);
		}
		return product_code;
	}
	public String getOperator_code(String operator_name)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String operator_code=null;
		System.out.println("operator_name="+operator_name);
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "select operator_code from operator where operator_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, operator_name);
			rs = pstmt.executeQuery();
			System.out.println(sql);
			System.out.println("getProduct_code���ݿⴴ���ɹ�");
			while (rs.next()) {
				operator_code=rs.getString("operator_code");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getOperator_codeʧ��");
			
		} finally {
			// 4.�ر����ݿ�
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);
		}
		return operator_code;
	}
	public String getSettle_code(String settle_name)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String settle_code=null;
		System.out.println("settle_name="+settle_name);
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "select settle_code from settle where settle_name=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, settle_name);
			rs = pstmt.executeQuery();
			System.out.println(sql);
			System.out.println("getSettle_code���ݿⴴ���ɹ�");
			while (rs.next()) {
				settle_code=rs.getString("settle_code");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getSettle_codeʧ��");
			
		} finally {
			// 4.�ر����ݿ�
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);
		}
		return settle_code;
	}
}
