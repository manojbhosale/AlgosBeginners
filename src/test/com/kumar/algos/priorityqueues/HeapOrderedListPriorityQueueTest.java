package test.com.kumar.algos.priorityqueues;

import java.util.Comparator;

import main.com.kumar.algos.priorityqueues.HeapOrderedListPriorityQueue;
import main.com.kumar.algos.queues.Queue;

public class HeapOrderedListPriorityQueueTest extends AbstratcPriorityQueueTestCase{

	@Override
	protected Queue createQueue(Comparator comparable) {
		// TODO Auto-generated method stub
		return new HeapOrderedListPriorityQueue(comparable);
	}

}
