package main.com.kumar.algos.sorting;

import java.util.Comparator;

public class InsertionSortListSorterTest extends AbstractListSorterTest{

	@Override
	protected ListSorter createListSorter(Comparator cmp) {
		
		return new InsertionSortListSorter(cmp);
	}

	
	
}
