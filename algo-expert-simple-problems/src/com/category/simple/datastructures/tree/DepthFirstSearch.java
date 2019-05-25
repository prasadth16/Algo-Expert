package com.category.simple.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.NodeList;

public class DepthFirstSearch {

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

	static class NTreeNode {
		private List<NTreeNode> chieldNodeList;
		private Integer data;

		public NTreeNode() {

			chieldNodeList = new ArrayList<>();
		}

		public NTreeNode(List<NTreeNode> chieldNodeList, Integer value) {

			this.chieldNodeList = chieldNodeList;
			data = value;
		}

		public List<NTreeNode> getChieldNodeList() {
			return chieldNodeList;
		}

		public void setChieldNodeList(List<NTreeNode> chieldNodeList) {
			this.chieldNodeList = chieldNodeList;
		}

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

	}

	public static List<TreeNode> depthFirstTraversal(TreeNode node, List<TreeNode> opNodeList) {
		if (node == null) {
			return opNodeList;
		}
		opNodeList.add(node);
		depthFirstTraversal(node.getLeftReference(), opNodeList);
		depthFirstTraversal(node.getRightReference(), opNodeList);
		return opNodeList;
	}
	/**
	 * Depth first search traversal using reccurssion.
	 * Time complexity: O(v+E) where v->Vertex/nodes, E->Edges
	 * Another way we can explain the Time complexity as O(V) as program will visit all the nodes in the tree.
	 * Space Complexity is: O(V). Consider a tree with one branch where at one point
	 * there will be V number of stack frames will be on the call stack and hence it is the worst case
	 * space complexity.
	 * **/
	public static List<NTreeNode> depthFirstTraversal(NTreeNode node, List<NTreeNode> opNodeList) {
		if (node == null) {
			return opNodeList;
		}
		opNodeList.add(node);
		node.getChieldNodeList().forEach(n -> depthFirstTraversal(n, opNodeList));
		return opNodeList;
	}

}
