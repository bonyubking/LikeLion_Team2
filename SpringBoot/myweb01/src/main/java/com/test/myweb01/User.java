package com.test.myweb01;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // DB 매핑
@Table(name="users") // 테이블 이름 users로 설정
public class User {

    @Id // 기본키 지정 PK
    @GeneratedValue(strategy = GenerationType.AUTO) // id 자동 증가
    @Column // 해당 필드가 DB 컬럼으로 명시 name, length, nullable=true/false
    private int id;

    //@Column(name="username",length=50,nullable=false)
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
