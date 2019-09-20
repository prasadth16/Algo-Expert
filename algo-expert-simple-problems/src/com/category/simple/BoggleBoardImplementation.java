package com.category.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
/**Boggle Board Implementation
 * Time Complexity:Traversal and Search->O(n*m*8^s)n and m is height and width of metrix and s is the average length of String. Trie Creation->k*h 
 * Space Complexity:O(K*H) to store trie and K to store output strings.
 * **/
public class BoggleBoardImplementation {
	private static Node parentNode = new Node(false);

	static class Node {
		Map<Character, Node> children;
		Boolean isEndOfWord = false;
		String word = "";

		public Node(Boolean isEndOfWord) {
			this.isEndOfWord = isEndOfWord;
			children = new HashMap<>();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((children == null) ? 0 : children.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (children == null) {
				if (other.children != null)
					return false;
			} else if (!children.equals(other.children))
				return false;
			return true;
		}

		public Map<Character, Node> getChildren() {
			return children;
		}

		public Boolean getIsEndOfWord() {
			return isEndOfWord;
		}

		public String getWord() {
			return word;
		}

		public void setWord(String word) {
			if (isEndOfWord) {
				this.word = word;
			}
		}

	}

	static class BBNode {
		Character character;
		boolean isvisited;
		int i;
		int j;

		public BBNode(Character ipChar, boolean isVisited) {
			this.character = ipChar;
			this.isvisited = isVisited;
		}

		public Character getCharacter() {
			return character;
		}

		public void setCharacter(Character character) {
			this.character = character;
		}

		public boolean isIsvisited() {
			return isvisited;
		}

		public void setIsvisited(boolean isvisited) {
			this.isvisited = isvisited;
		}

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}

		public int getJ() {
			return j;
		}

		public void setJ(int j) {
			this.j = j;
		}

	}

	// inserting string in Trie
	private static void insertWord(String inputWord) {
		int counter = 0;
		Node node = parentNode;
		while (counter < inputWord.length()) {
			Character currChar = inputWord.charAt(counter);
			Node currNode = node.getChildren().get(currChar);
			if (currNode == null) {
				if (counter == inputWord.length() - 1) {
					currNode = new Node(true);
					currNode.setWord(inputWord);
				} else
					currNode = new Node(false);
				node.getChildren().put(currChar, currNode);
			}
			node = currNode;
			counter++;
		}
	}

	// Searching word character by character in Trie
	private static Optional<Node> searchCharacter(BBNode characterNode, Node node) {
		if (node.getChildren().keySet().contains(characterNode.getCharacter())) {
			return Optional.of(node.getChildren().get(characterNode.getCharacter()));
		} else {
			return Optional.empty();
		}
	}

	private static void insertAllInputWords(String[] ipStrings) {
		Arrays.stream(ipStrings).forEach(BoggleBoardImplementation::insertWord);
	}

	public static Set<String> searchWordInBoggleBoard(String[] ipStrings, BBNode[][] boggleBoard) {
		Set<String> searchedWordList = new HashSet<String>();

		// insert all the words into Trie data structure
		insertAllInputWords(ipStrings);

		// Iterate over the boggle board and search the input words
		for (int i = 0; i < boggleBoard.length; i++) {
			for (int j = 0; j < boggleBoard[0].length; j++) {
				searchBoggleIndex(i, j, boggleBoard, searchedWordList, parentNode);
			}
		}
		return searchedWordList;
	}

