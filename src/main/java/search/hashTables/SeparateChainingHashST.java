package search.hashTables;

import search.ST;
import search.symbolTables.SequentialSearchST;

public class SeparateChainingHashST<Key, Value> implements ST<Key, Value> {

	private static final int TABLE_SIZE = 997;
	private int M, N;
	private SequentialSearchST<Key, Value>[] chains;
	
	public SeparateChainingHashST() {
		this(TABLE_SIZE);
	}

	public SeparateChainingHashST(int M) {
		this.M = M;
		this.chains = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
	}

	private int hash(Key k) {
		return ((k.hashCode() & 0x7FFFFFFF) % M);
	}

	@Override
	public void put(Key k, Value v) {
		int hash = hash(k);
		chains[hash].put(k, v);
	}

	@Override
	public Value get(Key k) {
		int hash = hash(k);
		return chains[hash].get(k);
	}
	

	//TODO:
	
	
	public void delete(Key key) {}
	public boolean contains(Key key) {return false;}
	public boolean isEmpty() {return false;}
	public int size() {return -1;}
	public Iterable<Key> keys() {return null;}

}