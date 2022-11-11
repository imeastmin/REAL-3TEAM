package peer.controller.booking;

import javax.servlet.http.HttpSession;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import peer.model.booking.BookingTabBean;
import peer.model.booking.HouseViewBean;
import peer.model.house.HouseBean;
import peer.service.booking.BookingListService;
import peer.service.booking.HouseViewService;
import peer.service.booking.HouseViewServiceImp;
import peer.service.house.HouseService;


@Controller
public class BookingController {

	//계정정보 불러오기, 예약한것 데베에 삽입하기, 예약한것 예약내역에 나타내기
	@Autowired
	private BookingListService blservice;
	
	@Autowired
	private HouseService hservice;
	
	@Autowired
	private HouseViewService hvservice;
	
	// 숙소 상세 페이지에서 정보 불러오기
	@RequestMapping(value="/HouseView")			// (데이터를 전달하기 위해 필요한 객체들, , , ...)
	public String HouseView(Integer house_num, HttpSession session, String pageNum, HouseViewBean hvbean, Model model) throws Exception{
		
		System.out.println("HouseView");
		HouseViewBean houseview = hvservice.housenumview(house_num);		// 객체 가공할 함수
		
		model.addAttribute("house", houseview);
		model.addAttribute("house_num", house_num);
		
		
		return "booking/HouseView";
	}
	
	
	
	
	// 예약 등록
	@RequestMapping("/bookRequest")
	public String bookRequest(BookingTabBean btbean, HttpSession session, Model model) throws Exception {
		
		
		
		
		return "booking/iamportPayment";
	}
	
	
	
	
	
	@RequestMapping("/bookInsert")
	public String bookInsert(Integer book_num, Model model, HttpSession session) throws Exception{
		System.out.println("결제성공bookInsert");
		System.out.println("book_num:" + book_num);
		return "booking/bookInsert";
	}
	
	
	
	
	
	@RequestMapping("/bookDelete")
	public String bookDelete(Integer book_num, Model model, HttpSession session) {
		System.out.println("결제 취소 bookDelete");
		System.out.println("book_num:"+book_num);
		
//		int result1 = os.orderProductDelete(o_no);
		
//		int result2 = os.orderDelete(o_no);
//		System.out.println("result2:"+result2);
		
//		model.addAttribute("result", result2);
		
		return "order/orderDeleteResult";
	}
}
