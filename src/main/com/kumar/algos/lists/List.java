package main.com.kumar.algos.lists;

import main.com.kumar.algos.iterationandrecursion.Iterable;;

public interface List extends Iterable{
	public void insert(int index, Object value) throws IndexOutOfBoundsException;
	public void add(Object value);
	public Object delete(int index);
	public boolean delete(Object o);
	public void clear();
	public Object set(int index, Object o) throws IndexOutOfBoundsException;
	public Object get(int index) throws IndexOutOfBoundsException;
	public int indexOf(Object o);
	public boolean contains(Object o);
	public int size();
	public boolean isEmpty();
	
}
