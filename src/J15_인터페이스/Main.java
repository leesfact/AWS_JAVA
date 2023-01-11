package J15_인터페이스;

public class Main {
	
	public static void main(String[] args) {
		
		
		
		Equipment[] equipments = new Equipment[2];
		
		equipments[0] = new GeneralCalculator();
		equipments[1] = new SmartPhone();
		
		Calculator calculator = new Computer();

		
		System.out.println("모든 장비 전원 켜기");
		for(Equipment eq : equipments) {  // E>S, 상위// E와 S는 상관관계 없음 E e = s;  (오->왼 갈려면 업캐스팅)   
			eq.powerOn();                 // C c =(C) e; (오 -> 왼 갈려면 다운캐스팅)
		}
		System.out.println();
		
		
		System.out.println("모든 장비에서 10을 0으로 나누기");
		for(Equipment eq : equipments) {
			Calculator c = (Calculator) eq; //다운캐스팅?
			double result = c.division(0, 10);
			System.out.println("결과: " + result);
		}
		System.out.println();
		System.out.println("모든 장비 전원 끄기");
		for(Equipment eq : equipments) {
			eq.powerOff();
		}
		System.out.println();
	}

}
