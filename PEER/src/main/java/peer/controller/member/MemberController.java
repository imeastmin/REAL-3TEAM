package peer.controller.member;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import peer.model.member.MemberBean;
import peer.service.member.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService ms;

	// 로그인 page로 이동
	@RequestMapping("/login")
	public String gotologin() {
		return "login/login";
	}

	// 이메일로 회원 정보 가져오기(로그인)
	@RequestMapping("/searchinfo2")
	@ResponseBody
	public int searchinfo2(@RequestParam("user_email") String user_email, @RequestParam("user_pass") String user_pass,
			Model model) {
		MemberBean findmember = ms.searchinfo(user_email);
		if (findmember != null) {
			if (user_pass.equals(findmember.getUser_pass())) {
				return 1; // 입력한 비밀번호와 DB의 pass가 같은경으
			} else {
				return -2; // 입력한 비밀번호와 DB의 pass가 같지 않는경우
			}
		} else {
			return -1; // ID가 없는경우
		}
	}

	// naver callback
	@RequestMapping("callback")
	public String callback() {
		return "login/callback";
	}

	// session 공유
	@GetMapping("/loginsuccess")
	public String SessionShare(@RequestParam("user_email") String user_email, HttpSession session) {
		MemberBean member;
		member = ms.searchinfo(user_email);
		if (member != null) {
			session.setAttribute("MemberBean", member);
			return "redirect:/movemain";
		} else {
			return "/login/userInfoNull";
		}
	}

	// session공유 post로 변경하기 위함
	@GetMapping("/movemain")
	public String movemain(HttpSession session, Model model) {
		MemberBean member = (MemberBean) session.getAttribute("MemberBean");
		System.out.println(member);
		return "main/main";
	}

	// 이메일 인증 page로 이동
	@RequestMapping("/emailAuth")
	public String emailAuth() {
		return "member/emailAuth";
	}

	// 이메일로 회원 정보 가져오기(이메일 인증)
	@RequestMapping("/searchinfo")
	public String searchinfo(@RequestParam("user_email") String user_email, Model model) {
		MemberBean member;
		member = ms.searchinfo(user_email);
		if (member != null) {
			return "member/userex";
		} else {
			String sendingrequest = "redirect:/sendingemail?user_email=" + user_email;
			return sendingrequest;
		}
	}

	// 닉네임으로 회원 정보 가져오기
	@RequestMapping("/nicknamecheck")
	@ResponseBody
	public int nicknamecheck(@RequestParam("user_nickname") String user_nickname, Model model) {
		MemberBean member;
		member = ms.nicknamecheck(user_nickname);
		if (member != null) {
			return 1; // 중복이 있는 경우 1
		} else {
			return 0; // 중복이 없는 경우 0
		}
	}

	// 이메일 보내기
	@RequestMapping("/sendingemail")
	public String sendingemail(@RequestParam("user_email") String user_email, Model model) throws Exception {

		Random random = new Random();
		int EAuthCode = random.nextInt(10000000);

		String charSet = "utf-8";
		String hostSMTP = "smtp.naver.net";
		String hostSMTPid = "joonsoung93";
		String hostSMTPpwd = "ghkdwnstjd93>";

		String fromEmail = "joonsoung93@google.com";
		String fromName = "thank you to join peer";
		String subject = "thank you to join peer . this is your authentication code";

//		String mail = user_email;
//
//		HtmlEmail email = new HtmlEmail();
//		email.setCharset(charSet);
//		email.setSSL(true);
//		email.setHostName(hostSMTP);
//		email.setSmtpPort(465);
//
//		email.setAuthentication(hostSMTPid, hostSMTPpwd);
//		email.setTLS(true);
//		email.addTo(mail, charSet);
//		email.setFrom(fromEmail, fromName, charSet);
//		email.setSubject(subject);
//		email.setHtmlMsg("<p align = 'center'>peer에 오신것을 환영합니다.</p><br>" + "<div align='center'> 인증번호 : " + EAuthCode
//				+ "</div>");
//		email.send();

		model.addAttribute("user_email", user_email);
		model.addAttribute("EAuthCode", EAuthCode);

		return "member/emailAuth";
	}

	// 회원 가입 page로 이동
	@RequestMapping("/join")
	public String gotojoin(@RequestParam String user_email, Model model) {
		MemberBean member;
		member = ms.searchinfo(user_email);
		if (member != null) {
			return "member/userex";
		} else {
			model.addAttribute("user_email", user_email);
			return "member/join";
		}
	}

	// 회원 정보 insert
	@RequestMapping("/insert")
	public String join(MemberBean member, Model model) {

		// 현재년도
		Date nowdate = new Date();
		SimpleDateFormat sb = new SimpleDateFormat("yyyy");
		int nowyear = Integer.parseInt(sb.format(nowdate));

		// 가입자 생년
		int birthyear = Integer.parseInt(member.getUser_birth().substring(0, 4));

		// setting
		member.setUser_age(nowyear - birthyear + 1);

		ms.createMember(member);
		return "login/login";
	}

	// 회원정보 수정 전 비밀번호 확인
	@RequestMapping("/passwordCheck")
	public String passwordCheck(HttpSession session) {
		session.getAttribute("MemberBean");
		return "member/UpdatePassCheck";
	}

	// 회원정보 수정으로 이동
	@RequestMapping("/memberUpdate")
	public String memberUpdate() {
		return "member/memberUpdate";
	}

	// 회원 정보 수정 update
	@RequestMapping("/updateuser")
	public String updateuser(MemberBean member, Model model, HttpSession session) {

		// 현재년도
		Date nowdate = new Date();
		SimpleDateFormat sb = new SimpleDateFormat("yyyy");
		int nowyear = Integer.parseInt(sb.format(nowdate));

		// 가입자 생년
		int birthyear = Integer.parseInt(member.getUser_birth().substring(0, 4));

		// setting
		member.setUser_age(nowyear - birthyear + 1);

		int result = ms.updateuser(member);
		if (result == 1) {
			session.setAttribute("Memberbean", ms.searchinfo(member.getUser_email()));
		}
		return "redirect:/login";
	}

	// 회원 탈퇴
	@RequestMapping("/deleteinfo")
	public String deleteinfo(HttpSession session) {
		MemberBean member = (MemberBean) session.getAttribute("MemberBean");
		System.out.println(member.getUser_num());
		int result = ms.deleteuser(member);
		System.out.println(result);

		return "redirect:/login";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "testtempleates/test";
	}

}