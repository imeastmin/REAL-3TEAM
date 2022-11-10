package peer.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import peer.dao.member.MemberDAO;
import peer.model.member.MemberBean;

@Service
public class MemberService {

	@Autowired
	private MemberDAO mR;
	
//	@Autowired
//	private MemberDaoImp mR;

	public int createMember(MemberBean member) {
		return mR.insert(member);
	}
	
	public MemberBean searchinfo(String email) {
		return mR.searchinfo(email);
	}

	public MemberBean nicknamecheck(String user_nickname) {
		return mR.nicknamecheck(user_nickname);
	}

}
