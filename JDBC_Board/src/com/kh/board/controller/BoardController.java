package com.kh.board.controller;

import java.util.List;

import com.kh.board.model.service.BoardServiceImpl;
import com.kh.board.model.vo.Board;

/* 
 * View요청에 맞는 Service를 선택하여 메서드를 실행 한 후 결과값을 돌려주는 클래스.
 * */
public class BoardController {
	// service 변수 선언 및 초기화
	private BoardServiceImpl bs = new BoardServiceImpl();
	
	// view의 login요청을 담당할 메서드
	public int login(String id, String pwd) {
		return bs.login(id, pwd);
	}

	// view의 selectBoardList요청을 담당할 메서드
	public List<Board> selectBoardList() {
		return bs.selectBoardList();
	}

	// view의 selectBoard요청을 담당할 메서드
	public Board selectBoard(int bNum) {
		return bs.selectBoard(bNum);
	}

	// view의 insertBoard요청을 담당할 메서드
	public int insertBoard(String title, String content) {
		Board b = new Board();
		b.setTitle(title);
		b.setContent(content);
		
		return bs.insertBoard(b);
	}

	// view의 updateBoard요청을 담당할 메서드
	public int updateBoard(int bno, String contentEdit) {
		Board b = new Board();
		b.setBno(bno);
		b.setContent(contentEdit);
		
		return bs.updateBoard(bno, b);
	}

	// view의 deleteBoard요청을 담당할 메서드
	public int deleteBoard(int bnoDelete) {
		return bs.deleteBoard(bnoDelete);
	}
	
	
	
	
	
	
	
	
			
}
