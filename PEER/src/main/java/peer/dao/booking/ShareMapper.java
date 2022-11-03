package peer.dao.booking;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import peer.model.booking.ShareBean;
import peer.model.member.MemberBean;

@Mapper
public interface ShareMapper {
	
	/* 예약정보 불러오기 */
	ShareBean getShareInfo(int id) throws Exception;
	
	/* 회원 성별 가져오기 */
	public String getGender(int id) throws Exception;

	/* 대기열 리스트 */
	List<MemberBean> getQueList(
			@Param("info") ShareBean info, 
			@Param("gender") String gender) throws Exception;

	/* 대기열 멤버 정보 */
	public MemberBean getQueMember() throws Exception;

	/* 쉐어신청 */
	public void sign() throws Exception;

	/* 쉐어확정 */
	public void Success() throws Exception;

	/* 쉐어취소 */
	public void Cancle() throws Exception;

	/* 예약취소 */
	public void bookingCancle() throws Exception;
}
