package graphs.directed.weighted;

import java.utils.Objects;

class DEdge extends Comparable<DEdge> {
	private int to, from;
	private Double weight;

	DEdge(int to, int from, double weight) {

		if(to < 0  || from < 0)
			throw new IllegalArgumentException("Vertices can't be negtive numbers");

		this.to = to;
		this.from = from;
		this.weight = weight;
	}

	int to() {return to;}
	int from() {return from;}
	double weight() {return weight;}

	@Override
	public int compareTo(DEdge de) {
		return this.weight().compareTo(that.weight());
	}

	@Override
	public int hashCode() {
		return Objects.hash(to, from, weight);
	}

	@Override
	public String toString() {
		return String.format("%d %d %.4f", from, to, weight);
	}
}