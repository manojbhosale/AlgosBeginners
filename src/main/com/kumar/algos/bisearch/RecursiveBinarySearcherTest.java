package main.com.kumar.algos.bisearch;

import java.util.Comparator;

public class RecursiveBinarySearcherTest extends AbstractListSearcherTestCase{

	protected ListSearcher createSearcher(Comparator comparator) {
		return new RecursiveBinaryListSearcher(comparator);
	}
	
}
