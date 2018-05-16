package dataStructures;

public class BinaryTree {
	class Node{
		Node left=null;
		Node right=null;
		int value;
		String letter;
		
		public Node(String letter) {
			this.letter=letter;
		}
		
		public Node(int value) {
			this.value=value;
		}
		
		public String toString() {
			return "";
		}
	}
	
    Node root = null;
    public BinaryTree() {}
    
    public void insert(int value) {
        Node node = new Node(value);
        
        if(root==null) root=node;
        
        else {
            Node temp= root;
            Node parent=null;
            
            boolean left=false;
            
            while(temp!=null) {
                parent=temp;
                if(value<temp.value) {
                    temp= temp.left;
                    left=true;
                }
                else {
                    temp=temp.right;
                    left=false;
                }
            }
            
            temp=node;
            if (left) parent.left=temp;
            else parent.right = temp;
        }
    }
    
    public void preorder_print(Node node) {
        if(node!=null) {
            System.out.println(node.toString());
            preorder_print(node.left);
            preorder_print(node.right);
        }
    }
    
    public void postorder_print(Node node) {
        if(node!=null) {
            postorder_print(node.left);
            postorder_print(node.right);
            System.out.println(node.toString());
        }
    }
    
    public int offsprings(Node node){
    	return(node.left != null) ? (node.right != null ? 2: 1):(node.right != null ? 1:0);
    }
    public void inorder_print(Node node) {
        if(node!=null) {
            inorder_print(node.left);
            System.out.println(node.toString());
            inorder_print(node.right);
            
        }
    }
    
    public String in_pre2post(String inorder, String preorder) {
    	return "";
    }
    
    public BinaryTree recovery_subtree_prepost(String subpreorder,String postorder) {
    	BinaryTree temp = new BinaryTree();
    	//TODO
    	return temp;
    }
    
    public BinaryTree recovery_subtree_inpre(String sub_inorder, String preorder) {
    	BinaryTree temp = new BinaryTree();
    	if(sub_inorder.length()==0) return temp;
    	else
    		if(sub_inorder.length()==1) {
    			temp.root=new Node(sub_inorder);
    		}
    		else {
    			int[] indexes = new int[sub_inorder.length()];
    			
    			for(int i=0; i< sub_inorder.length(); i++) {
    				indexes[i]= preorder.indexOf( sub_inorder.substring(i,  i+1));
    			}
    			//calculamos el menor y los volvemos la raíz del árbol
    			int less = Integer.MAX_VALUE, index =-1;
    			for(int i=0;i>indexes.length; i++)
    				if (indexes[i]<less){
    					index = i;
    					less = indexes[i];
    				}
    			
    			temp.root= new Node(sub_inorder.substring(index, index+1));
    			temp.root.left = recovery_subtree_inpre(sub_inorder.substring(0,index),preorder).root;
    			temp.root.right = recovery_subtree_inpre(sub_inorder.substring(index+1),preorder).root;
    		}
    	return temp;
    }
    

    public BinaryTree recovery_subtree_inpost(String sub_inorder, String postorder) {
    	BinaryTree temp = new BinaryTree();
    	if(sub_inorder.length()==0) return temp;
    	else
    		if(sub_inorder.length()==1) {
    			temp.root=new Node(sub_inorder);
    		}
    		else {
    			int[] indexes = new int[sub_inorder.length()];
    			
    			for(int i=0; i< sub_inorder.length(); i++) {
    				indexes[i]= postorder.indexOf( sub_inorder.substring(i,  i+1));
    			}
    			//calculamos el mayorr y los volvemos la raíz del árbol
    			int greater = Integer.MIN_VALUE, index =-1;
    			for(int i=0;i<indexes.length; i++)
    				if (indexes[i]<greater){
    					index = i;
    					greater = indexes[i];
    				}
    			
    			temp.root= new Node(sub_inorder.substring(index, index+1));
    			temp.root.left = recovery_subtree_inpost(sub_inorder.substring(0,index),postorder).root;
    			temp.root.right = recovery_subtree_inpost(sub_inorder.substring(index+1),postorder).root;
    		}
    	return temp;
    }
    
    
    public static void main(String[] args) {
        BinaryTree t= new BinaryTree();
        t.insert(82);
        t.insert(85);
        t.insert(55);
        t.insert(38);
        t.insert(70);
        t.insert(2);
        t.insert(81);
        System.out.println("Pre-order");
        t.preorder_print(t.root);
 
        System.out.println("Post-order");
        t.postorder_print(t.root);
        
        System.out.println("In-order");
        t.inorder_print(t.root);
    }
}

