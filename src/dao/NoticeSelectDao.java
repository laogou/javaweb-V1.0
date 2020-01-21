package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import common.Notice;
import common.City;
import common.Product;
import bean.SqlBean;

/**
 * 从数据库获得下拉框的值
 * @author 张志远
 *
 */
public class NoticeSelectDao {

	Connection conn=null;
	PreparedStatement pstm=null;
	ResultSet rs=null;
	String sql="";
	
	City city=null;
	Product product=null;
	Notice notice=null;
	
	
	ArrayList<City> cityList=new ArrayList<City>(); //城市集合
	ArrayList<Product> productList=new ArrayList<Product>(); //产品类型集合
	ArrayList<Notice> noticeList=new ArrayList<Notice>(); //运营商类型集合
	
	/**
	 * 查询出数据库中有效的地市编号、名称

	 * @return ArrayList<City>
	 */
	public ArrayList<City> getCity(){
		sql="select *from city";
		//sql="select t.city_zip,t.city_name from city t where t.city_state=1";
		try{
			conn=SqlBean.getConn();
			pstm=SqlBean.getPstmt(conn, sql);
			rs=SqlBean.executeQuery(pstm, sql);
			while(rs.next()){
				city=new City();
				city.setCityCode(rs.getString("city_code"));
				city.setCityName(rs.getString("city_name"));
				cityList.add(city);
			}
		}catch(SQLException e){
				e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstm!=null){
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return cityList;
	}
	/**
	 * 查询出数据库中按地市编号查询地市名称
	 * @return ArrayList<City>
	 */
	public String getCityName(String cityCode){
		String cityName = "";
		sql="select * from city  where city_code = '"+cityCode+"'";
		try{
			conn=SqlBean.getConn();
			pstm=SqlBean.getPstmt(conn, sql);
			rs=SqlBean.executeQuery(pstm, sql);
			if(rs.next()){
				cityName = rs.getString("city_name");
			}
		}catch(SQLException e){
				e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstm!=null){
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return cityName;
	}
	/**
	 * 查询出数据库中有效的产品编号、名称

	 * return ArrayList<Product>
	 */
	public ArrayList<Product> getProduct(){
		sql="select product_code,product_name from product where product_notice=1";
		try{
			conn=SqlBean.getConn();
			pstm=SqlBean.getPstmt(conn, sql);
			rs=SqlBean.executeQuery(pstm, sql);
			while(rs.next()){
				product=new Product();
				product.setProductCode(rs.getString("product_code"));
				product.setProductName(rs.getString("product_name"));
				productList.add(product);
			}
		}catch(SQLException e){
				e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstm!=null){
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return productList;
	}
	/**
	 * 查询出数据库中按产品编号查询产品名称
	 * @return ArrayList<City>
	 */
	public String getProductName(String productCode){
		String productName = "";
		sql="select product_name from product  where  product_code = '"+productCode+"'";
		try{
			conn=SqlBean.getConn();
			pstm=SqlBean.getPstmt(conn, sql);
			rs=SqlBean.executeQuery(pstm, sql);
			if(rs.next()){
				productName = rs.getString("product_name");
			}
		}catch(SQLException e){
				e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstm!=null){
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return productName;
	}

	
	/**
	 * 查询出数据库中有效的销账类型编号、名称

	 * @return ArrayList<Notice>
	 */
	public ArrayList<Notice> getNotice(){
		sql="select *from notice";
		try{
			conn=SqlBean.getConn();
			pstm=SqlBean.getPstmt(conn, sql);
			rs=SqlBean.executeQuery(pstm, sql);
			while(rs.next()){
				notice=new Notice();
				notice.setNoticeCode(rs.getString("notice_code"));
				notice.setNoticeName(rs.getString("notice_name"));
				noticeList.add(notice);
			}
		}catch(SQLException e){
				e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstm!=null){
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return noticeList;
	}
	/**
	 * 查询出数据库中按销账编号查询地市名称
	 * @return ArrayList<City>
	 */
	public String getNoticeName(String noticeCode){
		String noticeName = "";
		sql="select * from notice  where notice_code = '"+noticeCode+"'";
		try{
			conn=SqlBean.getConn();
			pstm=SqlBean.getPstmt(conn, sql);
			rs=SqlBean.executeQuery(pstm, sql);
			if(rs.next()){
				noticeName = rs.getString("notice_name");
			}
		}catch(SQLException e){
				e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstm!=null){
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return noticeName;
	}

}

