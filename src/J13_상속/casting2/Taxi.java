package J13_상속.casting2;

public class Taxi extends Transportation {
	
	@Override  // @시작하는 문법을 어노테이션이라고 한다.// 용도 : 상속받아서 재정의 한다는 표시용
	
	public void go() {
		System.out.println("택시를 타고 출발");
	}
	
	@Override
	public void stop() {
		System.out.println("택시를 타고 도착");
	}
	
	
	public void checkTaxiNumber() {
		
		System.out.println("택시 번호 확인");
	}

}
