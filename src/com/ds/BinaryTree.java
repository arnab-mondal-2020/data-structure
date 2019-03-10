package com.ds;

public class BinaryTree {
	private Node root;
	private int size;

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(int data) {
		if (isEmpty()) {
			root = new Node(data);
			System.out.println("Tree created - [data=" + data + "]");
		} else {
			doInsert(data);
		}
		size++;
	}

	public int getSize() {
		return size;
	}

	private void doInsert(int data) {
		Node current = root;
		Node position = current;
		while (current != null) {
			position = current;
			if (current.data < data) {
				current = current.leftChild;
			} else if (current.data > data) {
				current = current.rightChild;
			}
		}
		if (position.data > data) {
			position.leftChild = new Node(data);
			position.leftChild.parent = position;
			System.out.println("Left child of " + position.data + " added.");
		} else if (position.data < data) {
			position.rightChild = new Node(data);
			position.rightChild.parent = position;
			System.out.println("Right child of " + position.data + " added.");
		} else {
			System.out.println("Data " + position.data + " already exists. Doing nothing");
		}
	}

	private static class Node {
		Node(int data) {
			this.data = data;
		}

		int level;
		int data;
		Node leftChild;
		Node rightChild;
		Node parent;
		
		@Override
		public String toString() {
			return new StringBuilder()
			.append("Node=[")
			.append("data=" + data + ", ")
			.append("Left child=" + (leftChild == null ? "NULL" : leftChild.data) + ", ")
			.append("Right child=" + (rightChild == null ? "NULL" : rightChild.data) + ", ")
			.append("]")
			.toString();
		}
	}
}
