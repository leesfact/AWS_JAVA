package Test;

public class Factory {
	
	private static Factory instance;
	private String factoryName;
	
	
	private Factory() {}
	
	public static Factory getInstance() {
		
		if(instance == null) {
			instance = new Factory();
		}
		return instance;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
		
}
