/*
Quick union Union Find
*/
package fundamentals;

import fundamentals.UF;

public class QuickUnionUF extends UF {

	int count;
	int[] l; // l stands for links to parents

	public QuickUnionUF(int N) {
		this.count = N;
		l = new int[N];
		for(int i = 0; i < N; i++)
			l[i] = i;
	}

	@Override
	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);

		if(pRoot == qRoot) return;

		l[pRoot] = qRoot; // or l[qRoot] = pRoot; this decision is arbitrary
		count--;
	}

	@Override
	public int find(int p) {
		int v;
		for(v = p; v != l[v]; v = l[v]);
		return v;
	}

	@Override
	public int count() {
		return count;
	}
} 