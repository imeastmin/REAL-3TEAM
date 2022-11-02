package peer.model.booking;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingBean {

    private int BOOK_NUM;
    private String HOUSE_NAME;
    private int USER_NAME;
    private int USER_PHONE;
    private int USER_EMAIL;
    private Date CHECKIN;
    private Date CHECKOUT;
    private int HOUSE_PRICE;
}
