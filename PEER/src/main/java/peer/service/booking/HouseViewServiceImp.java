package peer.service.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import peer.dao.booking.HouseViewDao;
import peer.model.booking.HouseViewBean;

@Service
public class HouseViewServiceImp implements HouseViewService {

	@Autowired
	private HouseViewDao hvdao;
	

	@Override
	public Integer getHouseNum(HouseViewBean houseview)throws Exception {
		// TODO Auto-generated method stub
		return hvdao.getHouseNum(houseview);
	}

	@Override
	public HouseViewBean housenumview(Integer house_num) {
		// TODO Auto-generated method stub
		return hvdao.housenumview(house_num);
	}

	// 형식 / 함수 / 형식 / 변수
}
