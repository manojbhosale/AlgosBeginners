package test.com.kumar.algos.iterationandrecursion;

import main.com.kumar.algos.iterationandrecursion.PowerCalculator;
import junit.framework.TestCase;

public class PowerCalculatorTest extends TestCase{

	
		public void testAnythingRaisedToThePowerOfZeroIsOne(){
			
			PowerCalculator calculator = PowerCalculator.INSTANCE;
			
			assertEquals(1, calculator.calculate(0, 0));
			assertEquals(1, calculator.calculate(1, 0));
			assertEquals(1, calculator.calculate(27, 0));
			assertEquals(1, calculator.calculate(143, 0));
			
		}
		
		public void testAnuthingRaisedTOthePowerOfOneIsItSelf(){
			PowerCalculator calculator = PowerCalculator.INSTANCE;
			
			assertEquals(0, calculator.calculate(0, 1));
			assertEquals(1, calculator.calculate(1, 1));
			assertEquals(27, calculator.calculate(27, 1));
			assertEquals(143, calculator.calculate(143, 1));
			
		}
		
		public void testArbitrary(){
			PowerCalculator calculator = PowerCalculator.INSTANCE;
			
			assertEquals(1, calculator.calculate(20,0));
			assertEquals(4, calculator.calculate(2,2));
			assertEquals(27, calculator.calculate(3,3));
			assertEquals(390625, calculator.calculate(25,4));
		}
			
	
	
}
