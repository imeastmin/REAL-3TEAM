package peer.controller.payments;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class PayingController {

	@RequestMapping(value="/paying")
	public String iamport() {
		return "booking/paying";
	}
	
	@RequestMapping(value = "/index")
	public String test() {
		return "booking/index";
	}
	
	@RequestMapping("/calendar")
	public String calendar() {
		return "booking/calendar";
	}
	
	@RequestMapping("/calendar01")
	public String calendar01() {
		return "booking/calendar01";
	}
}
