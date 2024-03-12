package com.mysql.basic.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.basic.entity.Member;
import com.mysql.basic.repository.MemberDAO;

@Controller
public class MemberController {
	
	@Autowired
	MemberDAO memberDAO;
	
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	
	@RequestMapping(value="/member/userMenu")
	public String userMenu() {
		return "/member/userMenu";
	}
	
	@GetMapping("/member/list")
	public String list(Model model ) {
		ArrayList<Member> memberList = memberDAO.getMemberList();
		
		model.addAttribute("memberList", memberList);
		return "/member/list";
	}

	@GetMapping("/member/joinForm")
	public String joinForm() {
		return "/member/joinForm";
	}
	
	@PostMapping("/member/joinPro")
	public String joinPro( Member member) {
		System.out.println("Member = " + member);
		memberDAO.memberJoin(member); // db ¿˙¿Â 
		return "redirect:/member/list";
	}
	
	@GetMapping("/member/loginForm")
	public String loginForm() {
		return "/member/loginForm";
	}
	
	@PostMapping("/member/loginPro")
	public String loginPro( Member member, Model model , HttpSession session) {
		
		int check = memberDAO.checkMember(member);
		if(check == 1) {
			session.setAttribute("log", member.getId());
		}
		session.setAttribute("test" , "test");
		model.addAttribute("check" , check);
//		model.addAttribute("id", member.getId());
	
		return "/member/loginPro";
	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/member/index";  // /WEB-INF/ /.jsp
	}
	
	@GetMapping("/member/modifyForm")
	public String modifyForm(Model model , HttpSession session) {
//		if(session.getAttribute("log") == null) {
//			return "/";
//		}
		if(session.getAttribute("log") != null) {
			
			Member member = memberDAO.getOneMember((String)session.getAttribute("log"));
			model.addAttribute("member" , member);
	    }
		
		
		return "/member/modifyForm";
	}
	
	@PostMapping("/member/modifyPro")
	public String modifyPro(Member member , HttpSession session ) {
		
		if(session.getAttribute("log") == null) {
			return "/member/index";
		}
		
		System.out.println("modify Member = " + member);
		member.setId((String)session.getAttribute("log"));
		memberDAO.updateMember(member);
	
		return "redirect:/member/list";
	}
	
	@GetMapping("/member/deletePro")
	public String deletePro(HttpSession session){
		memberDAO.deleteMember((String)session.getAttribute("log"));
		session.invalidate();
		return "/member/index";
	}
}
