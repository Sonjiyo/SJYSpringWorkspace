package kr.board.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.board.entity.Member;
import kr.board.mapper.MemberMapper;

@RequestMapping("/member")
@Controller
public class MemberController {

	@Autowired
	MemberMapper memberMapper;
	
	@ModelAttribute("cp")
	public String getContextPath(Model model , HttpServletRequest request) {		
		model.addAttribute("cp", request.getContextPath());	
		return request.getContextPath();
	}
	
	@GetMapping("/joinForm.do")
	public String joinForm() {
		return "member/join";  // join.jsp
	}
	
	@GetMapping("/loginForm.do")
	public String loginForm() {
		return "member/memLoginForm";  // memLoginForm.jsp
	}
	
	//model 객체는 request객체를 forward할 때만 값을 전달해준다
	//RedirectAttributes => redirect: 할 때 값을 들고 가고 새로고침하면 값이 사라짐
	@PostMapping("/memLogin.do")
	public String memLogin(Member member, RedirectAttributes rttr, HttpSession session) {
		if(member.getMemID()==null || member.getMemID().equals("") || 
				member.getMemPassword() == null || member.getMemPassword().equals("")) {
			
			//새로고침하면 사라지는 객체
			rttr.addFlashAttribute("msgType","로그인 실패");
			rttr.addFlashAttribute("msg","모든 값을 넣어주세요");
			return "redirect:/member/loginForm.do";
		}
		Member mvo = memberMapper.memLogin(member);
		if(mvo==null) { //로그인 실패
			rttr.addFlashAttribute("msgType","로그인 실패");
			rttr.addFlashAttribute("msg","로그인 정보가 없습니다");
			return "redirect:/member/loginForm.do";
		}
		//로그인 성공
		session.setAttribute("mvo", mvo);
		rttr.addFlashAttribute("msgType","성공 메세지");
		rttr.addFlashAttribute("msg","로그인 성공 했습니다");	
		
		return "redirect:/";
	}
	
	@GetMapping("/memLogout.do")
	public String memLogout(HttpSession session, RedirectAttributes rttr) {
		session.invalidate();
		rttr.addFlashAttribute("msgType","성공 메세지");
		rttr.addFlashAttribute("msg","로그아웃 되었습니다");
		return "redirect:/";
	}
	
	@RequestMapping("/memRegisterCheck.do")
	public @ResponseBody int memRegisterCheck(@RequestParam("memID") String memID) {
		Member m=memberMapper.registerCheck(memID);
		if(m!=null || memID.equals("")) {
			return 0;
		}
		return 1;
	}
	
	@PostMapping("/memRegister.do")
	public String memRegister(Member m, String memPassword1, String memPassword2,
			                  RedirectAttributes rttr, HttpSession session) {
		if(m.nullValueCheck()){
		   rttr.addFlashAttribute("msgType", "회원가입 실패");
		   rttr.addFlashAttribute("msg", "값을 입력해주세요");
		   return "redirect:/member/memJoin.do";  // ${msgType} , ${msg}
		}
		if(!memPassword1.equals(memPassword2)) {
		   rttr.addFlashAttribute("msgType", "비밀번호 오류");
		   rttr.addFlashAttribute("msg", "비밀번호가 같지 않습니다");
		   return "redirect:/member/memJoin.do";  // ${msgType} , ${msg}
		}
		m.setMemPassword(memPassword2);
		m.setMemProfile(""); 
		int result=memberMapper.register(m);
		if(result==1) { 
		   rttr.addFlashAttribute("msgType", "성공 메세지");
		   rttr.addFlashAttribute("msg", "회원가입에 성공했습니다.");
		 
		   session.setAttribute("mvo", m); // ${!empty mvo}
		   return "redirect:/";
		}
		
		rttr.addFlashAttribute("msgType", "실패");
		rttr.addFlashAttribute("msg", "회원가입에 실패했습니다");
		return "redirect:/member/memJoin.do";		
	}
}
