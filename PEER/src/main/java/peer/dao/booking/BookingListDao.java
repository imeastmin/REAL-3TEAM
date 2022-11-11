package peer.dao.booking;

import java.util.Date;
import java.util.List;

import peer.model.booking.BookingListBean;
import peer.model.booking.HouseViewBean;

//예약 리스트에는
//BOOK_NUM;
//HOUSE_NUM;
//HOUSE_NAME;
//USER_NAME;
//USER_PHONE;
//USER_EMAIL;
//CHECKIN;
//CHECKOUT;
//HOUSE_PRICE; -> 총 가격으로 다시 계산
public interface BookingListDao {

	// 형식 함수명(형식 변수명)
	// 예약 리스트 불러오기
	List<BookingListBean> getBookNum(int book_num) throws Exception;
	
	// 결제시, 예약 정보를 예약종합테이블에 삽입
	int bookingInsert(BookingListBean bookinglistbean) throws Exception;
	
	
}
