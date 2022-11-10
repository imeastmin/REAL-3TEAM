package peer.service.message;

import java.util.List;

import peer.model.message.MessageBean;

public interface MessageService {
	// 쪽지 리스트
	public List<MessageBean> msgList(int user_num, int startPage, int endPage) throws Exception;
	
	// 쪽지 전체 개수
	public int msgTotal(int user_num) throws Exception;
	
	// 쪽지 보내기&답장하기
	public String msgSend(MessageBean msg) throws Exception;
	
	// 회원번호에서 닉네임 추출하기
	public String nicktoUser_num(int message_receiver_num) throws Exception;
	
	// 쪽지 상세보기
	public MessageBean msgOpen(int message_num) throws Exception;
	
	// 쪽지 삭제
	public void msgDel(int message_num) throws Exception;

}
