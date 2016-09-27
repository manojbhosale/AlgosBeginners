package test.com.kumar.algos.sorting;

import java.util.Comparator;

import main.com.kumar.algos.sorting.ListSorter;
import main.com.kumar.algos.sorting.MergesortListSorter;

public class MergesorterListSorterTest extends AbstractListSorterTest{

	@Override
	protected ListSorter createListSorter(Comparator cmp) {
		return new MergesortListSorter(cmp);
	}

	
	
}
