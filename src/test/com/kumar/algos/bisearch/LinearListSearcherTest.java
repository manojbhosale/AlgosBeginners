package test.com.kumar.algos.bisearch;

import java.util.Comparator;

import main.com.kumar.algos.bisearch.AbstractListSearcherTestCase;
import main.com.kumar.algos.bisearch.LinearListSearcher;
import main.com.kumar.algos.bisearch.ListSearcher;

public class LinearListSearcherTest extends AbstractListSearcherTestCase{

	@Override
	protected ListSearcher createSearcher(Comparator comparator) {
		// TODO Auto-generated method stub
		return new LinearListSearcher(comparator);
	}

	
	
}
