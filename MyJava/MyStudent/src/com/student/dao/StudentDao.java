package com.student.dao;

import static common.JDBCTemplate.Close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.java.Student;

public class StudentDao implements StudentDaoImple{

	
	public int insertStudent(Student s) {
		
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(insert_sql);
			
			pstm.setString(1, s.getId() );
			pstm.setString(2, s.getSname());
			pstm.setString(3, s.getMajor());
			pstm.setString(4, s.getGrade());
			
			res = pstm.executeUpdate();
			commit(conn);
			
		} catch (SQLException e) {
			
			rollback(conn);
			e.printStackTrace();
			
		} finally {
			
			Close(pstm);
			Close(conn);
		}
			
		
		return res;
	}
	
	/// 2.delete
	public int deleteStudent(Student s) {
		
		
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(delete_sql);
			
			pstm.setString(1, s.getSname());
			
			res = pstm.executeUpdate();
			commit(conn);
			
		} catch (SQLException e) {
			
			rollback(conn);
			e.printStackTrace();
			
		} finally {
			
			Close(pstm);
			Close(conn);
		}
			
		
		return res;
	}
	
	/// 3.update
	public int updateStudent(Student s) {
		
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		
		int res = 0;
		
		try {
			
			pstm = conn.prepareStatement(update_sql);
			
			pstm.setString(1, s.getId()); 
			pstm.setString(4, s.getSname());    
			pstm.setString(2, s.getMajor());
			pstm.setString(3, s.getGrade());
			
			res = pstm.executeUpdate();
			commit(conn);
			
		} catch (SQLException e) {
			
			rollback(conn);
			e.printStackTrace();
			
		} finally {
			
			Close(pstm);
			Close(conn);
		}
			
		
		return res;
		
	}
	
	/// 4.select
	public List<Student> selectAllStudent(){
		
		List<Student> list = new ArrayList<>();
		
		Connection conn = getConnection();
		Statement pstm = null;
		
		ResultSet rs = null;

		
		try {
			
			pstm = conn.createStatement();
			rs = pstm.executeQuery(select_sql);
			
			while (rs.next()) {

				Student s = new Student();
				
				s.setId(rs.getString(1));
			    s.setSname(rs.getString(2));
			    s.setMajor(rs.getString(3));
			    s.setGrade(rs.getString("Grade")); 
			
				list.add(s);}
			
		} catch (SQLException e) {
			
			rollback(conn);
			e.printStackTrace();
			
		} finally {
			
			Close(rs);
			Close(pstm);
			Close(conn);
		}
			
		
		return list;
	}
	

}
