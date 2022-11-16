package peer.dao.booking;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import peer.model.booking.BookingBean;
import peer.model.booking.ShareBean;

@Mapper
public interface MyBookingMapper {

	List<ShareBean> getMyShareBooking(int id) throws Exception;
	List<BookingBean> getMyBooking(int id) throws Exception;
}
