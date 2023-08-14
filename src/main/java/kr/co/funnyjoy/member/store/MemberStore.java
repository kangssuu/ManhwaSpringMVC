package kr.co.funnyjoy.member.store;

import org.apache.ibatis.session.SqlSession;

import kr.co.funnyjoy.member.domain.Member;

public interface MemberStore {
	
	public int insertMember(SqlSession session, Member member);
	
	public Member selectCheckLogin(SqlSession session, Member member);
	
	public int updateMember(SqlSession session, Member member);
}
