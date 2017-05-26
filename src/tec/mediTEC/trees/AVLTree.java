package tec.mediTEC.trees;

import java.util.*;

import tec.mediTEC.medicResources.cita;


public class AVLTree{
	//Nodo raiz del arbol.
    private Node<cita> root;
    //Comparador.
    Comparator<Integer> comparator;
    

    public AVLTree(){	
    }

    public AVLTree(Comparator<Integer> cmp){	
    	this.comparator = cmp;
    }

    //Insertar en el árbol
    public boolean insert(cita e) throws ClassCastException, NullPointerException, IllegalStateException{
    	Node<cita> node = new Node<cita>(e);
    	boolean exit = false;
    	boolean der = false;
    	Node<cita> tmpRoot = this.getRoot();

    	int leftHeight, rightHeight;

    	//no existía arbol
    	if(tmpRoot == null){
    		this.root = node;
    		return true;
    	}else
    	
    	//estaba ya en el arbol?
    	if(this.contains(node.getElement().getCodigo())){
    		return false;
    	}
    	
    	//no estaba antes en el arbol
    	else{    	
    		while(!exit){

    			//es mayor el nodo a insertar que la raiz?    				
		    	if(this.comparateElement(node.getElement().getCodigo(), tmpRoot.getElement().getCodigo())>0){
		    		if(tmpRoot.getRight()!=null){
		    			tmpRoot = tmpRoot.getRight();	
		    		}else{
		    			exit = true;
		    			der = true;
		    		}
		    			    		
		    	}
		    	//el nodo es menor que la raiz
		    	else{
		    		if(tmpRoot.getLeft()!=null){
		    			tmpRoot = tmpRoot.getLeft();
		    		}else{
		    			exit = true;
		    		}
		    	}
    		}
    		
    		//insertar a la derecha?
    		if(der){
    			tmpRoot.setRight(node);
    		}
    		
    		//insertar a la izquierda
    		else{
    			tmpRoot.setLeft(node);
    		}
	
    		//mientras no este equilibrado el arbol	miramos donde reestructurar
    		while(balanced(this.getRoot())<0){
				tmpRoot = father(tmpRoot);
    		
    			if(tmpRoot.getRight()==null){
	    			rightHeight = 0;
	    		}else{
	    			rightHeight = tmpRoot.getRight().getHeight();
	    		}
	    		
	    		if(tmpRoot.getLeft()==null){
	    			leftHeight = 0;
	    		}else{
	    			leftHeight = tmpRoot.getLeft().getHeight();
	    		}
	    		
    			Node<cita> change = estructure(tmpRoot, leftHeight, rightHeight);
    			Node<cita> superior = father(tmpRoot);
	
    			//si los nodos modificados tenian un padre anteriormente
    			if(comparateElement(superior.getElement().getCodigo(), tmpRoot.getElement().getCodigo())!=0){
    				if(superior.getLeft()!=null && comparateElement(superior.getLeft().getElement().getCodigo(), tmpRoot.getElement().getCodigo())==0){
	    				superior.setLeft(change);		
		    		}
		    		else if(superior.getRight()!=null && comparateElement(superior.getRight().getElement().getCodigo(), tmpRoot.getElement().getCodigo())==0){
	    				superior.setRight(change);
	    			}
    			}else{
    				this.root = change;
    			}
    		}
    		return true;
    	}
    }
    

    private Node<cita> estructure(Node<cita> node, int leftHeight, int rightHeight){
		if(extractBalanceF(node)==2){
			if( extractBalanceF(node.getRight() )==1  || extractBalanceF(node.getRight()) == 0){
				node = leftRotation(node);
			}
			
			else if(extractBalanceF(node.getRight() )==-1){
				node = rightComposedRotation(node);
			}
		}
		else if(extractBalanceF(node)==-2){
			if(extractBalanceF(node.getLeft() )==-1 || extractBalanceF(node.getRight())==0){
				node = rightRotation(node);
			}
			
			else if(extractBalanceF(node.getLeft())==1){
				node = leftComposedRotation(node);
			}
		}

		return node;	
    }
    
