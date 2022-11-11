package peer.dao.house;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import peer.model.house.HouseBean;
import peer.model.house.HousepriceBean;

@Mapper
public interface HouseDao {

	public int saveHouse(HouseBean h) throws Exception;
	
	public int savePrice(HousepriceBean hp) throws Exception;
	
	public HouseBean getHouseCont(int house_num) throws Exception;
//	public HousepriceBean gethousecont2(int house_num) throws Exception;
	
	public List<HouseBean> getHosthouseList(int page) throws Exception;
	
	public int getListCount() throws Exception;
}
