package test.com.kumar.algos.sorting;

import java.util.Comparator;

import main.com.kumar.algos.sorting.ListSorter;
import main.com.kumar.algos.sorting.QuicksortListSorter;

public class QuicksortListSorterTest extends AbstractListSorterTest{

	protected ListSorter createListSorter(Comparator comparator){
		return new QuicksortListSorter(comparator);
	}
	
}
