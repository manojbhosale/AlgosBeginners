package main.com.kumar.algos.sorting;

import java.util.Comparator;

public final class NaturalComparator implements Comparator{

	public static final NaturalComparator NATCOMPARATOR = new NaturalComparator();
	
	
	private NaturalComparator(){
		
	}
			
	
	@Override
	public int compare(Object left, Object right) {
		// TODO Auto-generated method stub
		assert left != null : " Left can not be null !!";
		return ((Comparable) left).compareTo(right) ;
	}

	
	
}
