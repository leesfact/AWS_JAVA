package J19_컬렉션;

import lombok.AllArgsConstructor;
import lombok.Data;
//ctrl + shift + O 자동 생성 & 제거

/*
 * 만들어 놓은 라이브러리 느낌?
 */

//@NoArgsConstructor  // 기본 생성자
//@RequiredArgsConstructor
@AllArgsConstructor // 전체 생성자
@Data
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
public class Student {
	
	private String name; // 이름
	private int year; // 학년
	//private final String address; //필수 생성자
	
}

