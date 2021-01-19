package session_12.exercise.optional_binary_tree;

public class BinaryTree<E> {
    Node<E> root;

    public Node<E> addRecursive(Node<E> current, int value){
        if (current == null) {
            return new Node<>(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right,value);
        } else {
            return current;
        }
        return current;
    }
    public void add(int value){
        root = addRecursive(root,value);
    }

    public boolean containsNodeRecursive(Node<E> current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        if (value < current.value) {
            return containsNodeRecursive(current.left,value);
        } else {
            return containsNodeRecursive(current.right, value);
        }
    }
    public boolean containsNode(int value){
        return containsNodeRecursive(root, value);
    }

    public Node<E> deleteRecursive(Node<E> current, int value) {
        if (current == null) {
            return null;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        if (value > current.value) {
            current.right = deleteRecursive(current.right, value);
            return current;
        }
        if (current.left == null && current.right == null) {
            return null;
        }
        if (current.left == null) {
            return current.right;
        }
        if (current.right == null) {
            return current.left;
        }
        int smallestValue = findSmallestValue(current.right);
        current.value = smallestValue;
        current.right = deleteRecursive(current.right, smallestValue);
        return current;
    }
    public int findSmallestValue(Node<E> root) {
        if (root.left == null) {
            return root.value;
        } else {
            return findSmallestValue(root.left);
        }
    }
    public void delete(int value) {
        deleteRecursive(root, value);
    }
    public void searchNode(int value){
        if (this.containsNode(value)) {
            System.out.println("Our Tree is containing this value "+value);
        } else {
            System.out.println("Our Tree is NOT containing this value "+value);
        }
    }
    public void PostOrder(Node<E> root) {
        if (root != null) {
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(" "+root.value);
        }
    }
    public void InOrder(Node<E> root) {
        if (root != null) {
            PostOrder(root.left);
            System.out.print(" "+root.value);
            PostOrder(root.right);
        }
    }
    public void PreOrder(Node<E> root) {
        if (root != null) {
            System.out.print(" "+root.value);
            PostOrder(root.left);
            PostOrder(root.right);
        }
    }
}
