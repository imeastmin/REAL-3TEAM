package peer.controller.message;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@RequestMapping("/message")
	public String message(Model model, HttpSession session) throws Exception {
/*
		// 세션 불러오기
		MemberBean user_info = new MemberBean();
		user_info = session.getAttribute("");
		
		// 세션에서 user_num 추출
		int user_num = user_info.getUser_num()
		 
		// 리스트에 쪽지 전체 담기
		// 전체 쪽지수
		int msgTotal = ms.msgTotal(user_num); 

		Pagination pg = new Pagination();
		
		// 전체 페이지수 설정
		int pglimit = pg.getPageLimit();
		int pageTotal = (msgTotal%pglimit == 0)? msgTotal/pglimit:(msgTotal/pglimit) +1 
		pg.setPageTotal(pageTotal);
		
		// 시작 쪽지 번호 설정
		int startPage = msgTotal;
		int endPage = startPage - pglimit + 1; 
		
		// List에 쪽지 담기
		List<MessageBean> msglist = ms.msgList(user_num, startPage, endPage);
		
		model.addAttribute("msglist", msglist);
*/	
		return "/message/messagebox";
	}
	
	// 쪽지 보내기 답장하기
	@RequestMapping("/msgsend")
	public String msgSend(String user_nickname, String message_content, HttpSession session) {
		
	// 세션 불러오기
	// MemberBean user_info = new MemberBean();
	// user_info = session.getAttribute("");
	
	// user_nickname을 message_receiver으로 변환하기
	// int message_receiver = ms.transUser_num(user_nickname);
		
	// MessageBean 생성
	// MessageBean msg = new MessageBean();
	// msg = 
		
	// 세션에서 user_num 추출해서 message_sender에 담기
	// msg.setMessage_sender(user_info.getUser_num());
		return null;
	}
	
	
	// 쪽지 상세보기
	@RequestMapping("/msgopen")
	public String msgOpen(int message_num, Model model) throws Exception {
		MessageBean msg = new MessageBean();
		msg = ms.msgOpen(message_num);
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
}
