package session_12.exercise.optional_binary_tree;

public class MainBinaryTree {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = new Node<>(10);
        tree.add(6);
        tree.add(16);
        tree.add(11);
        tree.add(7);
        tree.add(1);
        tree.add(17);
        tree.add(12);
        tree.add(8);
        tree.add(9);

        tree.searchNode(19);

        tree.PostOrder(tree.root);
        System.out.println();

        tree.delete(7);

        tree.InOrder(tree.root);
        System.out.println();

        tree.add(25);
        tree.PreOrder(tree.root);

    }
}
