package main.com.kumar.algos.sorting;

import java.util.Comparator;

public class ReverseComparator implements Comparator{

	private final NaturalComparator _comparator;
	
	public ReverseComparator(NaturalComparator comparator) {
		// TODO Auto-generated constructor stub
		_comparator = comparator;
	} 

	@Override
	public int compare(Object left, Object right) {		
		return _comparator.compare(right, left);
	}
	
}
