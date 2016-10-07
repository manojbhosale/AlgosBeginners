package com.asl.algos;

import java.util.Comparator;

public class BinaryTree {

	private Node root;
	private Comparator comparator;

	public BinaryTree(Comparator cmp) {
		root = new Node(); 
		comparator = cmp;
	} 

	public Node getRoot(){
		return root;
	}

	public void addNode(Object value){
		Node newNode = new Node(value);
		if(root.getValue() != null){
			addNodeRecursive(root, newNode);
			return;
		}
		root.setValue(value);
	}

	public void addNodeRecursive(Node rootNode, Node newNode){

		if(comparator.compare(rootNode.getValue(), newNode.getValue()) > 0){
			if(rootNode.getLeftNode() != null){
				addNodeRecursive(rootNode.getLeftNode(), newNode);	
			}else{
				rootNode.setLeftNode(newNode);
				newNode.setParentNode(rootNode);
			}
		}else if(comparator.compare(rootNode.getValue(), newNode.getValue()) < 0){
			if(rootNode.getRightNode() != null){
				addNodeRecursive(rootNode.getRightNode(), newNode);
			}else{
				rootNode.setRightNode(newNode);
				newNode.setParentNode(rootNode);
			}
		}else{
			return;
		}	
	}

	public static void inorder(Node node){

		if(node.getLeftNode() == null && node.getRightNode() == null){
			System.out.println(node.getValue());
			return;
		}

		if(node.getLeftNode() != null)
			inorder(node.getLeftNode());

		System.out.println(node.getValue());

		if(node.getRightNode() != null)
			inorder(node.getRightNode());

	}

	public static void preorder(Node node){

		if(node.getLeftNode() == null && node.getRightNode() == null){
			System.out.println(node.getValue());
			return;
		}

		System.out.println(node.getValue());

		if(node.getLeftNode() != null)
			preorder(node.getLeftNode());

		if(node.getRightNode() != null)
			preorder(node.getRightNode());


	}

	public static void postorder(Node node){

		if(node.getLeftNode() == null && node.getRightNode() == null){
			System.out.println(node.getValue());
			return;
		}


		if(node.getLeftNode() != null)
			postorder(node.getLeftNode());

		if(node.getRightNode() != null)
			postorder(node.getRightNode());

		System.out.println(node.getValue());


	}

	public Node search(Object value){

		if(value == null){
			return new Node();
		}

		Node n = searchTree(root,value);

		return n;

	}

	private Node searchTree(Node tempRoot, Object searchKey){

		if(tempRoot == null){
			return null;
		}

		int cmp = comparator.compare(tempRoot.getValue(), searchKey);
		Node res;
		if(cmp > 0){
			res = searchTree(tempRoot.getLeftNode(), searchKey);
		}else if(cmp < 0){
			res = searchTree(tempRoot.getRightNode(), searchKey);
		}else if(cmp == 0){
			res = tempRoot;
		}else{
			return null;
		}

		return res;

	}


	public void delete(Object value){

		Node searched = this.search(value);


		//check for leaf node
		if(searched.getLeftNode() == null && searched.getRightNode() == null){
			//check for left child
			if(comparator.compare(searched.getParentNode().getLeftNode().getValue(), searched.getValue()) == 0){
				searched.getParentNode().setLeftNode(null);
			}
			//check for right child
			if(comparator.compare(searched.getParentNode().getRightNode().getValue(), searched.getValue()) == 0){
				searched.getParentNode().setRightNode(null);
			}
		}else if(searched.getLeftNode() == null){
			//check for left child
			if(comparator.compare(searched.getParentNode().getLeftNode().getValue(), searched.getValue()) == 0){
				searched.getParentNode().setLeftNode(searched.getRightNode());
			}
			//check for right child
			if(comparator.compare(searched.getParentNode().getRightNode().getValue(), searched.getValue()) == 0){
				searched.getParentNode().setRightNode(searched.getRightNode());
			}

		}else if(searched.getRightNode() == null){

			//check for left child
			if(comparator.compare(searched.getParentNode().getLeftNode().getValue(), searched.getValue()) == 0){
				searched.getParentNode().setLeftNode(searched.getLeftNode());
			}
			//check for right child
			if(comparator.compare(searched.getParentNode().getRightNode().getValue(), searched.getValue()) == 0){
				searched.getParentNode().setRightNode(searched.getLeftNode());
			}

		}else{
			
			
			
		}

	}
	
}
