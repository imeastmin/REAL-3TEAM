package peer.service.booking;

import java.util.List;

import peer.model.booking.BookingListBean;
import peer.model.booking.HouseViewBean;

public interface BookingListService {

	// 예약 리스트 불러오기
	public List<BookingListBean> list(int book_num) throws Exception;
		
	// 결제시, 예약 정보 삽입 
	int bookingInsert(BookingListBean bookinglistbean) throws Exception;	
}
