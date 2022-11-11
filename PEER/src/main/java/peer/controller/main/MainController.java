package peer.controller.main;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		
		return "main";
	}
	
	
	/* 인터셉터 */
	/* @RequestMapping("Call.Interceptor")
	public String interceptor() {
		return "check";
	}*/
	
	
	/* 에러 */
	/*@RequestMapping("Error")*/
	public String error() {
		return "error";
	}

}