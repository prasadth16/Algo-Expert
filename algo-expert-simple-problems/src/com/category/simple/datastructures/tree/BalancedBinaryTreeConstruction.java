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

	public static TreeNode ConstructBalancedBST(Integer[] ipArray, int startIndex, int endIndex) {
		TreeNode node = new TreeNode();
		if (endIndex < startIndex)
			return null;
		node.setNodeData(ipArray[(startIndex + endIndex) / 2]);
		node.setLeftReference(ConstructBalancedBST(ipArray, startIndex, ((startIndex + endIndex) / 2) - 1));
		node.setRightReference(ConstructBalancedBST(ipArray, ((startIndex + endIndex) / 2) + 1, endIndex));
		return node;
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
