package main.com.kumar.algos.sorting;

import java.util.Comparator;

import main.com.kumar.algos.lists.List;

public class ShellSortListSorter implements ListSorter {

	private final Comparator _comparator;
	private final int[] _increments = { 121, 40, 13, 4, 1 };

	public ShellSortListSorter(Comparator comparator) {
		assert comparator != null : "Comparator can not be null  !!";
		_comparator = comparator;
	}

	public List sort(List list) {

		assert list != null : "List can not be null !!";

		for (int i = 0; i < _increments.length; i++) {
			int increment = _increments[i];
			hSort(list, increment);
		}

		return list;

	}

	private void hSort(List list, int increment) {

		if (list.size() < increment * 2) {
			return;
		}

		for (int i = 0; i < increment; i++) {
			sortSublist(list, i, increment);
		}

	}

	private void sortSublist(List list, int startIndex, int increment) {

		for (int i = startIndex + increment; i < list.size(); i += increment) {

			Object value = list.get(i);
			int j;
			for (j = i; j > startIndex; j -= increment) {

				Object previousValue = list.get(j - increment);
				if (_comparator.compare(value, previousValue) >= 0) {
					break;
				}
				list.set(j, previousValue);
			}
			list.set(j, value);

		}

	}

}
