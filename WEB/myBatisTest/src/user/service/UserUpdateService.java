package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService implements UserService {

	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("수정할 아이디 입력");
		String id = scan.next();
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = userDAO.getUser(id);
		
		
		if(userDTO == null) {
			System.out.println("수정할 아이디가 없습니다.");
			return;
		}
		
		System.out.println("이름 입력");
		String name = scan.next();

		System.out.println("비밀번호 입력");
		String pwd = scan.next();
		
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);

	
		//DB
		int su = userDAO.update(userDTO);
		
		//response
		System.out.println(su + "개의 행이 수정되었습니다.");
	}

}
