package dataStructures;


public class AdjacencyGraph{
	/**
	 * The square matrix for representing all the connections
	 */
	int[][] adj;
	/**
	 * All the ocuppied indexes in the adjacency matrix
	 */
	int occupied;
	/**
	 * Constructor with fixed size
	 * @param size
	 */
	public AdjacencyGraph(int size) {
		adj = new int[size][size];
	}
	
	/**
	 * Constructor with no fixed size, sets size to 10
	 */
	
	public AdjacencyGraph() {
		this(10);
	}
	
	/**
	 * Checks if all indexes are occupied
	 * @return a boolean indicating if the Graph is full
	 */
	public boolean isFull() {
		return occupied==adj.length;
	}
	
	/**
	 * Resizes the adjacency matrix of the Graph by a factor and copies all of its elements
	 * @param factor
	 * @throws IllegalArgumentException in case the factor is a number that makes the resizing 
	 * opperation unsuccesful
	 */
	
	public void resize(int factor)throws IllegalArgumentException {
		if(factor>1){
			int size = adj[0].length;
			int[][] resized = new int[size*factor][size*factor];
			//Copying
			for(int i =0;i<size;i++) {
				for(int j=0;j<size;j++) {
					resized[i][j]=adj[i][j];
				}
			}
			
			adj=resized;
		}else {
			throw new IllegalArgumentException();
		}
	}
	/**
	 * Creates a directed weighted connection from Node u to Node v. 
	 * Set <code>biDirectional=true</code> for an undirected graph  
	 * @param u
	 * @param v
	 * @param weight
	 * @param biDirectional
	 * @throws VertexOutOfBoundsException 
	 */
	public void insert(int u, int v, int weight, boolean biDirectional) throws VertexOutOfBoundsException {
		if(this.isFull()) {
			this.resize(2);
			this.insert(u,v,weight,biDirectional);
		}else if(this.contains(u) && this.contains(v)){
			adj[u][v]=weight;
			occupied++;
			if(biDirectional) {
				adj[v][u]=weight;
				occupied++;
			}
		}else {
			throw new VertexOutOfBoundsException();
		}
	}
	/**
	 * Sets the weigth of the connection between nodes u and v to zero.
	 * @param u
	 * @param v
	 */
	public void delete(int u, int v, boolean biDirectional) {
		if(this.contains(u) && this.contains(v)) {
			adj[u][v]=0;
			if(biDirectional) {
				adj[v][u]=0;
			}
		}
	}
	
	public boolean contains(int u) {
		return u<adj[0].length;
	}
	/**
	 * Traverses the Graph starting from Node u performing bfs 
	 * iteratively
	 * @param u
	 * @return a List with the bfs path
	 * @throws VertexOutOfBoundsException 
	 */
	
	public List bfs(int u) throws VertexOutOfBoundsException {
		if(this.contains(u)) {
			List path = new List();
			Queue q = new Queue();
			boolean[] visited = new boolean[occupied];
			visited[u]=true;
			q.enqueue(new Node(u));
			while(!q.isEmpty()) {
				Node v = q.dequeue();
				path.insertAtEnd(v);
				//check adjacent nodes from u
				
				for(int i=0;i<occupied;i++) {
					//if there is adjacent vertex enque it
					if(!visited[i] && (adj[u][i]!=0)) {
						q.enqueue(new Node(i));
						visited[i]=true;
					}
				}
			}
			return path;
		}
			throw new VertexOutOfBoundsException();	
	}
	
	/**
	 * Implements recursive dfs and returns a List containing the path
	 * form node u
	 * @param u
	 * @return
	 * @throws VertexOutOfBoundsException 
	 */
	
	
	public List dfs(int u) throws VertexOutOfBoundsException {
		if(this.contains(u)) {
			List path = new List();
			boolean[] visited = new boolean[occupied];
			visited[u]=true;
			path.insertAtEnd(new Node(u));
			for(int i=0;i<occupied;i++) {
				if(!visited[i] && (adj[u][i]!=0))
					path.concat(dfs(i));
			}
			return path;
		}
		throw new VertexOutOfBoundsException();
	}
	
}
