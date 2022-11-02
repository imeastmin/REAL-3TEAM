package peer.service.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import peer.dao.booking.ShareMapper;
import peer.model.booking.ShareBean;
import peer.model.member.MemberBean;

@Service
public class ShareServiceImp implements ShareService {
	
	@Autowired
	private ShareMapper shareMapper;
	
	/* 예약정보 불러오기 */
	public ShareBean getShareInfo(int user_num) throws Exception{
		return shareMapper.getShareInfo(user_num);
	}
	
	/* 성별 불러오기 */
	public String getGender(int user_num) throws Exception {
		return shareMapper.getGender(user_num);
	}

	/*쉐어 대기중인 대기열 리스트 구현*/
	public List<MemberBean> getQueList(ShareBean info, String gender) throws Exception {
		
		System.out.println("Service - getQueList");
		System.out.println("Service ShareBean DATA - " + info);
		System.out.println("Service Gender DATA - " + gender);
		
		/* Date 자료형 확인*/
		System.out.println("Service ShareBean DATA - " + info.getCheckin().getClass());
		
		return shareMapper.getQueList(info, gender);
	}

	
	
	
	public void sign() throws Exception {
	}

	public void result() throws Exception {
	}

	public void bookingCancle() throws Exception {
	}
}
