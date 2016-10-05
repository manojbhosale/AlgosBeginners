package main.com.kumar.algos.bisearch;

import java.util.Comparator;

import main.com.kumar.algos.iterationandrecursion.Iterator;
import main.com.kumar.algos.lists.List;

public class LinearListSearcher implements ListSearcher{

	private final Comparator _comparator;
	public LinearListSearcher(Comparator comparator) {
	assert comparator != null : "comparator can’t be null";
	_comparator = comparator;
	}
	
	public int search(List list, Object key){
		
		assert list != null : "list can not be null !!";
		
		
		int index= 0;
		
		for(int i = 0;i < list.size();i++){
			index = i;
			int cmp = _comparator.compare(key, list.get(i));
			
			if(cmp == 0){
				return i;
			}
			
			if(cmp < 0){
				break;
			}
			
		}
		
		
		return -(index+1);
	}
	
	
	
}
