package peer.controller.main;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import peer.model.member.MemberBean;

@Controller
public class MainController {
	

	@RequestMapping("/")
	public String index(HttpSession session) {
		// 세션 테스트 코드
		MemberBean test = new MemberBean();
		test.setUser_num(9900);
		test.setUser_nickname("테스트유저");
		session.setAttribute("MemberBean", test);
		
		return "mainindex";
	}

}
