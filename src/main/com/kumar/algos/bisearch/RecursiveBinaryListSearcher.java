package main.com.kumar.algos.bisearch;

import java.util.Comparator;

import main.com.kumar.algos.lists.LinkedList;
import main.com.kumar.algos.lists.List;

public class RecursiveBinaryListSearcher implements ListSearcher{

	private final Comparator _comparator;

	public RecursiveBinaryListSearcher(Comparator comp) {
		// TODO Auto-generated constructor stub
		_comparator = comp;
	}


	@Override
	public int search(List list, Object key) {
		// TODO Auto-generated method stub
		assert list != null : "List can not be null !!";
		
		return recursiveListSearch(list, key, 0, list.size()-1);
	}
	
	private int recursiveListSearch(List list, Object key, int lowerIndex, int upperIndex){
		
		assert list != null : "List can not be null !!";
		
		if(lowerIndex > upperIndex){
			return -(lowerIndex + 1);
		}
		
		int midIndex = lowerIndex + (upperIndex - lowerIndex) /2;
		
		int cmp = _comparator.compare(key, list.get(midIndex));
		
		if(cmp < 0){
			midIndex = recursiveListSearch(list, key, lowerIndex, midIndex - 1);
		}else if(cmp > 0){
			midIndex = recursiveListSearch(list, key, midIndex + 1, upperIndex);
		}
		
		return midIndex;
	}



}
