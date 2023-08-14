package kr.co.funnyjoy.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.funnyjoy.member.domain.Member;
import kr.co.funnyjoy.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="/member/register.do", method=RequestMethod.GET)
	public String showRegisterForm() {
		return "member/register";
		
	}

	@RequestMapping(value="/member/register.do", method=RequestMethod.POST)
	public String registerMember(@RequestParam("member-id") String memberId
			, @RequestParam("member-pw") String memberPw
			, @RequestParam("member-name") String memberName
			, @RequestParam("member-addr") String memberAddress
			, @RequestParam("member-fphone") String memberFirstPhone
			, @RequestParam("member-sphone") String memberSecondPhone
			, @RequestParam("member-lphone") String memberLastPhone
			, @RequestParam("member-email") String memberEmail
			, Model model) { 
		try {
			Member member = new Member(memberId, memberPw, memberName, memberAddress, memberFirstPhone, memberSecondPhone, memberLastPhone, memberEmail);
			int result = service.insertMember(member);
			if(result > 0) {
				return "member/registerFinish";
			}
			else {
				model.addAttribute("msg", "회원가입이 완료되지 않았습니다.");
				model.addAttribute("url", "/index.jsp");
				return "common/errorPage";
			}
		} catch (Exception e) {
			e.printStackTrace();  //콘솔창에 빨간색으로 뜨게함
			model.addAttribute("msg", e.getMessage());  // 콘솔창에 뜨는 메시지를 웹페이지로 뜨게 함
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public void showLoginForm(HttpServletRequest request, @RequestParam("member-id") String memberId, @RequestParam("member-pw") String memberPw, Model model) {
		Member member = new Member(memberId, memberPw);
		
		Member mOne = service.selectCheckLogin(member);
		if(mOne != null) {
			HttpSession session = request.getSession();
		}
	}
}
