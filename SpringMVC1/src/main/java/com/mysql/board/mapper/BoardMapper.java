package com.mysql.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mysql.board.entity.Board;

@Mapper
public interface BoardMapper {
	public List<Board> getBoardList();
}
