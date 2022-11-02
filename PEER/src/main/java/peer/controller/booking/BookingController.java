package peer.controller.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import peer.service.booking.BookingService;

@Controller
public class BookingController {

	@Autowired
	private BookingService bookingservice;
}
