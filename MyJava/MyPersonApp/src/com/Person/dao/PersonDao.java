package com.Person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static common.JDBCTemplate.*;

import com.Person.java.Person;

// DB CRUD
// view -> controller -> dao [jdbctemplate] -> db
// view <- controller <- dao [jdbctemplate] <- db
public class PersonDao implements PersonDaoImple {
	
	// 1.insert
	public int insertPerson(Person p) {
		
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(insert_sql);
			
			pstm.setString(1, p.getName() );
			pstm.setString(2, p.getAddress());
			pstm.setString(3, p.getPhone());
			
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
	public int deletePerson(Person p) {
		
		
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(delete_sql);
			
			pstm.setString(1, p.getName());
			
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
	public int updatePerson(Person p) {
		
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		
		int res = 0;
		
		try {
			
			pstm = conn.prepareStatement(update_sql);
			
			pstm.setString(1, p.getAddress()); 
			pstm.setString(2, p.getPhone());    
			pstm.setString(3, p.getName()); 
			
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
	public List<Person> selectAllPerson(){
		
		List<Person> list = new ArrayList<>();
		
		Connection conn = getConnection();
		Statement pstm = null;
		
		ResultSet rs = null;

		
		try {
			
			pstm = conn.createStatement();
			rs = pstm.executeQuery(select_sql);
			
			while (rs.next()) {

			    Person p = new Person();

			    p.setName(rs.getString(1));
			    p.setAddress(rs.getString(2));
			    p.setPhone(rs.getString("phone")); 
			
				list.add(p);}
			
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
	
	public Person searchByName (Person p) {
		

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Person person = null;
		
		try {
			
			pstmt = conn.prepareStatement(find_sql);
			pstmt.setString(1, p.getName());
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {

			    person = new Person();

			    person.setName(rs.getString(1));
			    person.setAddress(rs.getString(2));
			    person.setPhone(rs.getString("phone")); 
			}
			
		} catch (SQLException e) {
			
			rollback(conn);
			e.printStackTrace();
			
		} finally {
			
			Close(rs);
			Close(pstmt);
			Close(conn);
		}
			
		
		return person;
		
	}


	public List<Person> getPersonByPage(int page, int size) {
		
		List<Person> list = new ArrayList<>();
		
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		
		ResultSet rs = null;

		
		try {
			
			pstm = conn.prepareStatement(pageByInt);
			pstm.setInt(1,  size);
			pstm.setInt(2,  (page - 1) * size);
			
	        rs = pstm.executeQuery();
			
			while (rs.next()) {

			    Person p = new Person();

			    p.setName(rs.getString(1));
			    p.setAddress(rs.getString(2));
			    p.setPhone(rs.getString("phone")); 
			
				list.add(p);}
			
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

