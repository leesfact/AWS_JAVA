package J15_인터페이스;

public interface Calculator {   
	
	
	/* 변수 못 가짐, 오로지 상수만 
	 * 메소드 앞에 default를 넣어줘서 일반 메소드 형식을 만들 수 있음
	 * 
	 * 
	 * 
	 */
	
	public int ERROR = -9999999;
	
	
	public double plus(double x, double y);
	public double minus(double x, double y);

	public default double multiplication(double x, double y) {
		
		return x * y;
	} 
	
	public double division(double x, double y);
		
}
