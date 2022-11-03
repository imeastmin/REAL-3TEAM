package peer.service.booking;

import java.util.List;

import peer.model.booking.ShareBean;
import peer.model.member.MemberBean;

public interface ShareService {

	// 예약정보 불러오기
	public ShareBean getShareInfo(int id) throws Exception;
	
	// 성별 가져오기
	public String getGender(int user_num) throws Exception;
	
	// 대기열 리스트
	public List<MemberBean> getQueList(ShareBean info, String gender) throws Exception;
	
	// 쉐어신청
	public void sign() throws Exception;
	
	// 쉐어결과
	public void result() throws Exception;
	
	// 예약취소
	public void bookingCancle() throws Exception;
}
