package dao.collectDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import bean.SqlBean;

import common.CardG;

/**
 * 收款稽核底层操作
 * @author 郑拓
 *
 */
public class CardCollectDao {
/**
 * 实现多条件查询card信息
 * @param card
 * @return
 */
	public ArrayList<CardG> doSearch(CardG card){
		ArrayList<CardG> list = new ArrayList<CardG>();
		CardG c = null;
		//boolean flag = false;
		boolean flag1 = true;
		Connection conn = SqlBean.getConn();
		PreparedStatement pst = null;
		
		ResultSet rs = null;
		try{
			String sql = "select * from card_input where card_input_state = 1";
			if(card==null){
				System.out.println("kong");
			}
			if(!card.getCardCityCode().equals("-1")){
				sql += " and card_input_city_code = '"+card.getCardCityCode()+"'";
				flag1 = false;
			}
			if(!card.getCardProductCode().equals("-1")){
				sql += " and card_input_product_code = '"+card.getCardProductCode()+"'";
				flag1 = false;
			}
			
			String[] time=card.getCarddate().split("/");
			if(!time[0].equals(" ")){
				//sql=sql+" and card_input_date>=('"+time[0]+"','yyyy-mm-dd')";
				sql=sql+" and card_input_date>='"+time[0]+"'";
				flag1 = false;
			}
			if(!time[1].equals(" ")){
				//sql=sql+" and card_input_date<=('"+time[1]+"','yyyy-mm-dd')";
				sql=sql+" and card_input_date<='"+time[1]+"'";
				flag1 = false;
			}
			if(flag1){
				sql = "select * from card where card_input_state = 1";
			}
			sql += " order by serial";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next())
			{ 		
				c = new CardG();
				//给Staff对象给数据库中的值

				c.setCardserial(rs.getInt("serial"));
				c.setCarddate(rs.getDate("card_input_date").toString());
				c.setCardCityCode(rs.getString("card_input_city_code"));
				c.setCardProductCode(rs.getString("card_input_product_code"));
				c.setCardNum(rs.getInt("card_input_number"));
				c.setCardPrice(rs.getInt("card_input_price"));
				c.setCardAmount(rs.getInt("card_input_amount"));
				c.setCardDisamount(rs.getFloat("card_input_discount"));
				
				list.add(c);
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
