package exam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Emp {
	@Id
	private int empno;
	
	@Column(length = 14)
	private String ename;
	
	@Column(length = 14)
	private String job;
	
	private Integer mrg;
	private java.sql.Date hiredate;
	private int sal;
	private Integer comm;
	
	//연관 매핑
//	@ManyToOne(fetch = FetchType.EAGER)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deptno")
	private Dept deptno;
	
}
