package peer.dao.message;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import peer.model.message.MessageBean;

@Mapper
public interface MessageMapper {
	// 쪽지 리스트
	public List<MessageBean> msgList(int user_num, int startPage, int endPage) throws Exception;
	
	// 쪽지 전체 개수
	public int msgTotal() throws Exception;
	
	// 쪽지 보내기&답장하기
	public String msgSend() throws Exception;
	
	// 닉네임에서 회원번호 추출하기
	public int transUser_num(String user_nickname) throws Exception;
	
	// 쪽지 상세보기
	public MessageBean msgOpen(int message_num) throws Exception;
	
	// 쪽지 삭제
	public void msgDel(int message_num) throws Exception;
}
