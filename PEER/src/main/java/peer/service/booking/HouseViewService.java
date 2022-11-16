package peer.service.booking;

import java.util.List;

import peer.model.booking.HouseViewBean;
import peer.model.house.HouseBean;
import peer.model.house.HousepriceBean;
import peer.model.member.MemberBean;

public interface HouseViewService {

	// 숙소 정보 불러오기

	public Integer getHouseNum(HouseViewBean houseview) throws Exception;
	
	public HouseViewBean housenumview(Integer house_num) throws Exception;
	
	public HouseViewBean getHouseinfo(HouseViewBean houseviewbean) throws Exception;
	
	// 숙소 상세
	public HousepriceBean hprice_cont(int house_num) throws Exception;
	
}
