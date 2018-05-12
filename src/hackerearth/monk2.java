package hackerearth;
import java.util.*;
import java.io.*;
class Node {
	int power;
	int position;
	Node next = null;

	public Node(int pow, int pos)
	{
		this.power = pow;
		this.position=pos;
	}
	
	public String toString() {
		return Integer.toString(this.position)+" ";
	}
	
	public boolean equals(Node n) {
		return (this.position==n.position)?(this.power==n.power):false; 
		
	}
}

class Queue {
	Node head = null;
	Node tail = null;
	int size = 0;

	
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
		tail.next=null;
		size++;
		
	}
	
	public Node dequeue() {
		Node dequeue= head;
		head=dequeue.next;
		dequeue.next=null;
		size--;
		
		return dequeue;
	}
	
}

public class monk2 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			Queue spiders = new Queue();

			int N = sc.nextInt();
			int X = sc.nextInt();

			for(int i=0;i<N;i++) {
				spiders.enqueue(new Node(sc.nextInt(),i+1));
			}
			sc.close();
			
			for(int i=0;i<X;i++) {
				Queue removedSpiders = new Queue(); 
				Node maxnode = spiders.dequeue();
				removedSpiders.enqueue(maxnode);
				for(int j=1;j<X;j++) {
					//https://www.youtube.com/watch?v=1vuv8gF8rw0
					if(!spiders.isEmpty()) {
						Node temp = spiders.dequeue();
						maxnode=(temp.power>maxnode.power)?temp:maxnode;
						removedSpiders.enqueue(temp);
					}
				}
				for(int j=0;j<X;j++) {
					if(!removedSpiders.isEmpty()) {
						Node temp = removedSpiders.dequeue();
						if(temp.equals(maxnode)) 
							bw.write(temp.toString());
						else {
							if(temp.power!=0) temp.power--;
							spiders.enqueue(temp);
						}
					}
				}
			}
		
			//test case: 
		
			
			bw.flush();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
