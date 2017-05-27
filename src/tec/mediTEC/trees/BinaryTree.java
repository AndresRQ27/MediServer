package tec.mediTEC.trees;


public class BinaryTree<T extends Comparable<T>>{
	protected Node<T> root;
	
	//Constructor
	public BinaryTree(){
		this.root=null;
	}
	
	public boolean isEmpty(){
		if(root == null){
			return true;
		}else{
			return false;
		}
	}
	
	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}
	
	//Insertar en un árbol binario
	public void insert(T element){
		this.root = this.insert(element, this.root);
	}
	private Node<T> insert(T element, Node<T> current){
		if (current == null){
			return new Node<T>(element);
		} else if (element.compareTo(current.getElement())<0){
			current.setLeft( this.insert(element, current.getLeft()));
		}else if (element.compareTo(current.getElement())>0){
			current.setRight(this.insert(element, current.getRight()));
		}
		return current;
	}
	
	
	//Buscar en un árbol binario
	public T search(T id){
		return this.search(id, this.root);
	}
	private T search(T id, Node<T> node){
		if (node==null){
			return null;
		} else if (id.compareTo(node.getElement())<0){
			return search(id, node.getLeft());
		} else if (id.compareTo(node.getElement())>0){
			return search(id, node.getRight());	
		} else{
			return node.getElement();
		}
	}
	
	//Buscar menor
	public Node<T> findMin(){
		return findMin(this.root);
	}
	private Node<T> findMin(Node<T> node){
		if(node == null){
			return null;
		} else if (node.getLeft() == null){
			return node;
		} else {
			return findMin(node.getLeft());
		}
	}

	//Eliminar en un árbol binario
	public void remove(T element){
		this.root = remove(element, this.root);
	}
	private Node<T> remove(T element, Node<T> node){
		if (node == null){
			return node;
		} else if (element.compareTo(node.getElement()) < 0){
			node.setLeft(remove(element,node.getLeft()));
		} else if (element.compareTo(node.getElement()) > 0) {
			node.setRight(remove(element, node.getRight()));
		} else if (node.getLeft() != null && node.getRight() != null){
			node.setElement(findMin(node.getRight()).getElement());
			node.setRight(remove(node.getElement(), node.getRight()));
		} else{
			node = node.getLeft() != null ? node.getLeft(): node.getRight();	
		}
		return node;
	}
	
	/*//métodos para probar el arbol
	public void inOrden(Node<casoClinico> n){
		if (n != null){
			inOrden (n.getLeft());
			System.out.println(n.getElement() + ", ");
			inOrden(n.getRight());
		}
	}
	//Método para recorrer el árbol PreOrden
	public void preOrden(Node<Integer> n){
		if (n != null){
			System.out.println(n.getElement() + ", ");
			preOrden (n.getLeft());
			preOrden (n.getRight());
		}
	}
	//Método para recorrer el árbol PostOrden
	public void postOrden(Node<Integer> n){
		if (n != null){
			postOrden(n.getLeft());
			postOrden(n.getRight());
			System.out.println(n.getElement() + ", ");
		}
	}*/
}

