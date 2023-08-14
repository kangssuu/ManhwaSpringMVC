package kr.co.funnyjoy.member.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.funnyjoy.member.domain.Member;
import kr.co.funnyjoy.member.service.MemberService;
import kr.co.funnyjoy.member.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberStore mStore;
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int insertMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Member selectCheckLogin(Member member) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}
}
