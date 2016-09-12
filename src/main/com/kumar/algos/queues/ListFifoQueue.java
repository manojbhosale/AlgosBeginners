package main.com.kumar.algos.queues;

import main.com.kumar.algos.lists.LinkedList;
import main.com.kumar.algos.lists.List;

public class ListFifoQueue implements Queue{

	private final List _list;
	
	
	public ListFifoQueue(){
		this(new LinkedList());
	}
	
	public ListFifoQueue(List list) {
		// TODO Auto-generated constructor stub
		assert list != null :"List can not be null !!";
		_list = list;
		
	}

	@Override
	public void enqueue(Object value) {
		// TODO Auto-generated method stub
		_list.add(value);
	}

	@Override
	public Object dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub
		checkEmptyQueue();
		return _list.delete(0);
		
	}
	
	public void checkEmptyQueue() throws EmptyQueueException{
		if(isEmpty()){
			throw new EmptyQueueException();
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		_list.clear();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return _list.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(_list.isEmpty()){
			return true;
		}
		
		return false;
	}
	
	
	
}
