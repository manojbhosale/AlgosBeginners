package main.com.kumar.algos.iterationandrecursion;



public class FilterIterator implements Iterator{

	private final Iterator _iterator;
	private final Predicate _predicate;
	
	public FilterIterator(Iterator iterator, Predicate predicate){
		
		assert iterator != null: "Iterator cant be null";
		assert predicate != null: "predicate cant be null";
		
		_iterator = iterator;
		_predicate = predicate;
		
	}
	
	public boolean isDone(){
		return _iterator.isDone();
	}

	@Override
	public void first() {
		// TODO Auto-generated method stub
		_iterator.first();
		filterForwards();
	}
	
	@Override
	public void next() {
		// TODO Auto-generated method stub
		_iterator.next();
		filterForwards();
	}

	public void filterForwards(){
		while(!_iterator.isDone() && !_predicate.evaluate(_iterator.current())){
			_iterator.next();
		}
	}

	@Override
	public void last() {
		// TODO Auto-generated method stub
		_iterator.last();
		filterBackwards();
	}
	@Override
	public void previous() {
		// TODO Auto-generated method stub
		_iterator.previous();
		filterBackwards();
	}
	
	public void filterBackwards(){
		
		while(!_iterator.isDone() && !_predicate.evaluate(_iterator.current())){
			_iterator.previous();
		}
		
	}

	@Override
	public Object current() throws IteratorOutOfBoundException {
		// TODO Auto-generated method stub
		return _iterator.current();
	}
	
	
}
