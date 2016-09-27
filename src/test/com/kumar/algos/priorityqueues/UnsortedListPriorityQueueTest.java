package test.com.kumar.algos.priorityqueues;

import java.util.Comparator;

import main.com.kumar.algos.priorityqueues.UnsortedListPriorityQueue;
import main.com.kumar.algos.queues.Queue;

public class UnsortedListPriorityQueueTest extends AbstratcPriorityQueueTestCase{
	
	protected Queue createQueue(Comparator comparator){
		
		return new UnsortedListPriorityQueue(comparator);
		
	}

}