    //Extrae el Factor de Balance
    public int extractBalanceF(Node<cita> node){
    	if(node!=null){
    		return node.getBalanceF();
    	}else{
    		return 0;
    	}
    }

	//Rotación simple a la izquierda
    public Node<cita> leftRotation(Node<cita> node){
		Node<cita> nodoTmp = node;
    	node = nodoTmp.getRight(); 
		nodoTmp.setRight(node.getLeft());
		node.setLeft(nodoTmp);

		return node;
    }

	//Rotación simple a la derecha
    public Node<cita> rightRotation(Node<cita> node){
    	Node<cita> nodeTmp = node;
    	node = nodeTmp.getLeft();
		nodeTmp.setLeft(node.getRight());
		node.setRight(nodeTmp);

		return node;
    }

	//Rotación compuesta izquierda - derecha
    public Node<cita> leftComposedRotation(Node<cita> node){
    	Node<cita> nodeTmp = node; 
        nodeTmp = leftRotation(nodeTmp.getLeft()); 
		node.setLeft(nodeTmp);
		nodeTmp = rightRotation(node); 
		
		return nodeTmp;
    }

	//Rotación compuesta derecha - izquierda
    public Node<cita> rightComposedRotation(Node<cita> node){
    	Node<cita> nodeTmp = node;
        nodeTmp = rightRotation(nodeTmp.getRight());
		node.setRight(nodeTmp);
		nodeTmp= leftRotation(node);

		return nodeTmp;
    }

	//Indica si esta equilibrado, la altura si esta equilibrado, y -1 si no 
	public int balanced(Node<cita> n){
		int leftH = 0;
		int rightH = 0;
		
		if(n==null){
    		return 0;
    	}
    	
    	leftH = balanced(n.getLeft());
    	
    	if(leftH < 0){
    		return leftH;
    	}
    	
    	rightH = balanced(n.getRight());
    	
    	if(rightH <0){
    		return rightH;
    	}
    	
    	//si no es equilibrado
    	if(Math.abs(leftH - rightH)>1){
    		return -1;
    	}
    	
    	//si el trozo de arbol es AVL devolvemos la altura
    	return Math.max(leftH, rightH) + 1;
	}
	
	//Obtiene el nodo padre
	public Node<cita> father(Node<cita> nodo){
		Node<cita> tmpRoot = this.getRoot();
		Stack<Node<cita>> pila = new Stack<Node<cita>>();
    	pila.push(tmpRoot);	
    	while(tmpRoot.getRight()!=null || tmpRoot.getLeft()!=null){
	    	if(this.comparateElement(nodo.getElement().getCodigo(), tmpRoot.getElement().getCodigo())>0){
	    		if(tmpRoot.getRight()!=null){   	
	    			tmpRoot = tmpRoot.getRight();
	    		}
	    	}
	    	else if(this.comparateElement(nodo.getElement().getCodigo(), tmpRoot.getElement().getCodigo())<0){	
	    		if(tmpRoot.getLeft()!=null){   
		    		tmpRoot = tmpRoot.getLeft();
	    		}
	    	}
	    	if(this.comparateElement(nodo.getElement().getCodigo(), tmpRoot.getElement().getCodigo())==0){
	    		return pila.pop();
	    	}

	    	pila.push(tmpRoot);	
    	}
    	return pila.pop();
	}
	
	//Buscar en un árbol binario
		public boolean search(int element){
			return this.search(element, this.root);
		}

