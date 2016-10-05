package test.com.kumar.algos.bisearch;

import main.com.kumar.algos.bisearch.ListInserter;
import main.com.kumar.algos.bisearch.RecursiveBinaryListSearcher;
import main.com.kumar.algos.iterationandrecursion.Iterator;
import main.com.kumar.algos.lists.ArrayList;
import main.com.kumar.algos.lists.List;
import main.com.kumar.algos.sorting.NaturalComparator;
import junit.framework.TestCase;

public class ListInserterTest extends TestCase{


	private static final int TEST_SIZE = 1023;
	private ListInserter _inserter;
	private List _list;
	protected void setUp() throws Exception {
		super.setUp();
		_inserter = new ListInserter(new RecursiveBinaryListSearcher(NaturalComparator.NATCOMPARATOR));

		_list = new ArrayList(TEST_SIZE);
	}
	private void verify() {
		int previousValue = Integer.MIN_VALUE;
		Iterator i = _list.iterator();
		for (i.first(); !i.isDone(); i.next()) {
			int currentValue = ((Integer) i.current()).intValue();
			assertTrue(currentValue >= previousValue);
			previousValue = currentValue;
		}
	}

	public void testAscendingInOrderInsertion() {
		for (int i = 0; i < TEST_SIZE; ++i) {
			assertEquals(i, _inserter.insert(_list, new Integer(i)));
		}
		verify();
	}

	public void testDescendingInOrderInsertion() {
		for (int i = TEST_SIZE - 1; i >= 0; --i) {
			assertEquals(0, _inserter.insert(_list, new Integer(i)));
		}
		verify();
	}

	public void testRandomInsertion() {
		for (int i = 0; i < TEST_SIZE; ++i) {
			_inserter.insert(_list,
					new Integer((int) (TEST_SIZE * Math.random())));
		}
		verify();
	}


}
