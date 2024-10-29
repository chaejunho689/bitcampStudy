package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.dao.MemberDAO;

public class CheckIdService  implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	
	//데이터
	String id = request.getParameter("id");
	MemberDAO memberDAO = MemberDAO.getInstance();
	
	boolean result = memberDAO.isExistId(id);
		
	request.setAttribute("result", result);
	return "/member/checkId.jsp";
	}
	
	
}
