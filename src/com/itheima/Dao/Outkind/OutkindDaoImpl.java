package com.itheima.Dao.Outkind;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itheima.utils.DbUtils;

public class OutkindDaoImpl implements OutkindDao {

	public void addOutkind(Outkind outkind)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "insert into Outkind_input(serial,outkind_input_date,outkind_input_city_code"
					+ ",outkind_input_product_code,outkind_input_outkind_code,outkind_input_amount,"
					+ "outkind_input_state)  values(?,curdate(),?,?,?,?,'0')";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, outkind.getSerial());
			pstmt.setString(2, outkind.getCity_code());
			pstmt.setString(3, outkind.getProduct_code());
			pstmt.setString(4, outkind.getOutkind_code());
			pstmt.setDouble(5, outkind.getAmount());
			
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
	public void updateOutkind(Outkind outkind)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 3
			conn=DbUtils.getConnection();
			
			String sql = "update outkind_input set "
					+ "outkind_input_date=?,outkind_input_city_code=?,outkind_input_product_code=?,"
					+ "outkind_input_outkind_code=?,outkind_input_amount=?"
					+ " where serial=?";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setDate(1, outkind.getDate());
			pstmt.setString(2, outkind.getCity_code());
			pstmt.setString(3, outkind.getProduct_code());
			pstmt.setString(4, outkind.getOutkind_code());
			pstmt.setDouble(5, outkind.getAmount());
			pstmt.setInt(6, outkind.getSerial());
			pstmt.executeUpdate();

			System.out.println("出账收入信息修改");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("���ݿ����ʧ��");
			
		} finally {
			// 4.
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);
		}
	}
	public void deleteOutkind(int serial) 
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 3.
			conn=DbUtils.getConnection();
			
			String sql = "delete from outkind_input where serial=?;";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, serial);
			
			pstmt.executeUpdate();

			System.out.println("出账信息删除");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			// 4.
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);
		}

	}
	public int getMaxSerial()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int serial=0;
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "select max(serial) from outkind_input";
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
	public List<Outkind> getAllOutkind(String[] params)
	{
		// TODO Auto-generated method stub
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				List<Outkind>  outkinds=new ArrayList<>();
				List<String> listParams = new ArrayList<>();// ������Ž���sql����й��м�������
				try {
					
					// 3.�������ݿ�
					// String sql="select  *  from  outkind_input";
					conn=DbUtils.getConnection();
					StringBuffer sql = new StringBuffer(
							"select  *  from outkind_input,city,product,outkind  where  1=1 "
									+ " and outkind_input_city_code=city_code"
									+ " and outkind_input_product_code=product_code"
									+ " and outkind_input_outkind_code=outkind_code");
					if (!"".equals(params[0]) && params[0] != null) {
						
						sql.append(" and  serial=?");
						listParams.add(params[0]);
					}
					if (!"".equals(params[1]) && params[1] != null) {
						sql.append("  and  outkind_input_date=?");
						listParams.add(params[1]);
					}
					if (!"".equals(params[2]) && params[2] != null) {
						sql.append("  and  outkind_input_city_code=?");
						listParams.add(params[2]);
					}
					if (!"".equals(params[3]) && params[3] != null) {
						sql.append("  and  outkind_input_product_code=?");
						listParams.add(params[3]);
					}
					if (!"".equals(params[4]) && params[4] != null) {
						sql.append("  and  outkind_input_outkind_code=?");
						listParams.add(params[4]);
					}
					if (!"".equals(params[5]) && params[5] != null) {
						sql.append("  and  outkind_input_amount=?");
						listParams.add(params[5]);
					}
					if (!"".equals(params[6]) && params[6] != null) {
						sql.append("  and  outkind_input_state=?");
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
					Outkind  outkind1=new  Outkind();
					outkind1.setSerial(rs.getInt("serial"));
					outkind1.setDate(rs.getDate("outkind_input_date"));
					outkind1.setCity_code(rs.getString("city_name"));
					outkind1.setProduct_code(rs.getString("product_name"));
					outkind1.setOutkind_code(rs.getString("outkind_name"));
					outkind1.setAmount(rs.getDouble("outkind_input_amount"));
					outkind1.setState(rs.getString("outkind_input_state"));
					outkinds.add(outkind1);
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
				System.out.println(outkinds);
				return outkinds;
	}
	public Outkind getBySerial(int serial)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Outkind outkind = null;
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "select * from outkind_input,product,city,outkind where serial=?"
					+ " and outkind_input_city_code=city_code"
					+ " and outkind_input_product_code=product_code"
					+ " and outkind_input_outkind_code=outkind_code";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, serial);
			rs = pstmt.executeQuery();
			System.out.println(sql);
			System.out.println(serial);
			System.out.println("getBy���ݿⴴ���ɹ�");
			while (rs.next()) {
				Outkind  outkind1=new  Outkind();
				outkind1.setSerial(rs.getInt("serial"));
				outkind1.setDate(rs.getDate("outkind_input_date"));
				outkind1.setCity_code(rs.getString("city_name"));
				outkind1.setProduct_code(rs.getString("product_name"));
				outkind1.setOutkind_code(rs.getString("outkind_name"));
				outkind1.setAmount(rs.getDouble("outkind_input_amount"));
				outkind1.setState(rs.getString("outkind_input_state"));
				outkind=outkind1;
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
		return outkind;
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
	public String getOutkind_code(String outkind_name)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String outkind_code=null;
		System.out.println("outkind_name="+outkind_name);
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "select outkind_code from outkind where outkind_name=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, outkind_name);
			rs = pstmt.executeQuery();
			System.out.println(sql);
			System.out.println("getOutkind_code���ݿⴴ���ɹ�");
			while (rs.next()) {
				outkind_code=rs.getString("outkind_code");
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
		return outkind_code;
	}
}