	private static void searchBoggleIndex(int i, int j, BBNode[][] boggleBoard, Set<String> searchedWordList,
			Node node) {
		if (!boggleBoard[i][j].isvisited) {
			List<BBNode> children = new ArrayList<>();
			Optional<Node> optionalNode = searchCharacter(boggleBoard[i][j], node);
			if (!optionalNode.isPresent()) {
				return;
			}
			if (optionalNode.isPresent() && optionalNode.get().isEndOfWord) {
				searchedWordList.add(optionalNode.get().getWord());
				return;
			}
			if (optionalNode.isPresent()) {
				boggleBoard[i][j].setIsvisited(true);
				// list the neighbour of the node
				if (i - 1 >= 0) {
					boggleBoard[i - 1][j].setI(i - 1);
					boggleBoard[i - 1][j].setJ(j);
					children.add(boggleBoard[i - 1][j]);
				}
				if (j + 1 < boggleBoard[0].length && i - 1 >= 0) {
					boggleBoard[i - 1][j + 1].setI(i - 1);
					boggleBoard[i - 1][j + 1].setJ(j + 1);
					children.add(boggleBoard[i - 1][j + 1]);
				}
				if (j + 1 < boggleBoard[0].length) {
					boggleBoard[i][j + 1].setI(i);
					boggleBoard[i][j + 1].setJ(j + 1);
					children.add(boggleBoard[i][j + 1]);
				}
				if (i + 1 < boggleBoard.length && j + 1 < boggleBoard[0].length) {
					boggleBoard[i+1][j + 1].setI(i + 1);
					boggleBoard[i+1][j + 1].setJ(j + 1);
					children.add(boggleBoard[i+1][j + 1]);
				}
				if (i + 1 < boggleBoard.length) {
					boggleBoard[i + 1][j].setI(i + 1);
					boggleBoard[i + 1][j].setJ(j);
					children.add(boggleBoard[i + 1][j]);
				}
				if (i + 1 < boggleBoard.length && j - 1 >= 0) {
					boggleBoard[i + 1][j - 1].setI(i + 1);
					boggleBoard[i + 1][j - 1].setJ(j - 1);
					children.add(boggleBoard[i + 1][j - 1]);
				}
				if (j - 1 >= 0) {
					boggleBoard[i][j - 1].setI(i);
					boggleBoard[i][j - 1].setJ(j - 1);
					children.add(boggleBoard[i][j - 1]);
				}
				if (i - 1 >= 0 && j - 1 >= 0) {
					boggleBoard[i - 1][j - 1].setI(i - 1);
					boggleBoard[i - 1][j - 1].setJ(j - 1);
					children.add(boggleBoard[i - 1][j - 1]);
				}

				children.forEach(BBNode -> searchBoggleIndex(BBNode.getI(), BBNode.getJ(), boggleBoard,
						searchedWordList, optionalNode.get()));
			}
		}
		boggleBoard[i][j].setIsvisited(false);
	}

	public static void main(String[] args) {

		// row one
		BBNode t = createBBNode('t');
		BBNode h = createBBNode('h');
		BBNode i = createBBNode('i');
		BBNode s = createBBNode('s');
		BBNode i1 = createBBNode('i');
		BBNode s1 = createBBNode('s');
		BBNode a = createBBNode('a');

		// row two
		BBNode s2 = createBBNode('s');
		BBNode i2 = createBBNode('i');
		BBNode m = createBBNode('m');
		BBNode p = createBBNode('p');
		BBNode l = createBBNode('l');
		BBNode e = createBBNode('e');
		BBNode x = createBBNode('x');

		// row three
		BBNode b = createBBNode('b');
		BBNode x1 = createBBNode('x');
		BBNode x2 = createBBNode('x');
		BBNode x3 = createBBNode('x');
		BBNode x4 = createBBNode('x');
		BBNode e1 = createBBNode('e');
		BBNode b1 = createBBNode('b');

		// row four
		BBNode x5 = createBBNode('x');
		BBNode o = createBBNode('o');
		BBNode g = createBBNode('g');
		BBNode g1 = createBBNode('g');
		BBNode l1 = createBBNode('l');
		BBNode x6 = createBBNode('x');
		BBNode o1 = createBBNode('o');
		BBNode[][] boggleBoard = new BBNode[][] { { t,  h,  i,  s,  i1, s1, a }, 
												  { s2, i2, m,  p,  l,  e,  x },
												  { b,  x1, x2, x3, x4, e1, b1 }, 
												  { x5, o,  g,  g1, l1, x6, o1 } };
		Set<String> wordsFound = searchWordInBoggleBoard(new String[] { "this", "is", "a", "boggle","Ram" }, boggleBoard);
		wordsFound.forEach(System.out::println);
	}

	private static BBNode createBBNode(Character charr) {
		return new BBNode(charr, false);
	}
}
