package test.com.kumar.algos.bisearch;

import junit.framework.TestCase;
import main.com.kumar.algos.bisearch.LinearListSearcher;
import main.com.kumar.algos.bisearch.ListSearcher;
import main.com.kumar.algos.bisearch.RecursiveBinaryListSearcher;
import main.com.kumar.algos.lists.ArrayList;
import main.com.kumar.algos.lists.List;
import main.com.kumar.algos.sorting.CallCountingComparator;
import main.com.kumar.algos.sorting.NaturalComparator;

public class BinarySearchCallCountingTest extends TestCase{

	private static final int TEST_SIZE = 1021;
	private List _sortedList;
	private CallCountingComparator _comparator;

	public void setUp()throws Exception{

		super.setUp();

		_sortedList = new ArrayList(TEST_SIZE);


		for(int i = 0; i < TEST_SIZE; i++){

			_sortedList.add(new Integer(i));

		}


		_comparator = new CallCountingComparator(NaturalComparator.NATCOMPARATOR);
	}


	private void reportCalls(){
		System.out.println(getName() + ": "+_comparator.getCallCount() + " calls");
	}

	public void testRecursiveBinarySearch() {
		performInOrderSearch(new RecursiveBinaryListSearcher(_comparator));
	}
	/*public void testIterativeBinarySearch() {
		performInOrderSearch(new IterativeBinaryListSearcher(_comparator));
		}*/
	public void testLinearSearch() {
		performInOrderSearch(new LinearListSearcher(_comparator));
	}
	private void performInOrderSearch(ListSearcher searcher) {
		for (int i = 0; i < TEST_SIZE; ++i) {
			searcher.search(_sortedList, new Integer(i));
		}
		reportCalls();
	}

	public void testRandomRecursiveBinarySearch() {
		performRandomSearch(new RecursiveBinaryListSearcher(_comparator));
	}
	/*public void testRandomIterativeBinarySearch() {
			performRandomSearch(new IterativeBinaryListSearcher(_comparator));
			}*/
	public void testRandomLinearSearch() {
		performRandomSearch(new LinearListSearcher(_comparator));
	}
	private void performRandomSearch(ListSearcher searcher) {
		for (int i = 0; i < TEST_SIZE; ++i) {
			searcher.search(_sortedList,
					new Integer((int) (TEST_SIZE * Math.random())));
		}
		reportCalls();
	}
}
