package peer.service.house;

import java.util.List;

import peer.model.house.HouseBean;
import peer.model.house.HousepriceBean;

public interface HouseService {

	// 숙소등록
	public int insert(HouseBean h, HousepriceBean hp) throws Exception;
	
	// 숙소 상세
	public HouseBean house_cont(int house_num) throws Exception;
//	public HousepriceBean house_cont2(int house_num) throws Exception;
	
	// 등록된 숙소 갯수
	public int getListCount() throws Exception;
	
	// 호스트 등록된 숙소 목록
	public List getHosthouseList(int page) throws Exception;
}
