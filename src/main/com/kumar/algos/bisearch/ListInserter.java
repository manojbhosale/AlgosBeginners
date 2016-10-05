package main.com.kumar.algos.bisearch;

import main.com.kumar.algos.lists.List;

public class ListInserter {

	private final ListSearcher _searcher;
	
	
	public ListInserter(ListSearcher searcher) {
		assert searcher != null : "searcher can’t be null";
		_searcher = searcher;
	}
	public int insert(List list, Object value) {
		assert list != null : "list can't be null";
		int index = _searcher.search(list, value);
		if (index < 0) {
			index = -(index + 1);
		}
		list.insert(index, value);
		return index;
	}
}


