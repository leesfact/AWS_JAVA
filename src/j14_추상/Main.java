package j14_추상;

public class Main {
	
	public static void main(String[] args) {
		Transportation tp = new Subway();
		
		Transportation tp2 = new Taxi();
		
		
		Subway subway = new Subway();
		
		subway.checkRoute();
		
		tp.go();
		tp.stop();
		tp2.go();
		tp2.stop();	
	}
}
