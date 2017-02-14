package com.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Board;
import com.data.entities.State;
import com.data.repository.BoardJpaRepository;
import com.data.services.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardJpaRepository boardJpaRepository;
	
	@Override
	public List<Board> getBoardList(State state) {
		List<Board> boardList = boardJpaRepository.findBoardByState(state);
		return boardList;
	}

}
