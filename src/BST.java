/* CS2401: MINILAB 7
* Due: by 11:59PM on Sunday April, 24
 * Where: on Gradescope
 * This minilab focuses on Binary Search Trees. 
 * You are expected to follow the definition given in class, in which we enforce that:
 * 		- all values less than or equal to (<=) the root's value will be stored 
 * 			in the tree's left subtree, 
 * 		- all values more than (>) the root's value will be stored in the tree's 
 * 			right subtree, and
 *  	- all subtrees are themselves Binary Search Trees.
 */


public class BST<T extends Comparable<T>> {
	// Attributes ******************************************************************
    private NodeBST<T> root;
    private int size;
    private int height;
    
    // Constructors ****************************************************************
    public BST() {}
    
    public BST(NodeBST<T> N) {
        root = N;
        size = N.size();
        height = N.height();
    }
    
    // Setters *********************************************************************
    public void setRoot(NodeBST<T> N) {
    	root = N;
    	size = N.size();
        height = N.height();
    }
    
    public void setRoot(T d) {
    	root = new NodeBST<T>(d);
    	size = root.size();
        height = root.height();
    }
    
    public void setSize(int n) {
    	size = n;
    }
    
    public void setHeight(int n) {
    	height = n;
    }
    
    // Getters *********************************************************************
    public NodeBST<T> getRoot() {
    	return root;
    }
    
    public int getSize() {
    	return size;
    }
    
    public int getHeight() {
    	return height;
    }

     /* This method returns tree to default where there is no root node,
      */
    public void delete() {
    	root = null;
    	size = 0;
    	height = -1;
    }
    
    /*
     * The insert method takes data of type d and inserts it into the current tree.
     */
    public void insert(T d) {
    	if (size == 0) {
    		setRoot(d);
    	} else {
            NodeBST<T> N = (NodeBST<T>) d;
            N.insert(d);
    	}
    }
    
    /*
     * The removeRoot method removes the root of the current tree and reorganizes 
     * the Binary Search Tree's elements so that when the method ends, the current
     * tree is a BST.
     */
    public void removeRoot() {
    	if (size == 0) {}
    	else if (size == 1) delete();
    	else root.removeRoot();
    }
}
