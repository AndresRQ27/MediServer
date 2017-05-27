package tec.mediTEC.trees;

public class Node<T> {
	private T element;
	private int balanceF;
	private Node<T> left;
	private Node<T> right;
	
	
	public Node(T element){
		this(element, null, null);
	}
	private Node(T element, Node<T> left, Node<T> right){
		this.element = element;
		this.balanceF = 0;
		this.right = right;
		this.left = left;
		
	}
	//Gets
	public Node<T> getLeft(){
		return left;
	}

	public Node<T> getRight(){
		return right;
	}

	public T getElement(){
		return element;
	}
	
	
	public void setGetElement(T getElement) {
		this.element = getElement;
	}
	//Sets
	public void setRight(Node<T> right){
		this.right = right;
	}
	

	public void setLeft(Node<T> left){
		this.left = left;
	}
	

	public void setElement(T element){
		this.element = element;
	}
	
	
	public void setBalanceF(int bf){
		this.balanceF = bf;
	}

	public int getBalanceF(){
		int rightHeight = 0;
		int leftHeight = 0;
		if(this.getRight()!=null){
	    	rightHeight = this.getRight().getHeight();
	   	}
	   	if(this.getLeft()!=null){		    
	   		leftHeight = this.getLeft().getHeight();
	   	}
		return (rightHeight - leftHeight);
	}
	
	public int getHeight(){
		int leftH = 0;
		int rightH = 0;
		
		if(this.getElement()==null){
		  return 0;
    	}


		if(this.getLeft()!=null){	
			leftH = this.getLeft().getHeight();
		}else{
			leftH = 0;
		}
    	
    	if(this.getRight()!=null){   
    		rightH = this.getRight().getHeight();
    	}else{
    		rightH = 0;
    	}
    	return Math.max(leftH, rightH) + 1;
	}

}