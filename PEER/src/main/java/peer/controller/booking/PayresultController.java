package peer.controller.booking;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PayresultController {

	@RequestMapping("/payresult")
	public String payresult() {
		return "booking/payresult";
	}
}
