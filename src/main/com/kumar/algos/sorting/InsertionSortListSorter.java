package main.com.kumar.algos.sorting;

import java.util.Comparator;

import main.com.kumar.algos.iterationandrecursion.Iterator;
import main.com.kumar.algos.lists.LinkedList;
import main.com.kumar.algos.lists.List;

public class InsertionSortListSorter implements ListSorter{

	private final Comparator _comparator ;

	public InsertionSortListSorter(Comparator comparator) {
		_comparator = comparator;
	}

	@Override
	public List sort(List list) {
		assert list != null : "List can not be null !!";

		final List sortedList = new LinkedList();

		Iterator it = list.iterator();
		
		for(it.first();!it.isDone();it.next()){
			int slot = sortedList.size();
			
			while(slot > 0){
				
				if(_comparator.compare(it.current(), sortedList.get(slot-1)) >= 0){
					break;
				}
				slot--;
				
			}
			
			sortedList.insert(slot,it.current());
			
		}
		
		return sortedList;

	}
	
	
	
	
	public static void main(String args[]){

		List _unsortedList;
		List _sortedList;
		_unsortedList = new LinkedList();

		_unsortedList.add("test");
		_unsortedList.add("driven");
		_unsortedList.add("development");
		_unsortedList.add("is");
		_unsortedList.add("one");
		_unsortedList.add("small");
		_unsortedList.add("step");
		_unsortedList.add("for");
		_unsortedList.add("a");
		_unsortedList.add("programmer");
		_unsortedList.add("but");
		_unsortedList.add("it’s");
		_unsortedList.add("one");	
		_unsortedList.add("giant");
		_unsortedList.add("leap");
		_unsortedList.add("for");
		_unsortedList.add("programming");
		

		_sortedList = new LinkedList();
		_sortedList.add("a");
		_sortedList.add("but");
		_sortedList.add("development");
		_sortedList.add("driven");
		_sortedList.add("for");
		_sortedList.add("for");
		_sortedList.add("giant");
		_sortedList.add("is");
		_sortedList.add("it’s");
		_sortedList.add("leap");
		_sortedList.add("one");
		_sortedList.add("one");
		_sortedList.add("programmer");
		_sortedList.add("programming");
		_sortedList.add("small");
		_sortedList.add("step");
		_sortedList.add("test");

		List temp = new InsertionSortListSorter(NaturalComparator.NATCOMPARATOR).sort(_unsortedList);
		
		Iterator  it = temp.iterator();
		it.first();
		System.out.println(temp.size());
		//System.out.println("ManojS");
		while(!it.isDone()){
			System.out.println(it.current());
			it.next();
		}

	}
	
}
