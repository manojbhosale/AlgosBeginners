package test.com.kumar.algos.priorityqueues;

import java.util.Comparator;

import main.com.kumar.algos.priorityqueues.SortedListPriorityQueue;
import main.com.kumar.algos.queues.Queue;
import test.com.kumar.algos.sorting.AbstractListSorterTest;

public class SortedListPriorityQueueTest extends AbstratcPriorityQueueTestCase{

	@Override
	protected Queue createQueue(Comparator comparable) {
		// TODO Auto-generated method stub
		return new SortedListPriorityQueue(comparable);
	}
	
	
	

}
