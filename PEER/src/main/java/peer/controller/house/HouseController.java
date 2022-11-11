package peer.controller.house;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import peer.model.house.HouseBean;
import peer.model.house.HousepriceBean;
import peer.service.house.HouseServiceImpl;

@Controller
public class HouseController {

	@Autowired
	private HouseServiceImpl houseService;

	@RequestMapping("house")
	public String test() {
		return "house/index";
	}

	// 숙소 등록 폼
	@RequestMapping("house_insert")
	public String house_insert() {
		return "house/house_insert";
	}

	// 숙소 등록
	@RequestMapping("house_insert_ok")
	public String house_insert_ok(@RequestParam("myfile") List<MultipartFile> mpf, MultipartHttpServletRequest request,
			HouseBean h, HousepriceBean hp, String address, String tbox3, String photo, double house_x, double house_y)
			throws Exception {
		// 주소값+상세주소
		address += (" " + tbox3);
		h.setHouse_address(address);

		// x, y 좌표
		System.out.println("x,y: " + house_x + "," + house_y);

		// 사진파일 업로드
		System.out.println("mpf:" + mpf);
		System.out.println("request:" + request.getAttribute("myfile"));
		String path = request.getSession().getServletContext().getRealPath("resources");
		String root = path + "\\" + "img";

		System.out.println("path:" + path);
		System.out.println("root:" + root);

		File fileCheck = new File(root);

		if (!fileCheck.exists())
			fileCheck.mkdirs();

		List<String> fileList = new ArrayList<>();

		// fileList에 중복제거를 위해 uuid를 통해 새로운 파일네임 부여  
		for (int i = 0; i < mpf.size(); i++) {
			String originFile = mpf.get(i).getOriginalFilename();
			String ext = originFile.substring(originFile.lastIndexOf("."));
			String changeFile = UUID.randomUUID().toString() + ext;

			fileList.add(changeFile);

		}
		photo = fileList.toString();
		h.setHouse_photo(photo);
		System.out.println("fileList:" + fileList);

		for (int i = 0; i < mpf.size(); i++) {
			File uploadFile = new File(root + "\\" + fileList.get(i));
			mpf.get(i).transferTo(uploadFile);
		}

		System.out.println("다중 파일 업로드 성공!");

		System.out.println("house_insert_ok");
		houseService.insert(h, hp);
		return "redirect:/host_house_list";
	}

	// 호스트 숙소 목록
	@RequestMapping("host_house_list")
	public String list(Model model, HttpServletRequest request) throws Exception {

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

//		model.addAttribute("num", num);
		model.addAttribute("page", page);
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("listcount", listcount);
		model.addAttribute("hosthouselist", hosthouselist);

		return "house/host_house_list";
	}

	// 숙소 상세보기 (상세보기,수정폼,삭제폼)
	@RequestMapping(value = "house_cont", method = RequestMethod.GET)
	public String house_cont(@RequestParam("house_num") int house_num, 
							@RequestParam("page") String page,
							@RequestParam("state") String state, 
							Model model) throws Exception {
		System.out.println("house_num:" + house_num);

		HouseBean house = houseService.house_cont(house_num); // 상세정보 구하기

		
		model.addAttribute("hcont", house);
		model.addAttribute("page", page);

		if (state.equals("cont")) { // 상세폼
//			String house_cont = house.getHouse_detail2().replace("\n", "<br>");
//			model.addAttribute("house_cont", house_cont);
			return "house/house_cont";
		} else if (state.equals("upd")) { // 수정폼
			return "house/house_update";
		} else if (state.equals("del")) { // 삭제폼
			return "house/house_delete";
		}
		return null;
	}
	
	
	
}
