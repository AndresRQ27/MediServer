package tec.mediTEC.trees;
import javax.swing.JOptionPane;



public class Node<T> {
	//CasoClínico caso;
	private T Element;
	private int balanceF;
	private Node<T> left;
	private Node<T> right;
	private Node<T> father;
	
	
	public Node(T element){
		this(element, null, null, null);
	}
	private Node(T element, Node<T> left, Node<T> right, Node<T> father){
		this.Element = element;
		this.balanceF = 0;
		this.right = right;
		this.left = left;
		this.father = father;
		
	}
	//Gets
	public Node<T> getLeft(){
		return left;
	}

	public Node<T> getRight(){
		return right;
	}
	
	public Node<T> getFather(){
		return father;
	}
	public T getElement(){
		return Element;
	}
	
	
	
	//Sets
	public void setRight(Node<T> right){
		this.right = right;
	}
	

	public void setLeft(Node<T> left){
		this.left = left;
	}
	
	public void setFather(Node<T> father){
		this.father = father;
	}
	
	public void setElement(T element){
		this.Element = element;
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
	
	
	

	public static void main(String[] args){
		
		BinaryTree<Integer> tree = new BinaryTree();
		
		tree.insert(10);
		tree.insert(5);
		tree.insert(13);
		tree.insert(1);
		tree.insert(6);
		tree.insert(17);
		tree.insert(16);
		//tree.remove(10);
		//tree.remove(5);
		//tree.remove(6);
		System.out.println(tree.route(17));
		
		tree.postOrden(tree.getRoot()); //Binario
		//tree.postOrden(tree.getRoot()); //Splay
		//System.out.println(tree.postOrden()); //AVL
		
		
	
	}		

}