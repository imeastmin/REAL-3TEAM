package peer.dao.member;

import org.apache.ibatis.annotations.Mapper;

import peer.model.member.MemberBean;

@Mapper
public interface MemberDaoImp {

	int insert(MemberBean member);

	MemberBean searchinfo(String email);

	MemberBean nicknamecheck(String user_nickname);

}
