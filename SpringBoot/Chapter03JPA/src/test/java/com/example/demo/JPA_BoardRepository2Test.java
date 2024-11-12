package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import jakarta.transaction.Transactional;

//내장DB가 H2를 수행하지 않겠다.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@DataJPaApplicationTest를 사용하면 자동으로 EmbededDatabase-H2를 사용하게 된다.
//MySQL과 같이 외부의 DB를 연결하려는 경우엔 이 어노테이션을 설정한다.
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JPA_BoardRepository2Test {
	@Autowired
	private BoardDAO boardDAO;

	@BeforeEach
	public void solid1() {
		System.out.println("-".repeat(80));
	}
	
	@AfterEach
	public void solid2() {
		System.out.println("=".repeat(80));
	}
	
	
	@Test
	@Order(1) // 실행순서를 정한다. 숫자가 작을 수록 먼저 실행한다. 
	@Rollback(false) // rollback이 기본이다. DML문 수행한 후에 rollback를 하고 싶지 않다면 설정해야 한다.
	public void insert() {
		BoardEntity boardEntity = new BoardEntity();
		boardEntity.setId("banana");
		boardEntity.setName("바나나");
		boardEntity.setSubject("노랑 바나나");
		boardEntity.setContent("예전에는 바나나가 비쌌지만, 지금은 저렴하다.");
		
		boardDAO.save(boardEntity);
	}
	
	@Test
	@Order(2)
	public void list() {
		List<BoardEntity> list = boardDAO.findAll();
		list.stream().forEach(System.out :: println);
	}
}

