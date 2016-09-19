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
		return null;
	}

	private List mergeSort(List list, int startIndex, int endIndex) {
		List left;
		List right;
		List sortedSubList = new LinkedList();
		if ((endIndex - startIndex) > 0) {
			int size = (endIndex - startIndex) / 2;
			left = mergeSort(list, startIndex, (startIndex + size) - 1);
			right = mergeSort(list, (startIndex + size), endIndex);

			Iterator leftIter = left.iterator();
			Iterator rightIter = right.iterator();
			leftIter.first();
			rightIter.first();
			Object leftVal = null;
			Object rightVal = null;

			leftVal = leftIter.current();
			rightVal = rightIter.current();

			while (true) {

				if (_comparator.compare(leftVal, rightVal) <= 0 && !leftIter.isDone()) {
					sortedSubList.add(leftVal);
					leftIter.next();
					if(!leftIter.isDone())
						leftVal = leftIter.current();
				} else if (_comparator.compare(leftVal, rightVal) >= 0 	&& !rightIter.isDone()) {
					sortedSubList.add(rightVal);
					rightIter.next();
					if(!rightIter.isDone())
						rightVal = rightIter.current();
				} else {
					break;
				}

			}
			return sortedSubList;

		} else {
			List l = new LinkedList();
			l.add(list.get(startIndex));
			return l;
		}

	}

}
