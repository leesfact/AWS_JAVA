package j21_예외;

import java.util.Arrays;
import java.util.List;

public class ThrowsException {

	
	//메소드 하나 생성
	
	public static void printList(List<String> list, int size) throws Exception {//반환값이 있는//checked exception 
		                                                      //예외를 미루다?! throws 는 cheched exception만 
		for(int i = 0; i < size; i++) {
			
			System.out.println("[" + i + "]: " + list.get(i));
		}
		System.out.println();
	}
	
	public static void main(String[] args) { //반환타입 없음, static 영역 메모리 
		
		String[] names = {"가나다","라마바","사아자","카타파"};
		
		try {
			throw new ClassCastException();
//			printList(Arrays.asList(names), 5);
		} catch (IndexOutOfBoundsException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			System.out.println("무조건 실행");
		}
		
		System.out.println("프로그램 정상 종료");
		
	}
}
