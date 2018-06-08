package dataStructures;


public class BinarySearchTree extends BinaryTree{
	/**
	 * The height of the Tree. Represents the distance between the root ad the furthest child.
	 */
	int height=0;
	
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * Inserts a Node and updates the height of the BinarySearchTree. Overrides insert from BinaryTree.
	 */
	public void insert(int i) {
		BinaryTree.Node n = new BinaryTree.Node(i);
		int level = this.insert(this.root, n);
		height = (level>height)? level:height;
	}
	
	/**
     * This method recursively inserts a Node and calculates the depth of the insertion.
     * @param r
     * @param n
     * @return the level of the insertion
     * @author jucat
     */
    public int insert(Node r,Node n) {
    	if(this.isEmpty()) {
			this.root=n;
		}
		else {
			if(n.value>r.value)
				if(r.right==null) {
					r.right=n;
					return 1;
				}else {
					return 1+insert(r.right,n);
				}
				
			else if(n.value<r.value)
				if(r.left==null){
					r.left=n;
					return 1;
				}else {
					return 1+insert(r.left,n);
				}
		}
		return 0;
    }
    /**
     * Performs recursively a Binary Search
     * @param r
     * @param i
     * @return the element or <code>null</code> if this tree does not contain it
     * @author jucat
     */
    
    public Node binarySearch(Node r,int i) {
		if(i>r.value && r.right!=null) 
			return binarySearch(r.right,i);
		else if(i<r.value && r.left!=null)
			return binarySearch(r.left,i);
		else if(i==r.value)
			return r;
		else
			return null;
    }
    

    /**
     * Checks if an element is contained in this Tree.
     * @param i The index of the element
     */
    public boolean contains(int i) {
		return binarySearch(this.root,i)!=null;
	}
    
}