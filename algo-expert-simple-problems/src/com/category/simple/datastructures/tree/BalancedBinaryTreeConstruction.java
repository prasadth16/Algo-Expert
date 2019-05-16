package com.category.simple.datastructures.tree;

public class BalancedBinaryTreeConstruction {

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

	static class IsBalanceWithHeight {
		private int height;

		private boolean isBalanced;

		public IsBalanceWithHeight(int height, boolean isBalanced) {
			this.height = height;
			this.isBalanced = isBalanced;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public boolean isBalanced() {
			return isBalanced;
		}

		public void setBalanced(boolean isBalanced) {
			this.isBalanced = isBalanced;
		}

	}

	public static TreeNode ConstructBalancedBST(Integer[] ipArray, int startIndex, int endIndex) {
		TreeNode node = new TreeNode();
		if (endIndex < startIndex)
			return null;
		node.setNodeData(ipArray[(startIndex + endIndex) / 2]);
		node.setLeftReference(ConstructBalancedBST(ipArray, startIndex, ((startIndex + endIndex) / 2) - 1));
		node.setRightReference(ConstructBalancedBST(ipArray, ((startIndex + endIndex) / 2) + 1, endIndex));
		return node;
	}

	/**
	 * This method checks if given binary tree is balanced. We visit every node in
	 * case if the tree is balanced hence the time complexity is O(n) where n is the
	 * number of nodes in the tree. this is the recursive call and hence worst case
	 * number of function calls on the call stack are equal to height of the tree
	 * hence the space complexity is O(h).
	 **/
	public static IsBalanceWithHeight balancedBinaryTreeValidation(TreeNode node) {
		if (node == null)
			return new IsBalanceWithHeight(-1, true);

		IsBalanceWithHeight leftObject = balancedBinaryTreeValidation(node.getLeftReference());
		if (!leftObject.isBalanced()) {
			return new IsBalanceWithHeight(0, false);
		}
		IsBalanceWithHeight rightObject = balancedBinaryTreeValidation(node.getRightReference());
		if (!rightObject.isBalanced()) {
			return new IsBalanceWithHeight(0, false);
		}
		if (Math.abs(leftObject.getHeight() - rightObject.getHeight()) <= 1)
			return new IsBalanceWithHeight(Math.max(leftObject.getHeight(), rightObject.getHeight()) + 1, true);

		return new IsBalanceWithHeight(0, false);
	}

	public static void main(String[] arg) {
		System.out.println("Constructing and searching element in BST==>");
		Integer[] inputIntArray = new Integer[] { -12, 0, 1, 15, 71, 22, 23, 43, 45, 56, 76, 78, 100 };// Assumed that
																										// Array is
																										// sorted by the
																										// sort
																										// algorithm.
		TreeNode node = ConstructBalancedBST(inputIntArray, 0, 12);
		System.out.println("Balanced Search Tree is constructed!!!");
	}

}
