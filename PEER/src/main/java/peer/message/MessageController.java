package peer.message;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {
	 
	@RequestMapping("/message")
	public String message() {
		return "/message/messagebox";
	}
	
	@RequestMapping("/msgDel")
	public String msgDel(String checklist) {
		// 체크용 코드
		System.out.println("넘어와야하는값:"+checklist);
		return "/message/messagebox";
	}
}