		private boolean search(int element, Node<cita> node){
			if (node==null){
				return false;
			} else if (element < node.getElement().getCodigo()){
				return search(element, node.getLeft());
			} else if (element > node.getElement().getCodigo()){
				return search(element, node.getRight());	
			} else{
				return true;
			}
		}
    
    
    //Buscar un nodo
    public boolean contains(Object o) throws ClassCastException, NullPointerException{
    	Node<cita> raizTmp = this.getRoot();
    	if(this.isEmpty()){
    		return false;
    	}
    	
    	//si es la raiz el buscado
    	if(this.comparateElement((int)o, raizTmp.getElement().getCodigo())==0){
	    	return true;
	    }
	    
    	while(raizTmp.getRight()!=null || raizTmp.getLeft()!=null){

	    	if(this.comparateElement((int)o, raizTmp.getElement().getCodigo())>0){
	    		if(raizTmp.getRight()!=null){   		
	    			raizTmp = raizTmp.getRight();
	    		}else{
	    			return false;
	    		}
	    	}else if(this.comparateElement((int)o, raizTmp.getElement().getCodigo())<0){	
	    		if(raizTmp.getLeft()!=null){   
		    		raizTmp = raizTmp.getLeft();
	    		}else{
	    			return false;
	    		}
	    	}
	    	
	    	if(this.comparateElement((int)o, raizTmp.getElement().getCodigo())==0){
	    		return true;
	    	}
    	}
    	return false;
    }
    
    
    //Si esta vacio es true
    public boolean isEmpty(){
    	return this.size()==0;

    }
    
    
    //Eliminar objeto en el árbol AVL
    public boolean remove(Object o) throws ClassCastException, NullPointerException{
    	Node<cita> borrar=null,mirar=null,change=null, nPadre = null;
    	Node<cita> tmpRoot = this.getRoot();
    	cita c_aux, d_aux;
    	boolean exit = false;
    	int rightHeight = 0;
    	int leftHeight = 0;
    	int a = 0;
    	
    	if(this.isEmpty()){
    		return false;
    	}

    	//el nodo a borrar es la raiz?
    	if(this.comparateElement((int)o, tmpRoot.getElement().getCodigo())==0){
	    	exit = true;
	    	borrar = tmpRoot;
	    }
    	
    	//si no es la raiz, lo buscamos
    	while(!exit && (tmpRoot.getRight()!=null || tmpRoot.getLeft()!=null)){

	    	if(this.comparateElement((int)o, tmpRoot.getElement().getCodigo())>0){
	    		if(tmpRoot.getRight()!=null){   		
	    			tmpRoot = tmpRoot.getRight();
	    		}else{
	    			return false;
	    		}
	    	}else if(this.comparateElement((int)o, tmpRoot.getElement().getCodigo())<0){
	    	
	    		if(tmpRoot.getLeft()!=null){   
		    		tmpRoot = tmpRoot.getLeft();
	    		}else{
	    			return false;
	    		}
	    	}
	    	
	    	if(this.comparateElement((int)o, tmpRoot.getElement().getCodigo())==0){
	    		exit = true;
	    		borrar = tmpRoot;
	    	}
    	}
    

    	//existe el nodo a borrar?
    	if(exit){
    		mirar = borrar;

	    	//es una hoja?
	    	if(borrar.getLeft()==null && borrar.getRight()==null){
	    		mirar= father(borrar);
	    		nPadre = father(borrar);
	    		
	    		//es un arbol raiz con solo un nodo raiz?
	    		if(this.size()==1){
	    			this.root = null;
	    		}
	    		
	    		if(nPadre.getLeft()!=null && comparateElement(nPadre.getLeft().getElement().getCodigo(), borrar.getElement().getCodigo())==0){
	    			nPadre.setLeft(null);
	    		}else if(nPadre.getRight()!=null && comparateElement(nPadre.getRight().getElement().getCodigo(), borrar.getElement().getCodigo())==0){
	    			nPadre.setRight(null);
	    		}
	    		//nos lo cargamos
	    		borrar.setElement(null);
	    	}
	    	
	    	//solo tiene un hijo? (o 2 pero en la misma altura) entonces la altura de ese subarbol será 1 o 2 (altura raiz = 1)
	    	else if(borrar.getHeight()<=2){

	    		if(borrar.getLeft()!=null){
	    			borrar.setElement(borrar.getLeft().getElement());
	    			borrar.setLeft(null);
	    		}
	    		
	    		else if(borrar.getRight()!=null){
	    			borrar.setElement(borrar.getRight().getElement());
	    			borrar.setRight(null);
	    		}
	    	}
	    	
	    	//cuando no es ni un hoja ni su padre. Es decir, está por medio del arbol.
	    	else{

	    		//buscamos el mayor de la izquierda
		    	if(borrar.getLeft()!=null){
		    		change = borrar.getLeft();
		    		
		    		while(change.getRight()!=null){
		    			change = change.getRight();
		    		}
		    	}
		    		
		    	//buscamos el menor de la derecha
		    	else if(borrar.getRight()!=null){
		    		change = change.getRight();
		    	
		    		while(change.getLeft()!=null){
		    			change = change.getLeft();
		    		}
		    	}
	    	
		    	c_aux = change.getElement();
		    	Node<cita> father = father(change);
		    	
		    	//si el nodo que hemos cambiado se ha quedado con algún hijo...
		    	if(change.getLeft()!=null || change.getRight()!=null){
			    	if(change.getLeft()!=null){
			    		change.setElement(change.getLeft().getElement());
			    		change.setLeft(null);
			    	}else if(change.getRight()!=null){
			    		change.setElement(change.getRight().getElement());
			    		change.setRight(null);
			    	}
		    	}
		    	//si no tiene hijos ya, lo eliminamos sin más
		    	else{		    	
			    	if(father.getLeft()!=null && comparateElement(father.getLeft().getElement().getCodigo(), change.getElement().getCodigo())==0){
			    		father.setLeft(null);
			    	}else{
			    		father.setRight(null);
			    	}
			    	change.setElement(borrar.getElement());
			    	borrar.setElement(c_aux);
		    	}		    
	    	}
	    	
	    	while(balanced(this.getRoot())<0){
    			if(mirar.getRight()==null){
	    			rightHeight = 0;
	    		}else{
	    			rightHeight = mirar.getRight().getHeight();
	    		}
	    		
	    		if(mirar.getLeft()==null){
	    			leftHeight = 0;
	    		}else{
	    			leftHeight = mirar.getLeft().getHeight();
	    		}
	    		
    			Node<cita> cambiar2 = estructure(mirar, leftHeight, rightHeight);
    			Node<cita> superior = father(mirar);
    			
    			//si los nodos modificados tenian un padre anteriormente
    			if(comparateElement(superior.getElement().getCodigo(), mirar.getElement().getCodigo())!=0){
    				if(superior.getLeft()!=null && comparateElement(superior.getLeft().getElement().getCodigo(), mirar.getElement().getCodigo())==0){
	    				superior.setLeft(cambiar2);		
		    		}
		    		else if(superior.getRight()!=null && comparateElement(superior.getRight().getElement().getCodigo(), mirar.getElement().getCodigo())==0){
	    				superior.setRight(cambiar2);
	    			}
    			}else{
    				this.root = cambiar2;
    			}
    			mirar = father(mirar);
    		}
    		return true;	    	
    	}	
    	return false;
    }
    
   	
    
