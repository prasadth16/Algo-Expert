package com.category.simple.datastructures.tree.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class GraphBredthFirstTraversal {
	class GraphNode {
		private int value;
		private boolean isVisited;
		private List<GraphNode> adjecentNodeList;

		public GraphNode(int value, boolean isVisited) {
			super();
			this.value = value;
			this.isVisited = isVisited;
		}

		public GraphNode() {
			super();
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public boolean isVisited() {
			return isVisited;
		}

		public void setVisited(boolean isVisited) {
			this.isVisited = isVisited;
		}

		public List<GraphNode> getAdjecentNodeList() {
			return adjecentNodeList;
		}

		public void setAdjecentNodeList(List<GraphNode> adjecentNodeList) {
			this.adjecentNodeList = adjecentNodeList;
		}

		@Override
		public String toString() {
			return " " + value;
		}

		@Override
		public boolean equals(Object o) {
			if (!(o instanceof GraphNode))
				return false;
			if (o.equals(this)) {
				return true;
			}
			GraphNode node = (GraphNode) o;
			if (node.getValue() == this.value) {
				return true;
			}
			return false;
		}
	}

	private List<GraphNode> adjecencyList;
	private String[] opArray;

	public GraphBredthFirstTraversal() {

		super();
		GraphNode n1 = new GraphNode(23, false);
		GraphNode n2 = new GraphNode(10, false);
		GraphNode n3 = new GraphNode(33, false);
		GraphNode n4 = new GraphNode(17, false);
		GraphNode n5 = new GraphNode(21, false);
		GraphNode n6 = new GraphNode(12, false);
		List<GraphNode> nodeList = Arrays.asList(n4, n2, n5);
		n1.setAdjecentNodeList(nodeList);
		nodeList = Arrays.asList(n1, n3);
		n2.setAdjecentNodeList(nodeList);
		nodeList = Arrays.asList(n2, n5);
		n3.setAdjecentNodeList(nodeList);
		nodeList = Arrays.asList(n1, n5);
		n4.setAdjecentNodeList(nodeList);
		nodeList = Arrays.asList(n3, n4, n1, n6);
		n5.setAdjecentNodeList(nodeList);
		nodeList = Arrays.asList(n5);
		n6.setAdjecentNodeList(nodeList);
		adjecencyList = Arrays.asList(n1, n2, n3, n4, n5, n6);
	}

	/**
	 * Visiting and exploring node exactly once and hence time complexity is O(n)
	 * where n is number of nodes. space complexity: O(n) as this is not in place
	 * manipulation.
	 **/

	public String[] BFSForGraph() {
		opArray = new String[6];
		GraphNode[] tmpArray = new GraphNode[6];
		GraphNode firstNode = adjecencyList.get(0);
		firstNode.setVisited(true);
		tmpArray[0] = firstNode;
		opArray[0] = firstNode.toString();
		int maincounter = 0;
		int subCounter = 0;
		while (maincounter < tmpArray.length) {
			GraphNode node = tmpArray[maincounter];
			for (GraphNode nd : node.getAdjecentNodeList()) {
				if (!nd.isVisited) {
					nd.setVisited(true);
					tmpArray[++subCounter] = nd;
					opArray[subCounter] = nd.toString();
				}
			}
			maincounter++;
		}

		return opArray;
	}
	/**
	 * Visiting and exploring node exactly once and hence time complexity is O(n)
	 * where n is number of nodes. space complexity: O(n) as this is not in place
	 * manipulation.
	 **/

	public String[] DFSForGraph() {
		opArray = new String[6];
		int counter = 0;
		Deque<GraphNode> nodeStack = new ArrayDeque<>();
		GraphNode firstNode = adjecencyList.get(0);
		firstNode.setVisited(true);
		nodeStack.push(firstNode);
		opArray[counter] = firstNode.toString();
		GraphNode tmpNode = null;
		while (!nodeStack.isEmpty()) {
			tmpNode = null;
			for (GraphNode nd : nodeStack.peekFirst().getAdjecentNodeList()) {
				if (!nd.isVisited) {
					tmpNode = nd;
					break;
				}
			}
			if (tmpNode != null) {
				tmpNode.setVisited(true);
				nodeStack.push(tmpNode);
				opArray[++counter] = tmpNode.toString();
			} else {
				nodeStack.pop();
			}

		}
		return opArray;
	}

	public static void resetVisitedFlag(List<GraphNode> nodeList) {
		if (nodeList.size() > 0) {
			nodeList.forEach(nd -> nd.setVisited(false));
		}
	}

	public static void main(String[] arg) {
		GraphBredthFirstTraversal trvrsl = new GraphBredthFirstTraversal();

		String[] opArray = trvrsl.BFSForGraph();
		System.out.println("BFS Traversal");
		for (String str : opArray) {
			System.out.println(str);
		}
		resetVisitedFlag(trvrsl.adjecencyList);
		opArray = trvrsl.DFSForGraph();
		System.out.println("DFS Traversal");
		for (String str : opArray) {
			System.out.println(str);
		}
	}

}
