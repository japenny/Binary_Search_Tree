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



public class NodeBST<T extends Comparable<T>> extends NodeBT<T> {

	
	/* CONSTRUCTORS *******************************************************/
	public NodeBST() {super();}
	
	public NodeBST(T d) {
		super(d);
	}
	
	/* METHODS ************************************************************/
	/* Problem 1: 
	 * Method insert takes data d to be inserted (added) to the tree.
	 */
	public void insert(T d) {
		if (d.compareTo(this.getData()) <= 0) {
			if (!hasLeft())
				setLeft(new NodeBST<>(d) ) ;
			else {
				((NodeBST<T>) this.getLeft()).insert(d);
			}
		}
		else {
			if (!hasRight()) setRight(new NodeBST<>(d) );
			else {
				((NodeBST<T>) this.getRight()).insert(d);
			}
		}
	}
	
	/* Problem 2: 
	 * Method removeRoot removes the current node from the tree rooted in it.
	 * It rearranges the tree (the nodes connected to the current node) in such a way that 
	 * the new current node (this) is still the root of a Binary Search Tree. 
	 */

	public void removeRoot() {
		if(!this.hasLeft() && !this.hasRight()){this.setData(null);return;}

		if (!this.hasLeft()) {
			if (hasRight()){
				this.setData(this.getRight().getData());
				this.setLeft(this.getRight().getLeft());
				this.setRight(this.getRight().getRight());
			}
		}
		else if(!this.hasRight()){
			this.setData(this.getLeft().getData());
			this.setRight(this.getLeft().getRight());
			this.setLeft(this.getLeft().getLeft());

		}
		else {
			NodeBST<T> findSucc = (NodeBST<T>) this.getLeft();

			if(findSucc.hasRight()) {
				while (findSucc.getRight().getRight() != null)
					findSucc = (NodeBST<T>) findSucc.getRight();

				if(findSucc.getRight().hasLeft()){
					this.setData(findSucc.getRight().getData());
					findSucc.setRight(findSucc.getRight().getLeft());

				}
				else this.setData( findSucc.getData());
			}
			else{
				this.setData(findSucc.getData());
				this.setLeft(findSucc.getLeft());
			}



		}

	}
}
