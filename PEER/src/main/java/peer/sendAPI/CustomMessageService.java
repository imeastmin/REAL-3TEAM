package peer.sendAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import peer.sendAPI.dto.DefaultMessage;

@Service
public class CustomMessageService {
		
		@Autowired
		MessageService messageService;
		
		public boolean sendMyMessage() {
			DefaultMessage myMsg = new DefaultMessage();
			myMsg.setBtnTitle("자세히보기");
			myMsg.setMobileUrl("");
			myMsg.setObjType("text");
			myMsg.setWebUrl("");
			myMsg.setText("메시지 테스트입니다.");

			String accessToken = AuthService.authToken;

			return messageService.sendMessage(accessToken, myMsg);
		}
}
