package member.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LoginService  implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		boolean result = false;
	
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberDTO memberDTO = new MemberDTO();

		memberDTO.setId(id);
		memberDTO.setPwd(pwd);
		
		memberDTO = memberDAO.login(memberDTO);
		
		request.setAttribute("result", result);
	
		if(memberDTO == null ) {
			return "/member/loginFail.jsp";
		} else {
			result = true;
			HttpSession session = request.getSession();
			session.setAttribute("memName", memberDTO.getName()); // 다형성 : 자식 = (자식)부모 형태로 형변환
			session.setAttribute("memId", id); // 다형성 : 자식 = (자식)부모 형태로 형변환
			session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
			session.setAttribute("memDTO", memberDTO);
			
			return "/member/loginOk.jsp";
		}
	}
}