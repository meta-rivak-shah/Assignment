import java.util.Comparator;

//Class for bind vertex and edge in single entry
public class Edge implements Comparator<Edge> {

	private int startVertex;
	private int endVertex;
	private int weight;

	public Edge(int v1, int v2, int weight) {
		this.startVertex = v1;
		this.endVertex = v2;
		this.weight = weight;
	}

	// Getter Setter
	public int getstartVertex() {
		return startVertex;
	}

	public void setstartVertex(int startVertex) {
		this.startVertex = startVertex;
	}

	public int getendVertex() {
		return endVertex;
	}

	public void setendVertex(int endVertex) {
		this.endVertex = endVertex;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * Comparator for sorting edge collection based on edge's wight
	 * */
	public static final Comparator<Edge> sortByWeight = new Comparator<Edge>() {
		public int compare(Edge e1, Edge e2) {
			return e1.getWeight() - e2.getWeight();
		}
	};

	@Override
	public int compare(Edge o1, Edge o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}