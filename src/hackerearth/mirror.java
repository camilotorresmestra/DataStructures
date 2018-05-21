package hackerearth;

import java.util.Scanner;
import java.io.*;

class TreeNode{
	TreeNode left,right,parent;
	int value;
	String route="";
	
	public TreeNode(int value) {
		this.value=value;
		this.right=null;
		this.left=null;
	}
	
	public void setRight(TreeNode n) {
		this.right=n;
		n.route=this.route.concat("R");
	}
	
	public void setLeft(TreeNode n) {
		this.left=n;
		n.route=this.route.concat("L");
	}
	
	public String toString() {
		return Integer.toString(this.value).concat("\n");
	}
}

class BinaryTree{
	TreeNode root;
	TreeNode[] nodes = new TreeNode[1001];
	
	public BinaryTree() {
		this.root= new TreeNode(1);
		this.nodes[1]=this.root;
	}
	
	public void insert(TreeNode r, TreeNode n, char d) {
		if(d=='R') r.setRight(n);
		else if(d=='L') r.setLeft(n);
		this.nodes[n.value]=n;
	}
	
	public TreeNode searchMirror(String s, TreeNode n) {
		if(s.length()!=0) {
			char d = s.charAt(0);
			if(d=='R') {
				if(n.left!=null)
					return searchMirror(s.substring(1, s.length()),n.left);
				else
					return null;
			}		
			else if(d=='L') {
				if(n.right!=null)
					return searchMirror(s.substring(1,s.length()),n.right);
				else
					return null;
			}
		}
		return n;
	}
	
	
}

public class mirror {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		BinaryTree T = new BinaryTree();
		int N = sc.nextInt()-1;
		int Q = sc.nextInt();
		for(int i=0;i<N;i++) {
			int p = sc.nextInt();
			int c = sc.nextInt();
			char d = sc.nextLine().charAt(1);
			T.insert(T.nodes[p], new TreeNode(c), d);			
		}
		for(int i=0;i<Q;i++) {
			int q = sc.nextInt();
			TreeNode m = T.searchMirror(T.nodes[q].route, T.root);
			if(m!=null) bw.write(m.toString());
			else bw.write("-1\n");
		}
		bw.flush();
		sc.close();
	}
}
