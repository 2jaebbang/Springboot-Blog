 package com.cos.blog.model;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity  //User 클래스가 아래 변수들을 읽어서 자동으로  MySQL에 테이블 생성.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@DynamicInsert      //insert시에 null인 필드를 제외시켜준다. 
public class User {
	
	@Id   //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)     //프로젝트에서 연결된 db의 넘버링 전략을 따라감.
	private int id;  //시퀀스, auto_increment
	
	@Column(unique=true, nullable = false, length=100)
	private String username;  //아이디
	
	@Column(nullable = false, length=100)     //12345 -> 해쉬(암호화) 
	private String password;
	
	@Column(nullable = false, length=50)
	private String email;
	
	
//	@ColumnDefault("'user'")
//DB는 roletype이라는게 없다.
	@Enumerated(EnumType.STRING)
	private RoleType role;  //Enum을 쓰는게 좋다.  admin, user, manager
	
	private String oauth;    //kakao, google
	
	@CreationTimestamp  //시간이 자동 입력 
	private Timestamp createDate;
}
