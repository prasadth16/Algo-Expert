package com.category.simple.datastructures.tree.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Program to get Youngest common Manager. Please check AlgoExpert for more
 * program description. Time Complexity: O(n) where n is the number of employyes
 * in an organization. Space Complexity: O(D) where D is depth of Organizational
 * structure.
 * 
 **/
public class YoungestCommonManagerAlgorithm {
	static class ReturnValue {
		private Node youngestCommonManager;
		private int childCount;

		public Node getYoungestCommonManager() {
			return youngestCommonManager;
		}

		public void setYoungestCommonManager(Node youngestCommonManager) {
			this.youngestCommonManager = youngestCommonManager;
		}

		public int getChildCount() {
			return childCount;
		}

		public void setChildCount(int childCount) {
			this.childCount = childCount;
		}

	}

	static class Node {
		private String nodeName;
		private List<Node> repoties;

		public Node(String nodeName, List<Node> reporties) {
			super();
			this.nodeName = nodeName;
			this.repoties = reporties;
		}

		public Node() {
			super();
		}

		public String getNodeName() {
			return nodeName;
		}

		public void setNodeName(String nodeName) {
			this.nodeName = nodeName;
		}

		public List<Node> getRepoties() {
			return repoties;
		}

		public void setRepoties(List<Node> repoties) {
			this.repoties = repoties;
		}

	}

	public static ReturnValue findYCA(Node rootNode, Node rep1, Node rep2, ReturnValue ret) {
		if (rootNode.getRepoties().size() > 0) {
			for (Node n : rootNode.getRepoties()) {
				ReturnValue tmpRet = findYCA(n, rep1, rep2, new ReturnValue());
				if (tmpRet.getChildCount() >= 2 && ret.getYoungestCommonManager() == null
						&& tmpRet.getYoungestCommonManager() != null) {
					ret.setYoungestCommonManager(tmpRet.getYoungestCommonManager());
					ret.setChildCount(ret.getChildCount() + tmpRet.getChildCount());
				} else {
					ret.setChildCount(ret.getChildCount() + tmpRet.getChildCount());
				}

			}
			if (ret.getChildCount() >= 2 && ret.getYoungestCommonManager() == null) {
				ret.setYoungestCommonManager(rootNode);
			}
		}
		if ((rootNode.getNodeName().equalsIgnoreCase(rep1.getNodeName())
				|| rootNode.getNodeName().equalsIgnoreCase(rep2.getNodeName()))
				&& ret.getYoungestCommonManager() == null) {
			ret.setChildCount(ret.getChildCount() + 1);
			ret.setYoungestCommonManager(rootNode);
		}
		return ret;
	}

	public static void main(String[] arg) {
		Node H = new Node("H", new ArrayList<>());
		Node I = new Node("I", new ArrayList<>());
		Node D = new Node("D", Arrays.asList(H, I));
		Node E = new Node("E", new ArrayList<>());
		Node F = new Node("F", new ArrayList<>());
		Node G = new Node("G", new ArrayList<>());
		Node B = new Node("B", Arrays.asList(D, E));
		Node C = new Node("C", Arrays.asList(F, G));
		Node A = new Node("A", Arrays.asList(B, C));
		YoungestCommonManagerAlgorithm.ReturnValue ret = new YoungestCommonManagerAlgorithm.ReturnValue();
		findYCA(A, E, I, ret);

		System.out.println("Youngest Common Manager is: " + ret.getYoungestCommonManager().getNodeName());

		ret = new YoungestCommonManagerAlgorithm.ReturnValue();
		findYCA(A, H, G, ret);

		System.out.println("Youngest Common Manager SecondTime is: " + ret.getYoungestCommonManager().getNodeName());

		ret = new YoungestCommonManagerAlgorithm.ReturnValue();
		findYCA(A, H, D, ret);

		System.out.println("Youngest Common Manager Third Time is: " + ret.getYoungestCommonManager().getNodeName());

	}
}
