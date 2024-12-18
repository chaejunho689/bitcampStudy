package sample04;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component
@Scope("prototype")
public class SungJukInput implements SungJuk {
	@Autowired
	private SungJukDTO2 sungJukDTO2 = null;
	@Autowired
	@Qualifier("arrayList")
	private List<SungJukDTO2> list;
	
	public void setList(List<SungJukDTO2> list) {
		this.list = list;
	}

	@Override
	public void execute(List<SungJukDTO2> list) {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름 입력하세요.");
		String name = scan.next();
		
		System.out.println("국어 입력 : ");
		int kor = scan.nextInt();
		
		System.out.println("영어 입력 : ");
		int eng = scan.nextInt();
		
		System.out.println("수학 입력 : ");
		int math = scan.nextInt();
		
		int tot = kor + eng + math;
		double avg = tot / 3.;
		
		sungJukDTO2.setName(name);
		sungJukDTO2.setKor(kor);
		sungJukDTO2.setEng(eng);
		sungJukDTO2.setMath(math);
		sungJukDTO2.setTot(tot);
		sungJukDTO2.setAvg(avg);
		
		list.add(sungJukDTO2);
		System.out.println(name + "님의 데이터를 입력했습니다. ");
	}



}
