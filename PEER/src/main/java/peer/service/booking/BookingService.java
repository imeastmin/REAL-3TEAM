package peer.service.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import peer.dao.booking.BookingDao;
import peer.model.booking.BookingBean;

@Service
public interface BookingService {

	public int bookingInsert(BookingBean bookingbean);
	
}
