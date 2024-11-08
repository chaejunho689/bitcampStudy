package user.service;

import java.util.List;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSelectService implements UserService {


	@Override
	public void execute() {
		System.out.println();
		
		
		//DB
		UserDAO userDAO = UserDAO.getInstance();
		List<UserDTO> list = userDAO.getAllList();
		
		System.out.print("이름" + "\t" + "아이디" + "\t" + "비밀번호");
		System.out.println();
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName() + "\t"
								+ userDTO.getId() + "\t"
								+ userDTO.getPwd());
		}
		
	}

}
