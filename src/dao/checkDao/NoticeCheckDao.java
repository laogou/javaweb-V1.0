package dao.checkDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import bean.SqlBean;
import common.NoticeG;

/**
 * 收款稽核底层操作
 * @author 张志远
 *
 */
public class NoticeCheckDao {
/**
 * 实现多条件查询notice信息
 * @param pre
 * @return
 */
	public ArrayList<NoticeG> doSearch(NoticeG notice){
		ArrayList<NoticeG> list = new ArrayList<NoticeG>();
		NoticeG a = null;
		//boolean flag = false;
		boolean flag1 = true;
		Connection conn = SqlBean.getConn();
		PreparedStatement pst = null;
		
		ResultSet rs = null;
		try{
			String sql = "select * from notice_input where notice_input_state = 0";
			if(notice==null){
				System.out.println("kong");
			}
			if(!notice.getNoticeCityCode().equals("-1")){
				sql += " and notice_input_city_code = '"+notice.getNoticeCityCode()+"'";
				flag1 = false;
			}
			if(!notice.getNoticeProductCode().equals("-1")){
				sql += " and notice_input_product_code = '"+notice.getNoticeProductCode()+"'";
				flag1 = false;
			}
			if(!notice.getNoticeNoticeCode().equals("-1")){
				sql += " and notice_input_notice_code = '"+notice.getNoticeNoticeCode()+"'";
				flag1 = false;
			}
			
			
			String[] time=notice.getNoticedate().split("/");
			if(!time[0].equals(" ")){
				sql=sql+" and notice_input_date>='"+time[0]+"'";
				flag1 = false;
			}
			if(!time[1].equals(" ")){
				sql=sql+" and notice_input_date<='"+time[1]+"'";
				flag1 = false;
			}
			if(flag1){
				sql = "select * from notice_input where notice_input_state = 0";
			}
			sql += " order by serial";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next())
			{ 		
				a = new NoticeG();
				//给Staff对象给数据库中的值

				a.setNoticeserial(rs.getInt("serial"));
				a.setNoticedate(rs.getDate("notice_input_date").toString());
				a.setNoticeCityCode(rs.getString("notice_input_city_code"));
				a.setNoticeProductCode(rs.getString("notice_input_product_code"));
				a.setNoticeNoticeCode(rs.getString("notice_input_notice_code"));
				a.setNoticeAmount(rs.getFloat("notice_input_amount"));
				
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
	public void doUpdate(ArrayList<NoticeG> list){
		Connection conn = SqlBean.getConn();
		PreparedStatement pstmt = null;
		String sql = "Update notice_input set notice_input_state = ? where serial = ? ";
		pstmt = SqlBean.getPstmt(conn, sql);
		try {
			for(int i=0;i<list.size();i++){
				pstmt.setInt(1, list.get(i).getNoticeType());
				pstmt.setInt(2, list.get(i).getNoticeserial());
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
