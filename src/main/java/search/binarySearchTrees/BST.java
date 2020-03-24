package search.binarySearchTrees;

// package search.binarySearchTrees;
import java.util.HashSet;
import java.util.Collection;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.FrequencyCounter;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

class BST<Key extends Comparable<Key>, Value> {

	private class Node {

		private Key k;
		private Value v;
		private Node left, right;
		private int N;

		public Node(Key k, Value v) {
			this.k = k;
			this.v = v;
			N = 1;
		}
	}

	private Node root;

	public Value get(Key key) {
		return get(key, root);
	}

	private Value get(Key key, Node node) {
		if(node == null) return null;
		int cmp = key.compareTo(node.k);
		if(cmp < 0) return get(key, node.left);
		else if(cmp > 0) return get(key, node.right);
		else return node.v;
	}

	public void put(Key key, Value value) {
		root = put(key, value, root);

	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		return (node == null ? 0 : node.N);
	}

	private Node put(Key key, Value value, Node node) {
		if(node == null) return new Node(key, value);
		int cmp = key.compareTo(node.k);
		if(cmp < 0) node.left = put(key, value, node.left);
		else if(cmp > 0) node.right = put(key, value, node.right);
		else node.v = value;
		node.N = size(node.left) + size(node.right) + 1;
		return node;
	}

	public Node max() {
		return max(root);
	}

	private Node max(Node node) {
		if(node == null) return null;
		else if(node.right == null) return node;
		else return max(node.right);
	}

	public Node min() {
		return min(root);

	}

	private Node min(Node node) {
		if(node == null) return null;
		else if(node.left == null) return node;
		else return min(node.left);
	}

	public Node floor(Key key) {
		return floor(key, root);

	}

	private Node floor(Key key, Node node) {
		if(node == null) return null;
		int cmp = key.compareTo(node.k);
		if(cmp < 0) return floor(key, node.left);
		else if(cmp > 0) {
			Node n = floor(key, node.right);
			return (n == null ? node : n);
		}
		else return node;
	}

	public Node ceiling(Key key) {
		return ceiling(key, root);

	}

	private Node ceiling(Key key, Node node) {
		if(node == null) return null;
		int cmp = key.compareTo(node.k);
		if(cmp > 0) return ceiling(key, node.right);
		else if(cmp < 0) {
			Node n = ceiling(key, node.left);
			return (n == null ? node : n);
		}
		else return node;
	}

	public Node select(int r) {
		return select(r, root);
	}

	private Node select(int r, Node node) {
		int rank = size(node.left);
		if(rank > r) return select(r, node.left);
		else if(rank == r) return node;
		else return select(r - rank - 1, node.right);
	}

	public int rank(Key key) {
		return rank(key, root);
	}

	private int rank(Key key, Node node) {
		if(node == null) return 0;
		int cmp = key.compareTo(node.k);
		if(cmp < 0) return rank(key, node.left);
		else if(cmp == 0) return size(node.left);
		else return 1 + size(node.left) + rank(key, node.right);
	}

	public void delMin() {
		root = delMin(root);
	}

	private Node delMin(Node node) {
		if(node == null) return null;
		if(node.left == null) return node.right;
		else {
			node.left = delMin(node.left);
			node.N = size(node.left) + size(node.right) + 1;
			return node;
		}
	}

	public void delMax() {
		root = delMax(root);
	}

	private Node delMax(Node node) {
		if(node == null) return null;
		if(node.right == null) return node.left;
		else {
			node.right = delMin(node.right); 
			node.N = size(node.left) + size(node.right) + 1;
			return node;
		}
	}

	public void del(Key key) {
		root = del(key, root);
	}

	private Node del(Key key, Node node) {
		if(node == null) return null;
		int cmp = key.compareTo(node.k);
		if(cmp < 0) node.left = del(key, node.left);
		else if(cmp > 0) node.right = del(key, node.right);
		else {
			if(node.left == null) return node.right;
			if(node.right == null) return node.left;
			Node maxOfLeft = max(node.left);
			node.left = delMax(node.left);
			maxOfLeft.left = node.left;
			maxOfLeft.right = node.right;
			node = maxOfLeft;
		}
		node.N = size(node.left) + size(node.right) + 1;
		return node;
	}

	public Iterable<Key> keys() {
		return keys(min().k, max().k);
	}

