package com.test.myweb;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //DB 매핑하겠다
@Table(name="users") //테이블 이름을 users라고 하겠다
public class User {
	
	@Id // 기본키 지정하겠다 PK
	@GeneratedValue(strategy = GenerationType.AUTO)  // id 자동 증가하겠다
	@Column // 해당 필드가 DB의 컬럼으로 명시 name, length, unllable=true/false
	private int id;
	
	//@Column(name="username", length=50, nullable=false)
	@Column
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
