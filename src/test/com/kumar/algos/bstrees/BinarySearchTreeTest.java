package test.com.kumar.algos.bstrees;

import main.com.kumar.algos.bstrees.Node;
import main.com.kumar.algos.sorting.NaturalComparator;
import junit.framework.TestCase;

public class BinarySearchTreeTest extends TestCase{

	private Node _a;
	private Node _d;
	private Node _f;
	private Node _h;
	private Node _i;
	private Node _k;
	private Node _l;
	private Node _m;
	private Node _p;

	private Node _root;
	private BinarySearchTree _tree;
	protected void setUp() throws Exception {
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
		_root = _i;
		_tree = new BinarySearchTree(NaturalComparator.NATCOMPARATOR);
		_tree.insert(_i.getValue());
		_tree.insert(_d.getValue());
		_tree.insert(_l.getValue());
		_tree.insert(_a.getValue());
		_tree.insert(_f.getValue());
		_tree.insert(_k.getValue());
		_tree.insert(_m.getValue());
		_tree.insert(_h.getValue());
		_tree.insert(_p.getValue());
	}
	public void testInsert() {
		assertEquals(_root, _tree.getRoot());
	}
	public void testSearch() {
		assertEquals(_a, _tree.search(_a.getValue()));
		assertEquals(_d, _tree.search(_d.getValue()));
		assertEquals(_f, _tree.search(_f.getValue()));
		assertEquals(_h, _tree.search(_h.getValue()));
		assertEquals(_i, _tree.search(_i.getValue()));
		assertEquals(_k, _tree.search(_k.getValue()));
		assertEquals(_l, _tree.search(_l.getValue()));
		assertEquals(_m, _tree.search(_m.getValue()));
		assertEquals(_p, _tree.search(_p.getValue()));
		assertNull(_tree.search("UNKNOWN"));
	}
	public void testDeleteLeafNode() {
		Node deleted = _tree.delete(_h.getValue());
		assertNotNull(deleted);
		assertEquals(_h.getValue(), deleted.getValue());
		_f.setLarger(null);
		assertEquals(_root, _tree.getRoot());
	}

	public void testDeleteNodeWithOneChild() {
		Node deleted = _tree.delete(_m.getValue());
		assertNotNull(deleted);
		assertEquals(_m.getValue(), deleted.getValue());
		_l.setLarger(_p);
		assertEquals(_root, _tree.getRoot());
	}
	public void testDeleteNodeWithTwoChildren() {
		Node deleted = _tree.delete(_i.getValue());
		assertNotNull(deleted);
		assertEquals(_i.getValue(), deleted.getValue());
		_i.setValue(_k.getValue());
		_l.setSmaller(null);
		assertEquals(_root, _tree.getRoot());
	}
	public void testDeleteRootNodeUntilTreeIsEmpty() {
		while (_tree.getRoot() != null) {
			Object key = _tree.getRoot().getValue();
			Node deleted = _tree.delete(key);
			assertNotNull(deleted);
			assertEquals(key, deleted.getValue());
		}
	}

}
