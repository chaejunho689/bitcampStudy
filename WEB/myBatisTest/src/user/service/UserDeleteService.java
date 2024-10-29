package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService {

	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("삭제할 아이디 입력");
		String id = scan.next();
		
		UserDTO userDTO = new UserDTO();
		userDTO.setId(id);
	
		//DB
		UserDAO userDAO = UserDAO.getInstance();
		int su = userDAO.delete(userDTO);
		
		//response
		System.out.println(su + "개의 행이 삭제되었습니다.");
		
		
	}

}
