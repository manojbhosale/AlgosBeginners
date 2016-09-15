package main.com.kumar.algos.sorting;

import java.util.Comparator;

public class BubblesortListSorterTest extends AbstractListSorterTest{

	@Override
	protected ListSorter createListSorter(Comparator comparator) {
		// TODO Auto-generated method stub
		return new BubblesortListSorter(comparator);
	}


	
}
