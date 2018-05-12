package dataStructures;

public class Node {
    
	  double value;
	  
	  Node next = null;
	  
	  public Node(){}
	  public Node(double value)
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
