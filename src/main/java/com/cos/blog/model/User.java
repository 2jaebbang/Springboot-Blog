 package com.cos.blog.model;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity  //User 클래스가 아래 변수들을 읽어서 자동으로  MySQL에 테이블 생성.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
	@Id   //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)     //프로젝트에서 연결된 db의 넘버링 전략을 따라감.
	private int id;  //시퀀스, auto_increment
	
	@Column(nullable = false, length=30)
	private String username;  //아이디
	
	@Column(nullable = false, length=100)     //12345 -> 해쉬(암호화) 
	private String password;
	
	@Column(nullable = false, length=50)
	private String email;
	
	@ColumnDefault("'user'")
	private String role;  //Enum을 쓰는게 좋다.  admin, user, manager
	
	@CreationTimestamp  //시간이 자동 입력 
	private Timestamp createDate;
}
