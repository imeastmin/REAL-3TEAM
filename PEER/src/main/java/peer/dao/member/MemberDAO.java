package peer.dao.member;

import java.lang.reflect.Member;
import java.util.ArrayList;

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

	public MemberBean searchinfo(String user_email) {
		MemberBean member;
		member = ss.selectOne("searchinfo", user_email);
		return member;
	}

	public MemberBean nicknamecheck(String user_nickname) {
		MemberBean member = ss.selectOne("nicknamecheck", user_nickname);
		return member;
	}

	public int updateuser(MemberBean member) {
		int result = ss.update("updateuser", member);
		return result;
	}

	public int deleteuser(MemberBean member) {
		int result = ss.update("deleteuser", member);
		return result;
	}

	public ArrayList<MemberBean> searchid(String user_phone) {
		ArrayList<MemberBean> list = (ArrayList) ss.selectList("searchid", user_phone);
		return list;
	}

}
