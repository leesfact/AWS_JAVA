package J13_상속;

public class ExtendsMain {
	public static void main(String[] args) {
		
		KiaCar kiaCar = new KiaCar(); //kiaCar라는 객체 생성
		System.out.println(kiaCar);
		
		kiaCar.setPrice(30000000);
		
		
		System.out.println(kiaCar.getPrice());
		System.out.println(kiaCar.discountPrice(20));  //@Override 정의 안하면 Car에서 들고옴, 
		
		
		
	}

}
