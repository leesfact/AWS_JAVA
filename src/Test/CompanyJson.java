package Test;

import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CompanyJson {

	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();   //serializeNulls()
		
		Map<String, Object> company = new LinkedHashMap<>();
		
	
		company.put("companyId", "100");
		company.put("companyName", "Apple");
		company.put("address", "Apple Computer Inc. 1 infinite Loop");
		company.put("city", "Cupertino");
		company.put("zipCode", "95014");
		
	
		String companyJson = gson.toJson(company);

		System.out.println(companyJson);

	}

}
