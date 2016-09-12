package main.com.kumar.algos.lists;

import main.com.kumar.algos.iterationandrecursion.Iterator;
import main.com.kumar.algos.iterationandrecursion.IteratorOutOfBoundException;

public class LinkedList implements List{

	private final Element _headAndTail = new Element(null);
	private int _size;
	
	public LinkedList(){
		clear();
	}
	
	public void insert(int index, Object value){
		
		assert value != null : "value can not be null";
		
		if(index < 0 || index > _size){
			throw new IndexOutOfBoundsException();
		}
		
		
		Element element = new Element(value);
		element.attachBefore(getElement(index));
		++_size;
	}
	
	private Element getElement(int index){
		
		Element element = _headAndTail.getNext();
		for(int i = index; i > 0; --i){
			element = element.getNext();
		}
		
		return element;
	}
	
	public Object get(int index) throws IndexOutOfBoundsException{
		
		checkOutOfBounds(index);
		Element element = getElement(index);
		return getElement(index).getValue();
		
	}
	
	
	public void checkOutOfBounds(int index)throws IndexOutOfBoundsException{
		if(isOutOfBounds(index)){
			throw new IndexOutOfBoundsException();
		}
	}
	
	public boolean isOutOfBounds(int index){
		if(index < 0 || index >= _size){
			return true;
		}
		return false;
	}
	
	public void add(Object value){
		insert(_size,value);
	}
	
	public int indexOf(Object value){
		
		assert value != null : "value can not be null !!";
		int index = 0;
		
		for(Element e = _headAndTail.getNext() ; e !=  _headAndTail ; e = e.getNext()){
			if(value.equals(e.getValue())){
				return index;
			}
			++index;
		}
		return -1;
		
	}
	
	
	public boolean contains(Object value){
		return indexOf(value) != -1;
	}
	
	public Object delete(int index) throws IndexOutOfBoundsException{
		checkOutOfBounds(index);
		Element e = getElement(index);
		e.detach();
		--_size;
		return e.getValue();
	}
	
	public boolean delete(Object value){
		
		assert value != null: "Value can nto be null !!";
		
		for(Element e = _headAndTail.getNext(); e != _headAndTail ; e = e.getNext()){
			if(value.equals(e.getValue())){
				e.detach();
				--_size;
				return true;
			}
		}
		
		return false;
	}
	
	public final class ValueIterator implements Iterator{
		private Element _current = _headAndTail;
		
		@Override
		public void first() {
			// TODO Auto-generated method stub
			_current = _headAndTail.getNext();
		}

		@Override
		public void last() {
			// TODO Auto-generated method stub
			_current = _headAndTail.getPrevious();
		}

		@Override
		public boolean isDone() {
			// TODO Auto-generated method stub
			return _current == _headAndTail;
		}

		@Override
		public void next() {
			// TODO Auto-generated method stub
			_current = _current.getNext();
		}

		@Override
		public void previous() {
			// TODO Auto-generated method stub
			_current = _current.getPrevious();
		}

		@Override
		public Object current() throws IteratorOutOfBoundException {
			// TODO Auto-generated method stub
			if(isDone()){
				throw new IteratorOutOfBoundException();
			}
			return _current.getValue();
		}
		
		
		
	}
	
	public Iterator iterator(){
		return new ValueIterator();
	}
	
	public int size(){
		return _size;
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}
	
	public void clear(){
		_headAndTail.setNext(_headAndTail);
		_headAndTail.setPrevious(_headAndTail);
		_size = 0;
	}
	
	
	private static final class Element{
		private Object _value;
		private Element _next;
		private Element _previous;
		
		
		public Element(Object value){
			setValue(value);
		}
		
		public void setValue(Object value){
			_value = value;
		}
		
		public Object getValue(){
			return _value;
		}
		
		public Element getPrevious(){
			return _previous;
		}
		
		public void setPrevious(Element previous){
			assert previous != null : "previous cant be null";
			_previous = previous;
		}
		
		public Element getNext(){
			return _next;
		}
		
		public void setNext(Element next){
			assert next != null : "next can not be null";
			_next = next;
		}
		
		public void attachBefore(Element ele){
			
			Element previous = ele.getPrevious();
			setNext(ele);
			setPrevious(previous);
			
			ele.setPrevious(this);
			previous.setNext(this);
			
		}
		
		public void detach(){
			
			_previous.setNext(_next);
			_next.setPrevious(_previous);
			
		}
		
		
	}

	@Override
	public Object set(int index, Object value) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		checkOutOfBounds(index);
		assert value != null: "Value can not be null";
		Object val = get(index);
		insert(index, value);
		
		return val;
	}

	
	
}
