package com.category.simple.datastructures.tree;

/**
 * Binary Search Tree, Construction and Search Time Complexity for both the
 * operations: O(log n) Space Complexity for both the operations: O(log n)
 **/
public class BinarySearchTreeConstruction {

	static class TreeNode {
		private TreeNode leftReference;
		private TreeNode rightReference;
		private Integer data;

		public TreeNode getLeftReference() {
			return leftReference;
		}

		public void setLeftReference(TreeNode reference) {
			leftReference = reference;
		}

		public TreeNode getRightReference() {
			return rightReference;
		}

		public void setRightReference(TreeNode reference) {
			rightReference = reference;
		}

		public Integer getNodeData() {
			return data;
		}

		public void setNodeData(Integer element) {
			data = element;
		}

	}

	public static TreeNode addElementInBST(Integer element, TreeNode node) {
		TreeNode newNode = null;
		if (node == null) {
			node = new TreeNode();
			node.setNodeData(element);
			return node;
		}
		if (element <= node.getNodeData()) {
			if (node.getLeftReference() == null) {
				newNode = new TreeNode();
				newNode.setNodeData(element);
				node.setLeftReference(newNode);
				return node;
			} else {
				addElementInBST(element, node.getLeftReference());
			}
		}
		if (element > node.getNodeData()) {
			if (node.getRightReference() == null) {
				newNode = new TreeNode();
				newNode.setNodeData(element);
				node.setRightReference(newNode);
				return node;
			} else {
				addElementInBST(element, node.getRightReference());
			}
		}
		return node;
	}

	public static void searchBST(Integer element, TreeNode node) {
		if (node == null) {
			System.out.println(element + " Not Present in the given BST!!");
			return;
		}
		if (element == node.getNodeData()) {
			System.out.println(element + " found in BST!!!!");
			return;
		}
		if (element <= node.getNodeData())
			searchBST(element, node.getLeftReference());
		if (element > node.getNodeData())
			searchBST(element, node.getRightReference());
	}

	public static void main(String[] arg) {
		System.out.println("Constructing and searching element in BST==>");
		Integer[] inputIntArray = new Integer[] { 17, 1, 45, 78, 43, 23, 15, 56, 76, -12, 100, 0, 22 };
		TreeNode rootNode = null;
		for (Integer ipElement : inputIntArray) {
			rootNode = addElementInBST(ipElement, rootNode);
		}
		System.out.println("BST Constructed!!!!");
		System.out.println("Searching elements in BST!!!");
		searchBST(16, rootNode);
		searchBST(0, rootNode);
		searchBST(89, rootNode);
		searchBST(-12, rootNode);
	}

}