	public Iterable<Key> keys(Key k1, Key k2) {
		Queue<Key> q = new Queue<Key>();
		keys(k1, k2, root, q);
		return q;
	}

	private void keys(Key k1, Key k2, Node node, Queue<Key> q) {
		if(node == null) return;
		int cmp1 = k1.compareTo(node.k);
		int cmp2 = k2.compareTo(node.k);
		if(cmp1 > 0) keys(k1, k2, node.right, q);
		else if(cmp2 < 0) keys(k1, k2, node.left, q);
		else {
			keys(k1, node.k, node.left, q);
			q.enqueue(node.k);
			keys(node.k, k2, node.right, q);
		}
	}

	public boolean contains(Key k) {
		return contains(k, root);
	}

	private boolean contains(Key k, Node node) {
		if(node == null) return false;
		int cmp = k.compareTo(node.k);
		if(cmp == 0) return true;
		else if(cmp < 0) return contains(k, node.left);
		else return contains(k, node.right);
	}

	public static void main(String[] args) {
		// BST<Character, Integer> bst = new BST<Character, Integer>();
		// bst.put(new Character('e'), 123); 
		// bst.put(new Character('b'), 456);
		// bst.put(new Character('n'), 789);
		
		// assert(bst.get(new Character('e')) == 123);
		// assert(bst.max().k.equals(new Character('n')));
		// assert(bst.min().k.equals(new Character('b')));

		// assert(bst.floor(new Character('e')).k.equals(new Character('e')));
		// assert(bst.floor(new Character('f')).k.equals(new Character('e')));
		// assert(bst.floor(new Character('a')) == null);
		// assert(bst.floor(new Character('p')).k.equals(new Character('n')));

		// assert(bst.ceiling(new Character('e')).k.equals(new Character('e')));
		// assert(bst.ceiling(new Character('f')).k.equals(new Character('n')));
		// assert(bst.ceiling(new Character('p')) == null);
		// assert(bst.ceiling(new Character('a')).k.equals(new Character('b')));

		// assert(bst.select(1).k.equals(new Character('e')));
		// assert(bst.select(0).k.equals(new Character('b')));
		// assert(bst.select(2).k.equals(new Character('n')));

		// assert(bst.rank(new Character('e')) == 1);
		// assert(bst.rank(new Character('f')) == 2);
		// assert(bst.rank(new Character('a')) == 0);
		// assert(bst.rank(new Character('p')) == 3);

		// assert(bst.select(bst.rank(new Character('e'))).k.equals(new Character('e')));

		// BST<Character, Integer> bst = new BST<Character, Integer>();
		// bst.put(new Character('e'), 123); 
		// bst.put(new Character('b'), 456);
		// bst.put(new Character('n'), 789);

		// bst.delMax();
		// assert(bst.max().k.equals(new Character('e')));

		// bst.delMax();
		// assert(bst.max().k.equals(new Character('b')));

		// BST<Character, Integer> bst = new BST<Character, Integer>();
		// bst.put(new Character('e'), 123); 
		// bst.put(new Character('b'), 456);
		// bst.put(new Character('n'), 789);

		// bst.del('n');
		// assert(bst.max().k.equals(new Character('e')));
		// assert(bst.size() == 2);

		// BST<Character, Integer> bst = new BST<Character, Integer>();
		// bst.put(new Character('e'), 123); 
		// bst.put(new Character('b'), 456);
		// bst.put(new Character('n'), 789);

		// // HashSet<Character> result = new HashSet<Character>((Collection<Character>) bst.keys(new Character('b'), new Character('n')));
		// Iterable<Character> resIter = bst.keys(new Character('n'), new Character('b'));
		// HashSet<Character> result = new HashSet<Character>(3);
		// for(Character c : resIter) result.add(c);
		// HashSet<Character> keys = new HashSet<Character>(3);
		// keys.add(new Character('e'));
		// keys.add(new Character('b'));
		// keys.add(new Character('n'));
		// assert(result.isEmpty());

		int distinct = 0, words = 0;
        int minlen = Integer.parseInt(args[0]);
        BST<String, Integer> st = new BST<String, Integer>();

        // compute frequency counts
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (key.length() < minlen) continue;
            words++;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            }
            else {
                st.put(key, 1);
                distinct++;
            }
        }

        // find a key with the highest frequency count
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }

        StdOut.println(max + " " + st.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);

	}
}


















