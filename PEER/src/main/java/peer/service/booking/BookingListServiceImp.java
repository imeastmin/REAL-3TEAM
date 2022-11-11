package peer.service.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import peer.dao.booking.HouseViewDao;
import peer.dao.booking.BookingListDao;
import peer.model.booking.BookingListBean;
import peer.model.booking.HouseViewBean;

@Service
public class BookingListServiceImp implements BookingListService {

	@Autowired
	private BookingListDao bldao;
	
	@Override
	public List<BookingListBean> list(int book_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int bookingInsert(BookingListBean bookinglistbean) {
		return 0;	// bookinglistbean = otd
		// TODO Auto-generated method stub
		
	}
}
