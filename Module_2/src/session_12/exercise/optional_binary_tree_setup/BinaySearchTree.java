package session_12.exercise.optional_binary_tree_setup;

public class BinaySearchTree<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BinaySearchTree() {
    }
    public BinaySearchTree(E[] objects){
        for (E object : objects) {
            insert(object);
        }
    }

    @Override
    public boolean insert(E e) {
        if (root == null) {
            root = creatNewNode(e);
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current =current.left;
                } else if (e.compareTo(current.element) > 0){
                    parent = current;
                    current = current.right;
                } else {
                    return false;
                }
            }
            if (e.compareTo(parent.element) < 0) {
                parent.left = creatNewNode(e);
            } else {
                parent.right = creatNewNode(e);
            }
        }
        size++;
        return true;
    }

    @Override
    public int getSize() {
        return size;
    }

    protected TreeNode<E> creatNewNode(E element) {
        return new TreeNode<>(element);
    }

    @Override
    public void inorder() {
        inorder(root);
    }
    protected void inorder(TreeNode<E> root){
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.element+" ");
        inorder(root.right);
    }
}
