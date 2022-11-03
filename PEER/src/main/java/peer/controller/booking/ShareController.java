package peer.controller.booking;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import peer.model.booking.ShareBean;
import peer.model.member.MemberBean;
import peer.service.booking.ShareServiceImp;

@Controller
public class ShareController {
	
	@Autowired
	private ShareServiceImp shareService;
	
	@RequestMapping("/")
	public String Test() {
		return "index";
	}
	
	/* 대기열 리스트 */
	@RequestMapping(value = "GetQueList.do", method = RequestMethod.POST)
	public String getQueList(int id, 
							 Model model) throws Exception{
		
		/* 진입확인 */
		System.out.println("Controller - GetQueList.do");
		
		/* View에서 가져온 데이터 확인 */
		System.out.println("Controller USER_NUM DATA - " + id);
		
		/* 예약정보 확인 */
		ShareBean info = shareService.getShareInfo(id);
		System.out.println("Controller INFO DATA - " + info);
		int book_num = info.getBook_num();
		System.out.println("Controller BOOK_NUM DATA - " + book_num);
		
		/* 성별정보 확인 */
		String gender = shareService.getGender(id);
		System.out.println("Controller GENDER DATA - " + gender);
		
		/* 대기열 데이터 확인 */
		List<MemberBean> QueMember = shareService.getQueList(info, gender);
		System.out.println("Controller QUEMEMBER DATA - " + QueMember);
		
		/* 페이지에 공유 */
		model.addAttribute("id", id);
		model.addAttribute("book_num", book_num);
		model.addAttribute("QueMember", QueMember);
		
		return "share/queue_list";
	}
	
	
	/* PRG Pattern: 쉐어신청 - POST */
	@PostMapping(value = "Sign.do")
	public String sign(int user_num_1,
					   int user_num_2,
					   int book_num,
					   Model model) {
		
		System.out.println("Controller USER_NUM_1 DATA - " + user_num_1);
		System.out.println("Controller USER_NUM_2 DATA - " + user_num_2);
		System.out.println("Controller BOOK_NUM DATA - " + book_num);
		
		return "redirect:ShareSign.do";
	}
	
	/* PRG Pattern: 쉐어신청 - GET */
	@GetMapping(value = "ShareSign.do")
	public String shareSign(Model model) {
		System.out.println("쉐어사인 진입");
		return "share/queue_view";
	}
	
	
	// 쉐어 결정
	@RequestMapping("ShareResult.do")
	public String shareResult(String result) {
		
		// 쉐어확정
		if(!result.equals("")) {
			return "share/queue_result";
		}
		
		// 쉐어취소
		if(result.equals("")) {
			return "redirect:/share/queue_list";
		}
		
		return "/";
	}
	
	
	// 쉐어 예약취소
	@RequestMapping("BookingCancle.do")
	public String bookingCancle() { 
		return "";
	}
	
	
}
