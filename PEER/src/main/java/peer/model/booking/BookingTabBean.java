package peer.model.booking;

import lombok.Getter;
import lombok.Setter;

// 웹에서 입력한 예약내역을 데이터베이스에 넣을 DTO

@Getter
@Setter
public class BookingTabBean {

	private int book_num;
	private int house_price;

}
