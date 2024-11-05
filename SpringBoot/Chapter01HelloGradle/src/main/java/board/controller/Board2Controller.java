package board.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import board.bean.BoardDTO;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
public class Board2Controller {	
	
//	@Autowired
	private List<BoardDTO> list = new ArrayList<>();

	@PostMapping(value="board2/boardInput") 
	public void boardInput(@RequestBody BoardDTO boardDTO) {
		boardDTO.setLogtime(new SimpleDateFormat("yyyy.MM.dd").format(new Date()));
		list.add(boardDTO);		
		
		System.out.println(list);
	}

	
	@GetMapping(value="board2/boardWrite")
	public List<BoardDTO> boardWrite(
			@RequestParam("subject") String subject, 
			@RequestParam("name") String name, 
			@RequestParam("content") String content, 
			@RequestParam("seq") int seq) {
		
		BoardDTO boardDTO = new BoardDTO();
		
		boardDTO.setSeq(seq);
		boardDTO.setName(name);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		list.add(boardDTO);

		return list;
	}
	
	@GetMapping(value="board2/boardList")
	public List<BoardDTO> boardList() {
//		BoardDTO boardDTO = new BoardDTO();
//		list.add(boardDTO);
		
		return list;
	}
}
