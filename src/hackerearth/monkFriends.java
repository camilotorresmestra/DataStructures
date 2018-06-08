package hackerearth;
import java.io.*;
import java.util.*;

class BSTNode{
	int value;
	BSTNode right,left;
	
	
	public BSTNode(int value) {
		this.value=value;
	}
}

class BSTree{
	BSTNode root;
	public boolean isEmpty() {
		return this.root==null;
	}
	
	public void insert(BSTNode r,BSTNode n) {
		if(this.isEmpty()) {
			this.root=n;
		}
		else {
			if(n.value>r.value)
				if(r.right==null) {
					r.right=n;
					
				}else {
					insert(r.right,n);
				}
				
			else if(n.value<r.value)
				if(r.left==null){
					r.left=n;
					
				}else {
					insert(r.left,n);
				}
		}
	}
	
	public BSTNode binarySearch(BSTNode r,int i) {
		if(i>r.value && r.right!=null) 
			return binarySearch(r.right,i);
		else if(i<r.value && r.left!=null)
			return binarySearch(r.left,i);
		else if(i==r.value)
			return r;
		else
			return null;
		
	}
	
	public boolean contains(int i) {
		return binarySearch(this.root,i)!=null;
	}
}

public class monkFriends {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		BSTree BST = new BSTree();
		String[] S = br.readLine().split("");
		int T=Integer.parseInt(S[0]);
		for(int i=0;i<T;i++) {
			S = br.readLine().split(" ");
			int N = Integer.parseInt(S[0]);
			int M = Integer.parseInt(S[1]);
			S=br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				int index=Integer.parseInt(S[j]);
				BST.insert(BST.root, new BSTNode(index));
			}
			for(int j=0;j<M;j++) {
				if(BST.contains(Integer.parseInt(S[j+N])))
					bw.write("YES\n");
				else 
					bw.write("NO\n");
			}

		}
		bw.flush();
		sc.close();
	}
}