    //Numero de nodos en el árbol AVL
    public int size(){
    	return this.preOrden().size();
    }

    //Imprime el árbol en orden
    public List<cita> inOrden(){
		List<cita> list = new ArrayList<cita>();
    	Node<cita> node = this.getRoot();  	
    	Stack<Node<cita>> pila = new Stack<Node<cita>>();
     	
     	while((node!=null &&node.getElement()!=null)|| !pila.empty()){
     		if(node!=null){
     			pila.push(node);
     			node = node.getLeft();
     		}else{
     			node = pila.pop();
     			list.add(node.getElement());
     			node = node.getRight();
     		}
     	} 	
    	
    	return list;
    }
    
    
    //Imprime en orden primero raíz, despues izquierda y despues derecha
    public List<cita> preOrden(){
    	List<cita> list = new ArrayList<cita>();
    	Node<cita> node = this.getRoot();  	
    	Stack<Node<cita>> pila = new Stack<Node<cita>>();

     	while((node!=null && node.getElement()!=null) || !pila.empty()){
     		if(node!=null){
     			list.add(node.getElement());
     			pila.push(node);
     			node = node.getLeft();
     		}else{
     			node = pila.pop();
     			node = node.getRight();
     		}
     	} 	
    	
    	return list;
    }
    

    //Imprime en orden primero izquierdo, despues derecho y despues raíz
    public List<cita> postOrden(){
    	List<cita> list = new ArrayList<cita>();
    	Node<cita> node = this.getRoot();  	
    	Stack<Node<cita>> pila1 = new Stack<Node<cita>>();
    	Stack<Boolean> pila2 = new Stack<Boolean>();
    	
    	while((node!=null && node.getElement()!=null) || !pila1.empty()){
    		
    		if(node!=null){
    			pila1.push(node);
    			pila2.push(true);
    			node = node.getLeft();
    		}else{
    			node = pila1.pop();
    			if(pila2.pop()){
    				pila1.push(node);
    				pila2.push(false);
    				node = node.getRight();
    			}else{
    				list.add(node.getElement());
    				node = null;
    			}
    		}
    	}
    	
    	return list;
    }
    
