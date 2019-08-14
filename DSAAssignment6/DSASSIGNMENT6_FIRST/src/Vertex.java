import java.util.LinkedList;
import java.util.List;

public class Vertex {

	
	//list of neighbour of this vertex
	private List<Neighbour> neighbours = new LinkedList<Neighbour>();

	Vertex(){
	}

	/**
	 * Add neighbour vertex with their edge weight
	 * @param vertex - neighbour vertex
	 * @param edgeWeight - edge weight of neighbour vertex
	 */
	public void addNeighbour(int vertex, int edgeWeight) {
		Neighbour neighbour = new Neighbour(vertex, edgeWeight);
		this.neighbours.add(neighbour);
	}

	/**
	 * 
	 * @return - List of neighbours
	 */
	public List<Neighbour> getNeighbourList(){
		return this.neighbours;
	}
}