package test.com.kumar.algos.iterationandrecursion;


import main.com.kumar.algos.iterationandrecursion.ArrayIterator;
import main.com.kumar.algos.iterationandrecursion.IteratorOutOfBoundException;
import main.com.kumar.algos.iterationandrecursion.ReverseIterator;
import junit.framework.TestCase;

public class ReverseIteatorTest extends TestCase{

	private static final Object[] ARRAY = new Object[]{"A","B","C"};
	
	
	public void testForwardOfReverseIterator(){
		
		ReverseIterator iterator = new ReverseIterator(new ArrayIterator(ARRAY));
		
		iterator.first();
		
		assertFalse(iterator.isDone());
		assertSame(ARRAY[2], iterator.current());
		
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[1], iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[0], iterator.current());
		
		iterator.next();
		assertTrue(iterator.isDone());
		try{
			iterator.current();
			fail();
		}catch(IteratorOutOfBoundException e){
			// expected
		}
		
	}
	
	public void testBackwardOfReverseIterator(){
		
		ReverseIterator iterator = new ReverseIterator(new ArrayIterator(ARRAY));
		
		iterator.last();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[0], iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[1], iterator.current());
	
		iterator.previous();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[2], iterator.current());
		
		iterator.previous();
		assertTrue(iterator.isDone());
		
		try{
			iterator.current();
			fail();
		}catch(IteratorOutOfBoundException e){
			//
		}

		
	}
	
	public void testSequenceOfArray(){
		ReverseIterator iterator = new ReverseIterator(new ArrayIterator(ARRAY));
		while(!iterator.isDone()){
			System.out.println(iterator.current());
			iterator.next();
		}
		
	}
	
	
}
