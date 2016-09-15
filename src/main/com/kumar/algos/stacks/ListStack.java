package main.com.kumar.algos.stacks;

import main.com.kumar.algos.lists.LinkedList;
import main.com.kumar.algos.lists.List;
import main.com.kumar.algos.queues.EmptyQueueException;

public class ListStack implements Stack{


	private final List _list = new LinkedList();


	@Override
	public void enqueue(Object value) {
		// TODO Auto-generated method stub
		push(value);
	}

	@Override
	public Object dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub
		try{
			return pop();
		}catch(EmptyStackException e){
			throw new EmptyQueueException();
		}

	}

	@Override
	public void push(Object value) {
		// TODO Auto-generated method stub
		_list.add(value);
	}

	@Override
	public Object pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		if(_list.isEmpty()){
			throw new EmptyStackException();
		}

		return _list.delete(_list.size()-1);
	}

	@Override
	public Object peek() throws EmptyStackException {
		// TODO Auto-generated method stub
		Object result = pop();
		push(result);
		return result;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return _list.isEmpty();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return _list.size();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		_list.clear();
	}

}
