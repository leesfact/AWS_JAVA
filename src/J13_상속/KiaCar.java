package J13_상속;

public class KiaCar extends Car {
	

	public KiaCar() { //기본생성자 만드는 단축키  ctrl + spcae + enter
		super();  // 최상위에 존재해야함 //부모의 주소
		System.out.println("자식");		
	}
	
		@Override
		public int discountPrice(int percentage) {
			return super.discountPrice(percentage); //부모의 주소에서 결과를 리턴하라
		}		
		
		
	
}
