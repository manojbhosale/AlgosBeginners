package main.com.kumar.algos.sorting;

import java.util.Comparator;

import test.com.kumar.algos.sorting.AbstractListSorterTest;

public class MergesorterListSorterTest extends AbstractListSorterTest{

	@Override
	protected ListSorter createListSorter(Comparator cmp) {
		return new MergeListSorter(cmp);
	}

	
	
}
