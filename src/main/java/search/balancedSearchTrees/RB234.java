package search.balancedSearchTrees;

/*This class implements the top down 2-3-4 trees as described in 3.3.25*/

class RB234<Key extends Comparable<Key>, Value> {
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private class Node {
		Key k;
		Value v;
		Node left;
		Node right;
		int s;
		boolean color;

		public Node(Key k, Value v, boolean color) {
			this.k = k;
			this.v = v;
			this.left = this.right = null;
			this.s = 1;
			this.color = color;
		}
	}

	private Node root;

	public RB234() {
		root = null;
	}

	private Node rotateLeft(Node n) {
		Node x = n.right;
		n.right = x.left;
		x.left = n;
		x.color = n.color;
		x.left.color = RED;
		x.s = n.s;
		n.s = 1 + size(n.left) + size(n.right);
		return x;
	}

	private Node rotateRight(Node n) {
		Node x = n.left;
		n.left = x.right;
		x.right = n;
		x.color = n.color;
		x.right.color = RED;
		x.s = n.s;
		n.s = 1 + size(n.left) + size(n.right);
		return x;
	}

	private Node flip(Node n) {
		if (!(isRed(n.left) || isRed(n.right))) 
			throw new IllegalArgumentException("flip only when both children are red");
		n.left.color = n.right.color = BLACK;
		n.color = RED;
		return n;
	}
	private int size(Node n) {return (n == null ? 0 : n.s);}
	private boolean isRed(Node n) {return (n == null ? false : n.color);}

	public void put(Key k, Value v) {
		root = put(k, v, root);
		root.color = BLACK; 
	}
	private Node put(Key k, Value v, Node n) {
		if (n == null) n = new Node(k, v, RED);
		if (isRed(n.left) && isRed(n.right)) n = flip(n);
		int cmp = k.compareTo(n.k);
		if (cmp < 0) n.left = put(k, v, n.left);
		else if (cmp > 0) n.right = put(k, v, n.right);
		else n.v = v;
		if (isRed(n.right) && !isRed(n.left)) n = rotateLeft(n);
		if (isRed(n.left) && isRed(n.left.left)) n = rotateRight(n);
		n.s = 1 + size(n.left) + size(n.right);
		return n;
	}

	public Value get(Key k) {
		Node result = get(k, root);
		return (result == null ? null : result.v);
	}
	private Node get(Key k, Node n) {
		if (n == null) return null;
		int cmp = k.compareTo(n.k);
		if (cmp < 0) return get(k, n.left);
		else if (cmp > 0) return get(k, n.right);
		else return n;
	}

	//TODO:
	
	public void del(Key k) {}
	public int size() {return root.s;}
	public boolean isEmpty() {return root == null;}
	public boolean contains(Key k) {return get(k) != null;}
	public Iterable<Key> keys() {return null;}

	public Key min() {return null;}
	public Key max() {return null;}
	public Key floor(Key k) {return null;}
	public Key ceiling(Key k) {return null;}
	public int rank(Key k) {return -1;}
	public Key select(int r) {return null;}
	public void delMin() {del(min());}
	public void delMax() {del(max());}
	public int size(Key lo, Key hi) {return -1;}
	public Iterable<Key> keys(Key lo, Key hi) {return null;}

	public static void main(String[] args) {
		// Tests

		// RedBlackBST<Character, Integer> rbt = new RedBlackBST<Character, Integer>();
		// rbt.put(new Character('S'), new Integer(1));
		// assert rbt.get(new Character('S')).equals(new Integer(1)) : "get should get the right value";

		// RedBlackBST<Character, Integer> rbt = new RedBlackBST<Character, Integer>();
		// assert rbt.get(new Character('S')) == null : "get should get the right value";

		// RedBlackBST<Character, Integer> rbt = new RedBlackBST<Character, Integer>();
		// rbt.put(new Character('S'), new Integer(1));
		// rbt.put(new Character('E'), new Integer(2));
		// assert rbt.get(new Character('E')).equals(new Integer(2)) : "get should get the right value";
		// rbt.put(new Character('E'), new Integer(22));
		// assert rbt.get(new Character('E')).equals(new Integer(22)) : "get should get the updated value";

		RB234<Character, Integer> rbt = new RB234<Character, Integer>();
		rbt.put(new Character('S'), new Integer(1));
		rbt.put(new Character('E'), new Integer(2));
		rbt.put(new Character('A'), new Integer(3));
		rbt.put(new Character('R'), new Integer(4));
		rbt.put(new Character('C'), new Integer(5));
		rbt.put(new Character('H'), new Integer(6));
		rbt.put(new Character('S'), new Integer(7));
		rbt.put(new Character('X'), new Integer(8));
		rbt.put(new Character('M'), new Integer(9));
		rbt.put(new Character('P'), new Integer(10));
		rbt.put(new Character('L'), new Integer(11));
		assert rbt.get(new Character('H')).equals(new Integer(6)) : "get should get the right value";
		assert rbt.get(new Character('P')).equals(new Integer(10)) : "get should get the right value";
		rbt.put(new Character('R'), new Integer(44));
		assert rbt.get(new Character('R')).equals(new Integer(44)) : "get should get the updated value";
	}

}
























