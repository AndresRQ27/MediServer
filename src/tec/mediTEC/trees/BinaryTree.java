package tec.mediTEC.trees;

import tec.mediTEC.medicResources.casoClinico;

public class BinaryTree {
	protected Node<casoClinico> root;
	
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
	
	public Node<casoClinico> getRoot() {
		return root;
	}

	public void setRoot(Node<casoClinico> root) {
		this.root = root;
	}

	//Raiz
	public Node<casoClinico> obtenerRoot(){
		return root;
	}
	
	//Insertar en un árbol binario
	public void insert(casoClinico element){
		this.root = this.insert(element, this.root);
	}
	private Node<casoClinico> insert(casoClinico element, Node<casoClinico> current){
		if (current == null){
			return new Node<casoClinico>(element);
		} else if (element.getCodigo() < current.getElement().getCodigo()){
			current.setLeft( this.insert(element, current.getLeft()));
		}else if (element.getCodigo() > current.getElement().getCodigo()){
			current.setRight(this.insert(element, current.getRight()));
		}
		return current;
	}
	
	
	//Buscar en un árbol binario
	public casoClinico search(int id){
		return this.search(id, this.root);
	}
	private casoClinico search(int id, Node<casoClinico> node){
		if (node==null){
			return null;
		} else if (id < node.getElement().getCodigo()){
			return search(id, node.getLeft());
		} else if (id > node.getElement().getCodigo()){
			return search(id, node.getRight());	
		} else{
			return node.getElement();
		}
	}
	
	//Buscar menor
	public Node<casoClinico> findMin(){
		return findMin(this.root);
	}
	private Node<casoClinico> findMin(Node<casoClinico> node){
		if(node == null){
			return null;
		} else if (node.getLeft() == null){
			return node;
		} else {
			return findMin(node.getLeft());
		}
	}

	//Eliminar en un árbol binario
	public void remove(int element){
		this.root = remove(element, this.root);
	}
	private Node<casoClinico> remove(int element, Node<casoClinico> node){
		if (node == null){
			return node;
		} else if (element < node.getElement().getCodigo()){
			node.setLeft(remove(element,node.getLeft()));
		} else if (element > node.getElement().getCodigo()) {
			node.setRight(remove(element, node.getRight()));
		} else if (node.getLeft() != null && node.getRight() != null){
			node.setElement(findMin(node.getRight()).getElement());
			node.setRight(remove(node.getElement().getCodigo(), node.getRight()));
		} else{
			node = node.getLeft() != null ? node.getLeft(): node.getRight();	
		}
		return node;
	}
	
	//métodos para probar el arbol
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
	}
}

