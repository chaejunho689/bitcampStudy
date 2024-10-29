package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchService implements UserService {

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		Map<String,Object>map = new HashMap<String,Object>();

		System.out.println("1번 입력시 이름 검색, 2번 입력 시 아이디를 검색합니다.");
		int search_select = scan.nextInt();
		String search_keyword = "";
		
		if(search_select == 1) {
			System.out.println("이름을 입력하세요 : ");
			search_keyword = scan.next();
		} else {
			System.out.println("아이디를 입력하세요 : ");
			search_keyword = scan.next();
		}
		
		map.put("search_select", search_select);
		map.put("search_keyword", search_keyword);
		
		UserDAO userDAO = UserDAO.getInstance();
		List<UserDTO> list = userDAO.search(map);
		
		System.out.print("이름" + "\t" + "아이디");
		System.out.println();
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName() + "\t"
								+ userDTO.getId());
		}
	}

}
