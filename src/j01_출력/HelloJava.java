package j01_출력;

/**
 * 
 * @author ITPS
 *
 */
public class HelloJava {
	// 주석: 코드 내부에 메모를 할 때 사용함.
	// 컴파일 시에 무시됨.
	// 한 줄 주석
	// tab 들여쓰기
	/*
	  여러줄 주석
	  1
	  2
	  3
	 */
	/**
	 * 클래스, 메소드 등의 정보를 설명하기 위한 주석
	 */

	// 프로그램의 시작점
	public static void main(String[] args) {
		int[] A = new int[]{0, 3, 0, 2, 3, 0};
		int[] B = new int[]{1, 2, 1};
		int i, j;
		for(i = 1; i < 5; i++) {
		    int c = 0;
		    for(j = 0; j < 3; j++) {
		        c += A[i + j - 1] * B[j];
		    }
		    System.out.print(c);
		}
		System.out.println();

	}
	
}







