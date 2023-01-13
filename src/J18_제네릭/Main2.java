package J18_제네릭;

public class Main2 { //class  = 틀 
	/*
	 * 
	 * ? 와일드카드 제약
	 * extends 대상 객체 하위
	 * super   대상 객체 상위
	 * 
	 */
	
	public CMRespDto<?> reponse(CMRespDto<?>cmRespDto){ //확장성을 생각 했을때 wildCard [와일드 카드]
		// ? -> Object(최상위 클래스)로 쓸수있음
		//<? extends Person> Person을 상속받은 객체만 리턴 가능
		//<? super Student> // Student를 기준으로 상위 객체 (나 , Person 객체만 리턴 가능)
		System.out.println("[응답데이터]");
		
		System.out.println(cmRespDto);
		
		return cmRespDto;
	}
	
	
	
	public static void main(String[] args) {
		
		Main2 main = new Main2();////
		
		CMRespDto<String> hello 
			= new CMRespDto<String>(200, "성공", "안녕하세요");
		
		
		CMRespDto<Integer> score
		    = new CMRespDto<Integer>(200, "성공", 85);
		
		System.out.println("hello");
		System.out.println(main.reponse(hello));
		System.out.println("score");
		System.out.println(main.reponse(score));
				
		/*
		 * 왜 안될까?? static method 안에는 멤버변수 사용 X
		 * reponse 메서드는 주소가 생성되야 사용할 수 있는 메서드이기때문
		 */
		
		
		//안녕하세요.
		
		
	}

}
