package com.itheima.Dao.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itheima.utils.DbUtils;

public class PreDaoImpl implements PreDao{

	@Override
	public void addPre(Pre pre) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "insert into pre_input(serial,pre_input_date,pre_input_city_code"
					+ ",pre_input_product_code,pre_input_cancel_code,pre_input_amount,"
					+ "pre_input_state)  values(?,curdate(),?,?,?,?,'0')";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pre.getSerial());
			pstmt.setString(2, pre.getCity_code());
			pstmt.setString(3, pre.getProduct_code());
			pstmt.setString(4, pre.getCancel_code());
			pstmt.setDouble(5, pre.getAmount());
			
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

	@Override
	public void updatePre(Pre pre) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "update pre_input set "
					+ "pre_input_date=?,pre_input_city_code=?,pre_input_product_code=?,"
					+ "pre_input_cancel_code=?,pre_input_amount=?"
					+ " where serial=?";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setDate(1, pre.getDate());
			pstmt.setString(2, pre.getCity_code());
			pstmt.setString(3, pre.getProduct_code());
			pstmt.setString(4, pre.getCancel_code());
			pstmt.setDouble(5, pre.getAmount());

			pstmt.setInt(6, pre.getSerial());
			pstmt.executeUpdate();

			System.out.println("���ݿⴴ���ɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ����ʧ��");
			
		} finally {
			// 4.�ر����ݿ�
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);
		}
	}

	@Override
	public void deletePre(int serial) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "delete from pre_input where serial=?;";
			
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

	@Override
	public int getMaxSerial() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int serial=0;
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "select max(serial) from pre_input";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
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

	@Override
	public List<Pre> getAllPre(String[] params) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Pre>  pres=new ArrayList<>();
		List<String> listParams = new ArrayList<>();// ������Ž���sql����й��м�������
		try {
			
			// 3.�������ݿ�
			// String sql="select  *  from  outkind_input";
			conn=DbUtils.getConnection();
			StringBuffer sql = new StringBuffer(
					"select  *  from pre_input,city,product,cancel  where  1=1 "
							+ " and pre_input_city_code=city_code"
							+ " and pre_input_product_code=product_code"
							+ " and pre_input_cancel_code=cancel_code");
			if (!"".equals(params[0]) && params[0] != null) {
				
				sql.append(" and  serial=?");
				listParams.add(params[0]);
			}
			if (!"".equals(params[1]) && params[1] != null) {
				sql.append("  and  pre_input_date=?");
				listParams.add(params[1]);
			}
			if (!"".equals(params[2]) && params[2] != null) {
				sql.append("  and  pre_input_city_code=?");
				listParams.add(params[2]);
			}
			if (!"".equals(params[3]) && params[3] != null) {
				sql.append("  and  pre_input_product_code=?");
				listParams.add(params[3]);
			}
			if (!"".equals(params[4]) && params[4] != null) {
				sql.append("  and  pre_input_cancel_code=?");
				listParams.add(params[4]);
			}
			if (!"".equals(params[5]) && params[5] != null) {
				sql.append("  and  pre_input_amount=?");
				listParams.add(params[5]);
			}
			if (!"".equals(params[6]) && params[6] != null) {
				sql.append("  and  pre_input_state=?");
				listParams.add(params[6]);
			}
			System.out.println("sql:" + sql.toString());
			pstmt = conn.prepareStatement(sql.toString());
			for (int i = 0; i < listParams.size(); i++) {
				pstmt.setString(i + 1, listParams.get(i));
			}

			rs = pstmt.executeQuery();
			System.out.println("���ݿ��ѯ�ɹ�");
			while (rs.next()) {
			Pre  pre1=new  Pre();
			System.out.println(rs.getInt("serial"));
			pre1.setSerial(rs.getInt("serial"));
			pre1.setDate(rs.getDate("pre_input_date"));
			System.out.println(pre1.getSerial());
			pre1.setCity_code(rs.getString("city_name"));
			pre1.setProduct_code(rs.getString("product_name"));
			pre1.setCancel_code(rs.getString("cancel_name"));
			pre1.setAmount(rs.getDouble("pre_input_amount"));
			pre1.setState(rs.getString("pre_input_state"));
			pres.add(pre1);
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
		System.out.println(pres);
		return pres;
	}

	@Override
	public Pre getBySerial(int serial) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Pre pre = null;
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "select * from pre_input,city,product,cancel where serial=?"
					+ " and pre_input_city_code=city_code"
					+ " and pre_input_product_code=product_code"
					+ " and pre_input_cancel_code=cancel_code";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, serial);
			rs = pstmt.executeQuery();
			System.out.println(sql);
			System.out.println(serial);
			System.out.println("getBy���ݿⴴ���ɹ�");
			while (rs.next()) {
				Pre pre1=new  Pre();
				pre1.setSerial(rs.getInt("serial"));
				pre1.setDate(rs.getDate("pre_input_date"));
				pre1.setCity_code(rs.getString("city_name"));
				pre1.setProduct_code(rs.getString("product_name"));
				pre1.setCancel_code(rs.getString("cancel_name"));
				pre1.setAmount(rs.getDouble("pre_input_amount"));
				pre1.setState(rs.getString("pre_input_state"));
				pre=pre1;
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
		return pre;
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
			System.out.println("getProduct_codeʧ��");
			
		} finally {
			// 4.�ر����ݿ�
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);
		}
		return product_code;
	}
	public String getCancel_code(String cancel_name)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String cancel_code=null;
		System.out.println("cancel_name="+cancel_name);
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "select cancel_code from cancel where cancel_name=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cancel_name);
			rs = pstmt.executeQuery();
			System.out.println(sql);
			System.out.println("getCancel_code���ݿⴴ���ɹ�");
			while (rs.next()) {
				cancel_code=rs.getString("cancel_code");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getCancel_codeʧ��");
			
		} finally {
			// 4.�ر����ݿ�
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);
		}
		return cancel_code;
	}
}
