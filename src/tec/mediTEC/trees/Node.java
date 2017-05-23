package tec.mediTEC.trees;

public class Node<T> {
	private T element;
	private int bf;
	private Node<T> left;
	private Node<T> right;
	
	public Node(T element){
		this(element, null, null);
	}
	
	private Node(T element, Node<T> left, Node<T> right){
		this.element = element;
		this.bf = 0;
		this.right = right;
		this.left = left;
		
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public int getBf() {
		return bf;
	}

	public void setBf(int bf) {
		this.bf = bf;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}	
}