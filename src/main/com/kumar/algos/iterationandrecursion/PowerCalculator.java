package main.com.kumar.algos.iterationandrecursion;

public final class PowerCalculator {
	
	public static final PowerCalculator INSTANCE = new PowerCalculator();
	
	private PowerCalculator(){
		
	}
		
	
	public int calculate(int base, int exponent){
		
		assert exponent >= 0:"Exponent can't be less than zero !!";
		
		int result = 1;
		
		for(int i = 0; i < exponent ; i++){
			result *= base;
		}
		
		return result;
	}
	
	public int calculateRecursive(int base, int exponent){
		assert exponent > 0: "Exponent should be > 0 !!";
		
		if(exponent == 0){
			return 1;
		}
			
		return base * calculateRecursive(base,--exponent);

	}


}
