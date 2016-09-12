package main.com.kumar.algos.queues;

import main.com.kumar.algos.iterationandrecursion.Iterator;
import main.com.kumar.algos.lists.ArrayList;
import main.com.kumar.algos.lists.List;

public class CallCenter {

	private final Queue _calls = new BlockingQueue(new ListFifoQueue());

	private final List _threads;
	private final int _numberOfAgents;

	public CallCenter(int numberOfAgents){
		_threads = new ArrayList(numberOfAgents);
		_numberOfAgents = numberOfAgents;
	}

	public void open(){
		assert _threads.isEmpty() : "Already open";
		System.out.println("Call center opening");
		for (int i = 0; i < _numberOfAgents; ++i) {
			Thread thread =
					new Thread(new CustomerServiceAgent(i, _calls));
			thread.start();
			_threads.add(thread);
		}
		System.out.println("Call center open !!");
	}


	public void accept(Call call) {
		assert !_threads.isEmpty() : "Not open";
		_calls.enqueue(call);
		System.out.println(call + " queued");
	}

	public void close() {
		assert !_threads.isEmpty() : "Already closed";
		System.out.println("Call center closing");
		for (int i = 0; i < _numberOfAgents; ++i) {
			accept(CustomerServiceAgent.GO_HOME);
		}
		Iterator i = _threads.iterator();
		for (i.first(); !i.isDone(); i.next()) {
			waitForTermination((Thread) i.current());}
		_threads.clear();
		System.out.println("Call center closed");

	}
	
	public void waitForTermination(Thread t){
		try{
			t.join();
		}catch(InterruptedException e){
			//Ignore
		}
			
	}

}
