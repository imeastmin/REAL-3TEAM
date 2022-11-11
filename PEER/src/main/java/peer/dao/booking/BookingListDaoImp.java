package peer.dao.booking;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import peer.model.booking.BookingListBean;

@Service
public class BookingListDaoImp implements BookingListDao{

	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<BookingListBean> getBookNum(int book_num) {
		// TODO Auto-generated method stub
		return session.selectList("housens.house.select");
	}

	@Override
	public int bookingInsert(BookingListBean bookinglistbean) throws Exception {
		// TODO Auto-generated method stub
		return session.insert("housens.bookingInsert", bookinglistbean);
	}

}
