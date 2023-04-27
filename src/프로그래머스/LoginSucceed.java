package 프로그래머스;

public class LoginSucceed {
	
	 public static String solution(String[] id_pw, String[][] db) {
	       
	        for(int i = 0 ; i < db.length; i++) {
        		if(db[i][0].equals(id_pw[0])) {
        			if(db[i][1 ].equals(id_pw[1]) ) { // 아디 비번 둘 다 일치
        				return "login";
        			}else { 
        				return "wrong pw";
        			}
        		}
	        }
	        return "fail";		
	        	
	        }
	      
	 public static void main(String[] args) {
		 String[] id_pw = {"meosseugi", "0000"};
		 String[][] db = {{"rardss", "123"},{"yyoom", "1234"},{"meosseugi", "1234"}};
		solution(id_pw,db);
	}

}
