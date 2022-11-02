package peer.service.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import peer.dao.booking.BookingDao;

@Service
public class BookingService {

	@Autowired
	private BookingDao bookingdao;
}
