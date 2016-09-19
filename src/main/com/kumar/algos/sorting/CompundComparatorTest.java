package main.com.kumar.algos.sorting;

import junit.framework.TestCase;

public class CompundComparatorTest extends TestCase{

	public void testComparisonContinuesWhileEqual() {
		CompoundComparator comparator = new CompoundComparator();
		comparator.addComparator(new FixedComparator(0));
		comparator.addComparator(new FixedComparator(0));
		comparator.addComparator(new FixedComparator(0));
		assertTrue(comparator.compare("IGNORED", "IGNORED") == 0);
	}
	public void testComparisonStopsWhenLessThan() {
		CompoundComparator comparator = new CompoundComparator();
		comparator.addComparator(new FixedComparator(0));
		comparator.addComparator(new FixedComparator(0));
		comparator.addComparator(new FixedComparator(-57));
		comparator.addComparator(new FixedComparator(91));
		assertTrue(comparator.compare("IGNORED", "IGNORED") < 0);
	}
	public void testComparisonStopsWhenGreaterThan() {
		CompoundComparator comparator = new CompoundComparator();
		comparator.addComparator(new FixedComparator(0));
		comparator.addComparator(new FixedComparator(0));
		comparator.addComparator(new FixedComparator(91));
		comparator.addComparator(new FixedComparator(-57));
		assertTrue(comparator.compare("IGNORED", "IGNORED") > 0);
	}

}
