package peer.dao.booking;

import java.util.List;

import peer.model.booking.BookingListBean;
import peer.model.booking.HouseViewBean;


public interface HouseViewDao {
	
	// 숙소정보 불러오기

	Integer getHouseNum(HouseViewBean houseview) throws Exception;
	
	HouseViewBean housenumview(Integer house_num);
}
