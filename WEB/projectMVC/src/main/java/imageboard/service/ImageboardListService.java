package imageboard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import imageboard.bean.ImageboardDTO;
import imageboard.bean.ImageboardPaging;
import imageboard.dao.ImageboardDAO;

public class ImageboardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		int pg = 1;
		if(request.getParameter("pg") != null) pg = Integer.parseInt(request.getParameter("pg"));
				
//		//1페이지당 3개씩
//		Oracle
//		int endNum = pg * 3;
//		int startNum = endNum - 2;
		 
		int endNum = 3; // 개수
		int startNum = pg * endNum - endNum; // 시작위치 - 0, 3, 6
		
		
		
		//DB
		Map<String, Integer> map = new HashMap<>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
		List<ImageboardDTO> list = imageboardDAO.imageboardList(map);
		
		//페이징 처리
		int totalA = imageboardDAO.getTotalA();
		
		ImageboardPaging imageboardPaging = new ImageboardPaging();
		imageboardPaging.setCurrentPage(pg);
		imageboardPaging.setPageBlock(3);
		imageboardPaging.setPageSize(3);
		imageboardPaging.setTotalA(totalA);
		
		imageboardPaging.makePagingHTML();
				
		request.setAttribute("pg", pg);
		request.setAttribute("list", list);
		request.setAttribute("imageboardPaging", imageboardPaging);
		return "/imageboard/imageboardList.jsp";
	}

}








