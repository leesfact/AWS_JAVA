package j20_JSON;

import java.util.Arrays;

import com.google.gson.Gson;

public class Json3 {
	public static void main(String[] args) {
		
		Gson gson = new Gson();
		
		gson.fromJson("", Object.class); // json -> Object
		gson.toJson(null);         // Object ->json

		
		
	}

}
