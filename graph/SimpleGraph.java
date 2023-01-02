package graph;


class Vertex {
	
	public int Value;

	public Vertex(int val) {
		Value = val;
	}
	
}

class SimpleGraph {
	public Vertex[] vertex;
	public int[][] m_adjacency;
	public int max_vertex;

	public SimpleGraph(int size) {
		max_vertex = size;
		m_adjacency = new int[size][size];
		vertex = new Vertex[size];
	}

	public void AddVertex(int value) {
		
		for (int i = 0; i < max_vertex; ++i) {
			
			if (vertex[i] == null) {
				
				vertex[i] = new Vertex(value);
				break;
				
			}
			
		}
		
	}

	public void RemoveVertex(int v) {
		
		if (vertex[v] == null) {
			return;
		}
		
		for (int i = 0; i < max_vertex; ++i) {
			
			m_adjacency[v][i] = 0;
			m_adjacency[i][v] = 0;
			
		}
		
		vertex[v] = null;
		
	}

	public boolean IsEdge(int v1, int v2) {
		
		if (vertex[v1] == null || vertex[v2] == null) {
			return false;
		}
		
		return m_adjacency[v1][v2] == 1;
		
	}

	public void AddEdge(int v1, int v2) {
		
		if (vertex[v1] == null || vertex[v2] == null) {
			return;
		}
		
		m_adjacency[v1][v2] = 1;
		
	}

	public void RemoveEdge(int v1, int v2) {
		
		if (vertex[v1] == null || vertex[v2] == null) {
			return;
		}
		
		m_adjacency[v1][v2] = 0;
		
	}
}
