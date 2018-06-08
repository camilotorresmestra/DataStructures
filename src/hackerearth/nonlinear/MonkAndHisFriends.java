package hackerearth.nonlinear;
import java.io.*;
import java.util.*;

import dataStructures.BinarySearchTree;

public class MonkAndHisFriends {
	public static void main(String args[]) throws IOException {
		//Initialization
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		BinarySearchTree BST = new BinarySearchTree();
		
		String[] S = br.readLine().split("");
		int T=Integer.parseInt(S[0]);
		for(int i=0;i<T;i++) {
			S = br.readLine().split(" ");
			int N = Integer.parseInt(S[0]);
			int M = Integer.parseInt(S[1]);
			S=br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				int index=Integer.parseInt(S[j]);
				BST.insert(index);
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
