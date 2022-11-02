package peer.service.house;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import peer.dao.house.HouseDAOImpl;
import peer.model.house.HouseBean;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseDAOImpl HouseDao;

	public void insert(HouseBean h) throws Exception {
		HouseDao.inserthouse(h);
	}
}
