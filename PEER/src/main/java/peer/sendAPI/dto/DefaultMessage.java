package peer.sendAPI.dto;

import lombok.Data;

@Data
public class DefaultMessage {
	private String objType;
	private String text;
	private String webUrl;
	private String mobileUrl;
	private String btnTitle;
}
