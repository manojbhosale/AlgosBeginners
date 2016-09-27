package test.com.kumar.algos.sorting;

import main.com.kumar.algos.sorting.MergesortListSorter;
import main.com.kumar.algos.sorting.QuicksortListSorter;
import main.com.kumar.algos.sorting.ShellsortListSorter;

public class ListSorterCallCountingTestAdvanced extends
		ListSorterCallCountingTest {

	// ListSorterCallCountingTest ls = new ListSorterCallCountingTest();

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testWorstCaseShellsort() {
		new ShellsortListSorter(super.get_comparator()).sort(super
				.get_reversedArrayList());
		reportCalls(super.get_comparator().getCallCount());
	}

	public void testWorstCaseQuicksort() {
		new QuicksortListSorter(super.get_comparator()).sort(super
				.get_reversedArrayList());
		reportCalls(super.get_comparator().getCallCount());
	}

	public void testWorstCaseMergesort() {
		new MergesortListSorter(super.get_comparator()).sort(super
				.get_reversedArrayList());
		reportCalls(super.get_comparator().getCallCount());
	}

	public void testBestCaseShellsort() {
		new ShellsortListSorter(super.get_comparator()).sort(super
				.get_sortedArrayList());
		reportCalls(super.get_comparator().getCallCount());
	}

	public void testBestCaseQuicksort() {
		new QuicksortListSorter(super.get_comparator()).sort(super
				.get_sortedArrayList());
		reportCalls(super.get_comparator().getCallCount());
	}

	public void testBestCaseMergesort() {
		new MergesortListSorter(super.get_comparator()).sort(super
				.get_sortedArrayList());
		reportCalls(super.get_comparator().getCallCount());
	}

	public void testAverageCaseShellsort() {
		new ShellsortListSorter(super.get_comparator()).sort(super
				.get_randomArrayList());
		reportCalls(super.get_comparator().getCallCount());
	}

	public void testAverageCaseQuicksort() {
		new QuicksortListSorter(super.get_comparator()).sort(super
				.get_randomArrayList());
		reportCalls(super.get_comparator().getCallCount());
	}

	public void testAverageCaseMergeSort() {
		new MergesortListSorter(super.get_comparator()).sort(super
				.get_randomArrayList());
		reportCalls(super.get_comparator().getCallCount());
	}

}
