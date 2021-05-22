import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;


// 25 - 60k - 80k (100k+)
// 150k+
// 180k - 250k 
// 300k+ 
// 500k+


enum Traversal {
	BFS, // In level order
	IN_ORDER, //
	PRE_ORDER, //
	POST_ORDER, //
	ZIGZAG //
}

public class BTTree<T> {
	private Node<T> root;

	public void add(int key, T value) {
		if (Objects.isNull(root)) {
			root = new Node<>(key, value);
		} else {
			addChild(root, key, value);
		}
	}

	private void addChild(Node<T> root, int key, T value) {
		if (key > root.key) {
			// right side
			if (Objects.isNull(root.right))
				root.right = new Node<>(key, value);
			else
				addChild(root.right, key, value);
		} else {
			// left side
			if (Objects.isNull(root.left))
				root.left = new Node<>(key, value);
			else
				addChild(root.left, key, value);
		}
	}

	public void print(Traversal traversal) {
		switch (traversal) {
		case BFS: {
			levelOrder(root);
			break;
		}
		case IN_ORDER: {
			inOrder(root);
			break;
		}
		case PRE_ORDER: {
			preOrder(root);
			break;
		}
		case POST_ORDER: {
			postOrder(root);
			break;
		}
		case ZIGZAG: {
			zigZag(root);
			break;
		}
		default:
			break;
		}
	}

	private void zigZag(Node<T> root) {
		Stack<Node<T>> leftToRight = new Stack<>();
		Stack<Node<T>> rightToLeft = new Stack<>();
		leftToRight.push(root);

		while (!leftToRight.isEmpty()) {
			Node<T> node = leftToRight.pop();
			if (!Objects.isNull(node)) {
				System.out.println(node);
				rightToLeft.push(node.right);
				rightToLeft.push(node.left);
			}
			if (leftToRight.isEmpty()) {
				while (!rightToLeft.isEmpty()) {
					node = rightToLeft.pop();
					if (!Objects.isNull(node)) {
						System.out.println(node);
						leftToRight.push(node.left);
						leftToRight.push(node.right);
					}

				}
			}

		}

	}

	// L-R-N
	private void postOrder(Node<T> root) {
		if (Objects.isNull(root))
			return;

		preOrder(root.left);
		preOrder(root.right);
		System.out.println(root);

	}

	// N-L-R
	private void preOrder(Node<T> root) {
		if (Objects.isNull(root))
			return;

		System.out.println(root);
		preOrder(root.left);
		preOrder(root.right);
	}

	public int minNodesByHeight(int height) {
		return height + 1;
	}
	
//	2^h + 1 -1
	public int maxNodesByHeight(int height) {
		return (int)(Math.pow(2, height + 1)) - 1;
	}
	
	public int maxHeightByNodes(int nodes) {
		return nodes - 1;
	}

	public int minHeightByNodes(int nodes) {
		return log2(nodes);
	}

	public int log2(int nodes) {
		return (int) (Math.log(nodes) / Math.log(2));
	}

	// L-N-R
	private void inOrder(Node<T> root) {
		if (Objects.isNull(root))
			return;
		inOrder(root.left);
		System.out.println(root);
		inOrder(root.right);
	}

	private void levelOrder(Node<T> root) {
		Queue<Node<T>> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node<T> node = queue.poll();
			System.out.println(node);
			if (!Objects.isNull(node.left))
				queue.add(node.left);
			if (!Objects.isNull(node.right))
				queue.add(node.right);
		}
	}

	public int height() {
		return height(root);
	}

	private int height(Node<T> root) {
		if (Objects.isNull(root))
			return -1;
		return Math.max(height(root.left), height(root.right)) + 1;
	}

	public void widthByLevel() {
		int level = height(root);
		for (int x = 0; x <= level; x++) {
			System.out.println(width(root, x));
		}
	}

	private int width(Node<T> root, int level) {
		if (Objects.isNull(root))
			return 0;
		if (level == 0)
			return 1;
		return width(root.left, level - 1) + width(root.right, level - 1);
	}

	class Node<M> {

		private int key;
		private Node<M> left;
		private Node<M> right;
		private M value;

		public Node(int key, M value) {
			super();
			this.key = key;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public Node<M> getLeft() {
			return left;
		}

		public void setLeft(Node<M> left) {
			this.left = left;
		}

		public Node<M> getRight() {
			return right;
		}

		public void setRight(Node<M> right) {
			this.right = right;
		}

		public M getValue() {
			return value;
		}

		public void setValue(M value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Key = " + this.key + ", Value = " + this.value;
		}
	}

	public static void main(String[] args) {
		BTTree<Integer> bt = new BTTree<Integer>();
		bt.add(3, 8);
		bt.add(12, 4);
		bt.add(11, 10);
		bt.add(8, 6);
		bt.add(81, 3);
		bt.add(2, 12);
//		bt.print(Traversal.ZIGZAG);
//		System.out.println(bt.height());
		bt.widthByLevel();
	}
}
