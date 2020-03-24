/*
This class describes a weighted Edge
*/
package graphs.undirected.weighted;

class Edge implements Comparable<Edge> {
	
	int v, w;
	Double weight;

	Edge(int v, int w, Double weight) {
		
		if(v < 0  || w < 0)
			throw new IllegalArgumentException("Vertices can't be negtive numbers");

		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	int either() {
		return v;
	}

	int other(int u) {
		if(u != v && u != w) throw new RuntimeException("Inconsistent edge");
		return u == v ? w : v;
	}

	Double weight() {
		return weight;
	}

	@Override
	public int compareTo(Edge that) {
		return this.weight().compareTo(that.weight());
	}

	@Override
	public String toString() {
		return String.format("%d %d %f", v, w, weight);
	}

	public static void main(String[] args) {
		Edge e = new Edge(1, 2, 0.5);
		int v, w;
		v = e.either(); w = e.other(v);
		assert v == 1 || v == 2;
		assert v == 1 ? w == 2 : w == 1;
		assert e.weight() == 0.5;
		assert e.toString() == "1 2 0.5";
	}
}