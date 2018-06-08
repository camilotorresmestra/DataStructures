package dataStructures;
class VertexOutOfBoundsException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public VertexOutOfBoundsException() {
		super();
	}
	public VertexOutOfBoundsException(String message) {
		super(message);
	}
}
public class ListGraph {
	
	class Vertex extends Node{
		int value;
		Vertex next;
		List edges;
		public Vertex(int v) {
			this.value=v;
			this.edges = new List();
		}
	}
	
	class Edge extends Node{
		int weigth;
		Vertex output;
		public Edge(int w,Vertex v) {
			this.weigth=w;
			this.output=v;
		}
	}
	
	List vertex;
	
	public ListGraph() {
		vertex = new List();
	}
	
	public void addVertex(int i) {
		Vertex v = new Vertex(i);
		vertex.insertAtEnd(v);
	}
	
	public void removeVertex(int i) throws VertexOutOfBoundsException {
		int pos = vertex.linearSearch(i);
		if(pos>-1) {
			vertex.deleteAtIndex(pos);
		}else{
			throw new VertexOutOfBoundsException();
		}
		
	}
	
	public void addEdge(int u, int v, int w, boolean biDirectional) throws VertexOutOfBoundsException {
		if(vertex.contains(u) && vertex.contains(v)) {
			Vertex U = (Vertex) vertex.get(u);
			Vertex V = (Vertex) vertex.get(v);
			U.edges.insertAtEnd(new Edge(w,V));
			if(biDirectional)
				this.addEdge(v, u, w, false);
		}else {
			throw new VertexOutOfBoundsException();
		}
	}
	
	public void removeEdge(int u, int v, boolean biDirectional) throws VertexOutOfBoundsException {
		if(vertex.contains(u) && vertex.contains(v)) {
			Vertex U = (Vertex) vertex.get(u);
			int pos = U.edges.linearSearch(v);
			U.edges.deleteAtIndex(pos);
			if(biDirectional)
				this.removeEdge(v, u, false);
		}else {
			throw new VertexOutOfBoundsException();
		}
	}
	
	public List bfs(int u) throws VertexOutOfBoundsException {
		if(vertex.contains(u)) {
			List path = new List();
			boolean[] visited = new boolean[vertex.length()];
			Queue q = new Queue();
			
			int index = vertex.linearSearch(u);
			Vertex U =(Vertex) vertex.get(index);
			q.enqueue(U);
			visited[index]=true;
			
			while(!q.isEmpty()) {
				
				Vertex V = (Vertex) q.dequeue();
				List neighbours = V.edges;
				int nl =neighbours.length();
				
				for(int i=0;i<nl;i++) {
					
					Vertex N = (Vertex) neighbours.get(i);
					int pos = vertex.linearSearch(N.value);
					
					if(!visited[pos]) {
						path.insertAtEnd(N.clone());
						visited[pos]=true;
						q.enqueue(N);
					}
				}
			}
			return path;
			
		}else {
			throw new VertexOutOfBoundsException();
		}
	}
}
