package com.itheima.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtils {
	//private static final	String URL = "jdbc:mysql://129.204.178.246:3306/tele?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private static final	String URL = "jdbc:mysql://localhost:3306/tele?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	
	
	private static final	String USER = "user01";
	private static final	String PASSWORD = "1234";
	private  DbUtils(){}
	static{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("forName���óɹ�");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("forNameδ���óɹ�");
		}
	}
	public  static  Connection getConnection()
	{
		Connection  conn=null;
		try {
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("����δ�ɹ�");
		}
		return  conn;
		}
	public static void closeConnection(Connection conn)
	{
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	public  static  void closeResultSet(ResultSet  rs)
	{
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	public  static  void closePreparedStatement(PreparedStatement  pstmt)
	{
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
