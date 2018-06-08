package hackerearth;
import java.io.*;
class BTNode{
	int value;
	BTNode right,left;
	int level;
	
	
	public BTNode(int value) {
		this.value=value;
	}
}

class BinarySearchTree{
	BTNode root;
	int h=0;
	public boolean isEmpty() {
		return this.root==null;
	}
	
	public int insert(BTNode r,BTNode n) {
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
	
	public void checkHeight(int insertH) {
		if(insertH>this.h) this.h=insertH;
	}
}

public class monkFight {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BinarySearchTree BST= new BinarySearchTree();
		String[] S = br.readLine().split(" ");
		int N = Integer.parseInt(S[0]);
		S=br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			int n=Integer.parseInt(S[i]);
			int h = BST.insert(BST.root, new BTNode(n));
			BST.checkHeight(h);
		}
		
		System.out.println(BST.h+1);
	}
	

}
