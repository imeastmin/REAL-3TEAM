package peer.controller.booking;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class PayingController {

	@RequestMapping(value="/paying")
	public String paying() {
		return "booking/paying";
	}

	@RequestMapping("/paying0")
	public String paying0() {
		return "booking/paying0";
	}

	@RequestMapping("/paying1")
	public String paying1() {
		return "booking/paying1";
	}
	
	@RequestMapping(value="/paying2")
	public String paying2() {
		return "booking/paying2";
	}
	
	@RequestMapping(value="/paying3Verify")
	public String paying3Verify() {
		return "booking/paying3Verify";
	}
	
	@RequestMapping(value="/paying4Verify")
	public String paying4Verify() {
		return "booking/paying4Verify";
	}
	
	@RequestMapping(value="/paying5")
	public String paying5() {
		return "booking/paying5";
	}
	
	@RequestMapping(value="/paying6")
	public String paying6() {
		return "booking/paying6";
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
	
	@RequestMapping("/calendar02")
	public String calendar02() {
		return "booking/calendar02";
	}
	
	@RequestMapping("/calendar03")
	public String calendar03() {
		return "booking/calendar03";
	}
	
	@RequestMapping("/bookinglist")
	public String bookinglist() {
		return "booking/bookinglist";
	}
	
	@RequestMapping("/aaa")
	public String aaa() {
		return "booking/aaa";
	}
	
	@RequestMapping("/insertReservation")
	public String insertReservation() {
		return "booking/insertReservation";
	}

	@RequestMapping("/csstest")
	public String csstest() {
		return "booking/csstest";
	}
}
