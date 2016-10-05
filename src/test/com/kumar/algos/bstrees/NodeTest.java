package test.com.kumar.algos.bstrees;

import main.com.kumar.algos.bstrees.Node;
import junit.framework.TestCase;

public class NodeTest extends TestCase{

	private Node _a;
	private Node _d;
	private Node _f;
	private Node _h;
	private Node _i;
	private Node _k;
	private Node _l;
	private Node _m;
	private Node _p;

	protected void setUp()throws Exception{

		super.setUp();

		_a = new Node("A");
		_h = new Node("H");
		_k = new Node("K");
		_p = new Node("P");
		_f = new Node("F", null, _h);
		_m = new Node("M", null, _p);
		_d = new Node("D", _a, _f);
		_l = new Node("L", _k, _m);
		_i = new Node("I", _d, _l);


	}

	public void testMinimum(){

		assertSame(_a, _a.getMinimum());
		assertSame(_a, _d.getMinimum());
		assertSame(_f, _f.getMinimum());
		assertSame(_h, _h.getMinimum());
		assertSame(_a, _i.getMinimum());
		assertSame(_k, _k.getMinimum());
		assertSame(_k, _l.getMinimum());
		assertSame(_m, _m.getMinimum());
		assertSame(_p, _p.getMinimum());
	}

	public void testMaximum(){
		assertSame(_a, _a.getMaximum());
		assertSame(_h, _d.getMaximum());
		assertSame(_h, _f.getMaximum());
		assertSame(_h, _h.getMaximum());
		assertSame(_p, _i.getMaximum());
		assertSame(_k, _k.getMaximum());
		assertSame(_p, _l.getMaximum());
		assertSame(_p, _m.getMaximum());
		assertSame(_p, _p.getMaximum());
	}

	public void testSuccessor() {
		assertSame(_d, _a.successor());
		assertSame(_f, _d.successor());
		assertSame(_h, _f.successor());
		assertSame(_i, _h.successor());
		assertSame(_k, _i.successor());
		assertSame(_l, _k.successor());
		assertSame(_m, _l.successor());
		assertSame(_p, _m.successor());
		assertNull(_p.successor());
	}

	public void testIsSmaller() {
		assertTrue(_a.isSmaller());
		assertTrue(_d.isSmaller());
		assertFalse(_f.isSmaller());
		assertFalse(_h.isSmaller());
		assertFalse(_i.isSmaller());
		assertTrue(_k.isSmaller());
		assertFalse(_l.isSmaller());
		assertFalse(_m.isSmaller());
		assertFalse(_p.isSmaller());
	}

	public void testPredecessor() {
		assertNull(_a.predecessor());
		assertSame(_a, _d.predecessor());
		assertSame(_d, _f.predecessor());
		assertSame(_f, _h.predecessor());
		assertSame(_h, _i.predecessor());
		assertSame(_i, _k.predecessor());
		assertSame(_k, _l.predecessor());
		assertSame(_l, _m.predecessor());
		assertSame(_m, _p.predecessor());
	}

	public void testIsLarger() {
		assertFalse(_a.isLarger());
		assertFalse(_d.isLarger());
		assertTrue(_f.isLarger());
		assertTrue(_h.isLarger());
		assertFalse(_i.isLarger());
		assertFalse(_k.isLarger());
		assertTrue(_l.isLarger());
		assertTrue(_m.isLarger());
		assertTrue(_p.isLarger());
	}

	public void testSize() {
		assertEquals(1, _a.size());
		assertEquals(4, _d.size());
		assertEquals(2, _f.size());
		assertEquals(1, _h.size());
		assertEquals(9, _i.size());
		assertEquals(1, _k.size());
		assertEquals(4, _l.size());
		assertEquals(2, _m.size());
		assertEquals(1, _p.size());
	}
	
	public void testEquals() {
		Node a = new Node("A");
		Node h = new Node("H");
		Node k = new Node("K");
		Node p = new Node("P");
		Node f = new Node("F", null, h);
		Node m = new Node("M", null, p);
		Node d = new Node("D", a, f);
		Node l = new Node("L", k, m);
		Node i = new Node("I", d, l);
		assertEquals(a, _a);
		assertEquals(d, _d);
		assertEquals(f, _f);
		assertEquals(h, _h);
		assertEquals(i, _i);
		assertEquals(k, _k);
		assertEquals(l, _l);
		assertEquals(m, _m);
		assertEquals(p, _p);
		assertFalse(_i.equals(null));
		assertFalse(_f.equals(_d));
	}


}
