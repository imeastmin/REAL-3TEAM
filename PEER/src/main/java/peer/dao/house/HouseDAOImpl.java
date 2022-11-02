package peer.dao.house;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import peer.model.house.HouseBean;

@Repository
public class HouseDAOImpl implements HouseDao {
	
	@Autowired
	private SqlSession session;

	// 숙소 등록
	public void inserthouse(HouseBean h) throws Exception{
		session.insert("housens.house_insert", h);
	}

}
