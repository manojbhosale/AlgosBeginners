package main.com.kumar.algos.sorting;

import java.util.Comparator;

import main.com.kumar.algos.iterationandrecursion.Iterator;
import main.com.kumar.algos.lists.LinkedList;
import main.com.kumar.algos.lists.List;

public class MergesortListSorter implements ListSorter {

	private final Comparator _comparator;

	public MergesortListSorter(Comparator cmp) {
		assert cmp != null : "Comparator can not be null!!";
		_comparator = cmp;
	}

	@Override
	public List sort(List list) {
		return mergeSort(list, 0, list.size()-1);
	}

	private List mergeSort(List list, int startIndex, int endIndex) {
		List left;
		List right;
		List sortedSubList = new LinkedList();
		if ((endIndex - startIndex) > 0) {
			int size = (endIndex - startIndex) / 2;
			left = mergeSort(list, startIndex, (startIndex + size));
			right = mergeSort(list, (startIndex + size)+1, endIndex);

			Iterator leftIter = left.iterator();
			Iterator rightIter = right.iterator();
			
			leftIter.first();
			rightIter.first();


			while (true) {

				if(leftIter.isDone() && rightIter.isDone()){
					break;
				}
				
				  /*  if (leftIter.isDone()) {
						sortedSubList.add(rightIter.current());
						rightIter.next();
					} else if (rightIter.isDone()) {
						sortedSubList.add(leftIter.current());
						leftIter.next();
					} else if (_comparator.compare(leftIter.current(),rightIter.current()) <= 0) {
						sortedSubList.add(leftIter.current());
						leftIter.next();
					} else {
						sortedSubList.add(rightIter.current());
						rightIter.next();
					}*/
				
				
				if(rightIter.isDone() || (!leftIter.isDone() && _comparator.compare(leftIter.current(), rightIter.current()) <= 0) ){
					sortedSubList.add(leftIter.current());
					leftIter.next();
					continue;
				}
				
				if(leftIter.isDone() || (!rightIter.isDone() && _comparator.compare(leftIter.current(), rightIter.current()) > 0)){
					sortedSubList.add(rightIter.current());
					rightIter.next();
					continue;
				}

				break;
				
			}
			return sortedSubList;

		} else {
			List l = new LinkedList();
			l.add(list.get(startIndex));
			return l;
		}

	}

}
