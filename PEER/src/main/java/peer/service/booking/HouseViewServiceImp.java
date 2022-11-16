package peer.service.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import peer.dao.booking.HouseViewDao;
import peer.dao.house.HouseDao;
import peer.dao.member.MemberDAO;
import peer.model.booking.HouseViewBean;
import peer.model.house.HouseBean;
import peer.model.house.HousepriceBean;
import peer.model.member.MemberBean;

@Service
public class HouseViewServiceImp implements HouseViewService {

	@Autowired
	private HouseViewDao hvdao;	
	
	@Autowired
	private HouseDao houseDao;

	@Autowired
	private MemberDAO mR;
	
	@Override
	public Integer getHouseNum(HouseViewBean houseview)throws Exception {
		// TODO Auto-generated method stub
		return hvdao.getHouseNum(houseview);
	}

	@Override
	public HouseViewBean housenumview(Integer house_num) throws Exception {
		// TODO Auto-generated method stub
		return hvdao.housenumview(house_num);
	}

	@Override
	public HouseViewBean getHouseinfo(HouseViewBean houseviewbean) throws Exception {
		// TODO Auto-generated method stub
		return hvdao.getHouseinfo(houseviewbean);
	}
	
	public HousepriceBean hprice_cont(int house_num) throws Exception {
		HousepriceBean hprice = houseDao.getHpriceCont(house_num);
		return hprice;
	}

	
	// 형식 / 함수 / 형식 / 변수
}
