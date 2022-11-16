package peer.controller.booking;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import peer.model.booking.BookingBean;
import peer.model.booking.ShareBean;
import peer.model.member.MemberBean;
import peer.service.booking.MyBookingServiceImp;

@Controller
public class MyBookingController {
	
	@Autowired
	private MyBookingServiceImp MyBookingService;

	/* 예약내역 페이지 */
	@RequestMapping("MyBooking.Intercept")
	public String myBooking(HttpSession session,
						    Model model) throws Exception {
		
		MemberBean memberBean = (MemberBean)session.getAttribute("MemberBean");
		
		int id = memberBean.getUser_num();
		List<ShareBean> MyShareBooking = MyBookingService.getMyShareBooking(id);
		List<BookingBean> MyBooking = MyBookingService.getMyBooking(id);
		System.out.println("Service MYBOOKING DATA - " + MyBooking);
		
		model.addAttribute("MyShareBooking", MyShareBooking);
		model.addAttribute("MyBooking", MyBooking);
		model.addAttribute("id", id);

		return "share/mybooking";
	}
}
