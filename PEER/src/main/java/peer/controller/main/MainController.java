package peer.controller.main;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import peer.model.house.HouseBean;
import peer.service.house.HouseService;

@Controller
public class MainController {
	@Autowired
	private HouseService houseService;
	
	@RequestMapping("/")
	public String index() {
		return "main";
	}
	
	@RequestMapping("/search")
	   public String search(Model model, HttpServletRequest request) throws Exception{
	      List<HouseBean> hosthouselist = new ArrayList<HouseBean>();

	      int page = 1;
	      int limit = 10; // 한 화면에 출력할 레코드수

	      if (request.getParameter("page") != null) {
	         page = Integer.parseInt(request.getParameter("page"));
	      }

	      // 총 리스트 수를 받아옴.
	      int listcount = houseService.getListCount();
	      System.out.println("listcount:" + listcount);

	      // 페이지 번호(page)를 DAO클래스에게 전달한다.
	      hosthouselist = houseService.getHosthouseList(page); // 리스트를 받아옴.

	      // 총 페이지 수.
	      int maxpage = (int) ((double) listcount / limit + 0.95); // 0.95를 더해서 올림
	                                                   // 처리.
	      // 현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
	      int startpage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
	      // 현재 페이지에 보여줄 마지막 페이지 수.(10, 20, 30 등...)
	      int endpage = maxpage;

	      if (endpage > startpage + 10 - 1)
	         endpage = startpage + 10 - 1;

	      int num = listcount - (page - 1) * 10;

//	      model.addAttribute("num", num);
	      model.addAttribute("page", page);
	      model.addAttribute("startpage", startpage);
	      model.addAttribute("endpage", endpage);
	      model.addAttribute("maxpage", maxpage);
	      model.addAttribute("listcount", listcount);
	      model.addAttribute("hosthouselist", hosthouselist);
	      
	      return "search";
	   }
	
	/* 인터셉터 구현 - 김동민 */
	@RequestMapping("Interceptor")
	public String interceptor() {
		System.out.println("******* None Login Session *******");
		return "Interceptor";
	}
	
	/* 접근제한 구현 - 김동민 */
	@RequestMapping("Suspension")
	public String suspension() {
		System.out.println("******* None Login access *******");
		return "Suspension";
	}
}