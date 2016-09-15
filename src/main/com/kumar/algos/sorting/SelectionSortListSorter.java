package main.com.kumar.algos.sorting;

import java.util.Comparator;

import com.sun.media.sound.RIFFInvalidDataException;

import main.com.kumar.algos.iterationandrecursion.Iterator;
import main.com.kumar.algos.lists.LinkedList;
import main.com.kumar.algos.lists.List;

public class SelectionSortListSorter implements ListSorter{

	private final Comparator _comparator;

	public SelectionSortListSorter(Comparator comparator) {
		assert comparator != null : "comparator cannot be null";
		_comparator = comparator;
	}
	
	
	public List sort(List list){
		
		for(int i = 0; i < list.size()-1 ;i++){
			int left = i;
			int right = 0;
			for(int j = i+1; j < list.size() ; j++){
				//Object current = list.get(j);
				right = j;
				if(_comparator.compare(list.get(left),list.get(right)) > 0){
					left = right;
				}
			}
			swap(list,i,left);	
		}
		
		return list;
	}
	
	public void swap(List list, int source, int target){
		if(source == target){
			return;
		}
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

		List temp = new SelectionSortListSorter(NaturalComparator.NATCOMPARATOR).sort(_unsortedList);
		
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
