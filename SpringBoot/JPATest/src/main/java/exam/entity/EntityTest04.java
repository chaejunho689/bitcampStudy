package exam.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class EntityTest04 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.TIME)     //DB 타입이 time
    private java.util.Date utilTime;
	
	@Temporal(TemporalType.DATE)     //DB 타입이 date
    private java.util.Date utilDate;
	
	@Temporal(TemporalType.TIMESTAMP)    //DB 타입이 datetime
    private java.util.Date utilTimestamp;
	
	private java.util.Date utilPlainDate;   //DB 타입이 datetime
    private java.sql.Date sqlPlainDate;     //DB 타입이 date
    
    @Column(columnDefinition = "TIME")
    private LocalTime localTime1;           //DB 타입이 TIME
    
    //@Column이 없는 경우
    private LocalTime localTime2;           //DB 타입이 time(6)
    
    @Column(columnDefinition = "DATE")
    private LocalDate localDate1;           //DB 타입이 DATE

    //@Column이 없는 경우
    private LocalDate localDate2;           //DB 타입이 date
    
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime localDateTime1;   //DB 타입이 TIMESTAMP null

  //@Column이 없는 경우
    private LocalDateTime localDateTime2;   //DB 타입이 datetime(6)
}










