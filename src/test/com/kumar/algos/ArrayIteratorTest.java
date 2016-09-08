package test.com.kumar.algos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import junit.framework.TestCase;

import org.junit.Test;

import main.com.kumar.algos.ArrayIterator;
import main.com.kumar.algos.IteratorOutOfBoundException;


public class ArrayIteratorTest {
	
	@Test
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
	
	
	@Test
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
