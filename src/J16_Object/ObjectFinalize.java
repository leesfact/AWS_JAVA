package J16_Object;


class Test {
	
	private int num;

	public Test(int num) {
		super();
		this.num = num;
		System.out.println(num + "생성");
	}
	
	@Override
	
	/*
	 * 소멸되면 안되는 중요한 정보를 finalize() 메소드에 넣는다.
	 * 
	 * 
	 * 
	 */
		protected void finalize() throws Throwable { // 가비지 컬렉터가 실행(소멸) 됐을때, 동작
			System.out.println(num + "객체 소멸");
		}
	
}

public class ObjectFinalize {
	
	public static void main(String[] args) {
		
		
		Test test = null;
		
		for(int i = 0; i<30; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			test = new Test(i);
			
			test = null;
			
			System.gc();  // 가비지컬렉터 강제로 호출도 할 수 있음
		}
		
		
	}

}
