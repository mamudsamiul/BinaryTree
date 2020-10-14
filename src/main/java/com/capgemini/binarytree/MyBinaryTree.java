package com.capgemini.binarytree;

public class MyBinaryTree<K extends Comparable<K>> {
	private MyBinaryNode<K> root;

	public MyBinaryTree() {
	}

	public void add(K key) {
		this.root = this.addRecursively(root, key);
	}

	private MyBinaryNode<K> addRecursively(MyBinaryNode<K> current, K key) {
		if (current == null) {
			return new MyBinaryNode<>(key);
		}
		int compareResult = key.compareTo(current.key);
		if (compareResult == 0)
			return current;
		if (compareResult < 0) {
			current.left = addRecursively(current.left, key);
		} else {
			current.right = addRecursively(current.right, key);
		}
		return current;
	}

	public int getSize() {
		return this.getSizeRecursive(root);
	}

	private int getSizeRecursive(MyBinaryNode<K> current) {
		return current == null ? 0 : 1 + this.getSizeRecursive(current.left) + this.getSizeRecursive(current.right);
	}

	public boolean search(K key) {

		return searchRecursive(root, key);
	}

	private boolean searchRecursive(MyBinaryNode<K> root, K key) {
		if (root == null) {
			return false;
		}
		int compared = root.key.compareTo(key);
		if (compared == 0)
			return true;
		else if (compared < 0)
			return searchRecursive(root.right, key);
		else
			return searchRecursive(root.left, key);
	}

}
