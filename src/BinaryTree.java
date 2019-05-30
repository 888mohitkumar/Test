import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

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
		tree.levelOrderTraversalInSprial(tree.root);

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
