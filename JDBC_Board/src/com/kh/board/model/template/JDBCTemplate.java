package com.kh.board.model.template;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

// JDBC의 주요 메서드들을 정의한 클래스
// getConnection, close, commit, rollback 메서드를 정의
// 단, db와의 연결정보는 resources/driver.properties에서 관리한다.
public class JDBCTemplate {
	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		
		try {
			// prop 로드
			prop.load(new FileInputStream("resources/driver.properties"));
			
			// 1. 드라이버 클래스 등록
			Class.forName(prop.getProperty("driver"));
			
			// 2. 커넥션 객체 생성
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("username"),
					prop.getProperty("password")
					);
			
			conn.setAutoCommit(false);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (conn == null) {
			System.out.println("conn is null: template");
		}
		
		return conn;
	}
	
	// close 메서드 류
	public static void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) { // 다형성으로 자식클래스를 모두 받음
		try {
			if (stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if (rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public <T> static void close(T t) {
//		try {
//			if (t != null && !t.isClosed()) {
//				t.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void commit(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.commit();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.rollback();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
