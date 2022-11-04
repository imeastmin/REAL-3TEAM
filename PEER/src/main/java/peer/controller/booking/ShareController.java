package peer.controller.booking;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import peer.model.booking.ShareBean;
import peer.model.member.MemberBean;
import peer.service.booking.ShareServiceImp;

@Controller
public class ShareController {
	
	@Autowired
	private ShareServiceImp shareService;
	
//	@RequestMapping("/")
//	public String Test() {
//		return "index";
//	}
	
	// 대기열 리스트
	@RequestMapping(value = "/GetQueList.do", method = RequestMethod.POST)
	public String queue(HttpServletRequest request, 
						Model model) throws Exception{
		/* 진입확인 */
		System.out.println("Controller - GetQueList.do");
		
		/* View에서 가져온 데이터 확인 */
		int user_num = Integer.parseInt(request.getParameter("user_num"));
		System.out.println("Controller USER_NUM DATA - " + user_num);
		
		/* 예약정보 확인 */
		ShareBean info = shareService.getShareInfo(user_num);
		System.out.println("Controller INFO DATA - " + info);
		
		/* 성별정보 확인 */
		String gender = shareService.getGender(user_num);
		System.out.println("Controller GENDER DATA - " + gender);
		
		/* 대기열 데이터 확인 */
		List<MemberBean> QueMember = shareService.getQueList(info, gender);
		System.out.println("Controller QUEMEMBER DATA - " + QueMember);
		
		/* 페이지에 공유 */
		model.addAttribute("user_num", user_num);
		model.addAttribute("QueMember", QueMember);
		
		return "share/queue_list";
	}
	
	
	// 쉐어 신청
	@RequestMapping(value = "/ShareSign.do", method = RequestMethod.GET)
	public String shareSign(Model model) {
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
