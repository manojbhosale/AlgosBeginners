package test.com.kumar.algos.iterationandrecursion;

import junit.framework.TestCase;
import main.com.kumar.algos.iterationandrecursion.ArrayIterator;
import main.com.kumar.algos.iterationandrecursion.IteratorOutOfBoundException;


public class ArrayIteratorTest extends TestCase{
	
	
	public void testIterationRespectsBounds(){
		Object[] array = new Object[]{"A", "B", "C", "D", "E", "F"};
		ArrayIterator iterator = new ArrayIterator(array, 1, 3);
		
		iterator.first();
		
		assertFalse(iterator.isDone());
		assertSame(array[1], iterator.current());
		
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(array[2], iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(array[3], iterator.current());
		
		iterator.next();
		assertTrue(iterator.isDone());
		try{
			iterator.current();
			fail();
		}catch(IteratorOutOfBoundException e){
			// expected
		}
		
	}
	
	
	
	public void testBackwardsIteration(){
		
		Object[] array = new Object[]{"A", "B", "C"};
		ArrayIterator iterator = new ArrayIterator(array);
		
		iterator.last();
		assertFalse(iterator.isDone());
		assertSame(array[2], iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertSame(array[1], iterator.current());
	
		iterator.previous();
		assertFalse(iterator.isDone());
		assertSame(array[0], iterator.current());
		
		iterator.previous();
		assertTrue(iterator.isDone());
		
		try{
			iterator.current();
			fail();
		}catch(IteratorOutOfBoundException e){
			//
		}
	}
	
	
}
