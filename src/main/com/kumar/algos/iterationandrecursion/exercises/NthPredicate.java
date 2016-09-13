package main.com.kumar.algos.iterationandrecursion.exercises;

import main.com.kumar.algos.iterationandrecursion.Iterator;
import main.com.kumar.algos.iterationandrecursion.Predicate;

public class NthPredicate implements Predicate{
	private final Iterator _iterator;
	private final int _nValue;
	private int _counter = -1;
	
	public NthPredicate(int n, Iterator iterator){
		assert n > 0 : "n should be greater than zero !!";
		_nValue= n;
		_iterator = iterator;
		_iterator.first();
	}
	
	@Override
	public boolean evaluate(Object obj) {
		
		++_counter;
		if(_counter % _nValue == 0){
//			/System.out.println("Inside Evaluate !!");
			return true;
		}
		
		return false;
	}

	
}
