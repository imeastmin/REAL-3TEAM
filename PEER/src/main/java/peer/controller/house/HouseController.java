package peer.controller.house;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import peer.model.house.HouseBean;
import peer.service.house.HouseServiceImpl;

@Controller
public class HouseController {

	@Autowired
	private HouseServiceImpl houseService;
	
//	@RequestMapping("/")
//	public String test() {
//		return "house/index";
//	}
//	
	// 숙소 등록 폼
	@RequestMapping("house_insert")
	public String house_insert() {
		return "house/house_insert";
	}
	
	// 숙소 등록
	@RequestMapping("house_insert_ok")
	public String house_insert_ok(@ModelAttribute HouseBean house)
			throws Exception {
		houseService.insert(house); // 저장 메서드 호출	

		return "redirect:/house/host_house_list";
	}
	
	
}
