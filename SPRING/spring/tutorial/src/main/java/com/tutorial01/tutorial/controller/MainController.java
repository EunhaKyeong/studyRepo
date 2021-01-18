package com.tutorial01.tutorial.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tutorial01.tutorial.model.dto.PointDTO;
import com.tutorial01.tutorial.model.dto.ProductDTO;

@Controller
public class MainController {
	//http://localhost:8080/
	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("name", "홍길동");
		model.addAttribute("message", "홈페이지 방문을 환영합니다.");
		
		return "main";	///WEB-INF/views/main.jsp
	}
	
	//http://localhost:8080/gugu.do
	@RequestMapping("gugu.do")
	public String gugu() {
		return "test/gugu";
	}
	
	//http://localhost:8080/gogo_result.do
	@RequestMapping("gugu_result.do")
	//@RequestParam() : 폼데이터를 개별변수로 전달하는 방법
	public String guguResult(@RequestParam(defaultValue="3") int dan, Model model) {
		String result = "";
		for (int i=1; i<=9; i++) {
			result += dan + "x" + i + "=" + dan*i + "<br>";
		}
		model.addAttribute("gugu_result", result);
		return "test/gugu_result";
	}
	
	//http://localhost:8080/point.do
	@RequestMapping("point.do")
	public String point() {
		return "test/point";
	}
	
	//http://localhost:8080/point_result.do
	@RequestMapping("point_result.do")
	//@ModelAttribute : form 전송 데이터를 클래스 형태로 여러개의 데이터를 한번에 받아오는 방법.
	public String pointResult(@ModelAttribute PointDTO dto, Model model) {
		dto.setTotal(dto.getKor()+dto.getEng()+dto.getMath());
		dto.setAverage(dto.getTotal()/3.0);
			
		model.addAttribute("dto", dto);
		return "test/point_result";
	}
	
	//http://localhost:8080/move.do
	@RequestMapping("move.do")
	public String move(Model model) {
		//redirect의 경우 데이터 전달은 안되지만 파라미터 전달은 가능함.
		//따라서 redirect:/result.do?name=kim&age=20 이런식으로.
		//이 때 name과 age 파라미터는 @RequestParam을 이용하여 result.do로 파라미터값을 넘겨줄 수 있음.
		return "redirect:/result.do";
	}
	
	//http://localhost:8080/result.do
	@RequestMapping("result.do")
	public String result(@RequestParam(defaultValue="noname") String name, 
			@RequestParam(defaultValue="10") int age, 
			Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "test/result";
	}
	
	//http://localhost:8080/mav.do
	@RequestMapping("mav.do")
	//기존에 쓰던 Model은 addAttribute() 메서드를 사용해 데이터를 뷰에 추가하고 return으로 뷰를 호출했지만
	//ModelAndView는 return문에서 데이터와 뷰를 동시에 처리할 수 있다.
	public ModelAndView mav(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("product", new ProductDTO("샤프", 1000));
			
		return new ModelAndView("test/mav_result", "stationeries", map);
	}
	
	//htttp://localhost:8080/ajax.do
	@RequestMapping("ajax.do")
	public String ajax() {
		return "test/ajax";
	}
	
	//http://localhost:8080/background.do
	@RequestMapping("background.do")
	//비동기 통신은 클라이언트가 본문에 요청 데이터를 전달하고 본문에서 요청 데이터를 읽어 서버가 응답데이터를 전송함. 
	//@ResponseBody는 서버에서 클라이언트로 응답데이터를 전송하기 위해 사용함. 이때 return 타입은 JSON 형태.
	public @ResponseBody ProductDTO background() {
		ProductDTO dto = new ProductDTO("지우개", 700);
		return dto;
	}
	
	//http://localhost:8080/login.do
	@RequestMapping("login.do")
	public String ajax2() {
		return "test/login";
	}
	
	//http://localhost:8080/login_result.do
	@RequestMapping("login_result.do")
	public String loginResult(@RequestParam String id, @RequestParam String pw, Model model) {
		String result = "";
		if (id.equals("kim")&&pw.equals("1234")) {
			result = "로그인에 성공했습니다.";
		}
		else
			result = "아이디 또는 비밀번호가 틀렸습니다.";
		model.addAttribute("login_result", result);
		
		return "test/login_result";
	}
	
	//http://localhost:8080/gugu_ajax.do
	@RequestMapping("gugu_ajax.do")
	public String guguAjax() {
		return "test/gugu_ajax";
	}
	
	//http://localhost:8080/gugu_ajax_result.do
	@RequestMapping("gugu_ajax_result.do")
	//@RequestParam() : 폼데이터를 개별변수로 전달하는 방법
	public String guguAjaxResult(@RequestParam(defaultValue="3") int dan, Model model) {
		String result = "";
		for (int i=1; i<=9; i++) {
			result += dan + "x" + i + "=" + dan*i + "<br>";
		}
		model.addAttribute("gugu_result", result);
		return "test/gugu_ajax_result";
	}
}
