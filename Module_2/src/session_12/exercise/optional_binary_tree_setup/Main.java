package session_12.exercise.optional_binary_tree_setup;

public class Main {
    public static void main(String[] args) {
        BinaySearchTree<String> binaryString = new BinaySearchTree<>();
        binaryString.insert("Hoàng");
        binaryString.insert("Vi");
        binaryString.insert("Quang");
        binaryString.insert("Thuần");
        binaryString.insert("Sang");
        binaryString.insert("Khoa");
        binaryString.insert("Ngọc");
        binaryString.insert("Tùng");
        System.out.println("Inorder sorted");
        binaryString.inorder();
        System.out.println("Size of Tree is "+binaryString.getSize());
    }
}
