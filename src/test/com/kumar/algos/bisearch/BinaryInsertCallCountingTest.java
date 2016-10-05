package test.com.kumar.algos.bisearch;

import main.com.kumar.algos.bisearch.ListInserter;
import main.com.kumar.algos.bisearch.RecursiveBinaryListSearcher;
import main.com.kumar.algos.lists.ArrayList;
import main.com.kumar.algos.lists.List;
import main.com.kumar.algos.sorting.CallCountingComparator;
import main.com.kumar.algos.sorting.ListSorter;
import main.com.kumar.algos.sorting.MergesortListSorter;
import main.com.kumar.algos.sorting.NaturalComparator;
import main.com.kumar.algos.sorting.QuicksortListSorter;
import main.com.kumar.algos.sorting.ShellsortListSorter;
import junit.framework.TestCase;

public class BinaryInsertCallCountingTest extends TestCase{

	private static final int TEST_SIZE = 4091;
	private List _list;
	private CallCountingComparator _comparator;
	protected void setUp() throws Exception {
		super.setUp();
		_list = new ArrayList(TEST_SIZE);
		_comparator = new CallCountingComparator(NaturalComparator.NATCOMPARATOR);
	}

	public void testBinaryInsert() {
		ListInserter inserter = new ListInserter(
				new RecursiveBinaryListSearcher(_comparator));
		for (int i = 0; i < TEST_SIZE; ++i) {
			inserter.insert(_list,
					new Integer((int) (TEST_SIZE * Math.random())));
		}
		reportCalls();
	}

	private void reportCalls() {
		System.out.println(getName() + ": "
				+ _comparator.getCallCount() + " calls");
	}

	public void testMergeSort() {
		populateAndSortList(new MergesortListSorter(_comparator));
	}
	public void testShellsort() {
		populateAndSortList(new ShellsortListSorter(_comparator));
	}
	public void testQuicksort() {
		populateAndSortList(new QuicksortListSorter(_comparator));
	}

/*	private void populateAndSortList(ListSorter sorter) {
		for (int i = 0; i < TEST_SIZE; ++i) {
			_list.add(new Integer((int) (TEST_SIZE * Math.random())));
		}
		_list = sorter.sort(_list);
		reportCalls();
	}
*/
	private void populateAndSortList(ListSorter sorter) {
		for (int i = 0; i < TEST_SIZE; ++i) {
			_list.add(new Integer((int) (TEST_SIZE * Math.random())));
			_list = sorter.sort(_list);
		}
		reportCalls();
	}

}
