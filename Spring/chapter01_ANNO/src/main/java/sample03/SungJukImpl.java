package sample03;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class SungJukImpl implements SungJuk {
	private String name;
	private int kor, eng, math, tot;
	private double avg;
	
	public SungJukImpl() {
		Scanner sc = new Scanner(System.in);
		
        System.out.print("이름 입력 : ");
        name = sc.next();
        System.out.print("국어 입력 : ");
        kor = sc.nextInt();
        System.out.print("영어 입력 : ");
        eng = sc.nextInt();
        System.out.print("수학 입력 : ");
        math = sc.nextInt();
	}

	@Override
	public void calc() {
		tot = kor + eng + math;
		avg = (double) tot / 3.;
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
        System.out.print(name + "\t"+ kor + "\t"+ eng + "\t" + math + "\t" + tot + "\t" + String.format("%.2f", avg));
	}

}








