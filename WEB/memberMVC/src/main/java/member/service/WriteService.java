package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class WriteService  implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String id = request.getParameter("id");
		String pwd1 = request.getParameter("password1");
		String pwd2 = request.getParameter("password2");

		String name = request.getParameter("name");
		String gender = request.getParameter("gender");

		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");

		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");

		String zipcode = request.getParameter("zipcode");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");


		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setId(id);
		memberDTO.setPwd(pwd1);
		memberDTO.setName(name);
		memberDTO.setGender(gender);
		memberDTO.setEmail1(email1);
		memberDTO.setEmail2(email2);
		memberDTO.setTel1(tel1);
		memberDTO.setTel2(tel2);
		memberDTO.setTel3(tel3);
		memberDTO.setZipcode(zipcode);
		memberDTO.setAddr1(addr1);
		memberDTO.setAddr2(addr2);
		

		memberDAO.register(memberDTO);
	
		return "/member/write.jsp";
	}
	
	
}