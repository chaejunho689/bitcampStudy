package exam.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EntityTest02 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int num1;
	private Integer num2;
}

/*
JPA에서 int와 Inteter의 차이
- MySQL에서 INT와 INTEGER는 같은 타입으로 처리하므로, 실제로 두 데이터 타입에 차이가 없다.
- JPA에서는 Java의 기본 타입 int와 wrapper 클래스 Integer가 서로 다른 개념이다.

① int (primitive type)는 기본 데이터 타입으로, 값을 반드시 가져야 하며 null을 허용하지 않는다.
기본값은 0이다.
② Integer (wrapper class)는 객체 타입으로, null을 허용하며, null 값을 저장할 수 있다.

 */









