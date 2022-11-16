/* CS2401: MINILAB 6
 * Due: by 11:59PM on Sunday April, 17
 * Where: on Gradescope
 */


public class NodeBT<T> {

	/* Attributes ******************************************************************
	 */
    private T data;
    private NodeBT<T> left;
    private NodeBT<T> right;
    
    // Constructors ****************************************************************  
    public NodeBT(T d) {
        data = d;
        left = null;
        right = null;
    }
    public NodeBT (){}
    
    // Setters *********************************************************************
    public void setData(T d) {
        data = d;   
    }
    
    /* */
    public void setLeft(NodeBT<T> L) {
        left = L;
    }
    
    public void setLeft(T d) {
        left = new NodeBT<T>(d);
    }
    
    /**/
    public void setRight(NodeBT<T> R) {
        right = R;
    }
    
    public void setRight(T d) {
        right = new NodeBT<T>(d);
    }
    
    // Getters **********************************************************************
    public T getData() {
        return data;   
    }
    
    public NodeBT<T> getLeft() {
        return left;   
    }
    
    public NodeBT<T> getRight() {
        return right;   
    }
    
    // Other methods ***************************************************************

    /** printNode prints the content of the current node
     */
    public void printNode() {
        System.out.println(data.toString());   
    }
    
    /** implementation of the toString method for objects of type NodeBT
     */ 
    public String toString() {
    	return data.toString();
    }

    /** hasLeft returns true if the current node (this) has a non null left attribute
     */
    public boolean hasLeft() {
       return (left != null);
    }
    
    /* Method, hasRight, returns true if the current node (this) has a non null
	 * right child; false otherwise. 
	 */
    public boolean hasRight() {
        return (right != null);
    }

   /*
    * Method height computes the height of the current node (this) 
    */
    public int height() {
        if ( !hasLeft() && !hasRight() ) return 0;
        if ( hasLeft() && hasRight() )
            return 1 + Math.max(left.height(), right.height());
        if(hasLeft())
            return 1 + left.height();
        else
            return 1 + right.height();

    }
    
    /*
     * Method size computes the number of nodes that are part of the subtree
     * originating at the current node (this), including this current node. 
     */
    public int size() {
    	if (this.hasLeft() && this.hasRight())
    		return 1 + left.size() + right.size();
    	if (this.hasLeft())
            return 1 + left.size();
    	if (this.hasRight()) {
            return 1 + right.size();
        }
		return 1;
    }
    
    /* GIVEN TO YOU: Do not modify
     * Method preOrder returns a string that is the concatenation of all
     * toString content of each nodeBT in a pre-order fashion as seen in class.
     */
    public String preOrder() {
    	String result = toString();
    	if (hasLeft()) 
    		result += ", " + left.preOrder();
    	if (hasRight())
    		result += ", " + right.preOrder();
    	return result;
    }
 
    /* Problem 4: [20 pts]
     * Method postOrder returns a string that is the concatenation of all
     * toString content of each nodeBT in a post-order fashion as seen in class.
     *                 4
     *               /   \
     *              2     6
     *             / \   / \
     *            1   3 5   7
     * 
     * The output should be the string "1, 3, 2, 5, 7, 6, 4" (not including the quotes)
     */
    public String postOrder() {
        String result = "";
        //if(this.getData() == null) return result;
        if(hasLeft())
            result += left.postOrder() + ", ";
        if(hasRight())
            result += right.postOrder() + ", ";
        return result += data;
    }

    //return string of tree in inOrder fashion
    public String inOrder(){
        String result = "";
        if(getLeft().hasLeft())
            result += left.inOrder();
        else result += data;
        if(getRight().hasRight())
            result += right.inOrder();
        return result+= data;
    }
 
    /*
     * Method shortestPathToLeaf return the smallest number of edges for the 
     * current node (this) to a leaf.
     */
    public int shortestPathToLeaf(){
        if(hasRight() && hasLeft())
            return 1 + Math.min( right.shortestPathToLeaf(), left.shortestPathToLeaf() );
        if(hasRight())
            return 1 + right.shortestPathToLeaf();
        if(hasLeft())
            return 1 + left.shortestPathToLeaf();
        return 0;
    }
    

}
