package session_12.exercise.product_management.linked_list;

import session_12.exercise.product_management.array_list.Product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(1000,"SAMSUNG","SAMSUNG Inc", 500000);
        Product product2 = new Product(1001,"SONY","SONY Inc", 700000);
        Product product3 = new Product(1002, "HITACHI", "HITACHI Inc", 300000);

        ProductManaLinkedList list = new ProductManaLinkedList();
        list.addProduct(product1);
        list.addProduct(product2);
        list.addProduct(product3);

        Scanner scanner = new Scanner(System.in);
        int menu;
        boolean flagMenu = true;
        do {
            System.out.println( "\nMENU\n"+
                    "1. Add Product\n"+
                    "2. Display Product\n"+
                    "3. Edit Product\n"+
                    "4. Search Product\n"+
                    "5. Sort Product\n"+
                    "6. Delete Product\n"+
                    "0. Exit\n"
            );
            do {
                System.out.print("Your choice is : ");
                menu = Integer.parseInt(scanner.nextLine());
                if (menu < 0 || menu > 6){
                    System.out.println("Choose options in menu!");
                }
            } while (menu < 0 || menu > 6);
            switch (menu) {
                case 1 :
                    int id;
                    String name;
                    String label;
                    int price;
                    do {
                        System.out.print("Id of Product : ");
                        id = Integer.parseInt(scanner.nextLine());
                        if (list.isIdExist(id) || id < 0) {
                            System.out.println("Invalid ID!");
                        }
                    } while (id < 0 || list.isIdExist(id));
                    System.out.print("Name of Product : ");
                    name = scanner.nextLine();
                    System.out.print("Label of Product : ");
                    label = scanner.nextLine();
                    System.out.print("Price of Product : ");
                    do {
                        price = Integer.parseInt(scanner.nextLine());
                        if (price < 0) {
                            System.out.println("Invalid Price!");
                        }
                    } while (price < 0);

                    Product newPro = new Product(id,name,label,price);
                    list.addProduct(newPro);
                    break;
                case 2 :
                    list.displayProduct();
                    break;
                case 3 :
                    int editId;
                    System.out.print("Enter the ID : ");
                    editId = Integer.parseInt(scanner.nextLine());
                    list.editProduct(editId);
                    break;
                case 4 :
                    String searchName;
                    System.out.print("Enter a name you wanna search : ");
                    searchName = scanner.nextLine();
                    list.search(searchName);
                    break;
                case 5 :
                    int sort;
                    boolean flagSort = true;
                    System.out.println( "Sort By\n" +
                            "1. Ascending\n"+
                            "2. Descending\n"
                    );
                    do {
                        System.out.print("Choice is  : ");
                        sort = Integer.parseInt(scanner.nextLine());
                        switch (sort) {
                            case 1:
                                list.ascendingSort();
                                flagSort = false;
                                break;
                            case 2:
                                list.descendingSort();
                                flagSort = false;
                                break;
                            default:
                                System.out.println("Choose 1 or 2!");
                                break;
                        }
                    } while (flagSort);
                    break;
                case 6 :
                    int deleteId;
                    System.out.print("Enter a ID you wanna delete : ");
                    do {
                        deleteId = Integer.parseInt(scanner.nextLine());
                        if (deleteId < 0) {
                            System.out.println("Invalid ID!");
                        }
                    } while (deleteId < 0);
                    list.deleteProduct(deleteId);
                    break;
                case 0 :
                    flagMenu = false;
                    break;
            }
        } while (flagMenu);
    }
}
