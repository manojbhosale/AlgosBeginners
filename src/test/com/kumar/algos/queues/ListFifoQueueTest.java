package test.com.kumar.algos.queues;

import main.com.kumar.algos.queues.ListFifoQueue;
import main.com.kumar.algos.queues.Queue;

public class ListFifoQueueTest extends AbstractFifoQueueTestCase{

	protected Queue createFifoQueue(){
		return new ListFifoQueue();
	}
}
