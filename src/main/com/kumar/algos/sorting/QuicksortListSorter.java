package main.com.kumar.algos.sorting;

import java.util.Comparator;

import main.com.kumar.algos.lists.List;

public class QuicksortListSorter implements ListSorter{
	
	private final Comparator _comparator;
	
	public QuicksortListSorter(Comparator comparator) {
	
		assert comparator != null : "comparator can not be null !!";
		
		_comparator = comparator;
		
	}
	
	

	@Override
	public List sort(List list) {
		assert list != null : "List can not be null!!";
		
		quickSort(list, 0, list.size() - 1);
		
		return list;
	}
	
	
	private void quickSort(List list, int startIndex,int endIndex){
	
		if(startIndex < 0 || endIndex >= list.size()){
			return;
		}
		if(endIndex <= startIndex){
			return;
		}
		
		Object value = list.get(endIndex);
		
		int partition = partition(list, value, startIndex, endIndex -1);
		
		if(_comparator.compare(list.get(partition), value) < 0){
			++partition;
		}
		
		swap(list, partition, endIndex);
		
		quickSort(list, startIndex, partition-1);
		quickSort(list, partition+1, endIndex);
		
	}
	
	
	public int partition(List list, Object value ,int startIndex, int endIndex){
		
		int left = startIndex;
		int right = endIndex;
		
		while(left < right){
			
			if(_comparator.compare(list.get(left), value) < 0){
				++left;
				continue;
			}
			
			
			if(_comparator.compare(list.get(right), value) > 0){
				--right;
				continue;
			}
			
			swap(list, left, right);
			++left;
		}
		
		return left;
		
		
		
	}
	
	
	private void swap(List list, int left, int right){
		
		if(left == right){
			return;
		}
			
		
		Object val = list.set(right, list.get(left));
		list.set(left, val);
		
	}

	
	
}
