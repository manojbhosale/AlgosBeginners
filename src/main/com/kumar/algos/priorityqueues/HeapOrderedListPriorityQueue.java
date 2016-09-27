package main.com.kumar.algos.priorityqueues;

import java.util.Comparator;

import main.com.kumar.algos.lists.LinkedList;
import main.com.kumar.algos.lists.List;
import main.com.kumar.algos.queues.EmptyQueueException;
import main.com.kumar.algos.queues.Queue;
import main.com.kumar.algos.sorting.NaturalComparator;

public class HeapOrderedListPriorityQueue implements Queue{
	private List list = new LinkedList();
	private final Comparator _comparator;

	public HeapOrderedListPriorityQueue(Comparator comp){

		_comparator = comp;


	}

	@Override
	public void enqueue(Object value) {
		// TODO Auto-generated method stub

		list.add(value);
		swim(list);
		return;

	}

	public List swim(List list){

		int lastIndex = list.size()-1;

		while(true){

			if(lastIndex == 0){
				break;
			}
			int parentIndex = getParent(lastIndex);
			if(_comparator.compare(list.get(lastIndex), list.get(parentIndex)) <= 0){
				break;
			}
			list =	swap(list, lastIndex, parentIndex);
			lastIndex = parentIndex;
		}

		return list;
	}

	private List swap(List list, int lastIndex, int parentIndex){

		Object lastVal = list.set(lastIndex,list.get(parentIndex));
		list.set(parentIndex, lastVal);
		return list;

	}

	/*public boolean checkHeap(List list, ){

	}*/

	public int getParent(int index){

		return (index-1)/2;
		//return (int)Math.floor((index-1)/2);

	}

	@Override
	public Object dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub

		if(list.isEmpty()){
			throw new EmptyQueueException();
		}

		Object retVal = list.get(0);		
		list.set(0, list.get(list.size()-1));
		

		sink(list);
		
		list.delete(list.size()-1);

		return retVal;
	}

	private void sink(List list){

		int parentIndex = 0;

		 
		// test case A B 
		while(true){
			Object parentVal = list.get(parentIndex);
			if(hasLeftChild(parentIndex)){
				int leftIndex = getLeftChild(parentIndex);
				Object leftVal = list.get(leftIndex);
				Object largeVal = leftVal;
				int largeIndex = leftIndex;
				if(hasRightChild(parentIndex)){
					int rightIndex = getRightChild(parentIndex);
					Object rightval = list.get(rightIndex);
					if(_comparator.compare(leftVal, rightval) < 0){
						largeVal = rightval;
						largeIndex = rightIndex;
					}
					
				}		
				if(_comparator.compare(parentVal, largeVal) < 0){
					swap(list, parentIndex, largeIndex);
				}
				parentIndex = largeIndex;
				continue;
			
			}
			break;

		}

	}

	private int getLeftChild(int index){

		int leftChildIndex  = (2 * index + 1); 


		return leftChildIndex;

	}

	private int getRightChild(int index){

		int leftChildIndex  = (2 * index + 2); 


		return leftChildIndex;

	}

	private boolean hasLeftChild(int index){
		int	leftChildIndex  = (2 * index + 1);
		if(leftChildIndex >= list.size()){
			return false;
		}
		return true;
	}

	public boolean hasRightChild(int index){
		int	rightChildIndex  = (2 * index + 2);
		if(rightChildIndex >= list.size()){
			return false;
		}

		return true;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		list.clear();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(new HeapOrderedListPriorityQueue(NaturalComparator.NATCOMPARATOR).getParent(8));
	}


}
