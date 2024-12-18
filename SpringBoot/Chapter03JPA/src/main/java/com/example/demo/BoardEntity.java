package com.example.demo;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="boardtbl")
public class BoardEntity {
	
	@Id // pk 키 설정
	@Column(name="seq")
	//특정 데이터베이스에 맞게 자동으로 생성하는 방식, 자동으로 시퀀스 테이블이 생성된다.
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq;
	
	@Column(name="id", nullable = false, unique =  true, length = 30)
	private String id;
	
	@Column(name="name", nullable = false, length = 30)
	private String name;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="content")
	private String content;
	
	//private Timestamp logtime;
	//@CreationTimestamp // 엔티티가 생성되는 시점의 시간 등록 - insert 할 때 자동으로 시간 등록
	@UpdateTimestamp // update 할 때 자동으로 시간 등록
	private LocalDateTime logtime = LocalDateTime.now();
	
	

}
