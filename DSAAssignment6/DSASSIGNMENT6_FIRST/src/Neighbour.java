public class Neighbour {
	private int neighbourVertex;
	private int edgeWeight;

	/**
	 * Constructor
	 * @param vertex
	 * @param edgeWeight
	 * */
	Neighbour(int vertex, int edgeWeight) {
		this.neighbourVertex = vertex;
		this.edgeWeight = edgeWeight;
	}

	/**
	 * @return neighbour of this vertex
	 */
	public int getNeighbourVertex() {
		return this.neighbourVertex;
	}

	/**
	 * 
	 * @return weight of edge with this neighbour vertex
	 */
	public int getEdgeWeight() {
		return this.edgeWeight;
	}
}