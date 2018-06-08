package hackerearth.nonlinear;
import java.io.*;
import dataStructures.BinarySearchTree;
public class MonkWatchingFight {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BinarySearchTree BST= new BinarySearchTree();
		String[] S = br.readLine().split(" ");
		int N = Integer.parseInt(S[0]);
		//Creates an Array to Store the elements
		S=br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			int n=Integer.parseInt(S[i]);
			BST.insert(n);
		}
		
		System.out.println(BST.getHeight()+1);
	}
}