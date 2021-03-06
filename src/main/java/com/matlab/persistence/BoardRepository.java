package com.matlab.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.matlab.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{

	public List<Board> findBoardByTitle(String title);
	
	public Collection<Board> findByWriter(String writer);
	
}