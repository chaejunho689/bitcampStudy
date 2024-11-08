package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

//@Component
@Service
public class UserInsertService implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserDTO userDTO;
	
	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름 입력 : ");
		String name = scan.next();
		
		System.out.println("아이디 입력 : ");
		String id = scan.next();
		
		System.out.println("비밀번호 입력 : ");
		String pwd = scan.next();
	
		UserDTO userDTO = new UserDTO();
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);

		userDAO.write(userDTO);
		
		System.out.println(name + "님의 데이터를 저장하였습니다.");
		
//		UserDAO userDAO = context.getBean("UserDAOImpl");
	}
}
