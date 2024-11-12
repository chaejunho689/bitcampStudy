package exam.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
@Entity
public class EntityTest03 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 10)
	private String name;
	
	@Column(columnDefinition = "varchar(15) default '파랑'")
	private String favoriteColor;
	
	@Column(name="age", nullable = false)
	private int num1;
	
	@Column(name="score", precision = 6, scale = 2) //전체 자리수의 개수가 6개, 소수이하 자리수 2자리, 9999.99
	private BigDecimal num2; //decimal(6,2) - 고정 소수점 숫자를 저장하기 위한 데이터 타입
	
	@Lob //Large Object
	private byte[] content1; // 대용량 이진 데이터를 저장(BLOB), tinyblob
	
	@Lob
	private char[] content2; //tinytext
	
	@Lob
	private String content3; // 대용량 텍스트 데이터를 저장(CLOB), tinytext
}













