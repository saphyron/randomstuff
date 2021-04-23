package kasseret_opgave_binært_søgetræ;


/**
 * A binary tree in which each node has two children.
 */
public class BinaryTree<E> {
	private Node root;

	/**
	 * Constructs an empty tree.
	 */
	public BinaryTree() {
		root = null;
	}

	/**
	 * Constructs a tree with one node and no children.
	 *
	 * @param rootData
	 *            the data for the root
	 */
	public BinaryTree(E rootData) {
		root = new Node();
		root.data = rootData;
		root.left = null;
		root.right = null;
	}

	/**
	 * Constructs a binary tree.
	 *
	 * @param rootData
	 *            the data for the root
	 * @param left
	 *            the left subtree
	 * @param right
	 *            the right subtree
	 */
	public BinaryTree(E rootData, BinaryTree<E> left, BinaryTree<E> right) {
		root = new Node();
		root.data = rootData;
		if (left != null) {
			root.left = left.root;
		}
		if (right != null) {
			root.right = right.root;
		}
	}

	/**
	 * Checks whether this tree is empty.
	 *
	 * @return true if this tree is empty
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Gets the data at the root of this tree.
	 *
	 * @return the root data
	 */
	public E data() {
		return root.data;
	}

	/**
	 * Gets the left subtree of this tree.
	 *
	 * @return the left child of the root
	 */
	public BinaryTree<E> left() {
		BinaryTree<E> result = new BinaryTree<E>();
		result.root = root.left;
		return result;
	}

	/**
	 * Gets the right subtree of this tree.
	 *
	 * @return the right child of the root
	 */
	public BinaryTree<E> right() {
		BinaryTree<E> result = new BinaryTree<E>();
		result.root = root.right;
		return result;
	}

	/**
	 *
	 * @param rootData
	 *            the new data for the root
	 *
	 * @return the data previous in the root
	 */
	public E replace(E rootData) {
	
		E old = root.data;
		root.data = rootData;
		return old;
	}
	/**
	 *
	 * @param n
	 * @return true in n has no children
	 */
	private boolean isLeaf(Node n) {
		return (root.left == null && root.right == null);
	}

	/**
	 *
	 * @param n
	 * @return true in n has at least one child
	 */
	private boolean isInternal(Node n) {
		return root.left != null || root.right != null;
	}

	/**
	 *
	 * @return the number of nodes in the tree
	 */
	public int size() {
		return size(root);
	}

	private int size(Node n) {

		if (n == null) {
			return 0;
		}
		return 1 + size(n.left) + size(n.right);
	}
	
	
	public int countElements(E data) {
		
		return countElements(data, root);
	}
	
		
	public int countElements(E data, Node irter) {
		
		if (irter == null) {
			return 0;
		}
		
		if (irter.data.equals(data)) {
			return 1 + countElements(data, irter.left) + countElements(data, irter.right);
		}
		
		return countElements(data, irter.left) + countElements(data, irter.right);
		
	}
	/*
	Node treasure = null;
	
	private void find(E data, Node irter) {
		
		if (irter.data.equals(data)) {
			treasure = irter;
			return;
		}
		
		find(data, irter.left);
		find(data, irter.right);
	} */
	
	public int value() {
		return value(root);
	}
	
	
	private int value(Node n) {
		
		if (n.left == null && n.right == null) {
			return Integer.parseInt((String) n.data);
		} 
		
		if (n.data.equals("+")) {
			return value(n.left) + value(n.right);
		}
		
		if (n.data.equals("*")) {
			return value(n.left) * value(n.right);
		}
		
		System.out.println("wtf");
		return -1;
			
	}

	private class Node {
		public E data;
		public Node left;
		public Node right;
	}
	
}
