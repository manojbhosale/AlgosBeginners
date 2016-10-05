package main.com.kumar.algos.bstrees;

public class Node implements Cloneable{

	private Object _value;
	private Node _parent;
	private Node _smaller;
	private Node _larger;

	public Node(Object value){
		this(value, null, null);
	}

	public Node(Object value, Node smaller, Node larger){

		setValue(value);
		setSmaller(smaller);
		setLarger(larger);


		if(smaller != null){
			smaller.setParent(this);
		}

		if(larger != null){
			larger.setParent(this);
		}

	}

	public Object getValue(){
		return _value;
	}

	public void setValue(Object value){
		assert value != null: "value can't be null";
		_value = value;
	}

	public Node getParent(){
		return _parent;
	}
	public void setParent(Node parent){
		_parent = parent;
	}

	public Node getSmaller(){
		return _smaller;
	}

	public void setSmaller(Node smaller){
		assert smaller != getLarger() : "Smaller cant be same as larger !!";
		_smaller = smaller;
	}

	public Node getLarger(){
		return _larger;
	}

	public void setLarger(Node larger){

		assert larger != getSmaller() :"larger cant be the same as the smaller !!";
		_larger = larger;
	}

	public boolean isSmaller(){

		return getParent() != null && this == getParent().getSmaller();

	}

	public boolean isLarger(){

		return getParent() != null && this == getParent().getLarger();

	}

	public Node getMinimum(){

		Node node = this;

		while(node.getSmaller() !=  null){
			node = node.getSmaller();
		}

		return node;
	}

	public Node getMaximum(){
		Node node = this;

		while(node.getLarger() !=  null){
			node = node.getLarger();
		}

		return node;

	}
/*
	public Node succesor(){

		Node node = this;
		Node successor = this;
		if(node.getLarger() != null)
			node.getLarger().getMinimum();

		while(node.getParent() != null){
			if(node.isSmaller()){
				successor = node.getParent();
				break;
			}
			node = node.getParent();
		}
		return successor;

	}

*/
	
	public Node successor(){
		
		if(getLarger() != null)
			return getLarger().getMinimum();
		
		Node node = this;
		
		while(node.isLarger()){
			node = node.getParent();
		}
		
		return node.getParent();
	}
	
	public Node predecessor(){
		
		if(getSmaller() != null)
			return getSmaller().getMaximum();
		
		Node node = this;
		
		while(node.isSmaller()){
			
			node = node.getParent();
			
		}
		return node.getParent();
		
	}
	
	public boolean equals(Object object){
		
		if(this == object)
			return true;
		
		if(object == null || this.getClass() != object.getClass())
			return false;
		
		Node other = (Node)object;
		
		return getValue().equals(other.getValue()) && 
				equalsSmaller(other.getSmaller()) &&
				equalsLarger(other.getLarger());
		
	}
	
	private boolean equalsSmaller(Node other){
		
		return getSmaller() == null && other == null || getSmaller() != null && getSmaller().equals(other); 
		
	}
	
	private boolean equalsLarger(Node other){
		
		return getLarger() == null && other == null || getLarger() != null && getLarger().equals(other);
		
	}
	
	public int size(){
		return size(this);
	}
	
	public int size(Node node){
		
			if(node == null)
				return 0;
		
			return 1 + size(node.getSmaller()) + size(node.getLarger());
	}

}
