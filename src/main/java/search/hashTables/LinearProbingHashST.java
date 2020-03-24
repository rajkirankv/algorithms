package search.hashTables;

import search.ST;

public class LinearProbingHashST<Key, Value> implements ST<Key, Value> {

	private Key[] keys;
	private Value[] vals;
	private int N, M;
	private static final int INITIAL_SIZE = 997;
	private static final double INV_ALPHA_MIN = 16;
	private static final double INV_ALPHA_MAX = 2; // Inverse alpha max


	public LinearProbingHashST() {
		this(INITIAL_SIZE);
	}

	public LinearProbingHashST(int M) {
		this.M = M;
		this.keys = (Key[]) new Object[M];
		this.vals = (Value[]) new Object[M];
	}

	private void resize(int M) {
		Key[] keys = (Key[]) new Object[M];
		Value[] vals = (Value[]) new Object[M];

		for(int i = 0, j = 0; i < this.M; i++) {
			if (this.keys[i] == null) continue;
			j = this.keys[i].hashCode() % M;
			keys[j] = this.keys[i];
			vals[j] = this.vals[i];
		}

		this.keys = keys;
		this.vals = vals;
		this.M = M;
		
	}

	private int hash(Key k) {
		return ((k.hashCode() & 0x7FFFFFFF) % M);
	}

	@Override
	public void put(Key k, Value v) {
		
		if(M <= INV_ALPHA_MAX*N) resize(2*M);

		int i;

		for(i = hash(k); keys[i] != null; i = (i + 1) % M)
			if(k.equals(keys[i])) {vals[i] = v; return;}
		keys[i] = k; vals[i] = v;
		N++;
	}

	@Override
	public Value get(Key k) {	
		int i;
		for(i = hash(k); !k.equals(keys[i]); i = (i + 1) % M)
			if(keys[i] == null) return null;
		return vals[i];
	}

	public void delete(Key k) {
		if(!contains(k)) return;
		int i;
		for(i = hash(k); !k.equals(keys[i]); i = (i + 1) % M);
		keys[i] = null;
		vals[i] = null;
		Key key2Move;
		Value val2Move;
		for(i = (i + 1) % M; keys[i] != null; i = (i + 1) % M) {
			key2Move = keys[i];
			val2Move = vals[i];
			N--;
			put(key2Move, val2Move);
		}

		N--;
		if(M > INV_ALPHA_MIN*N) resize(M/2);
	}

	// TODO:
	
	
	public boolean contains(Key k) {return false;}
	public boolean isEmpty() {return false;}
	public int size() {return -1;}
	public Iterable<Key> keys() {return null;}


}