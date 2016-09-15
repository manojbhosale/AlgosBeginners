package main.com.kumar.algos.sorting;

import java.util.Comparator;

public class SelectionSortListSorterTest extends AbstractListSorterTest{

	@Override
	protected ListSorter createListSorter(Comparator cmp) {
		// TODO Auto-generated method stub
		return new SelectionSortListSorter(cmp);
	}


	
}
