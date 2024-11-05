package board.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import board.bean.BoardDTO;

@RestController
public class BoardController {
	public BoardController() {
		System.out.println("BoardController 생성자 ");
	}
	
	@GetMapping(value="board/hello")
	public String Hello(@RequestParam(value="name") String name) {
		return "Hello   " + name + "!!!";
	}
	
	@GetMapping(value="board/getBoard")
	public BoardDTO getBoard() {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSeq(10);
		boardDTO.setName("허균");
		boardDTO.setSubject("홍길동전");
		boardDTO.setContent("허난설화");
		boardDTO.setLogtime(new Date());
		return boardDTO;
	}
	
	@GetMapping(value="board/getBoardList")
	public List<BoardDTO> getBoardList() {
		List<BoardDTO> list = new ArrayList<>();
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSeq(10);
		boardDTO.setName("허균");
		boardDTO.setSubject("홍길동전");
		boardDTO.setContent("허난설화");
		boardDTO.setLogtime(new Date(0));
		
		list.add(boardDTO);
		
		boardDTO = new BoardDTO();
		boardDTO.setSeq(11);
		boardDTO.setName("김수정");
		boardDTO.setSubject("둘리");
		boardDTO.setContent("빙하타고");
		boardDTO.setLogtime(new Date(0));
		
		list.add(boardDTO);

		
		return list;
	}
	
}


//생성자에 있는 내용이 출력되지 않은 것은 빈으로 생성이 안되었다는 뜻이다.