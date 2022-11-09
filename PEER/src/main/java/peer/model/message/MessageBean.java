package peer.model.message;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageBean {
	private int message_num;
	private String message_sender;
	private String message_receiver;
	private Date message_date;
	private String message_content;
}
