import java.util.Comparator;

public class Pair implements Comparator<Pair> {

	private int weight;
	private int vertex;

	Pair(int weight, int vertex) {
		this.weight = weight;
		this.vertex = vertex;
	}

	public int getWeight() {
		return this.weight;
	}

	public int getVertex() {
		return this.vertex;
	}

	public static final Comparator<Pair> sortPairByWeight = new Comparator<Pair>() {

		@Override
		public int compare(Pair pair1, Pair pair2) {
			return pair1.getWeight() - pair2.getWeight();
		}

	};

	@Override
	public int compare(Pair o1, Pair o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}