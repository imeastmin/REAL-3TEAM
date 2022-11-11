package peer.model.house;


import org.apache.ibatis.type.Alias;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("house")
public class HouseBean {

	private int house_num;
	private int user_num;
	private String house_name;
	private String house_address;
	private Double house_x;
	private Double house_y;
	private String house_photo;
	private int house_capacity;
	private String house_form;
	private String house_detail;
	private int house_share;
	private int house_authority;


	
}
