import java.util.List;

public interface Graph {

	boolean isConnected();

	Integer[] reachable(int node);

	List<Edge> minimumSpanningTree();

	int shortestPath(int startvertex, int endVertex);
}