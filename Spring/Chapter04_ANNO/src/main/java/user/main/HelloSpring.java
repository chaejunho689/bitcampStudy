package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import user.service.UserService;


@Component
public class HelloSpring {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
		helloSpring.menu(context);
		System.out.println("프로그램을 종료합니다.");
	}
	
	
	public void menu(ApplicationContext context) {
		Scanner scan = new Scanner(System.in);
		
		UserService userService = null;
//		= (UserService) context.getBean("UserService");
		int num;
		
		while(true) {
			System.out.println();
			System.out.println("**************************");
			System.out.println("	1.  입력");
			System.out.println("	2.  출력");
			System.out.println("	3.  수정");
			System.out.println("	4.  삭제");
			System.out.println("	5.  종료");
			System.out.println("**************************");
			System.out.println(" 선택 : ");
			num = scan.nextInt();
			
			if(num == 5) break;
			if(num == 1) 		userService = (UserService) context.getBean("userInsertService"); 
			else if(num == 2)  	userService = (UserService) context.getBean("userSelectService"); 
			else if(num == 3)  	userService = (UserService) context.getBean("userUpdateService"); 
			else if(num == 3)  	userService = (UserService) context.getBean("userDeleteService"); 

			userService.execute(); //if안에다가 따로따로 안불러줘도됨.
			
		}
		
	
	}
}
