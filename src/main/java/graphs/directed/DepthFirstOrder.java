package graphs.directed;

import graphs.directed.DiGraph;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import graphs.directed.Order;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;


public class DepthFirstOrder extends Order {
	
	private LinkedList<Integer> pre;
	private LinkedList<Integer> post;
	private ArrayDeque<Integer> reversePost;
	private boolean[] isMarked;

	public DepthFirstOrder(DiGraph dg) {
		this.dg = dg;
		pre = new LinkedList<Integer>();
		post = new LinkedList<Integer>();
		reversePost = new ArrayDeque<Integer>();
		isMarked = new boolean[dg.V()];
		build();
	}

	private void build() {
		for(int i = 0; i < dg.V(); i++)
			if(!isMarked[i])
				dfs(i);
	}

	private void dfs(int node) {
		isMarked[node] = true;
		pre.add(node);
		for(int child : dg.adj(node))
			if(!isMarked[child])
				dfs(child);
		post.add(node);
		reversePost.push(node);
	}

	// default traverse
	public Iterable<Integer> traverse() {
		return pre();
	}

	public Iterable<Integer> pre() {
		// return pre.clone();
		return pre;
	}

	public Iterable<Integer> post() {
		// return post.clone();
		return post;

	}

	public Iterable<Integer> reversePost() {
		return reversePost.clone();
	}
}