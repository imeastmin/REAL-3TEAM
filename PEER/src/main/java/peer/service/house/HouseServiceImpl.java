package peer.service.house;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import peer.dao.house.HouseDao;
import peer.model.house.HouseBean;
import peer.model.house.HousepriceBean;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseDao houseDao;

	// 숙소 등록
	public int insert(HouseBean h, HousepriceBean hp) throws Exception {
		int result = 0;
		result = houseDao.saveHouse(h);
		result = houseDao.savePrice(hp);
		
		return result;
	}

	
	// 등록된 숙소 갯수
	@Override
	public int getListCount() throws Exception {
		// TODO Auto-generated method stub
		return houseDao.getListCount();
	}

	// 호스트 등록된 숙소 목록
	@Override
	public List getHosthouseList(int page) throws Exception {
		// TODO Auto-generated method stub
		return houseDao.getHosthouseList(page);
	}
	
	// 숙소 상세
	public HouseBean house_cont(int house_num) throws Exception {
		
		HouseBean house = houseDao.getHouseCont(house_num);
		
		return house;
	}
//	public HousepriceBean house_cont2(int house_num) throws Exception {
//
//		HousepriceBean hprice = houseDao.gethousecont2(house_num);
//
//		return hprice;
//	}
//	

}

