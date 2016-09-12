package main.com.kumar.algos.iterationandrecursion;

public class ReverseIterator implements Iterator{

	/*private final Object[] _array;
	private final int _first;
	private final int _last;
	private int _current = -1;  // otherwise the iterator will never reach the zeroth index value
	 */	
	private final Iterator _iterator;

	public ReverseIterator(Iterator it){
		assert it != null:"Iterator cant be null";
		_iterator = it;
	}

	public boolean isDone() {
		return _iterator.isDone();
	}
	public Object current() throws IteratorOutOfBoundException {
		return _iterator.current();
	}
	public void first() {
		_iterator.last();
	}
	public void last() {
		_iterator.first();
	}
	public void next() {
		_iterator.previous();
	}
	public void previous() {
		_iterator.next();
	}

	/*public ReverseIterator(Object[] testArray){

		assert testArray != null : "Array oject can not be null!!";

		_array = testArray;
		_first = 0;
		_last = _array.length - 1;
		_current = _first;

	}

	@Override
	public void first() {
		// TODO Auto-generated method stub
		_current = _first;
	}

	@Override
	public void last() {
		// TODO Auto-generated method stub
		_current = _last;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return (_current < _first || _current > _last);
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
	}*/

}
