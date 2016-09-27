package main.com.kumar.algos.priorityqueues;

import java.util.Comparator;

import main.com.kumar.algos.lists.LinkedList;
import main.com.kumar.algos.lists.List;
import main.com.kumar.algos.queues.EmptyQueueException;
import main.com.kumar.algos.queues.Queue;

public class SortedListPriorityQueue implements Queue{

	private final List _list;
	private final Comparator _comparator;

	public SortedListPriorityQueue(Comparator comparator) {
		assert comparator != null : "comparator cannot be null";
		_comparator = comparator;
		_list = new LinkedList();
	}
	public void enqueue(Object value) {
		int pos = _list.size();
		while (pos > 0 && _comparator.compare(_list.get(pos - 1), value) > 0) {
			--pos;
		}
		_list.insert(pos, value);
	}

	public Object dequeue() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		return _list.delete(_list.size() - 1);
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
