package peer.service.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import peer.dao.booking.BookingDao;
import peer.model.booking.BookingBean;

@Service
public class BookingServiceImp implements BookingService{

	@Autowired
	private BookingDao bdao;

	@Override
	public int bookingInsert(BookingBean bookingbean) {
		// TODO Auto-generated method stub
		return bdao.bookingInsert(bookingbean);
	}
}
