package peer.dao.booking;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import peer.model.booking.BookingListBean;
import peer.model.booking.HouseViewBean;
import peer.model.house.HouseBean;
import peer.model.house.HousepriceBean;
import peer.model.member.MemberBean;


@Repository
public class HouseViewDaoImp implements HouseViewDao{

	@Autowired
	private SqlSession session;



	@Override
	public Integer getHouseNum(HouseViewBean houseview) throws Exception{
		// TODO Auto-generated method stub
		return session.selectOne("peer.dao.booking.HouseViewDao.housenum_select", houseview);
	}

	@Override
	public HouseViewBean housenumview(Integer house_num) {
		// TODO Auto-generated method stub
		return session.selectOne("peer.dao.booking.HouseViewDao.housenumview", house_num);
	}

	@Override
	public HouseViewBean getHouseinfo(HouseViewBean houseviewbean) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne("peer.dao.booking.HouseViewDao.getHouseinfo", houseviewbean);
	}


	@Override
	public HousepriceBean getHpriceCont(int house_num) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
