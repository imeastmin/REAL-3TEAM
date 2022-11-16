package peer;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;
import peer.model.member.MemberBean;
import peer.model.member.UserLog;
import peer.service.member.MemberService;

@Slf4j
@Component
public class intercepter extends HandlerInterceptorAdapter {

	@Autowired
	MemberService ms;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		MemberBean member = (MemberBean) session.getAttribute("MemberBean");
		if (member != null) {
			System.out.println("interceptor member : " + member);
			UserLog log = new UserLog();
			Date today = new Date();

			String readyToMappingName = request.getRequestURI();
			System.out.println(readyToMappingName);
			if (!readyToMappingName.equals("/error")) {
				log.setUser_do(readyToMappingName);
				log.setUser_name(member.getUser_name());
				log.setUser_num(member.getUser_num());
				log.setUser_date(today);
			} else {
				return true;
			}

			System.out.println("interceptor log : " + log);
			ms.insertLog(log);
			System.out.println("인터셉터 성공");
			return true;
		} else {
//			// 사용자 ip가져옴
//			InetAddress local = InetAddress.getLocalHost();
//			String ip = local.getHostAddress();
//			System.out.println(ip);
//			
//			// adminip 설정 => 이걸 db에 넣냐 안넣냐...
//			String adminip[] = { "192.168.0.9", "172.30.1.41", "172.30.1.254" };
//			for (int i = 0; i < adminip.length; i++) {
//				if (ip.equals(adminip[i])) {
//					response.sendRedirect("/logview.EI");
//					return false;
//				}
//			}
		}
		return true;
	}

}