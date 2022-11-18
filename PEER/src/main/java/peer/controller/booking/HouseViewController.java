package peer.controller.booking;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import peer.model.booking.BookingBean;
import peer.model.booking.HouseViewBean;
import peer.model.house.HouseBean;
import peer.model.house.HousepriceBean;
import peer.model.member.MemberBean;
import peer.service.booking.HouseViewService;
import peer.service.house.HouseService;
import peer.service.member.MemberService;

@Controller
public class HouseViewController {

	//계정정보 불러오기, 예약한것 데베에 삽입하기, 예약한것 예약내역에 나타내기
	
	@Autowired
	private HouseService houseService;
	
	@Autowired
	private HouseViewService hvservice;
	
	@Autowired
	private MemberService ms;
	
	
	// 임시 숙소검색창
	@RequestMapping("/HouseListView")
	public String list(Model model, int user_num, HttpServletRequest request, HttpSession session) throws Exception {

		MemberBean member = (MemberBean)session.getAttribute("MemberBean");
		
		List<HouseBean> hosthouselist = new ArrayList<HouseBean>();

		int page = 1;
		int limit = 10; // 한 화면에 출력할 레코드수

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		// 총 리스트 수를 받아옴.
		int listcount = houseService.getListCount(user_num);
		System.out.println("listcount:" + listcount);

		// 페이지 번호(page)를 DAO클래스에게 전달한다.
		hosthouselist = houseService.getHosthouseList(page, user_num); // 리스트를 받아옴.

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

//		model.addAttribute("num", num);
		model.addAttribute("page", page);
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("listcount", listcount);
		model.addAttribute("hosthouselist", hosthouselist);

		return "booking/HouseListView";
	}
	

	// 숙소 상세보기 (상세보기)
		@RequestMapping(value = "/HouseView", method = RequestMethod.GET)
		public String house_cont(@RequestParam("house_num") int house_num, 
//								@RequestParam("page") String page,
								@RequestParam("state") String state, 
								HttpSession session,
								Model model) throws Exception {			
			
			HouseBean house = houseService.house_cont(house_num); // house 상세정보 구하기
			MemberBean member = (MemberBean)session.getAttribute("MemberBean");
			HouseViewBean hostname = hvservice.getHostname(house_num);
			
			System.out.println("house_num:"+house.getHouse_num());
			System.out.println("hostname:"+hostname.getUser_name());
			System.out.println("house:"+house);
			
			HousepriceBean hprice = houseService.hprice_cont(house_num); // houseprice 상세정보 구하기
		    
			String details =  house.getHouse_detail();
		    String[] detail = details.split(",");
		      
		    String Pho = house.getHouse_photo();
		    System.out.println("Pho - " + Pho);
			String[] PhotoList = Pho.split(",");
			String[] Photos = new String[PhotoList.length-1];
			System.out.println("PhotoList - " + PhotoList.toString());
			
			String FirstPhoto = PhotoList[0];
			System.out.println("FirstPho - " + FirstPhoto);
			System.out.println("PhotoList Length - " + PhotoList.length);
			System.out.println("Photos Length - " + Photos.length);
			
			if(PhotoList.length > 1) {
				for(int i = 1; i < PhotoList.length; i++) {
					Photos[i-1] = PhotoList[i];
				}
			}
			
			System.out.println("Photos - " + Photos[0]);
			
			model.addAttribute("hcont", house);
			model.addAttribute("house_num", house.getHouse_num());
			model.addAttribute("hostname", hostname);
		    model.addAttribute("detail", detail);
			model.addAttribute("FirstPhoto", FirstPhoto);
			model.addAttribute("Photos", Photos);
			model.addAttribute("hpcont", hprice);
//			model.addAttribute("page", page);
			
			if (state.equals("cont")) { // 상세폼

				return "booking/HouseView";
			}
			return null;
		}

}
