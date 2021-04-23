package binartreestuderende;

import java.util.NoSuchElementException;

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
		BinaryTree<E> resultRight = new BinaryTree<E>();
		resultRight.root = root.right;
		return resultRight;

	}

	/**
	 *
	 * @param rootData
	 *            the new data for the root
	 *
	 * @return the data previous in the root
	 */
	public E replace(E rootData) {
		if (isEmpty()) {
			return null;
		}
		Node previousRoot = new Node();
		previousRoot.data = root.data;
		root.data = rootData;
		return previousRoot.data;
	}

	/**
	 *
	 * @param n
	 * @return true in n has no children
	 */
	private boolean isLeaf(Node n) {
		if (root.left == null && root.right == null) {
			return true;
		}
		return false;
	}

	/**
	 *
	 * @param n
	 * @return true in n has at least one child
	 */
	private boolean isInternal(Node n) {
		if (root.left != null && root.right != null) {
			return true;
		}
		return false;
	}

	/**
	 *
	 * @return the number of nodes in the tree
	 */
	public int size() {
		return size(root);
	}

	private int size(Node n) {
		if (isEmpty()) {
			return 0;
		}
		return 1 + size(n.left) + size(n.right);
	}
	
	public int countElements(E element) {
		return countElements(root, element);
	}
	
	public int countElements(Node node, E elements) {
		if (isEmpty()) {
			return 0;
		}
		if (node.data.equals(elements)) {
			return countElements(node.left, elements) + countElements(node.right, elements) + 1;
		} else {
			return countElements(node.left, elements) + countElements(node.right, elements);
		}
	}
	
//	public void printTree() {
//		inOrder(root);
//		System.out.println();
//	}
//	
//	private void inOrder() {
//		
//	}

	private class Node {
		public E data;
		public Node left;
		public Node right;
	}
}
