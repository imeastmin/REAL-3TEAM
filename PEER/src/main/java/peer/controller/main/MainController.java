package peer.controller.main;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		session.setAttribute("nickname", "닉네임");
		return "mainindex";
	}

}
