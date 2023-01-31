package j22_익명클래스;

public class Main {
	
	public static void main(String[] args) {
		
		Calculator c1  = new Addition();
		
		System.out.println(c1.cal(10, 20));
		
		
		System.out.println("===================================");
		
		Calculator c2 = new Calculator() {
			
			/*
			 *  Calculator() interface// 
			 *  메서드 오버라이드 (재정의)
			 */
			
			@Override
			public int cal(int x, int y) {  // 일회성은 익명클래스 ^^
				
				return x-y;
			}
		};
		
		System.out.println(c2.cal(20, 10));
		
		System.out.println("============ 람 다 ============="); 
		
		System.out.println("Cal c2 == Cal c3");
		
		Calculator c3 = (x,y) -> x*y;
		System.out.println(c3.cal(20, 3));
		
		
		
	}

}
