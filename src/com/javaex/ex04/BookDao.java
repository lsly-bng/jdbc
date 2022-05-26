package com.javaex.ex04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

	// field
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "oracle.jdbc.driver.OracleDriver"; // 드라이버
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; // IP주소와 포트번호
	private String id = "webdb"; // SQL 계정 이름
	private String pw = "webdb"; // SQL 계정 비밀번호

	// constructor

	// method - g/s

	// method - general

// ===============================================================================//

	// --DB연결 메소드
	private void getConnection() {

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

// ===============================================================================//

	// --자원정리 메소드
	private void close() {
		// 5. 자원정리
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

// ===============================================================================//

	// --도서 등록 메소드
	
	public int bookInsert(BookVo bookVo) {

		int count = -1;

		getConnection(); // this.getConnection()

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += "insert into book ";
			query += "values(seq_book_id.nextval,?,?,?,?) ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookVo.getTitle());
			pstmt.setString(2, bookVo.getPubl());
			pstmt.setString(3, bookVo.getPublDate());
			pstmt.setInt(4, bookVo.getAuthorId());

			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건이 등록되었습니다");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		close();
		
		return count;
	}

//===============================================================================//

	// --도서 삭제 메소드
	public int bookDelete(BookVo bookVo) {

		int count = -1;

		getConnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += "delete from book ";
			query += "where book_id= ? ";

			// 바인딩
			pstmt = conn.prepareStatement(query); 
			pstmt.setInt(1, bookVo.getBookId());

			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건이 삭제되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		close();
		
		return count;
	}

// ===============================================================================//

	// --도서 수정 메소드
	public int bookUpdate(BookVo bookVo) {

		int count = -1;

		getConnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += "update book ";
			query += "set title = ?, ";
			query += "	  publ = ?, ";
			query += "	  publ_date = ?, ";
			query += "    author_id = ? ";
			query += "where book_id = ? ";
			System.out.println(query);
			
			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookVo.getTitle());
			pstmt.setString(2, bookVo.getPubl());
			pstmt.setString(3, bookVo.getPublDate());
			pstmt.setInt(4, bookVo.getAuthorId());
			pstmt.setInt(5, bookVo.getBookId());

			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건이 수정되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		close();
		
		return count;
	}

// ===============================================================================//

	// --도서 전체리스트 가져오기 메소드
	public List<BookVo> bookSelect() {

		// 리스트 준비
		List<BookVo> bookList = new ArrayList<BookVo>();

		getConnection();
		
		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += "select  book_id, ";
			query += "		  title, ";
			query += "        publ, ";
			query += "        to_char(publ_date, 'yyyy-mm-dd') publ_date, ";
			query += "        a.author_name ";
			query += "from book b, author a ";
			query += "where b.author_id = a.author_id ";
			query += "order by book_id ";
			System.out.println(query);

			// 바인딩
			pstmt = conn.prepareStatement(query);

			// 실행
			// ResultSet 가져오기
			rs = pstmt.executeQuery();

			// 4.결과처리
			// 반복문으로 Vo 만들기 / list에 추가하기
			while (rs.next()) {
				int bookId = rs.getInt("book_id");
				String title = rs.getString("title");
				String publ = rs.getString("publ");
				String publDate = rs.getString("publ_date");
				String authorName = rs.getString("author_name");

				BookVo bookVo = new BookVo(bookId, title, publ, publDate, authorName);

				bookList.add(bookVo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		close();
		
		return bookList;
	}
}
