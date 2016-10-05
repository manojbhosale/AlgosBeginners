package test.com.kumar.algos.bisearch;

import java.util.Comparator;

import main.com.kumar.algos.bisearch.AbstractListSearcherTestCase;
import main.com.kumar.algos.bisearch.ListSearcher;
import main.com.kumar.algos.bisearch.RecursiveBinaryListSearcher;

public class RecursiveBinarySearcherTest extends AbstractListSearcherTestCase{

	protected ListSearcher createSearcher(Comparator comparator) {
		return new RecursiveBinaryListSearcher(comparator);
	}
	
}
