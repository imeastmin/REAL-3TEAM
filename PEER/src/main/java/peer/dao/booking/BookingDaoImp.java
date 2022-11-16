package peer.dao.booking;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import peer.model.booking.BookingBean;

@Repository
public class BookingDaoImp implements BookingDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public int bookingInsert(BookingBean bookingbean) {
		// TODO Auto-generated method stub
		return session.insert("peer.dao.booking.HouseViewDao.bookingInsert", bookingbean);
	}
	
	
	
}
