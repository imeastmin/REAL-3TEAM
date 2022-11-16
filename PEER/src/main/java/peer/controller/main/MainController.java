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
	@RequestMapping("Interceptor")
	public String interceptor() {
		System.out.println("******* None Login Session *******");
		return "Interceptor";
	}
	
	/* 접근제한 구현 - 김동민 */
	@RequestMapping("Suspension")
	public String suspension() {
		System.out.println("******* None Login access *******");
		return "Suspension";
	}
}