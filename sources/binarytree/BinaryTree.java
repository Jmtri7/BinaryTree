package binarytree;

import java.util.ArrayList;

public class BinaryTree<T> {
	private Node<T> root;

	public BinaryTree(T[] valueArray) {
		// Build an ArrayList
		ArrayList<T> values = new ArrayList<T>();
		for(T value : valueArray) {
			values.add(value);
		}

		// Build the tree
		this.root = buildTree(values, 0);
	}

	// Recursively builds tree from array list
	private Node<T> buildTree(ArrayList<T> values, int index) {
		if(index >= values.size()) {
			// Node doesn't exist
			return null;
		} else {
			// Get Value
			T value = values.get(index);

			// Allows gaps in tree
			if(value == null) {
				return null;
			}

			// Get children
			int leftIndex = index * 2 + 1;
			int rightIndex = index * 2 + 2;
			Node<T> leftChild = buildTree(values, leftIndex);
			Node<T> rightChild = buildTree(values, rightIndex);

			// Build node
			Node<T> node = new Node<T>(value, leftChild, rightChild);

			return node;
		}
	}

	Node<T> getRoot() {
		return this.root;
	}

	// Should this be static?
	int countLayers(Node root) {
		int leftCount = 0;
		if(root.getLeftChild() != null) {
			leftCount = countLayers(root.getLeftChild());
		}

		int rightCount = 0;
		if(root.getRightChild() != null) {
			rightCount = countLayers(root.getRightChild());
		}

		return 1 + Math.max(leftCount, rightCount);
	}

	class Node<T> {
		private T value;
		private Node<T> leftChild;
		private Node<T> rightChild;

		public Node(T value, Node<T> leftChild, Node<T> rightChild) {
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		public T getValue() {
			return this.value;
		}

		Node<T> getLeftChild() {
			return this.leftChild;
		}

		Node<T> getRightChild() {
			return this.rightChild;
		}
	}
}