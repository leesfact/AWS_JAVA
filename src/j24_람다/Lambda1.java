package j24_람다;

public class Lambda1 {
	
	
	public static void main(String[] args) {
		
		
		Instrumnet it = new Instrumnet() {
			
		
			@Override
			public String play(String instrument) {  // 구현부, 일회성은 익명클래스 ^^
		
				return instrument + "을(를) 연주합니다.";
			}
		};
		
		
		Instrumnet it2 = (String itm) -> {
			
			return itm + "을(를) 연주합니다 ";
		};
		
		// 매개변수의 자료형을 생략할 수 있다.
		// 매개변수의 이름을 바꿀 수 있다.
		Instrumnet it3 = (itm) -> {
			
			return itm + "을(를) 연주합니다 ";
		};
		
		// 매개변수가 하나이면 매개변수를 감싸는 괄호를 생략할 수 있다.
		Instrumnet it4 = itm -> {
			
			return itm + "을(를) 연주합니다 ";
		};	
		
		
		// 중괄호를 생략할 수 있는 조건 : 구현부의 실행문(명령문)이 하나일 경우
		// 이때 return 자료형이 정해져있으면, return값으로 사용이 된다.
		// Ex) if문도 실행문이 하나일때 중괄호 생략가능 
		Instrumnet it5 = itm -> itm + "을(를) 연주합니다 ";
		
		
		int result = 10 + 20;
		Instrumnet it6 = itm -> itm + "을(를) 연주합니다 " ;
			
	
		/*
		 * 람다를 쓰는 이유 : 
		 * 1. 간결성
		 * 2. 자유도가 생김
		 * 3. 한번만 사용 (익명 클래스와 동일)
		 */

		
		System.out.println(it2.play("피아노"));  //play method 호출
		String playText = it2.play("드럼"); //  
		System.out.println(playText);
		String playText2 = it6.play("트럼펫");
		System.out.println(playText2);
		
		
		
	}
}
