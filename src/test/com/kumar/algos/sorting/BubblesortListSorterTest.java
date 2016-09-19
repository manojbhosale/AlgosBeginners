package test.com.kumar.algos.sorting;

import java.util.Comparator;

import main.com.kumar.algos.sorting.BubblesortListSorter;
import main.com.kumar.algos.sorting.ListSorter;

public class BubblesortListSorterTest extends AbstractListSorterTest{

	@Override
	protected ListSorter createListSorter(Comparator comparator) {
		// TODO Auto-generated method stub
		return new BubblesortListSorter(comparator);
	}


	
}
