package test.com.kumar.algos.sorting;

import junit.framework.TestCase;
import main.com.kumar.algos.lists.ArrayList;
import main.com.kumar.algos.lists.List;
import main.com.kumar.algos.sorting.BubblesortListSorter;
import main.com.kumar.algos.sorting.CallCountingComparator;
import main.com.kumar.algos.sorting.InsertionSortListSorter;
import main.com.kumar.algos.sorting.NaturalComparator;
import main.com.kumar.algos.sorting.SelectionSortListSorter;

public class ListSorterCallCountingTest  extends TestCase{

	private static final int TEST_SIZE = 1000;
	private final List _sortedArrayList = new ArrayList(TEST_SIZE);
	private final List _reversedArrayList = new ArrayList(TEST_SIZE);
	private final List _randomArrayList = new ArrayList(TEST_SIZE);

	private CallCountingComparator _comparator;

	protected void setUp() throws Exception{
		_comparator = new CallCountingComparator(NaturalComparator.NATCOMPARATOR);

		for(int i = 1; i < TEST_SIZE; ++i){
			_sortedArrayList.add(new Integer(i));
		}

		for(int i = TEST_SIZE; i > 0; --i){
			_reversedArrayList.add(new Integer(i));
		}

		for(int i = 1; i < TEST_SIZE; ++i){
			_randomArrayList.add(new Integer((int) (TEST_SIZE * Math.random())));
		}

	}

	public void testWorstCaseBubblesort() {
		new BubblesortListSorter(_comparator).sort(_reversedArrayList);
		reportCalls(_comparator.getCallCount());
	}

	public void testWorstCaseSelectionSort() {
		new SelectionSortListSorter(_comparator).sort(_reversedArrayList);
		reportCalls(_comparator.getCallCount());
	}

	public void testWorstCaseInsertionSort() {
		new InsertionSortListSorter(_comparator).sort(_reversedArrayList);
		reportCalls(_comparator.getCallCount());
	}

	public void testBestCaseBubblesort() {
		new BubblesortListSorter(_comparator).sort(_sortedArrayList);
		reportCalls(_comparator.getCallCount());
	}

	public void testBestCaseSelectionSort() {
		new SelectionSortListSorter(_comparator).sort(_sortedArrayList);
		reportCalls(_comparator.getCallCount());
	}

	public void testBestCaseInsertionSort() {
		new InsertionSortListSorter(_comparator).sort(_sortedArrayList);
		reportCalls(_comparator.getCallCount());
	}
	public void testAverageCaseBubblesort() {
		new BubblesortListSorter(_comparator).sort(_randomArrayList);
		reportCalls(_comparator.getCallCount());
	}

	public void testAverageCaseSelectionSort() {
		new SelectionSortListSorter(_comparator).sort(_randomArrayList);
		reportCalls(_comparator.getCallCount());
	}

	public void testAverageCaseInsertionSort() {
		new InsertionSortListSorter(_comparator).sort(_randomArrayList);
		reportCalls(_comparator.getCallCount());
	}

	private void reportCalls(int callCount) {
		System.out.println(getName() + ": " + callCount + " calls");
	}
}
