package dataStructures;

public class Queue {
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
	
	public void reverse() {
		Stack reverse = new Stack();
		while(!this.isEmpty()) {
			reverse.push(this.dequeue());
		}
		while(!reverse.isEmpty()) {
			this.enqueue(reverse.pop());
		}
	}
}
