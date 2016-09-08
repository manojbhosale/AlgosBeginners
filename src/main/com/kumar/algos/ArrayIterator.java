package main.com.kumar.algos;

public class ArrayIterator implements Iterator{
	
	private final Object[] _array;
	private final int _start;
	private final int _end;
	private int _current = -1;
	
	public ArrayIterator(Object[] array, int start, int length){
		
		assert array != null : "Array cant be null";
		assert start >= 0 : "Start cant be less than 0"; 
		assert start < array.length : "start cant be greater than array length";
		assert length >= 0: "length cant be less than 0";
		
		_array = array;
		_start = start;
		_end = start + length - 1;
		
		assert _end < array.length : "Start + length cant be > array.length";
	}
	
	
	public ArrayIterator(Object[] array){
		
		assert array != null : "array cant be null";
		_array  = array;
		_start = 0;
		_end = array.length - 1;
		
	}
	
	
	@Override
	public void first() {
		// TODO Auto-generated method stub
		_current = _start;
	}
	@Override
	public void last() {
		// TODO Auto-generated method stub
		_current = _end;	
	}
	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return _current < _start || _current > _end;
	}
	@Override
	public void next() {
		// TODO Auto-generated method stub
		++_current;
	}
	@Override
	public void previous() {
		// TODO Auto-generated method stub
		--_current;
	}
	@Override
	public Object current() throws IteratorOutOfBoundException {
		// TODO Auto-generated method stub
		if(isDone()){
			throw new IteratorOutOfBoundException();
		}
		return _array[_current];
	
	}
}
