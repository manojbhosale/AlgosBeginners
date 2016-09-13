package main.com.kumar.algos.iterationandrecursion.exercises;

import junit.framework.TestCase;
import main.com.kumar.algos.iterationandrecursion.ArrayIterator;
import main.com.kumar.algos.iterationandrecursion.FilterIterator;
import main.com.kumar.algos.iterationandrecursion.Iterator;
import main.com.kumar.algos.iterationandrecursion.IteratorOutOfBoundException;

public class PredicateCombinedTest extends TestCase{

	public final Object[] ARRAY = {"A","","","Aaa","E","","G","","AA"};


	public void testForwardIteratorByTwo(){

		Iterator _iterator = new ArrayIterator(ARRAY);

		FilterIterator fi = new FilterIterator(_iterator, new PredicateCombined());

		fi.first();
		
		while(!fi.isDone()){
			System.out.println(fi.current());
			fi.next();
		}
		
		fi.first();

		assertFalse(fi.isDone());
		assertSame(ARRAY[0],fi.current());
		assertNotSame(ARRAY[1], fi.current());
		//assertNotSame(ARRAY[0], fi.current());

		fi.next();
		assertFalse(fi.isDone());
		assertSame(ARRAY[3],fi.current());
		assertNotSame(ARRAY[2],fi.current());

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


}
