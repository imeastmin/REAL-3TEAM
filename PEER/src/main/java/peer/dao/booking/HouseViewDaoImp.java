package peer.dao.booking;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import peer.model.booking.BookingListBean;
import peer.model.booking.HouseViewBean;


@Repository
public class HouseViewDaoImp implements HouseViewDao{

	@Autowired
	private SqlSession session;



	@Override
	public Integer getHouseNum(HouseViewBean houseview) throws Exception{
		// TODO Auto-generated method stub
		return session.selectOne("bookns.housenum_select", houseview);
	}

	@Override
	public HouseViewBean housenumview(Integer house_num) {
		// TODO Auto-generated method stub
		return session.selectOne("bookns.housenumview", house_num);
	}


}
