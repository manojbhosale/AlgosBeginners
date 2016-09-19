package test.com.kumar.algos.sorting;

import java.util.Comparator;

import main.com.kumar.algos.sorting.ListSorter;
import main.com.kumar.algos.sorting.SelectionSortListSorter;

public class SelectionSortListSorterTest extends AbstractListSorterTest{

	@Override
	protected ListSorter createListSorter(Comparator cmp) {
		// TODO Auto-generated method stub
		return new SelectionSortListSorter(cmp);
	}


	
}
