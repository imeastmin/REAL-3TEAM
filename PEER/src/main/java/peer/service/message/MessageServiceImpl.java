package peer.service.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import peer.dao.message.MessageMapper;
import peer.model.message.MessageBean;

public class MessageServiceImpl implements MessageService{
	@Autowired
	private MessageMapper mm;

	// 쪽지 리스트
	@Override
	public List<MessageBean> msgList(int user_num, int startPage, int endPage) throws Exception {
		return mm.msgList(user_num, startPage, endPage);
	}
	
	// 쪽지  전체 개수
	@Override
	public int msgTotal(int user_num) throws Exception {
		return mm.msgTotal(user_num);
	}
	
	// 쪽지 보내기&답장하기 
	@Override
	public String msgSend(MessageBean msg) throws Exception {
		return mm.msgSend(msg);
	}
	
	// 회원번호에서 닉네임 추출하기
	@Override
	public String nicktoUser_num(int message_receiver_num) throws Exception {
		return mm.nicktoUser_num(message_receiver_num);
	}

	// 쪽지 상세보기
	@Override
	public MessageBean msgOpen(int message_num) throws Exception {
		return mm.msgOpen(message_num);
	}
	
	// 쪽지 삭제
	@Override
	public void msgDel(int message_num) throws Exception {
		mm.msgDel(message_num);
	}


	

}
