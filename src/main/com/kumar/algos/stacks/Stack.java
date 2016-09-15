package main.com.kumar.algos.stacks;

import main.com.kumar.algos.queues.Queue;

public interface Stack extends Queue{

	public void push(Object value);
	public Object pop() throws EmptyStackException;
	public Object peek() throws EmptyStackException;
	public boolean isEmpty();
	public int size();
	public void clear();
}
