package 프로그래머스;

public class BinaryNumber {
	public static String solution(String bin1, String bin2) {
        String  answer = "";
		int num1 = Integer.parseInt(bin1, 2);
		int num2 = Integer.parseInt(bin2, 2);
		
        int binary = num1 + num2;
        
        answer = Integer.toBinaryString(binary);
        return answer;
    }
	
	public static void main(String[] args) {
		solution("10","11");
	}

}
