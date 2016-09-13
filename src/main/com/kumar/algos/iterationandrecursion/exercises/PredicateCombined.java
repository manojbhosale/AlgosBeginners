package main.com.kumar.algos.iterationandrecursion.exercises;

import main.com.kumar.algos.iterationandrecursion.Predicate;

public class PredicateCombined implements Predicate{
	
	public PredicateCombined(){
		
	}
	
	
	class PredicateOne implements Predicate{
		
		@Override
		public boolean evaluate(Object obj) {
			// TODO Auto-generated method stub
			assert obj != null: "value shoule not be null";
			String str = (String) obj;
			if(str.isEmpty()){
				return false;
			}
			
			return true;
		}
		
	}
	
	class PredicateTwo implements Predicate{

		@Override
		public boolean evaluate(Object obj) {
			assert obj != null: "value shoule not be null";
			String str = (String) obj;
			if(str.startsWith("A")){
				return true;
			}
			
			return false;
		}
		
	}

	@Override
	public boolean evaluate(Object obj) {
		// TODO Auto-generated method stub
		PredicateOne pOne = new PredicateOne();
		PredicateTwo pTwo = new PredicateTwo();
		
		if(pOne.evaluate(obj) && pTwo.evaluate(obj)){
			return true;
		}
		
		return false;
	}
	
	
}


