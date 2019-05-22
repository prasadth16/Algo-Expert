package com.category.simple.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Search Tree, Construction and Search Time Complexity for both the
 * operations: O(log n) Space Complexity for both the operations: O(log n)
 * 
 * Binary Search Tree Node deletion implemented iterativly and hence the time
 * complexity is O(log n) and the space complexity is 1.
 **/
public class BinarySearchTreeConstruction {

	static class TreeNode {
		private TreeNode leftReference;
		private TreeNode rightReference;
		private Integer data;

		public TreeNode() {

		}

		public TreeNode(TreeNode leftRef, TreeNode rightRef, Integer value) {

			leftReference = leftRef;
			rightReference = rightRef;
			data = value;
		}

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

	static class NearestValueHolder {
		private static int value;
		private static int difference;

		public static int getValue() {
			return value;
		}

		public static void setValue(int value) {
			NearestValueHolder.value = value;
		}

		public static int getDifference() {
			return difference;
		}

		public static void setDifference(int difference) {
			NearestValueHolder.difference = difference;
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

	public static Integer getLeftmostfromRightSubTree(TreeNode node) {
		TreeNode currentNode = node;
		TreeNode parentNode = node;
		while (currentNode.getLeftReference() != null) {
			parentNode = currentNode;
			currentNode = currentNode.getLeftReference();
		}
		parentNode.setLeftReference(null);
		return currentNode.getNodeData();
	}

	public static TreeNode deleteElementFromBST(TreeNode node, Integer element) {
		boolean isOperationComplete = false;
		boolean isLeft = false;
		TreeNode currentNode = node;
		TreeNode parentNode = node;
		while (currentNode != null && !isOperationComplete) {
			if (currentNode.getNodeData() == element) {

				if (currentNode.getLeftReference() == null && currentNode.getRightReference() == null) {
					if (isLeft) {
						parentNode.setLeftReference(null);
					} else {
						parentNode.setRightReference(null);
					}
				} else if (currentNode.getLeftReference() != null && currentNode.getRightReference() != null) {
					currentNode.setNodeData(getLeftmostfromRightSubTree(currentNode.getRightReference()));
				} else {
					if (currentNode.getLeftReference() != null) {
						if (isLeft)
							parentNode.setLeftReference(currentNode.getLeftReference());
						else
							parentNode.setRightReference(currentNode.getLeftReference());
					} else {
						if (isLeft) {
							parentNode.setLeftReference(currentNode.getRightReference());
						} else {
							parentNode.setLeftReference(currentNode.getRightReference());
						}

					}
				}
				isOperationComplete = true;
			}

			if (currentNode.getNodeData() >= element) {
				parentNode = currentNode;
				currentNode = currentNode.getLeftReference();
				isLeft = true;

			} else {
				parentNode = currentNode;
				isLeft = false;
				currentNode = currentNode.getRightReference();
			}
		}
		return node;

	}

	/***
	 * This is recurssive approach Time Complexity is O(n) where n is number of
	 * nodes in the tree space complexity is O(d) as number of recurssive calls on
	 * the calls stack=depth of the tree at any point.
	 */
	public static boolean binarySearchTreeValidator(TreeNode node) {
		if (node != null) {
			if (testNodeForBST(node) && binarySearchTreeValidator(node.getLeftReference())
					&& binarySearchTreeValidator(node.getRightReference())) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	private static boolean testNodeForBST(TreeNode node) {
		if (((node.getLeftReference() != null && node.getLeftReference().getNodeData() <= node.getNodeData())
				|| node.getLeftReference() == null)
				&& ((node.getRightReference() != null && node.getRightReference().getNodeData() > node.getNodeData())
						|| node.getRightReference() == null)) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Traversing BST Pre-orderTraversal, Post-Order Traversal, Inorder Traversal
	 * Time Complexity: O(n) where n is number of nodes in a tree Space Complexity:
	 * O(h) where h is depth of binary tree
	 * 
	 */
	public static List<Integer> preorderTraversal(TreeNode node, List<Integer> opArray) {

		if (node == null) {
			return opArray;
		}

		opArray.add(node.getNodeData());
		preorderTraversal(node.getLeftReference(), opArray);
		preorderTraversal(node.getRightReference(), opArray);
		return opArray;

	}

	public static List<Integer> inOrderTraversal(TreeNode node, List<Integer> opArray) {
		if (node == null) {
			return opArray;
		}

		inOrderTraversal(node.getLeftReference(), opArray);
		opArray.add(node.getNodeData());
		inOrderTraversal(node.getRightReference(), opArray);

		return opArray;
	}

	public static List<Integer> postOrderTraversal(TreeNode node, List<Integer> opArray) {
		if (node == null) {
			return opArray;
		}

		postOrderTraversal(node.getLeftReference(), opArray);
		postOrderTraversal(node.getRightReference(), opArray);
		opArray.add(node.getNodeData());
		return opArray;
	}
	/**
	 * Time Complexity is O(logn)
	 * space complexity is O(1) or constant space
	 * **/
	public static Integer findClosestValueInBST(TreeNode node, Integer targetValue) {
		TreeNode currentNode = node;
		NearestValueHolder.setValue(node.getNodeData());
		NearestValueHolder.setDifference(Math.abs(targetValue - node.getNodeData()));
		while (currentNode != null) {
			if (targetValue == currentNode.getNodeData()) {
				NearestValueHolder.setValue(targetValue);
				break;
			}
			if (Math.abs(targetValue - currentNode.getNodeData()) <= NearestValueHolder.getDifference()) {
				NearestValueHolder.setDifference(Math.abs(targetValue - currentNode.getNodeData()));
				NearestValueHolder.setValue(currentNode.getNodeData());
			}
			if (currentNode.getNodeData() >= targetValue) {
				currentNode = currentNode.getLeftReference();
			} else {
				currentNode = currentNode.getRightReference();
			}
		}

		return NearestValueHolder.getValue();
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

		System.out.println("Deleting elments from BST==>");
		Integer[] inputArray = new Integer[] { 23, 21, 27, 12, 22, 25, 30, 14, 24, 28, 42 };
		rootNode = null;
		for (Integer ipElement : inputArray) {
			rootNode = addElementInBST(ipElement, rootNode);
		}
		System.out.println("BST ready for deletion!!!!");
		// rootNode = deleteElementFromBST(rootNode, 14);
		// System.out.println("Elment 14 deleted!!!!");
		// rootNode = deleteElementFromBST(rootNode, 22);
		// System.out.println("Elment 22 deleted!!!!");
		rootNode = deleteElementFromBST(rootNode, 12);
		System.out.println("Elment 12 deleted!!!!");
		rootNode = deleteElementFromBST(rootNode, 27);
		System.out.println("Elment 27 deleted!!!!");

		inputArray = new Integer[] { 23, 21, 27, 12, 22, 25, 30, 14, 24, 28, 42 };
		rootNode = null;
		for (Integer ipElement : inputArray) {
			rootNode = addElementInBST(ipElement, rootNode);
		}
		System.out.println("is this a perfect BST? " + binarySearchTreeValidator(rootNode));

		rootNode = new TreeNode(new TreeNode(null, null, 24), new TreeNode(null, null, 17), 20);
		System.out.println("is this a perfect BST? " + binarySearchTreeValidator(rootNode));

		rootNode = null;
		for (Integer ipElement : inputArray) {
			rootNode = addElementInBST(ipElement, rootNode);
		}

		System.out.println("Traversing a Tree in all three styles!!!!");

		List<Integer> preOrderList = new ArrayList<>();
		List<Integer> inOrderList = new ArrayList<>();
		List<Integer> postOrderList = new ArrayList<>();
		preorderTraversal(rootNode, preOrderList);
		inOrderTraversal(rootNode, inOrderList);
		postOrderTraversal(rootNode, postOrderList);
		System.out.println("Traversing a Tree --> Pre-order");
		preOrderList.forEach(System.out::println);
		System.out.println("Traversing a Tree --> In-order");
		inOrderList.forEach(System.out::println);
		System.out.println("Traversing a Tree --> Post-order");
		postOrderList.forEach(System.out::println);
		
		System.out.println("Searching the nearest value: ");
		rootNode = null;
		for (Integer ipElement : inputArray) {
			rootNode = addElementInBST(ipElement, rootNode);
		}
		System.out.println("Nearest Element of 29 in the BST is: "+findClosestValueInBST(rootNode,29));
		System.out.println("Nearest Element of 27 in the BST is: "+findClosestValueInBST(rootNode,27));
		System.out.println("Nearest Element of 13 in the BST is: "+findClosestValueInBST(rootNode,13));
	}

}
