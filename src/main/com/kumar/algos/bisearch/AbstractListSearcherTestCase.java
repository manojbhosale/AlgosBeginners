package main.com.kumar.algos.bisearch;

import java.util.Comparator;

import main.com.kumar.algos.lists.ArrayList;
import main.com.kumar.algos.lists.List;
import main.com.kumar.algos.sorting.NaturalComparator;
import junit.framework.TestCase;

public abstract class AbstractListSearcherTestCase extends TestCase{

	private static final Object[] VALUES = {"B", "C", "D", "F", "H", "I",
		"J", "K", "L", "M", "P", "Q"};
	private ListSearcher _searcher;
	private List _list;
	protected abstract ListSearcher createSearcher(Comparator comparator);
	protected void setUp() throws Exception {
		super.setUp();
		_searcher = createSearcher(NaturalComparator.NATCOMPARATOR);
		_list = new ArrayList(VALUES);

	}

	public void testSearchForExistingValues() {
		for (int i = 0; i < _list.size(); ++i) {
			assertEquals(i, _searcher.search(_list, _list.get(i)));
		}
	}

	public void testSearchForNonExistingValueLessThanFirstItem() {
		assertEquals(-1, _searcher.search(_list, "A"));
	}

	public void testSearchForNonExistingValueGreaterThanLastItem() {
		assertEquals(-13, _searcher.search(_list, "Z"));
	}

	public void testSearchForArbitraryNonExistingValue() {
		assertEquals(-4, _searcher.search(_list, "E"));
	}
}
