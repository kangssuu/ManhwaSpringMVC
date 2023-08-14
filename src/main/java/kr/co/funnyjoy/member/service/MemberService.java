package kr.co.funnyjoy.member.service;

import kr.co.funnyjoy.member.domain.Member;

public interface MemberService {
	
	public int insertMember(Member member);
	
	public Member selectCheckLogin(Member member);
	
	public int updateMember(Member member);
}
