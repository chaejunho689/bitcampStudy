package homework;

import java.util.Scanner;

public class StringMain {
	public StringMain() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문자열 입력 : ");
		String txt_input = scan.next();
		
		System.out.print("바꿀 문자열 입력 : ");
		String txt_target = scan.next();

		System.out.print("바뀔 문자열 입력 : ");
		String txt_change = scan.next();
	}
}
	

	
	
	public static void main(String[] args) {
		new StringMain();
		
	}
}


/*
[문제]
치환하는 프로그램을 작성하시오 - indexOf(?, ?), replace()
String 클래스의 메소드를 이용하시오
대소문자 상관없이 개수를 계산하시오

[실행결과]
문자열 입력 : aabba
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddbba
1번 치환

문자열 입력 : aAbbA
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddbba
1번 치환

문자열 입력 : aabbaa
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddbbdd
2번 치환

문자열 입력 : AAccaabbaaaaatt
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddccddbbddddatt
4개 치환

문자열 입력 : aabb
현재 문자열 입력 : aaaaa
바꿀 문자열 입력 : ddddd
입력한 문자열의 크기가 작습니다
치환 할 수 없습니다
*/