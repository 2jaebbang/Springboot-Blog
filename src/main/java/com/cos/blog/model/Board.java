package com.cos.blog.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  //User 클래스가 아래 변수들을 읽어서 자동으로  MySQL에 테이블 생성.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)    //auto_increment
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob      //대용량 데이터 
	private String content;       //섬머노트 라이브러리 <html> 태그가 섞여서 디자인이 됨.
	
	private int count;  //조회수
	
	
	@ManyToOne(fetch = FetchType.EAGER)      //Many = Board, User = one  한명의 유저는 여러 게시글 쓸 수 있다.    연관관계 @Entity
	@NotFound(action = NotFoundAction.IGNORE)
  	@JoinColumn(name="userId")       //필드값 
	private User user;        //DB는 오브젝트 저장못함. 자바는 오브젝트 저장 가능.
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) // mappedBy 연관관계의 주인이 아니다 (난 FK가 아니에요) DB에 칼럼을 만들지 마세요.
	@JsonIgnoreProperties({"board"})
	@OrderBy("id desc")
	private List<Reply> replys;
	
	@CreationTimestamp
	private LocalDateTime createDate;
}
