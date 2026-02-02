package java_quiz;

import java.util.*;

/*
 * Board 객체의 getBoardList() 를 호출하면 List<Board> 타입의 컬렉션을 리턴,
 * ListExam 의 실행 결과를 보고 BoardDao 클래스와 getBoardList() 메서드 작성
 */

class Board{
	private String title;
	private String content;
	
	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}
	
}

class BoardDao{
	public List<Board> getBoardList(){
		List<Board> li = new ArrayList<Board>();
		li.add(new Board("제목1","내용1"));
		li.add(new Board("제목2","내용2"));
		li.add(new Board("제목3","내용3"));
		return li;
	}
}
	
class ListExam{
	public void doSome() {
		BoardDao dao = new BoardDao();
		List<Board> list = dao.getBoardList();
		for(Board b : list) {
			System.out.println(b.getTitle() + " = " + b.getContent());
		}
	}
}
public class quiz_5_0202 {
	public static void main(String[] args) {
		//실행결과 아래와 같음 
		//제목1 = 내용1
		//제목2 = 내용2
		//제목3 = 내용3
		ListExam le = new ListExam();
		le.doSome();
	}
}
