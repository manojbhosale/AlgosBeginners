package test.com.kumar.algos.sorting;

import java.util.Comparator;

import main.com.kumar.algos.sorting.InsertionSortListSorter;
import main.com.kumar.algos.sorting.ListSorter;

public class InsertionSortListSorterTest extends AbstractListSorterTest{

	@Override
	protected ListSorter createListSorter(Comparator cmp) {
		
		return new InsertionSortListSorter(cmp);
	}

	
	
}
