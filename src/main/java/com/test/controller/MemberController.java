package com.test.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.domain.MemberVO;
import com.test.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger Logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	//회원가입 get
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public void getSignup() throws Exception {
		Logger.info("get signup");
	}
	
	//회원가입 post
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String postSignup(MemberVO vo) throws Exception{
		Logger.info("post signup");
		String inputPass = vo.getUserPass();
		String pass = passEncoder.encode(inputPass);
		vo.setUserPass(pass);
		
		service.signup(vo);
		
		
		return "redirect:/";
	}
	
	//로그인get
	@RequestMapping(value="/signin",method=RequestMethod.GET)
	public void getSignin() throws Exception{
		Logger.info("get signin");
	}
	
	//로그인post
	@RequestMapping(value="/signin",method=RequestMethod.POST)
	public String postSignin(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		Logger.info("post signin");
		
		MemberVO login = service.signin(vo);
		
		if (login == null) {
			rttr.addFlashAttribute("msg", "등록된 회원이 아닙니다.");
			return "redirect:/member/signin";
		}
		
		HttpSession session = req.getSession();
		
		boolean passMatch = passEncoder.matches(vo.getUserPass(), login.getUserPass());
		
		if(login != null && passMatch) {
			session.setAttribute("member", login);
		}else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg",false);
			return "redirect:/member/signin";
		}
		
		return "redirect:/";
	}
	
	//로그아웃
	@RequestMapping(value="/signout", method=RequestMethod.GET)
	public String signout(HttpSession session) throws Exception {
		Logger.info("get logout");
		
		service.signout(session);
		
		return "redirect:/";
	}
}