    //Devuelve la altura del nodo, sino esta en el árbol devuelve -1
    public int altura(Integer dato){
    	Node<cita> nodo = this.getNode(dato);
    	if(!this.contains(dato)){
    		return -1;
    	}
    	
    	return nodo.getHeight();
    }

    //Devuelve la profundidad del nodo, si no está en el árbol devurlve -1
    public int profundidad(cita element){
    	Node<cita> node = new Node<cita>(element);
    	int profundidad = 0;
    	while(comparateElement(node.getElement().getCodigo(), this.getRoot().getElement().getCodigo())!=0){
    		profundidad++;
    		node = father(node);
    	}
    	
    	return profundidad;
    }
    
    //Devuelve el nodo raíz del árbol
    public Node<cita> getRoot(){
    	return this.root;
    }
    
    //Devuelve el nodo del elemento ingresado
    public Node<cita> getNode(int dato){
     	Node<cita> tmpRoot = this.getRoot();
     	
     	if(this.isEmpty()){
     		return null;
     	}
    	
   		while(tmpRoot.getRight()!=null || tmpRoot.getLeft()!=null){

	    	if(this.comparateElement(dato, tmpRoot.getElement().getCodigo())>0){
	    		if(tmpRoot.getRight()!=null){   		
	    			tmpRoot = tmpRoot.getRight();
	    		}else{
	    			return null;
	    		}
	    	}else if(this.comparateElement(dato, tmpRoot.getElement().getCodigo())<0){	
	    		if(tmpRoot.getLeft()!=null){   
		    		tmpRoot = tmpRoot.getLeft();
	    		}else{
	    			return null;
	    		}
	    	}
	    	
	    	if(this.comparateElement(dato, tmpRoot.getElement().getCodigo())==0){
	    		return tmpRoot;
	    	}
    	}
    	
    	return tmpRoot;
    }
    
    //Devuleve el comparador que utiliza el árbol
    private Comparator<Integer> getComparator(){
    	return this.comparator;
    }
    
    //Extrae el dato de un nodo
    public cita extraeDato(Node<cita> node){
    	return node.getElement();
    }
    
    //Compara dos elementos
    private int comparateElement(Integer t1, Integer t2){
    	if(this.comparator==null){
    		return ((Comparable)t1).compareTo(t2);
    	}else{
    		return this.comparator.compare(t1,t2);
    	}
    }

}

