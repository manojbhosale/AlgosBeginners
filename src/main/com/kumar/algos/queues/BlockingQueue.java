package main.com.kumar.algos.queues;


public class BlockingQueue implements Queue{

	private final Object _mutex = new Object();
	private final Queue _queue;
	private final int _maxSize;

	public BlockingQueue(Queue queue, int maxSize){

		assert queue != null : "Queue can not be null";
		assert maxSize > 0: "Size can not be < 1";

		_queue = queue;
		_maxSize = maxSize;

	}

	public BlockingQueue(Queue queue){

		this(queue, Integer.MAX_VALUE);

	}

	public void enqueue(Object value){
		synchronized(_mutex) {
			while(size() == _maxSize){
				waitForNotification();
			}
			_queue.enqueue(value);
			_mutex.notifyAll();
		}
	}

	private void waitForNotification(){
		try{
			_mutex.wait();
		}catch(InterruptedException e){
			//Ignore it
		}
	}

	public Object dequeue() throws EmptyQueueException{

		synchronized (_mutex) {

			while(isEmpty()){
				waitForNotification();
			}

			Object value = _queue.dequeue();
			_mutex.notifyAll();
			return value;
		}


	}
	
	public void clear(){
		synchronized (_mutex) {
			_queue.clear();
			_mutex.notifyAll();
		}
	}
	
	public int size(){
		synchronized(_mutex){
			return _queue.size();
		}
	}
	
	public boolean isEmpty(){
		synchronized(_mutex){
			return _queue.isEmpty();
		}
	}
}
