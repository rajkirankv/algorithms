/*
Abstract class for union find
*/
package fundamentals;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

abstract class UF {
	int N;
	abstract void union(int p, int q);
	abstract int find(int p);
	
	boolean connected(int p, int q) {
		return (find(p) == find(q));
	}

	abstract int count();

	public static void main(String[] args) throws IOException, FileNotFoundException, IllegalArgumentException {
		Scanner sc = new Scanner(new FileInputStream(args[0]));
		int N = sc.nextInt();
		// UF uf = new QuickFindUF(N);
		// UF uf = new QuickUnionUF(N);
		UF uf = new WeightedQuickUnionUF(N);
		int p, q;
		long startTime = System.nanoTime();
		while(sc.hasNextInt()) {
			p = sc.nextInt();
			q = sc.nextInt();
			if (p > N - 1 || q > N - 1) 
				throw new IllegalArgumentException(String.format("Nodes can't have names > %d", uf.N - 1));
			if(uf.connected(p, q))
				continue;
			uf.union(p, q);
			// System.out.println(p + " " + q);
		}
		long stopTime = System.nanoTime();
		System.out.println("Components: " + uf.count());
		System.out.println(String.format("Time elapsed: %f ms)", (stopTime - startTime)/Math.pow(10, 6)));
	}
}