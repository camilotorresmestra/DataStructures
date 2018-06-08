package urijugde.linear;

import java.io.*;
import java.util.*;

class Node {
    
	  int value;
	  Node next = null;
	  
	  public Node(int value)
	  {
	      
	      this.value = value;
	      
	  }
	  public String toString()
	  {
	      return "Value: " + this.value + "\n"; 
	  }
	  public Node clone()
	  {
	      Node temp = new Node(this.value);
	      return temp;
	  }
	    
	}

class Queue {
	Node head = null;
	Node tail = null;
	int size = 0;
	double total = 0;
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void enqueue(Node newNode) {
		if(this.isEmpty()) {
			head=newNode;
			tail=newNode;
		}else {
			tail.next=newNode;
			tail=newNode;
		}
		size++;
		total +=newNode.value;
		
	}
	
	public Node dequeue() {
		Node dequeue= head;
		head=dequeue.next;
		size--;
		total -=dequeue.value;
		return dequeue;
	}
	
}

public class Problem1110 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			Queue cards = new Queue();
			while(true) {
				int n = sc.nextInt();
				if(n==0) break;
				for(int i=0;i<n;i++) {
					cards.enqueue(new Node(i+1));
				}
				bw.write("Discarted cards: ");
				while(cards.size>1) {
					Node t = cards.dequeue();
					bw.write(Integer.toString(t.value));
					if(cards.size!=1) bw.write(", ");
					cards.enqueue(cards.dequeue());
				}
				
				if(cards.size==1) {
					bw.write("\nRemaining card: "+Integer.toString(cards.dequeue().value)+"\n");
				}
			}
			sc.close();
			bw.flush();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
