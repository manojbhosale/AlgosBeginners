package test.com.kumar.algos.stacks;

import main.com.kumar.algos.stacks.ListStack;
import main.com.kumar.algos.stacks.Stack;

public class ListStackTest extends AbstractStackTestCase{

	@Override
	protected Stack createStack() {
		// TODO Auto-generated method stub
		return new ListStack();
	}

}
