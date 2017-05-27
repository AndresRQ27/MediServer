package tec.mediTEC.trees;

 
 public class SplayTree<T extends Comparable<T>>{
	 protected Node<T> root;
     private int count = 0;
 
     public Node<T> getRoot(){
 		return root;
 	}

     public SplayTree(){
    	 this.root=null;
     }
 
     //Esta vacio?
     public boolean isEmpty(){
         return root == null;
     }
 
     //Borrar
     public void clear(){
         root = null;
     }
 
     //Insertar en el árbol splay
     public void insert(T element){
    	
    	 
         Node<T> z = this.root;
         Node<T> p = null;
         while (z != null)
         {
             p = z;
             if (element.compareTo(p.getElement()) > 0)
                 z = z.getRight();
             else
                 z = z.getLeft();
         }
         z = new Node(0);
         z.setElement(element);
         z.setFather(p);
         if (p == null)
             root = z;
         else if (element.compareTo(p.getElement()) > 0)
             p.setRight(z);
         else
             p.setLeft(z);
         Splay(z);
         count++;

     }
     //Rotar en el árbol
     public void makeLeftChildParent(Node<T> c, Node<T> p)
     {
         if ((c == null) || (p == null) || (p.getLeft() != c) || (c.getFather() != p))
             throw new RuntimeException("WRONG");
 
         if (p.getFather() != null)
         {
             if (p == p.getFather().getLeft())
                 p.getFather().setLeft(c);
             else 
                 p.getFather().setRight(c);
         }
         if (c.getRight() != null)
             c.getRight().setFather(p);
 
         c.setFather(p.getFather());
         p.setFather(c);
         p.setLeft(c.getRight());
         c.setRight(p);
     }
 
     //Rotar en el árbol
     public void makeRightChildParent(Node<T> c, Node<T> p)
     {
         if ((c == null) || (p == null) || (p.getRight() != c) || (c.getFather() != p))
             throw new RuntimeException("WRONG");
         if (p.getFather() != null)
         {
             if (p == p.getFather().getLeft())
                 p.getFather().setLeft(c);
             else
                 p.getFather().setRight(c);
         }
         if (c.getLeft() != null)
             c.getLeft().setFather(p);
         c.setFather(p.getFather());
         p.setFather(c);
         p.setRight(c.getLeft());
         c.setLeft(p);
     }
 
     //Splay
     private void Splay(Node<T> x)
     {
         while (x.getFather() != null)
         {
             Node<T> Father = x.getFather();
             Node<T> GrandFather = Father.getFather();
             if (GrandFather == null)
             {
                 if (x == Father.getLeft())
                     makeLeftChildParent(x, Father);
                 else
                     makeRightChildParent(x, Father);                 
             } 
             else
             {
                 if (x == Father.getLeft())
                 {
                     if (Father == GrandFather.getLeft())
                     {
                         makeLeftChildParent(Father, GrandFather);
                         makeLeftChildParent(x, Father);
                     }
                     else 
                     {
                         makeLeftChildParent(x, x.getFather());
                         makeRightChildParent(x, x.getFather());
                     }
                 }
                 else 
                 {
                     if (Father == GrandFather.getLeft())
                     {
                         makeRightChildParent(x, x.getFather());
                         makeLeftChildParent(x, x.getFather());
                     } 
                     else 
                     {
                         makeRightChildParent(Father, GrandFather);
                         makeRightChildParent(x, Father);
                     }
                 }
             }
         }
         root = x;
     }
 
     //Eliminar elemento
     public void remove(T element)
     {
         Node<T> node = findNode(element);
         remove(node);
     }
 
     //Eliminar el nodo
     private void remove(Node<T> node)
     {
         if (node == null)
             return;
 
         Splay(node);
         if( (node.getLeft() != null) && (node.getRight() !=null))
         { 
             Node<T> min = node.getLeft();
             while(min.getRight()!=null)
                 min = min.getRight();
 
             min.setRight(node.getRight());
             node.getRight().setFather(min);
             node.getLeft().setFather(null);
             root = node.getLeft();
         }
         else if (node.getRight() != null)
         {
             node.getRight().setFather(null);
             root = node.getRight();
         } 
         else if( node.getLeft() !=null)
         {
             node.getLeft().setFather(null);
             root = node.getLeft();
         }
         else
         {
             root = null;
         }
         node.setFather(null);
         node.setLeft(null);
         node.setRight(null);
         node = null;
         count--;
     }
 
     //Contar nodos
     public int countNodes()
     {
         return count;
     }
 
     //Buscar elemento
     public boolean search(T val)
     {
         return findNode(val) != null;
     }
     private Node<T> findNode(T element)
     {
         Node<T> z = root;
         while (z != null)
         {
             if (element.compareTo(z.getElement()) > 0)
                 z = z.getRight();
             else if (element.compareTo(z.getElement()) < 0)
                 z = z.getLeft();
             else
                 return z;
         }
         return null;
     }
     
     public T searching(T val)
     {
         return findingNode(val);
     }
     private T findingNode(T element)
     {
         Node<T> z = root;
         while (z != null)
         {
             if (element.compareTo(z.getElement()) > 0)
                 z = z.getRight();
             else if (element.compareTo(z.getElement()) < 0)
                 z = z.getLeft();
             else
                 return z.getElement();
         }
         return null;
     }
 
     /** Function for inorder traversal **/ 
     
     public void inOrden(Node<T> r)
     {
         if (r != null)
         {
             inOrden(r.getLeft());
             System.out.print(r.getElement() +" , ");
             inOrden(r.getRight());
         }
     }
 
     /** Function for preorder traversal **/
     
     public void preOrden(Node<T> r)
     {
         if (r != null)
         {
             System.out.print(r.getElement() +" , ");
             preOrden(r.getLeft());             
             preOrden(r.getRight());
         }
     }
 
     /** Function for postorder traversal **/
     
     public void postOrden(Node<T> r)
     {
         if (r != null)
         {
             postOrden(r.getLeft());             
             postOrden(r.getRight());
             System.out.print(r.getElement() +" , ");
         }
     }     
 }
 
 