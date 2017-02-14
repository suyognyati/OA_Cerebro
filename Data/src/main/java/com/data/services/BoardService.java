package com.data.services;

import java.util.List;

import com.data.entities.Board;
import com.data.entities.State;

public interface BoardService {
	List<Board> getBoardList(State state);
}
