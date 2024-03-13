package com.mysql.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mysql.board.entity.Board;

@Mapper
public interface BoardMapper {
	public List<Board> getBoardList();
	public Board boardContent(int idx);
	public void addBoard(Board board);
	public void updateBoard(Board board);
	public void deleteBoard(int idx);
	public void removeMemberBoard(String writer);
}
