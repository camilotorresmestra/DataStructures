package dataStructures;
import dataStructures.Queue;

public class Stack {
    Node head = null;
    public double total=0;
    public int size=0;
    
    public boolean isEmpty()
    {
        return head == null ? true : false;
    }
    
    public void push(Node newNode)
    {
        isEmpty();
        newNode.next = head;
        head = newNode;
        total+=newNode.value;
        size++;
    }
    
    public Node pop()
    {
        Node temp = head;
        Node pop = temp.clone();
        head = head.next;
        
        total-= temp.value;
        temp = null;
        size--;
        return pop;
    }
    
    
    public double peek(int index)
    {
        Node temp = new Node();
        temp = head;
        for(int i = 0 ; i<index-1;i++)
            temp = temp.next;
        return temp.value;
    }
    
    public void reverse()
    {
    	Queue reverse = new Queue();
    	while(!this.isEmpty()) {
    		reverse.enqueue(this.pop());
    	}
    	while(!reverse.isEmpty()) {
    		this.push(reverse.dequeue());
    	}
    }
    
    
}
