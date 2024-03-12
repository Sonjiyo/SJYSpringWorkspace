package com.mysql.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.board.entity.Board;
import com.mysql.board.mapper.BoardMapper;

@Controller
public class BoardController {
	
	@Autowired
	private BoardMapper mapper;
	
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/boardList.do")
	public String index() {
		return "index";
	}
	
	@GetMapping("/boardList.do")
	public String boardList(Model model) {
		List<Board> list = mapper.getBoardList();
		model.addAttribute("list", list);
		return "board/boardList";
	}
	
	@GetMapping("/boardForm.do")
	public String boardForm() {
		return "board/boardForm";
	}
	
	@PostMapping("/boardInsert.do")
	public String boardInsert(Board board) {
		mapper.addBoard(board);
		return "redirect:/boardList.do";
	}
	
	@GetMapping("/boardContent.do")
	public String boardContent(int idx, Model model) {
		Board board = mapper.boardContent(idx);
		board.setContent(board.getContent().replace("\n", "<br/>"));
		model.addAttribute("vo",board);
		return "board/boardContent";
	}
	
	@GetMapping("/boardUpdateForm.do/{idx}")
	public String boardUpdateForm(@PathVariable("idx") int idx,Model model) {
		Board board = mapper.boardContent(idx);
		model.addAttribute("vo",board);
		return "board/boardUpdate";
	}
	
	@PostMapping("/boardUpdate.do")
	public String boardUpdate(Board board) {
		mapper.updateBoard(board);
		return "redirect:/boardList.do";
	}
	
	@GetMapping("/boardDelete.do/{idx}")
	public String boardDelete(@PathVariable("idx") int idx) {
		mapper.deleteBoard(idx);
		return "redirect:/boardList.do";
	}
}
