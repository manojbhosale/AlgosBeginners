package test.com.kumar.algos.iterationandrecursion;

import main.com.kumar.algos.iterationandrecursion.ArrayIterator;
import main.com.kumar.algos.iterationandrecursion.FilterIterator;
import main.com.kumar.algos.iterationandrecursion.Iterator;
import main.com.kumar.algos.iterationandrecursion.IteratorOutOfBoundException;
import main.com.kumar.algos.iterationandrecursion.Predicate;
import main.com.kumar.algos.iterationandrecursion.ReverseIterator;
import junit.framework.TestCase;

public class FilterIteratorTest extends TestCase {

	private static final Object[] ARRAY = {"A", "B", "C"};


	private final class DummyPredicate implements Predicate {

		private final Iterator _iterator;
		private final boolean _result;

		public DummyPredicate(boolean result, Iterator iterator){

			_iterator = iterator;
			_result = result;
			_iterator.first();

		}


		@Override
		public boolean evaluate(Object obj) {
			// TODO Auto-generated method stub
			assertSame(_iterator.current(),obj);
			_iterator.next();
			return _result;
		}



	}


	public void testForwardsIterationIncludesItemsWhenPredicateReturnsTrue() {

		Iterator expectedIterator = new ArrayIterator(ARRAY);
		Iterator underlyingIterator = new ArrayIterator(ARRAY);

		Iterator iterator = new FilterIterator(underlyingIterator, new DummyPredicate(true, expectedIterator));

		iterator.first();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[0], iterator.current());

		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[1], iterator.current());

		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[2], iterator.current());

		iterator.next();
		assertTrue(iterator.isDone());

		try{
			iterator.current();
			fail();

		}catch(IteratorOutOfBoundException e){
			//expected
		}

		assertTrue(expectedIterator.isDone());
		assertTrue(underlyingIterator.isDone());
	}

	public void testForwardsIterationExcludesItemsWhenPredicateReturnsFalse() {
		Iterator expectedIterator = new ArrayIterator(ARRAY);
		Iterator underlyingIterator = new ArrayIterator(ARRAY);

		Iterator iterator = new FilterIterator(underlyingIterator, new DummyPredicate(false, expectedIterator));

		iterator.first();
		assertTrue(iterator.isDone());

		try{
			iterator.current();
			fail();
		}catch(IteratorOutOfBoundException e){
			//expected
		}
		assertTrue(expectedIterator.isDone());
		assertTrue(underlyingIterator.isDone());

	}

	public void testBackwardssIterationIncludesItemsWhenPredicateReturnsTrue() {
		Iterator expectedIterator = new ReverseIterator(new ArrayIterator(ARRAY));
		Iterator underlyingIterator = new ArrayIterator(ARRAY);

		Iterator iterator = new FilterIterator(underlyingIterator, new DummyPredicate(true, expectedIterator));

		iterator.last();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[2], iterator.current());

		iterator.previous();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[1], iterator.current());

		iterator.previous();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[0], iterator.current());

		iterator.previous();
		assertTrue(iterator.isDone());

		try{
			iterator.current();
			fail();

		}catch(IteratorOutOfBoundException e){
			//expected
		}

		assertTrue(expectedIterator.isDone());
		assertTrue(underlyingIterator.isDone());
	}
	public void testBackwardsIterationExcludesItemsWhenPredicateReturnsFalse() {
		Iterator expectedIterator = new ReverseIterator(new ArrayIterator(ARRAY));
		Iterator underlyingIterator = new ArrayIterator(ARRAY);

		Iterator iterator = new FilterIterator(underlyingIterator, new DummyPredicate(false, expectedIterator));

		iterator.last();
		assertTrue(iterator.isDone());

		try{
			iterator.current();
			fail();
		}catch(IteratorOutOfBoundException e){
			//expected
		}
		assertTrue(expectedIterator.isDone());
		assertTrue(underlyingIterator.isDone());
	}

}
