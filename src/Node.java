/******************************************************************************
	 * In this file, you are asked to implement a few methods for Linked lists
	 * as generic containers (where the data type is T and is not specified until 
	 * declaration).
	 *  
	 * For each METHOD you are asked to implement, here are the rubrics:
	 * 	- 13 pts for a correct body of the method
	 * 	- 12 pts for testing the method using JUnit test cases:
	 * 		3 pts per test case; 4 test cases per method
	 * 		Your JUnit test cases should be written in a file called NodeTester.java.
	 ******************************************************************************/

public class Node<T> {

	// Attributes *****************************************************************
    private T data;
    private Node<T> next;
    
    // Constructors ****************************************************************
    public Node() {}
    
    public Node(T d) {
        data = d;
        next = null;
    }
    
    // Setters *********************************************************************
    public void setData(T d) {
        data = d;   
    }
    
    public void setNext(Node<T> N) {
        next = N;
    }

    // Getters **********************************************************************
    public T getData() {return data;}
    
    public Node<T> getNext() {
        return next;   
    }
    
    // Other methods ***************************************************************
    public int sizeFromNode() {
        Node<T> iter = this;
        int size = 0;
        while (iter != null) {
            size++;
            iter = iter.getNext();
        }
        return size;
    }
    
    public void printNode() {
        System.out.println(data.toString());
    }
    
    /* METHOD 1 called toString
     * This method prints the content of the current node, as well as
     * the following node, in order of the links, from head to tail
     * THIS METHOD MUST BE RECURSIVE
     */
    public String toString() {
        Node<T> curr = this;

        if(curr.getNext() != null){
            return curr.getData() + " " + curr.getNext().toString();
        }
        else{
            return curr.getData() + "";
        }

    }
    
    /* METHOD 2 called addTail
     * This method takes data of type T and adds a node at the end
     * of the sequence starting with the current node
     * THIS METHOD MUST BE RECURSIVE
     */
    public void addTail(T data){
        Node<T> curr = this;

        if(curr.getData() == null){
            curr.setData(data);
            return;
        }
        if(curr.getNext() == null){
            curr.setNext(new Node(data) );
        }
        else{
            curr.getNext().addTail(data);
        }

    }
    
    /* METHOD 3 called removeTail
     * This method removes the last node in the sequence starting
     * at the current node
     */
    public void removeTail() {
        Node<T> curr = this;

        if(curr.getNext() == null){
            curr.setData(null);
            return;
        }
        if(curr.getNext().getNext() == null){
            curr.setNext(null);
        }
        else{
            curr.getNext().removeTail();
        }

    }

    //exam 9am question 1
    public int appear(Node<String> bob, String str){

        if(bob == null){
            return 0;
        }
        else{
            if(bob.getData().equals(str)){
                return 1 + appear(bob.getNext(), str);
            }
            else{
                return 0 + appear(bob.getNext(), str);

            }

        }

    }



    //addhead to thing
    public void addHead(T d){
        Node<T> curr = new Node(d);

        if(curr == null){
            curr.setData(data);
            curr.setNext(null);
        }
        else{
            curr.setNext(this);
            Node<T> temp = curr;
            System.out.println(temp);
        }
    }

    public void removeHead(){
        Node<T> curr = this;

        //if(curr == null) return;

    }


    /* METHOD 4 called toStringReverse
     * This method prints the content of list that starts at the current node,
     * in reverse order of the links, from tail to head
     * THIS METHOD MUST BE RECURSIVE
     */
    public String toStringReverse() {
        Node<T> curr = this;

        if(curr.getNext() != null){
            return curr.getNext().toStringReverse() + " " + curr.getData();
        }
        else{
            return curr.getData() + "";
        }

    }


}
































