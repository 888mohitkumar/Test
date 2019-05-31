import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	static boolean result1 = false;

	static boolean result2 = false;

	// Function to convert given binary Tree to its mirror
	public static void convertToMirror(final Node root) {
		// base case: if tree is empty
		if (root == null) {
			return;
		}

		// convert left subtree
		convertToMirror(root.left);

		// convert right subtree
		convertToMirror(root.right);

		// swap left subtree with right subtree
		swap(root);
	}

	public static void main(final String args[]) {

		final BinaryTree tree = new BinaryTree();
		tree.root = new Node(4);
		tree.root.left = new Node(2);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(1);
		tree.root.left.left.right = new Node(20);
		tree.root.left.right = new Node(3);
		tree.root.right.right = new Node(6);
		tree.root.right.right.right = new Node(7);

		/*
		 * if (tree.isBST()) { System.out.println("IS BST"); } else {
		 * System.out.println("Not a BST"); }
		 */

		// System.out.println("Height of tree is :::" +
		// tree.getHeight(tree.root));
		// tree.leftView(tree.root);
		// tree.bottomView(tree.root);
		// tree.levelOrderTraversal(tree.root);
		// tree.levelOrderTraversalInSprial(tree.root);
		// tree.pathToNode(tree.root, 7);
		// tree.LCAbyPathArray(tree.root, 20, 3);
		// final Node temp = tree.LCA(tree.root, 20, 3);

		// final Node temp = tree.LCA_Final(tree.root, 20, 300);
		// System.out.println("In main method and LCA is ::" + temp.data);
		tree.levelOrderTraversal(tree.root);
		convertToMirror(tree.root);
		System.out.println("After Mirror");
		tree.levelOrderTraversal(tree.root);

	}

	public static void swap(final Node root) {
		if (root == null) {
			return;
		}

		final Node temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	Node root;

	Node prev;

	public void bottomView(final Node root) {
		final Map<Integer, Integer> hm = new HashMap<>();
		final int hd = 0;
		printBottomView(root, hd, hm);
		for (final Integer i : hm.keySet()) {
			System.out.print(i + "   ");
			System.out.println(hm.get(i));
		}
	}

	public boolean findPathToNode(final Node root, final int element, final List<Integer> al) {
		if (root == null) {
			return false;
		}
		al.add(root.data);
		if (root.data == element) {
			System.out.println("Element has found and path for element  :::" + element);
			for (final Integer i : al) {
				System.out.println(i);
			}
			return true;
		}
		if (findPathToNode(root.left, element, al) || findPathToNode(root.right, element, al)) {
			return true;
		} else {
			al.remove(al.size() - 1);
			return false;
		}
	}

	public int getHeight(final Node root) {
		if (root == null) {
			return 0;
		}
		final int leftHeight = getHeight(root.left);
		final int rightHeight = getHeight(root.left);
		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}

	public boolean getPathToNode(final Node root, final int element, final int arr[], int index) {
		if (root == null) {
			return false;
		}
		arr[index++] = root.data;
		if (root.data == element) {
			printArray(arr, index);
			return true;
		}
		return getPathToNode(root.left, element, arr, index) || getPathToNode(root.right, element, arr, index);
	}

	boolean isBST() {
		prev = null;
		// return isBST(root);
		final List<Integer> al = new ArrayList<>();
		isBST(root, al);
		Integer min = Integer.MIN_VALUE;
		for (final Integer i : al) {
			System.out.println(i);
			if (min > i) {
				return false;
			}
			min = i;

		}
		return true;
	}

	void isBST(final Node node, final List al) {

		if (node == null) {
			return;
		}
		isBST(node.left, al);
		al.add(node.data);
		isBST(node.right, al);

	}

	public Node LCA(final Node root, final int element1, final int element2) {
		final Optional<Node> optional = Optional.ofNullable(root);
		if (!optional.isPresent()) {
			return root;
		}
		if (root.data == element1) {
			result1 = true;
			return root;
		}
		if (root.data == element2) {
			result2 = true;
			return root;
		}
		final Node leftRoot = LCA(root.left, element1, element2);
		final Node rightRoot = LCA(root.right, element1, element2);

		if (leftRoot != null && rightRoot != null) {
			return root;
		} else {
			return leftRoot == null ? rightRoot : leftRoot;
		}
	}

	public Node LCA_Final(final Node root, final int element1, final int element2) {

		final Node temp = LCA(root, element1, element2);
		if (result1 && result2) {
			return temp;
		}
		return null;
	}

	public void LCAbyPathArray(final Node root, final int el1, final int el2) {
		final List<Integer> al1 = new ArrayList<>();
		final List<Integer> al2 = new ArrayList<>();
		if (findPathToNode(root, el1, al1) && findPathToNode(root, el2, al2)) {
			for (int i = 0; i < al1.size() && i < al2.size(); i++) {
				if (al1.get(i) != al2.get(i)) {
					System.out.println("LCA is ::" + al1.get(i - 1));
					break;
				}
			}
		} else {
			System.out.println("Element do not exists");
		}

	}

	void leftView(final Node root) {
		if (root == null) {
			return;
		}
		final Queue<Node> queue = new LinkedList<>();
		Boolean flag = false;
		queue.add(root);
		queue.add(null);
		System.out.println(root.data);
		while (!queue.isEmpty()) {
			final Node temp = queue.remove();
			if (temp == null) {
				flag = true;
				queue.add(null);
				continue;
			} else if (flag == true) {
				System.out.println(temp.data);
				flag = false;
			}
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	public void levelOrderTraversal(final Node root) {
		final Optional optional = Optional.ofNullable(root);
		if (!optional.isPresent()) {
			return;
		}
		final Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			final Node temp = queue.remove();
			if (temp == null) {
				if (!queue.isEmpty()) {
					queue.add(null);
					System.out.println();
				}
			} else {
				System.out.print("" + temp.data + " ,");
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
		}
	}

	/*
	 * boolean isBST(final Node node) {
	 *
	 * if (node != null) { if (!isBST(node.left)) { return false; }
	 *
	 * // allows only distinct values node if (prev != null && node.data <=
	 * prev.data) { return false; } prev = node; return isBST(node.right); }
	 * return true; }
	 */

	/*
	 * boolean isBST(final Node node) {
	 *
	 * if (node == null) { return true; } if (!isBST(node.left)) { return false;
	 * }
	 *
	 * // allows only distinct values node if (prev != null && node.data <=
	 * prev.data) { return false; } else { prev = node; } if
	 * (!isBST(node.right)) { return false; } else { return true; } }
	 */

	public void levelOrderTraversalInSprial(final Node root) {
		final Optional optional = Optional.ofNullable(root);
		if (!optional.isPresent()) {
			return;
		}
		final Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);

		final Stack<Node> stack = new Stack<>();
		boolean stack_on = true;

		while (!queue.isEmpty()) {
			final Node temp = queue.remove();
			if (temp == null) {
				if (!queue.isEmpty()) {
					queue.add(null);
				}
				if (stack_on) {
					printStack(stack);
				}
				stack_on = !stack_on; // change the switch

			} else {
				if (stack_on) {
					stack.push(temp);
				} else {
					System.out.print("" + temp.data + " ,");
				}

				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}

			}
		}
	}

	public void pathToNode(final Node root, final int element) {
		final int arr[] = new int[500];
		final int index = 0;
		getPathToNode(root, element, arr, index);
	}

	private void printArray(final int[] arr, final int index) {

		for (int i = 0; i < index; i++) {
			System.out.println(arr[i]);
		}
	}

	public void printBottomView(final Node root, final int hd, final Map<Integer, Integer> hm) {
		final Optional<Node> optional = Optional.ofNullable(root);
		if (!optional.isPresent()) {
			return;
		}
		hm.put(hd, root.data);
		printBottomView(root.left, hd - 1, hm);
		printBottomView(root.right, hd + 1, hm);
	}

	private void printStack(final Stack<Node> stack) {
		// System.out.println("Stack print now ");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().data + " ,");
		}

		// System.out.println();
	}

}

class Node {
	int data;
	Node left, right;

	public Node(final int item) {
		data = item;
		left = right = null;
	}

	// https://github.com/888mohitkumar/Test.git
}
