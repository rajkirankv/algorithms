/*
Weighted quick union Union Find
*/
package fundamentals;

import fundamentals.QuickUnionUF;

public class WeightedQuickUnionUF extends QuickUnionUF {
	// This array stores the size of each tree
	int[] sz;

	public WeightedQuickUnionUF(int N) {
		super(N);
		sz = new int[N];
		for(int i = 0; i < N; i++)
			sz[i] = 1;
	}

	@Override
	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);

		if (pRoot == qRoot) return;

		if(sz[pRoot] > sz[qRoot]) {
			l[qRoot] = pRoot;
			sz[pRoot] = sz[pRoot] + sz[qRoot];
		}
		else {
			l[pRoot] = qRoot;
			sz[qRoot] = sz[qRoot] + sz[pRoot];
		}

		count--;
	}
}