package main.com.kumar.algos.priorityqueues;

import java.util.Comparator;

import main.com.kumar.algos.lists.LinkedList;
import main.com.kumar.algos.lists.List;
import main.com.kumar.algos.queues.EmptyQueueException;
import main.com.kumar.algos.queues.Queue;

public class UnsortedListPriorityQueue implements Queue{
	private final List _list;
	private final Comparator _comparator;
	public UnsortedListPriorityQueue(Comparator comparator) {
		assert comparator != null : "comparator cannot be null";
		_comparator = comparator;
		_list = new LinkedList();
	}

	public void enqueue(Object value) {
		_list.add(value);
	}
	public Object dequeue() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		return _list.delete(getIndexOfLargestElement());
	}

	private int getIndexOfLargestElement() {
		int result = 0;
		for (int i = 1; i < _list.size(); ++i) {
			if (_comparator.compare(_list.get(i), _list.get(result)) > 0) {
				result = i;
			}
		}
		return result;
	}

	public void clear() {
		_list.clear();
	}
	public int size() {
		return _list.size();
	}
	public boolean isEmpty() {
		return _list.isEmpty();
	}

}
