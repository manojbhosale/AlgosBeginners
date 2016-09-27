package test.com.kumar.algos.sorting;

import java.util.Comparator;

import main.com.kumar.algos.sorting.ListSorter;
import main.com.kumar.algos.sorting.ShellsortListSorter;

public class ShellsortListSorterTest extends AbstractListSorterTest{
	
	@Override
	protected ListSorter createListSorter(Comparator comparator){
		return new ShellsortListSorter(comparator);
	}

	
}
