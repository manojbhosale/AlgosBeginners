package com.asl.algos;

import java.util.Comparator;

public class TreeDriver {
	
	public static void main(String[] args) {
		//System.out.println("manoj");
		
		Comparator<Integer> intCompare = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				return o1.compareTo(o2);
			}
			
		};
		
		Comparator<String> strCompare = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				return o1.compareTo(o2);
			}
			
		};
		
		BinaryTree bt = new BinaryTree(strCompare);
		
		bt.addNode("A");
		bt.addNode("F");
		bt.addNode("P");
		bt.addNode("D");
		bt.addNode("H");
		bt.addNode("K");
		bt.addNode("M");
		bt.addNode("G");
		bt.addNode("L");
		bt.addNode("I");
		
		
		BinaryTree.inorder(bt.getRoot());
		System.out.println();
		BinaryTree.preorder(bt.getRoot());
		System.out.println();
		BinaryTree.postorder(bt.getRoot());
		System.out.println();
		System.out.println(bt.search("K"));
		
		
	}

	
	
	
}
