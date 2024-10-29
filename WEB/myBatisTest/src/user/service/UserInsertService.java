package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;
import user.service.UserService;

public class UserInsertService implements UserService {

	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름 입력");
		String name = scan.next();
		System.out.println("아이디 입력");
		String id = scan.next();
		System.out.println("비밀번호 입력");
		String pwd = scan.next();
		
		UserDTO userDTO = new UserDTO();
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
	
		//DB
		UserDAO userDAO = UserDAO.getInstance();
		int su = userDAO.write(userDTO);
		
		//response
		System.out.println(su + "개의 행이 삽입되었습니다.");
		
	}
}
