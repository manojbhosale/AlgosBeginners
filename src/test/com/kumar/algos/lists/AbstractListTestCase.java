package test.com.kumar.algos.lists;

import main.com.kumar.algos.iterationandrecursion.Iterator;
import main.com.kumar.algos.iterationandrecursion.IteratorOutOfBoundException;
import main.com.kumar.algos.lists.List;
import junit.framework.TestCase;

public abstract class AbstractListTestCase extends TestCase{

	protected static final Object VALUE_A = "A";
	protected static final Object VALUE_B = "B";
	protected static final Object VALUE_C = "C";

	protected abstract List createList();

	public void testInsertIntoEmptyList(){

		List list = createList();
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

		list.insert(0, VALUE_A);

		assertEquals(1, list.size());
		assertFalse(list.isEmpty());
		assertSame(VALUE_A, list.get(0));

	}

	public void testInsertBetweenElements(){

		List list = createList();

		list.insert(0, VALUE_A);
		list.insert(1, VALUE_B);
		list.insert(1, VALUE_C);

		assertEquals(3, list.size());

		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_B, list.get(2));
		assertSame(VALUE_C, list.get(1));
	}

	public void testInsertBeforFirstElement(){
		List list = createList();

		list.insert(0, VALUE_A);
		list.insert(0, VALUE_B);

		assertEquals(2, list.size());

		assertSame(VALUE_A, list.get(1));
		assertSame(VALUE_B, list.get(0));
	}

	public void testInsertAfterLastElement(){

		List list = createList();

		list.insert(0, VALUE_A);
		list.insert(1, VALUE_B);

		assertEquals(2, list.size());

		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_B, list.get(1));
	}

	public void testInsertOutOfBounds(){

		List list = createList();

		try{
			list.insert(-1, VALUE_A);
			fail();
		}catch(IndexOutOfBoundsException e){
			//expected
		}

		try{
			list.insert(1, VALUE_A);
			fail();
		}catch(IndexOutOfBoundsException e){
			//expected
		}

	}

	public void testAdd(){

		List list = createList();

		list.add(VALUE_A);
		list.add(VALUE_C);
		list.add(VALUE_B);

		assertEquals(3, list.size());

		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_C, list.get(1));
		assertSame(VALUE_B, list.get(2));


	}

	public void testSet(){
		List list = createList();
		list.insert(0, VALUE_A);
		assertSame(VALUE_A, list.get(0));

		assertSame(VALUE_A, list.set(0, VALUE_B));
		assertSame(VALUE_B, list.get(0));

	}

	public void getOutOfBounds(){
		List list = createList();

		try{
			list.get(-1);
			fail();
		}catch(IndexOutOfBoundsException e){
			//expected
		}

		try{
			list.get(0);
			fail();
		}catch(IndexOutOfBoundsException e){
			//expected
		}

		list.add(VALUE_A);
		try{
			list.get(1);
			fail();
		}catch(IndexOutOfBoundsException e){
			//expected
		}


	}


	public void testSetOutOfBounds(){

		/*		List list = createList();

		try{
			list.set(-1, VALUE_A);
			fail();
		}catch(IndexOutOfBoundsException e){
			//expected
		}

		try{
			list.set(1, VALUE_B);
			fail();
		}catch(IndexOutOfBoundsException e){
			//expected
		}

		list.add(VALUE_A);

		try{
			list.set(1, VALUE_A);
			fail();
		}catch(IndexOutOfBoundsException e){
			//expected
		}*/
		List list = createList();
		try {
			list.set(-1, VALUE_A);
			fail();
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		try {
			list.set(1, VALUE_B);
			fail();
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
		list.insert(0, VALUE_C);
		try {
			list.set(2, VALUE_C);
			fail();
		} catch (IndexOutOfBoundsException e) {
			// expected
		}
	}

	public void testDeletionOnlyElement(){
		List list = createList();

		assertEquals(0, list.size());

		list.insert(0,VALUE_A);

		assertEquals(1, list.size());

		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_A,list.delete(0));

		assertEquals(0, list.size());

	}

	public void deleteFirstElement(){

		List list = createList();

		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);

		assertEquals(3, list.size());

		assertSame(VALUE_A, list.delete(0));
		assertSame(VALUE_B, list.get(0));
		assertSame(VALUE_C, list.get(1));

		assertEquals(2, list.size());

		assertSame(VALUE_B, list.delete(0));
		assertSame(VALUE_C, list.get(0));

		assertEquals(1, list.size());

		assertSame(VALUE_C, list.delete(0));

		assertTrue(list.isEmpty());

	}

	public void testDeleteLastElement(){

		List list = createList();

		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);

		assertEquals(3, list.size());

		assertSame(VALUE_C, list.delete(2));
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_B, list.get(1));

		assertEquals(2, list.size());

		assertSame(VALUE_B, list.delete(1));
		assertSame(VALUE_A, list.get(0));

		assertEquals(1, list.size());

		assertSame(VALUE_A, list.delete(0));

		assertTrue(list.isEmpty());

	}

	public void testDeleteBetweenTwoElement(){

		List list = createList();

		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);

		assertEquals(3, list.size());

		assertSame(VALUE_B, list.delete(1));
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_C, list.get(1));

		assertEquals(2, list.size());


	}

	public void testDeleteOutOfBounds(){
		List list = createList();

		try{
			list.delete(-1);
			fail();
		}catch(IndexOutOfBoundsException e){

			//expected

		}

		try{
			list.delete(0);
			fail();
		}catch(IndexOutOfBoundsException e){

			//expected

		}


	}

	public void testDeleteByValue(){

		List list = createList();

		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_A);



		assertEquals(3, list.size());
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_B, list.get(1));
		assertSame(VALUE_A, list.get(2));


		assertTrue(list.delete(VALUE_A));

		assertEquals(2, list.size());

		assertSame(VALUE_B, list.get(0));
		assertSame(VALUE_A, list.get(1));


		assertTrue(list.delete(VALUE_A));

		assertEquals(1, list.size());		
		assertSame(VALUE_B, list.get(0));

		assertFalse(list.delete(VALUE_C));

		assertEquals(1, list.size());		
		assertSame(VALUE_B, list.get(0));

		assertTrue(list.delete(VALUE_B));

		assertEquals(0, list.size());


	}


	public void testEmptyIteration(){
		List list = createList();

		Iterator iterator = list.iterator();

		assertTrue(iterator.isDone());

		try{
			iterator.current();
			fail();
		}catch(IteratorOutOfBoundException e){
			//expected
		}
	}

	public void testForwardIteration() {
		List list = createList();
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);
		Iterator iterator = list.iterator();
		iterator.first();
		assertFalse(iterator.isDone());
		assertSame(VALUE_A, iterator.current());
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(VALUE_B, iterator.current());
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(VALUE_C, iterator.current());
		iterator.next();
		assertTrue(iterator.isDone());
		try {
			iterator.current();
			fail();
		} catch (IteratorOutOfBoundException e) {

			// expected
		}
	}

	public void testIndexOf() {
		List list = createList();
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_A);
		assertEquals(0, list.indexOf(VALUE_A));
		assertEquals(1, list.indexOf(VALUE_B));
		assertEquals(-1, list.indexOf(VALUE_C));
	}

	public void testContains() {
		List list = createList();
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_A);
		assertTrue(list.contains(VALUE_A));
		assertTrue(list.contains(VALUE_B));
		assertFalse(list.contains(VALUE_C));
	}

	public void testClear() {
		List list = createList();
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);
		assertFalse(list.isEmpty());
		assertEquals(3, list.size());
		list.clear();
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}
}
