package imageboard.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageboardDAO;

public class ImageboardWriteAJaxService implements CommandProcess {
	private String bucketName = "bitcamp-9th-storage-144";
	
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//실제 폴더
		String realFolder = request.getServletContext().getRealPath("/storage");
		System.out.println("realFolder = " + realFolder);
		
		//업로드
//		MultipartRequest multi = new MultipartRequest(
//				request,
//				realFolder,
//				5 * 1024 * 1024, //5MB
//				"UTF-8");
		
		MultipartRequest multi = new MultipartRequest(
				request,
				realFolder, //이미지가 저장되는 위치
				5 * 1024 * 1024, //5MB
				"UTF-8",
				new DefaultFileRenamePolicy()); //똑같은 이름이 업로드되면 파일명을 변경해서 올린다.
		
		//데이터
		String imageId = multi.getParameter("imageId");
		String imageName = multi.getParameter("imageName");
		int imagePrice = Integer.parseInt(multi.getParameter("imagePrice"));
		int imageQty = Integer.parseInt(multi.getParameter("imageQty"));
		String imageContent = multi.getParameter("imageContent");
		
		String image1 = multi.getOriginalFileName("image1");
		String fileName = multi.getFilesystemName("image1");
		
		// 파일 객체 생성
		File file = new File(realFolder, image1);
		
		// Object Storage(NCP) 의 새로운 이미지 올리기
		NCPObjectStorageService ncp = new NCPObjectStorageService();
		image1 = ncp.uploadFile("bitcamp-9th-bucket-144", "storage/" , file);
		
		System.out.println(image1 + ", " + fileName);
		
		ImageboardDTO imageboardDTO = new ImageboardDTO();
		imageboardDTO.setImageId(imageId);
		imageboardDTO.setImageName(imageName);
		imageboardDTO.setImagePrice(imagePrice);
		imageboardDTO.setImageQty(imageQty);
		imageboardDTO.setImageContent(imageContent);
		imageboardDTO.setImage1(image1); //파일명만 DB에 저장
		
		ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
		imageboardDAO.imageboardWrite(imageboardDTO);
		
		return "none";
	}

}









