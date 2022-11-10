package peer.controller.message;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import peer.model.member.MemberBean;
import peer.model.message.MessageBean;
import peer.model.message.Pagination;
import peer.service.message.MessageService;

@Controller
public class MessageController {
	@Autowired(required=false)
	private MessageService ms;
	
	// 쪽지 메인 페이지
	@RequestMapping(value= {"/message", "/message/{page}"})
	public String message(@PathVariable(name="page", required=false) Integer page, Model model, HttpSession session) throws Exception {
		// 세션 불러오기
		MemberBean user_info = new MemberBean();
		user_info = (MemberBean)session.getAttribute("MemberBean");
		
		// 세션에서 user_num 추출
		int user_num = user_info.getUser_num();
		 
		// 리스트에 쪽지 전체 담기
		// 전체 쪽지수
		int msgTotal = ms.msgTotal(user_num);
		
		if (page == null) page = 1; 
			
		Pagination pg = new Pagination(page, msgTotal);
		
		List<MessageBean> msglist = ms.msgList(user_num, pg.getStartPage(), pg.getEndPage());
		
		model.addAttribute("msglist", msglist);
		model.addAttribute("pg", pg);
	
		//return "/message/messagebox";
		return "message/messagebox?page=" + pg.getPage();
	}
	
	// 쪽지 보내기 폼
	@RequestMapping("/msgwrite")
	public String msgWrite(HttpServletRequest request, Model model, HttpSession session) {
		MemberBean test = new MemberBean();
		test = (MemberBean)session.getAttribute("MemberBean");
		
		System.out.println(test);
		System.out.println(test.getUser_num());
		System.out.println(test.getUser_nickname());
		// 탈퇴한 회원인지 체크
		System.out.println(request.getAttribute("message_sender_num"));
		// 쪽지 작성할 회원번호 체크 
		//int message_receiver_num = request.getAttribute("message_sender_num");
		//String message_receiver_nick = request.getAttribute(name);
		
		//model.addAttribute("message_receiver_num", message_receiver_num);
		//model.addAttribute("message_receiver_nick", message_receiver_nick);
		
		
		return "message/messagewrite";
	}
	
	
/*	
	// 쪽지 보내기 & 답장하기
	@RequestMapping("/msgsend")
	public String msgSend(int message_receiver_num, HttpSession session) throws Exception {
		
		// 세션 불러오기
		MemberBean user_info = new MemberBean();
		user_info = (MemberBean)session.getAttribute("MemberBean");

		System.out.println("send"+message_receiver_num);
		
		// receiver_num에서 nickname 추출하기
		String message_receiver_nick = ms.nicktoUser_num(message_receiver_num);
			
		// MessageBean 생성
		MessageBean msg = new MessageBean();
		msg.setMessage_receiver_nick(message_receiver_nick);
			
		// 세션에서 user_num, user_nickname 추출해서 MessageBean에 담기
		msg.setMessage_sender_num(user_info.getUser_num());
		msg.setMessage_sender_nick(user_info.getUser_nickname());
		System.out.println(msg.getMessage_num());
		System.out.println(msg.getMessage_sender_num());
		System.out.println(msg.getMessage_sender_nick());
		System.out.println(msg.getMessage_receiver_num());
		System.out.println(msg.getMessage_receiver_nick());
		System.out.println(msg.getMessage_content());
		ms.msgSend(msg);
	
		return "/msgwrite?close=1";
	}
	
	
	// 쪽지 상세보기
	@RequestMapping("/msgopen")
	public String msgOpen(int message_num, Model model) throws Exception {
		MessageBean msg = new MessageBean();
		msg = ms.msgOpen(message_num);
		
		model.addAttribute("msg",msg);
		return null;
	}
	
	// 쪽지 삭제
	@RequestMapping("/msgdel")
	public String msgDel(String checklist, int page, RedirectAttributes rattr) throws Exception {

		// '/'로 묶어둔 message_num 분리
		String[] msg_num = checklist.split("/");
		
		// 삭제 처리
		if (msg_num.length != 0) {
			for(int i=0;i<msg_num.length;i++) {
				ms.msgDel(Integer.parseInt(msg_num[i]));
			}
		}
		
		
		
		// 뒤로가기나 새로고침으로 다시 접근하는 것 방지
		rattr.addAttribute("page", page);
		return "redirect:/message/messagebox?page={page}";
	}
*/
}
