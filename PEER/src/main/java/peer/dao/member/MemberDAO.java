package peer.dao.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import peer.model.member.MemberBean;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession ss;

	public int insert(MemberBean member) {
		int a = ss.insert("insert", member);
		return a;
	}
	
	public MemberBean searchinfo(String email) {
		MemberBean member = ss.selectOne("searchinfo",email);
		return member;
	}

	public MemberBean nicknamecheck(String user_nickname) {
		MemberBean member = ss.selectOne("nicknamecheck",user_nickname);
		return member;
	}
	
	
}
