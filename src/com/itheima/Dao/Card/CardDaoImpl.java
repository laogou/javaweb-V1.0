package com.itheima.Dao.Card;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itheima.Dao.Outkind.Outkind;
import com.itheima.utils.DbUtils;

public class CardDaoImpl implements CardDao{

	public void addCard(Card card)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "insert into Card_input(serial,card_input_date,card_input_city_code"
					+ ",card_input_product_code,card_input_number,card_input_price,card_input_amount,"
					+ "card_input_discount,card_input_state)  values(?,curdate(),?,?,?,?,?,?,'0')";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, card.getSerial());
			pstmt.setString(2, card.getCity_code());
			pstmt.setString(3, card.getProduct_code());
			pstmt.setInt(4, card.getNumber());
			pstmt.setDouble(5, card.getPrice());
			pstmt.setDouble(6, card.getAmount());
			pstmt.setDouble(7, card.getDiscount());
			
			pstmt.executeUpdate();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			// 4.�ر����ݿ�
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);
		}
	}
	public void updateCard(Card card)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "update card_input set "
					+ "card_input_date=?,card_input_city_code=?,card_input_product_code=?,"
					+ "card_input_number=?,card_input_price=?,card_input_amount=?,"
					+ "card_input_discount=?"
					+ " where serial=?";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setDate(1, card.getDate());
			pstmt.setString(2, card.getCity_code());
			pstmt.setString(3, card.getProduct_code());
			pstmt.setInt(4, card.getNumber());
			pstmt.setDouble(5, card.getPrice());
			pstmt.setDouble(6, card.getAmount());
			pstmt.setDouble(7, card.getDiscount());
			pstmt.setInt(8, card.getSerial());
			pstmt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		} finally {
			// 4.
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);
		}
	}
	public void deleteCard(int serial)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 3.
			conn=DbUtils.getConnection();
			
			String sql = "delete from card_input where serial=?;";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, serial);
			
			pstmt.executeUpdate();

			System.out.println("���ݿⴴ���ɹ�");
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
		int serial=1;
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "select max(serial) from card_input";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
				serial=rs.getInt("max(serial)");
			//System.out.println("���ݿⴴ���ɹ�");
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
	
	public List<Card> getAllCard(String[] params)
	{
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Card>  cards=new ArrayList<>();
		List<String> listParams = new ArrayList<>();// ������Ž���sql����й��м�������
		try {
			
			// 3.�������ݿ�
			// String sql="select  *  from  outkind_input";
			conn=DbUtils.getConnection();
			StringBuffer sql = new StringBuffer(
					"select  *  from card_input,city,product  where  1=1"
					+ " and card_input_city_code=city_code"
					+ " and card_input_product_code=product_code");
			if (!"".equals(params[0]) && params[0] != null) {
				
				sql.append(" and  serial=?");
				listParams.add(params[0]);
			}
			if (!"".equals(params[1]) && params[1] != null) {
				sql.append("  and  card_input_date=?");
				listParams.add(params[1]);
			}
			if (!"".equals(params[2]) && params[2] != null) {
				sql.append("  and  card_input_city_code=?");
				listParams.add(params[2]);
			}
			if (!"".equals(params[3]) && params[3] != null) {
				sql.append("  and  card_input_product_code=?");
				listParams.add(params[3]);
			}
			if (!"".equals(params[4]) && params[4] != null) {
				sql.append("  and  card_input_number=?");
				listParams.add(params[4]);
			}
			if (!"".equals(params[5]) && params[5] != null) {
				sql.append("  and  card_input_price=?");
				listParams.add(params[5]);
			}
			if (!"".equals(params[6]) && params[6] != null) {
				sql.append("  and  card_input_amount=?");
				listParams.add(params[6]);
				System.out.println(params[6]);
			}
			if (!"".equals(params[7]) && params[7] != null) {
				sql.append("  and  card_input_discount=?");
				listParams.add(params[7]);
			}
			if (!"".equals(params[8]) && params[8] != null) {
				sql.append("  and  card_input_state=?");
				listParams.add(params[8]);
			}
			System.out.println("sql:" + sql.toString());
			pstmt = conn.prepareStatement(sql.toString());
			for (int i = 0; i < listParams.size(); i++) {
				pstmt.setString(i + 1, listParams.get(i));
			}

			rs = pstmt.executeQuery();
			System.out.println("���ݿ��ѯ�ɹ�");
			while (rs.next()) {
				Card card=new Card();
 				System.out.println(rs.getInt("serial"));
 				card.setSerial(rs.getInt("serial"));
 				card.setDate(rs.getDate("card_input_date"));
 				card.setCity_code(rs.getString("city_name"));
 				card.setProduct_code(rs.getString("product_name"));
 				card.setNumber(rs.getInt("card_input_number"));
 				card.setPrice(rs.getDouble("card_input_price"));
 				card.setAmount(rs.getDouble("card_input_amount"));
 				card.setDiscount(rs.getDouble("card_input_discount"));
 				card.setState(rs.getString("card_input_state"));
 				cards.add(card);
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
		System.out.println(cards);
		return cards;
	}
	public Card getBySerial(int serial)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Card card=null;
		try {
			// 3.�������ݿ�
			conn=DbUtils.getConnection();
			
			String sql = "select * from card_input,city,product where serial=?"
					+ " and card_input_city_code=city_code"
					+ " and card_input_product_code=product_code";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, serial);
			rs = pstmt.executeQuery();
			System.out.println(sql);
			System.out.println(serial);
			System.out.println("getBy���ݿⴴ���ɹ�");
			while (rs.next()) {
				Card card1=new Card();
				card1.setSerial(rs.getInt("serial"));
 				card1.setDate(rs.getDate("card_input_date"));
 				card1.setCity_code(rs.getString("city_name"));
 				card1.setProduct_code(rs.getString("product_name"));
 				card1.setNumber(rs.getInt("card_input_number"));
 				card1.setPrice(rs.getDouble("card_input_price"));
 				card1.setAmount(rs.getDouble("card_input_amount"));
 				card1.setDiscount(rs.getDouble("card_input_discount"));
 				card1.setState(rs.getString("card_input_state"));
 				card=card1;
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
		return card;
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
}
