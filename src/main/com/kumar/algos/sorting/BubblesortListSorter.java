package main.com.kumar.algos.sorting;

import java.util.Comparator;

import main.com.kumar.algos.iterationandrecursion.Iterator;
import main.com.kumar.algos.lists.LinkedList;
import main.com.kumar.algos.lists.List;

public class BubblesortListSorter implements ListSorter{

	private final Comparator _comparator;

	public BubblesortListSorter(Comparator comparator) {
		// TODO Auto-generated constructor stub
		assert comparator != null : "comparator can not be null !!";
		_comparator = comparator;
	}

	@Override	
	public List sort(List list) {
		assert list != null :"List cannot be null !!";
		
		int size = list.size();
		for(int j = 1; j < size; ++j){

			for(int i = 0; i < size - j; ++i){

				if(_comparator.compare(list.get(i), list.get(i+1)) > 0){
					swap(list, i, i+1);
				}

			}
		}

		return list;

	}

	public void swap(List list, int source, int target){
		Object value = list.get(source);
		Object secValue = list.set(target, value);
		list.set(source, secValue);
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
		System.out.println(_unsortedList.size());

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

		List temp = new BubblesortListSorter(NaturalComparator.NATCOMPARATOR).sort(_unsortedList);
		
		Iterator  it = temp.iterator();
		System.out.println("ManojS");
		while(!it.isDone()){
			System.out.println(it.current());
			it.next();
		}

	}

}
