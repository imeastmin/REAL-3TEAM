package peer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class PeerInterceptor implements HandlerInterceptor{
	@Override
		public boolean preHandle(
				HttpServletRequest request, 
				HttpServletResponse response, 
				Object handler)
				throws Exception {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		/* 계정권한 */
		int authority = 1;
		
		if(id == null || id.equals("")) {
			System.out.println("============== INTERCEPTOR ==============");
			response.sendRedirect("Call.Interceptor");
			return false;
		}
		
		if(id != null && authority != 1) {
			System.out.println("============== INTERCEPTOR AUTHORITY ==============");
			response.sendRedirect("Error");
			return false;
		}
		
		return true;
		}
}
