package search;

public interface ST<Key, Value> {
	public void put(Key k, Value v);
	public Value get(Key k);
	public void delete(Key k);
	public boolean contains(Key k);
	public boolean isEmpty();
	public int size();
	public Iterable<Key> keys();
}