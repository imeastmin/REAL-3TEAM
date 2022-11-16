package peer.service.booking;

import java.util.List;

import peer.model.booking.BookingBean;
import peer.model.booking.ShareBean;

public interface MyBookingService {
	
	/* 예약내역 불러오기 */
	List<ShareBean> getMyShareBooking(int id) throws Exception;
	List<BookingBean> getMyBooking(int id) throws Exception;
}
