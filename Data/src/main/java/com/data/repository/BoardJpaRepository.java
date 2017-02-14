package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.Board;
import com.data.entities.State;

@Repository("boardJpaRepository")
public interface BoardJpaRepository extends JpaRepository<Board, Integer> {
	List<Board> findBoardByState(State state);
}
