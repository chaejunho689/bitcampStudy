package board.bean;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	private int seq;
	private String id;
	private String name;
	private String gender;
	private String email;
	private String subject;
	private String content;
	private int lev;
	private int ref;
	private int step;
	private int pseq;
	private int reply;
	private int hit;
	private Date logtime;

}
