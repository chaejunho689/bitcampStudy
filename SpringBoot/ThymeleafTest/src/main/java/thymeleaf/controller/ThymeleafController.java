package thymeleaf.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import thymeleaf.bean.PersonDTO;

@Controller
public class ThymeleafController {
	
	public ThymeleafController() {
		System.out.println("ThymeleafController 생성자");
	}
	
	
	@GetMapping(value = "hithymeleaf")
	public String hitymeleaf(Model model) {
		model.addAttribute("say", "안녕하세요");
		return "basic/hithymeleaf";
	}

	@GetMapping(value = "literal")
	public String literal(Model model) {
		model.addAttribute("data", "스프링 부트 ");
		return "basic/literal";
	}
	@GetMapping(value = "variable")
	public String variable(Model model) {
		PersonDTO aa = new PersonDTO("홍길동", 25);
		PersonDTO bb = new PersonDTO("라이언", 33);
		PersonDTO cc = new PersonDTO("프로도", 18);
		
		List<PersonDTO> list = new ArrayList<>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		Map<String, Object> map = new HashMap<>();
		map.put("aa", aa);
		map.put("bb", bb);
		map.put("cc", cc);
		
		model.addAttribute("aa", aa);
		model.addAttribute("bb", bb);
		model.addAttribute("cc", cc);
		
		model.addAttribute("list", list);
		model.addAttribute("map", map);
		
		
		return "basic/variable";
	}

	@GetMapping(value = "operation")
	public String operation(Model model) {
		return "basic/operation";
	}
}
