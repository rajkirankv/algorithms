/*
This class describes a weighted Edge
*/
package graphs.undirected.weighted;

import java.util.Objects;

public class Edge implements Comparable<Edge> {
	
	protected int v, w;
	protected Double weight;

	protected Edge(int v, int w, Double weight) {
		
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

	public Double weight() {
		return weight;
	}

	@Override
	public int compareTo(Edge that) {
		return this.weight().compareTo(that.weight());
	}

	@Override
	public String toString() {
		return String.format("%d %d %.4f", v, w, weight);
	}

	@Override
	public int hashCode() {
		return Objects.hash(v, w, weight);
	}

	public static void main(String[] args) {
		
	}
}