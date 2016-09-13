package main.com.kumar.algos.iterationandrecursion.exercises;

import main.com.kumar.algos.iterationandrecursion.ArrayIterator;
import main.com.kumar.algos.iterationandrecursion.FilterIterator;
import main.com.kumar.algos.iterationandrecursion.Iterator;
import main.com.kumar.algos.iterationandrecursion.IteratorOutOfBoundException;
import junit.framework.TestCase;

public class NthPredicateTest extends TestCase{
	
	
	public final Object[] ARRAY = {"A","B","C","D","E","F","G","H","I"};
	
	
	public void testForwardIteratorByTwo(){
		
		Iterator _iterator = new ArrayIterator(ARRAY);
		
		FilterIterator fi = new FilterIterator(_iterator, new NthPredicate(2, _iterator));
		
		fi.first();
		
		assertFalse(fi.isDone());
		assertSame(ARRAY[0],fi.current());
		assertNotSame(ARRAY[1], fi.current());
		//assertNotSame(ARRAY[0], fi.current());
		
		fi.next();
		assertFalse(fi.isDone());
		assertSame(ARRAY[2],fi.current());
		
		fi.next();
		assertFalse(fi.isDone());
		assertSame(ARRAY[4],fi.current());

		fi.next();
		assertFalse(fi.isDone());
		assertSame(ARRAY[6],fi.current());

		
		fi.next();
		assertFalse(fi.isDone());
		assertSame(ARRAY[8],fi.current());

		
		fi.next();
		assertTrue(fi.isDone());
		
		try{
			fi.current();
			fail();
		}catch(IteratorOutOfBoundException e){
			//expected
		}
		
	}

	
public void testForwardIteratorByThree(){
		
		Iterator _iterator = new ArrayIterator(ARRAY);
		
		FilterIterator fi = new FilterIterator(_iterator, new NthPredicate(3, _iterator));
		
		fi.first();
		
		assertFalse(fi.isDone());
		assertSame(ARRAY[0],fi.current());
		assertNotSame(ARRAY[1], fi.current());
		assertNotSame(ARRAY[2], fi.current());

		
		fi.next();
		assertFalse(fi.isDone());
		assertSame(ARRAY[3],fi.current());
		
		fi.next();
		assertFalse(fi.isDone());
		assertSame(ARRAY[6],fi.current());
		
		fi.next();
		assertTrue(fi.isDone());
		
		try{
			fi.current();
			fail();
		}catch(IteratorOutOfBoundException e){
			//expected
		}
		
	}

}
