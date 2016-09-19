package main.com.kumar.algos.sorting;

import java.util.Comparator;

import test.com.kumar.algos.sorting.AbstractListSorterTest;

public class ShellSortListSorterTest extends AbstractListSorterTest{
	
	@Override
	protected ListSorter createListSorter(Comparator comparator){
		return new ShellSortListSorter(comparator);
	}

	
}
