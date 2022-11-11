package peer.model.booking;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingListBean {

	private int book_num;
    private int house_num;
    private String house_name;
    private int user_name;
    private int user_phone;
    private int user_email;
    private Date checkin;
    private Date checkout;
    private int house_price;
}
