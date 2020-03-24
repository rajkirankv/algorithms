/*
Quick find Union Find
*/
package fundamentals;
// TODO: use timer to measure performace, use logger to log, use maven/gradle

import fundamentals.UF;
import java.util.Arrays;

public class QuickFindUF extends UF {
	
	int[] c; // This implementation uses this array to assign component number to each node/vertex
	int count; // Number of components

	public QuickFindUF(int N) {
		this.N = N;
		c = new int[N];
		for(int i = 0; i < N; i++)
			c[i] = i;
		count = N;
	}

	@Override
	public void union(int p, int q) {
		int pComp = find(p);
		int qComp = find(q);

		if(pComp == qComp) return;

		for(int i = 0; i < N; i++)
			if(c[i] == qComp)
				c[i] = pComp;
		
		count--;
	}

	@Override
	public int find(int p) {
		return c[p];
	}

	@Override
	public int count() {
		return count;
	}
}