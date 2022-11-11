package peer.service.booking;

import java.util.List;

import peer.model.booking.HouseViewBean;

public interface HouseViewService {

	// 숙소 정보 불러오기

	Integer getHouseNum(HouseViewBean houseview) throws Exception;
	
	HouseViewBean housenumview(Integer house_num);
}
