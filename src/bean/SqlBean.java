package bean;


import java.sql.*;


public class SqlBean {

    //

	public static Connection getConn(){
		
			Connection conn = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tele?","user01","1234");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//
	public static Statement getStmt(Connection conn){
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}
	
	//ִ
	public static ResultSet executeQuery(Statement stmt,String sql){
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	
	//
	public static int executeUpdate(Connection conn,String sql){
		int ret = 0;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			ret = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			close(stmt);
		}
		
		return ret;
	}

	//
	public static PreparedStatement getPstmt(Connection conn,String sql){
			
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return pstmt;
		
	}
	
	//
	public static void close(Connection conn) {
		
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			conn = null;
		}
	}
	//
	public static void close(Statement stmt) {
		
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			stmt = null;
		}
	}
	//
	public static void close(ResultSet rs) {
		
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			rs = null;
		}
	}

}
