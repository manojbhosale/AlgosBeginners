package test.com.kumar.algos.lists;

import main.com.kumar.algos.lists.ArrayList;
import main.com.kumar.algos.lists.LinkedList;
import main.com.kumar.algos.lists.List;



public class LinkedListTest extends AbstractListTestCase{
	public void testResizeBeyondInitialCapacity() {
		List list = new ArrayList(1);
		list.add(VALUE_A);
		list.add(VALUE_A);
		list.add(VALUE_A);
		assertEquals(3, list.size());
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_A, list.get(1));
		assertSame(VALUE_A, list.get(2)); }

	public void testDeleteFromLastElementInArray() {
		List list = new ArrayList(1);
		list.add(new Object());
		list.delete(0);
	}
	@Override
	protected List createList() {
		// TODO Auto-generated method stub
		return new LinkedList();
	}

	
	
}
