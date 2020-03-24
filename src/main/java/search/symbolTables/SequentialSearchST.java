package search.symbolTables;

import java.util.ArrayDeque;
import search.ST;

public class SequentialSearchST<Key, Value> implements ST<Key, Value> {
	public SequentialSearchST() {


	}

	private class Node {
		Key k;
		Value v;
		int n;
		Node next;

		Node(Key k, Value v) {
			this.k = k;
			this.v = v;
			this.n = 1;
			this.next = null;
		}
	}

	private Node root = null;

	@Override
	public void put(Key k, Value v) {
		root = put(k, v, root);
	}
	private Node put(Key k, Value v, Node node) {
		if(node == null) return new Node(k, v);
		if(k.equals(node.k)) {
			node.v = v;
		}
		else {
			node.next = put(k, v, node.next);
			node.n = 1 + size(node.next);
		}
		return node;
	}

	public Value get(Key k) {
		return (isEmpty() ? null : get(k, root).v);
	}
	private Node get(Key k, Node node) {
		if(node == null) return null;
		if(k.equals(node.k)) return node;
		else return get(k, node.next);
	}

	public void delete(Key k) {
		root = delete(k, root);
	}
	private Node delete(Key k, Node node) {
		if(node == null) return null;
		if(k.equals(node.k)) return node.next;
		else {
			node = delete(k, node.next);
			node.n = 1 + size(node.next);
			return node;
		}
	}

	public boolean contains(Key k) {
		return contains(k, root);
	}
	private boolean contains(Key k, Node node) {
		if(node == null) return false;
		if(k.equals(node.k)) return true;
		else return contains(k, node.next);
	}

	public boolean isEmpty() {
		return (size() == 0);
	}

	public int size() {return size(root);}
	private int size(Node node) {
		return (node == null ? 0 : node.n);
	}

	public Iterable<Key> keys() {
		// ArrayDeque<Key> q = new ArrayDeque<Key>();
		// return keys(root, q);
		return keys(root);
	}
	private ArrayDeque<Key> keys(Node node) {
		if(node == null) return new ArrayDeque<Key>();
		else {
			ArrayDeque<Key> q = keys(node.next);
			q.add(node.k);
			return q;
		}
	}

	//TODO:
	public static void main(String[] args) {
		System.out.println("SequentialSearchST class works");
	}
}