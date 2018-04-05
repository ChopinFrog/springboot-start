package com.matlab;

import java.util.Collection;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.matlab.domain.Board;
import com.matlab.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTests {

	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void inspect() {
		// 실제 객체의 클래스 이름
		Class<?> clz = boardRepo.getClass();
		System.out.println(clz.getName());
		
		// 클래스가 구현하고 있는 인터페이스 목록
		Class<?>[] interfaces = clz.getInterfaces();
		Stream.of(interfaces).forEach(inter -> System.out.println(inter.getName()));

		// 클래스의 부모 클래스
		Class<?> superClasses = clz.getSuperclass();
		System.out.println(superClasses.getName());
	}

	@Test
	public void testInsert() {
		
		Board board = new Board();
		board.setTitle("title");
		board.setContent("content");
		board.setWriter("user00");
		
		boardRepo.save(board);
	}

	@Test
	public void testRead() {
		
		Board board = boardRepo.findOne(1L);
		
		System.out.println(board);
	}
	
	
	@Test
	public void testUpdate() {
		
		System.out.println("Read First...........................");
		Board board = boardRepo.findOne(1L);
		
		System.out.println("Update First.........................");
		board.setTitle("modified");
		
		System.out.println("Call Save()..........................");
		boardRepo.save(board);
	}

	
	@Test
	public void testDelete() {
		
		System.out.println("DELETE Entity ");
		
		boardRepo.delete(1L);;
	}
	
	@Test
	public void testInsert200() {
		
		for (int i = 1; i <=200 ; i++) {
			Board board = new Board();
			board.setTitle("title : " + i);
			board.setContent("content : " + i);
			board.setWriter("user0" + (i % 10));
			boardRepo.save(board);
			
		}
	}
	
	
	@Test
	public void testByTitle() {
		
		boardRepo.findBoardByTitle("title : 1")
			.forEach(board -> System.out.println(board));
	}
	
	
	@Test
	public void testBywriter() {
		Collection<Board> results = boardRepo.findByWriter("user00");
		
		results.forEach(
				board -> System.out.println(board)
		);
	}
	
	
	
	
	
	
	
	
	
}
