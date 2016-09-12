package test.com.kumar.algos.queues;

import main.com.kumar.algos.queues.EmptyQueueException;
import main.com.kumar.algos.queues.Queue;
import junit.framework.TestCase;

public abstract class AbstractFifoQueueTestCase extends TestCase{

	private static final String VALUE_A = "A";
	private static final String VALUE_B = "B";
	private static final String VALUE_C = "C";

	private Queue _queue;
	protected void setUp() throws Exception {

		super.setUp();
		_queue = createFifoQueue();
	}

	protected abstract Queue createFifoQueue();

	public void testAccessAnEmptyQueue() {
		assertEquals(0, _queue.size());
		assertTrue(_queue.isEmpty());
		try {
			_queue.dequeue();
			fail();
		} catch (EmptyQueueException e) {
			// expected
		}
	}

	public void testEnqueueDequeue() {
		_queue.enqueue(VALUE_B);
		_queue.enqueue(VALUE_A);
		_queue.enqueue(VALUE_C);
		assertEquals(3, _queue.size());
		assertFalse(_queue.isEmpty());
		assertSame(VALUE_B, _queue.dequeue());
		assertEquals(2, _queue.size());
		assertFalse(_queue.isEmpty());
		assertSame(VALUE_A, _queue.dequeue());
		assertEquals(1, _queue.size());
		assertFalse(_queue.isEmpty());
		assertSame(VALUE_C, _queue.dequeue());
		assertEquals(0, _queue.size());
		assertTrue(_queue.isEmpty());
		try {
			_queue.dequeue();
			fail();
		} catch (EmptyQueueException e) {
			// expected
		}
	}

	public void testClear() {
		_queue.enqueue(VALUE_A);
		_queue.enqueue(VALUE_B);
		_queue.enqueue(VALUE_C);
		assertFalse(_queue.isEmpty());
		_queue.clear();
		assertEquals(0, _queue.size());
		assertTrue(_queue.isEmpty());
		try {
			_queue.dequeue();
			fail();
		} catch (EmptyQueueException e) {
			// expected
		}
	}

}
