package main.com.kumar.algos.sorting;

import java.util.Comparator;

import junit.framework.TestCase;

public class TestReverseComparator extends TestCase{
	


	public void testLessThanBecomesGreaterThan(){
		ReverseComparator comparator = new ReverseComparator(NaturalComparator.NATCOMPARATOR);
		
		assertTrue(comparator.compare("A", "B") > 0);	
	}

	public void testGreaterThanBecomesLessThan(){
		ReverseComparator comparator = new ReverseComparator(NaturalComparator.NATCOMPARATOR);
		assertTrue(comparator.compare("B", "A") < 0);
	}

	public void testEqualsRemainsEquals(){
		ReverseComparator comparator = new ReverseComparator(NaturalComparator.NATCOMPARATOR);
		assertTrue(comparator.compare("A","A") == 0);
	}

}
