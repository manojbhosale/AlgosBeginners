package main.com.kumar.algos.sorting;

import java.util.Comparator;

import test.com.kumar.algos.sorting.AbstractListSorterTest;

public class QuicksortListSorterTest extends AbstractListSorterTest{

	protected ListSorter createListSorter(Comparator comparator){
		return new QuicksortListSorter(comparator);
	}
	
}
