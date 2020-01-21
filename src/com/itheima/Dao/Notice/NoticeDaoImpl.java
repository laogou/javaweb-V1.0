package com.itheima.Dao.Notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.itheima.utils.DbUtils;

public class NoticeDaoImpl implements NoticeDao{

	@Override
	public void addNotice(Notice notice) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "insert into Notice_input(serial,notice_input_date,notice_input_city_code"
					+ ",notice_input_product_code,notice_input_notice_code,notice_input_amount,"
					+ "notice_input_state)  values(?,curdate(),?,?,?,?,'0')";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, notice.getSerial());
			pstmt.setString(2, notice.getCity_code());
			pstmt.setString(3, notice.getProduct_code());
			pstmt.setString(4, notice.getNotice_code());
			pstmt.setDouble(5, notice.getAmount());
			
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
	public void updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "update notice_input set "
					+ "notice_input_date=?,notice_input_city_code=?,notice_input_product_code=?,"
					+ "notice_input_notice_code=?,notice_input_amount=?"
					+ " where serial=?";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setDate(1, notice.getDate());
			pstmt.setString(2, notice.getCity_code());
			pstmt.setString(3, notice.getProduct_code());
			pstmt.setString(4, notice.getNotice_code());
			pstmt.setDouble(5, notice.getAmount());
			
			pstmt.setInt(6, notice.getSerial());
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

	@Override
	public void deleteNotice(int serial) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "delete from notice_input where serial=?;";
			
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
			
			String sql = "select max(serial) from notice_input";
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
	public List<Notice> getAllNotice(String[] params) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Notice>  notices=new ArrayList<>();
		List<String> listParams = new ArrayList<>();// ������Ž���sql����й��м�������
		try {
			
			// 3.�������ݿ�
			// String sql="select  *  from  notice_input";
			conn=DbUtils.getConnection();
			StringBuffer sql = new StringBuffer(
					"select  *  from notice_input,city,product,notice  where  1=1 "
							+ " and notice_input_city_code=city_code"
							+ " and notice_input_product_code=product_code"
							+ " and notice_input_notice_code=notice_code");
			if (!"".equals(params[0]) && params[0] != null) {
				
				sql.append(" and  serial=?");
				listParams.add(params[0]);
			}
			if (!"".equals(params[1]) && params[1] != null) {
				sql.append("  and  notice_input_date=?");
				listParams.add(params[1]);
			}
			if (!"".equals(params[2]) && params[2] != null) {
				sql.append("  and  notice_input_city_code=?");
				listParams.add(params[2]);
			}
			if (!"".equals(params[3]) && params[3] != null) {
				sql.append("  and  notice_input_product_code=?");
				listParams.add(params[3]);
			}
			if (!"".equals(params[4]) && params[4] != null) {
				sql.append("  and  notice_input_notice_code=?");
				listParams.add(params[4]);
			}
			if (!"".equals(params[5]) && params[5] != null) {
				sql.append("  and  notice_input_amount=?");
				listParams.add(params[5]);
			}
			if (!"".equals(params[6]) && params[6] != null) {
				sql.append("  and  notice_input_state=?");
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
				Notice  notice1=new  Notice();
			System.out.println(rs.getInt("serial"));
			notice1.setSerial(rs.getInt("serial"));
			notice1.setDate(rs.getDate("notice_input_date"));
			System.out.println(notice1.getSerial());
			notice1.setCity_code(rs.getString("city_name"));
			notice1.setProduct_code(rs.getString("product_name"));
			notice1.setNotice_code(rs.getString("notice_name"));
			notice1.setAmount(rs.getDouble("notice_input_amount"));
			notice1.setState(rs.getString("notice_input_state"));
			notices.add(notice1);
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
		System.out.println(notices);
		return notices;
	}

	@Override
	public Notice getBySerial(int serial) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Notice notice = null;
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "select * from notice_input,city,product,notice where serial=?"
					+ " and notice_input_city_code=city_code"
					+ " and notice_input_product_code=product_code"
					+ " and notice_input_notice_code=notice_code";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, serial);
			rs = pstmt.executeQuery();
			System.out.println(sql);
			System.out.println(serial);
			System.out.println("getBy���ݿⴴ���ɹ�");
			while (rs.next()) {
				Notice  notice1=new  Notice();
				notice1.setSerial(rs.getInt("serial"));
				notice1.setDate(rs.getDate("notice_input_date"));
				notice1.setCity_code(rs.getString("city_name"));
				notice1.setProduct_code(rs.getString("product_name"));
				notice1.setNotice_code(rs.getString("notice_name"));
				notice1.setAmount(rs.getDouble("notice_input_amount"));
				notice1.setState(rs.getString("notice_input_state"));
				notice=notice1;
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
		return notice;
	
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
	public String getNotice_code(String notice_name)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String product_code=null;
		System.out.println("notice_name="+notice_name);
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "select notice_code from notice where notice_name=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice_name);
			rs = pstmt.executeQuery();
			System.out.println(sql);
			System.out.println("getNotice_code���ݿⴴ���ɹ�");
			while (rs.next()) {
				product_code=rs.getString("notice_code");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getNotice_codeʧ��");
			
		} finally {
			// 4.�ر����ݿ�
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);
		}
		return product_code;
	}
}
