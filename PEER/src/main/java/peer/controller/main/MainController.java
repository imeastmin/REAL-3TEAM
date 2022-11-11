package peer.controller.main;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		
		return "main";
	}
	
	/* 인터셉터 구현 - 김동민 */
	
	/* 에러페이지 구현 - 김동민 */
}