package main.com.kumar.algos.sorting;

import java.util.Comparator;

public final class CallCountingComparator implements Comparator{

	private final Comparator _comparator;
	private int _callCount;
	
	
	public CallCountingComparator(Comparator comparator){
		
		assert comparator != null : "Comparator can not be null !!";
		
		_comparator = comparator;
		_callCount = 0;
		
	}
	
	@Override
	public int compare(Object left, Object right) {
		++_callCount;
		return _comparator.compare(left, right);
	}
	
	public int getCallCount(){
		return _callCount;
	}
	
	

	
	
}
