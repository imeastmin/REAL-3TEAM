package peer.controller.booking;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import peer.model.booking.BookingBean;
import peer.model.member.MemberBean;
import peer.service.booking.BookingService;
import peer.service.member.MemberService;


@Controller
public class BookingController {

	@Autowired
	private MemberService ms;
	
	@Autowired
	private BookingService bs;
	
	@RequestMapping(value="/paying")
	public String paying() {
		return "booking/paying";
	}

	@RequestMapping("bookingInsert.do")
	public String bookingInsert(BookingBean bookingbean, @RequestParam("house_num") int house_num, Model model, HttpSession session)throws Exception {
		
		System.out.println("결제 성공 payingInsert");
		MemberBean member = (MemberBean)session.getAttribute("MemberBean");	// 로그인된 유저정보 불러오기
		
		int user_num = member.getUser_num();
		
		bookingbean.setHouse_num(house_num);
		bookingbean.setUser_num(user_num);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy/MM/dd");	// checkin, checkout 날짜형 보기 편하게 하는 용
		
		System.out.println("book_num:" + bookingbean.getBook_num());
		System.out.println("house_num:" + bookingbean.getHouse_num());
		System.out.println("user_num:" + bookingbean.getUser_num());
		System.out.println("checkin:" + simpleDateFormat.format(bookingbean.getCheckin()));
		System.out.println("checkout:" + simpleDateFormat.format(bookingbean.getCheckout()));

		System.out.println("house_price:" + bookingbean.getHouse_price());
		System.out.println("total_price:" + bookingbean.getTotal_price());
		
		
		int result=0;
		
//		String user_email = (String)session.getAttribute("user_email");	// 해당 유저의 예약
		
		result = bs.bookingInsert(bookingbean);
		if(result == 1) System.out.println("예약완료");
		
		model.addAttribute("result", result);
				
		return "booking/bookingInsert";
	}
	
	@RequestMapping("/payresult")
	public String payresult() {
		return "booking/payresult";
	}	
	
	@RequestMapping("/bookinglist")
	public String bookinglist() {
		return "booking/bookinglist";
	}

}
