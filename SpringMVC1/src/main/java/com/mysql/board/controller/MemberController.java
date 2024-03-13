package com.mysql.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mysql.board.entity.Member;
import com.mysql.board.mapper.MemberMapper;

@Controller
public class MemberController {
	
	@Autowired
	private MemberMapper mapper;
	
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	
	@GetMapping("/login.do")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/loginPro.do")
	public String loginPro(Member member, HttpSession session) {
		int check = mapper.loginCheck(member);
		if(check == 1) {
			session.setAttribute("log", member.getId());			
			return "redirect:/boardList.do";
		}else {
			return "member/login";
		}
	}
	
	@GetMapping("/memberList.do")
	public String memberList(Model model) {
		List<Member> list = mapper.getMemberList();
		model.addAttribute("list", list);
		return "member/memberList";
	}
	
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/boardList.do";
	}
	
	@GetMapping("/memberInfo.do/{num}")
	public String memberInfo(@PathVariable("num") int num, Model model) {
		model.addAttribute("vo", mapper.memberInfo(num));
		return "member/memberInfo";
	}
	
	@GetMapping("/pwCheck.do")
	public String pwCheck() {
		return "member/pwCheck";
	}
	
	@PostMapping("/pwCheckPro.do")
	public String pwCheckPro(Member member, Model model) {
		int check = mapper.loginCheck(member);
		if(check == 1) {
			model.addAttribute("vo", mapper.updateMemberInfo(member.getId()));
			return "member/updateMember";
		}else {
			return "member/pwCheck";
		}
	}
	
	@PostMapping("/updateMember.do")
	public String updateMember(Member member) {
		mapper.updateMember(member);
		return "redirect:/boardList.do";
	}
	
	@GetMapping("/removeMember.do")
	public String removeMember(HttpSession session) {
		String id = (String)session.getAttribute("log");
		mapper.removeMember(id);
		session.invalidate();
		return "redirect:/removeMemberBoard.do/"+id;
	}
	
	@GetMapping("/joinMember.do")
	public String joinMember() {
		return "member/joinMember";
	}
	
	@PostMapping("/joinMemberPro.do")
	public String joinMemberPro(Member member) {
		mapper.insertMember(member);
		return "redirect:/boardList.do";
	}
}
