package main.com.kumar.algos.lists;


import main.com.kumar.algos.iterationandrecursion.ArrayIterator;
import main.com.kumar.algos.iterationandrecursion.Iterator;


public class ArrayList implements List{

	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	private final int _initialCapacity;
	private Object[] _array;
	private int _size;


	public ArrayList(){
		this(DEFAULT_INITIAL_CAPACITY);
	}

	public ArrayList(int initialCapacity){
		assert initialCapacity > 0: "initial capacity must be > 0";

		_initialCapacity = initialCapacity; 
		clear();
	}
	
	public ArrayList(Object[] arr){
		
		_initialCapacity = arr.length;
		_array = arr;
				
	}



	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		Iterator it = new ArrayIterator(_array, 0, _size);
		return it;
	}

	@Override
	public void insert(int index, Object value)
			throws IndexOutOfBoundsException {
		assert value != null: "value cant be null";

		if(index < 0 || index > _size){
			throw new IndexOutOfBoundsException();
		}

		ensureCapacity(_size+1);
		System.arraycopy(_array, index, _array, index+1, _size - index);
		_array[index] = value;
		++_size;
	}

	public void ensureCapacity(int capacity){
		assert capacity > 0 : "capacity must be > 0";
		if(_array.length < capacity){
			Object[] copy =  new Object[capacity +capacity /2];
			System.arraycopy(_array, 0, copy, 0, _size);
			_array = copy;
		}
	}

	@Override
	public void add(Object value) {
		// TODO Auto-generated method stub
		insert(_size,value);
	}

	@Override
	public Object delete(int index) {
		// TODO Auto-generated method stub
		checkOutOfBounds(index);

		Object value = _array[index];
		int copyFromIndex = index + 1;
		if (copyFromIndex < _size) {
			System.arraycopy(_array, copyFromIndex,
					_array, index,
					_size - copyFromIndex);
		}

		_array[--_size] = null;
		return value;
	}

	@Override
	public boolean delete(Object value) {
		// TODO Auto-generated method stub

		int index = indexOf(value);
		if (index != -1) {
			delete(index);
			return true;
		}
		return false;



	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		_array = new Object[_initialCapacity];
		_size = 0;
	}

	@Override
	public Object set(int index, Object value) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		assert value != null : "value can’t be null";
		checkOutOfBounds(index);
		Object oldValue = _array[index];
		_array[index] = value;
		return oldValue;


	}

	private void checkOutOfBounds(int index){
		if(isOutOfBounds(index)){
			throw new IndexOutOfBoundsException();
		}
	}

	private boolean isOutOfBounds(int index){
		return index < 0 || index > _size;
	}

	@Override
	public Object get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		checkOutOfBounds(index);
		return _array[index];
	}

	@Override
	public int indexOf(Object value) {		
		// TODO Auto-generated method stub
		assert value != null : "value can’t be null";
		for (int i = 0; i < _size; ++i) {
			if (value.equals(_array[i])) {
				return i;
			}
		}
		return -1;

	}

	@Override
	public boolean contains(Object value) {
		// TODO Auto-generated method stub
		return indexOf(value) != -1;


	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return _size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0;
	}



}
