package app;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
	protected TreeNode<E> root;
	protected int size = 0;

	public BST() {
	}

	public BST(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			insert(objects[i]);
	}

	@Override
	public boolean insert(E e) {
		TreeNode node = new TreeNode<>(e);
		if (root == null)
			root = node;
		else {
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while (current != null) {
				if (e.compareTo(current.getElement()) < 0) {
					parent = current;
					current = current.getLeft();
				} else if (e.compareTo(current.getElement()) > 0) {
					parent = current;
					current = current.getRight();
				} else
					return false;
			}
			if (e.compareTo(parent.getElement()) < 0)
				parent.setLeft(node);
			else
				parent.setRight(node);
		}
		size++;
		return true;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void inorder() {
		inorder(root);
	}

	protected void inorder(TreeNode<E> root) {
		if (root == null) return;
		inorder(root.getLeft());
		System.out.println(root.getElement()+ " ");
		inorder(root.getRight());
	}
}
