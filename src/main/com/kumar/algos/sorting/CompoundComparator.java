package main.com.kumar.algos.sorting;

import java.util.Comparator;

import main.com.kumar.algos.iterationandrecursion.Iterator;
import main.com.kumar.algos.lists.ArrayList;
import main.com.kumar.algos.lists.List;

public class CompoundComparator implements Comparator{

	private final List _comparators = new ArrayList();
	
	
	public void addComparator(Comparator comparator){
		
		assert comparator != null :"comparator can’t be null";
		assert comparator != this : "can’t add comparator to itself";
		_comparators.add(comparator);
		
	}
	
	public int compare(Object left, Object right){
		
		int result = 0;
		
		Iterator i= _comparators.iterator();
		for(i.first(); !i.isDone(); i.next()){
			result = ((Comparator) i.current()).compare(left, right);
			
			if(result != 0){
				break;
			}
		}
		return result;
		
	}
	
}
