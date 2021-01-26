package extra_exercise.crud_product.controllers;

import extra_exercise.crud_product.services.ProductManagement;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Product Management");
        ProductManagement list = new ProductManagement();
        int menu;
        boolean flagMenu = true;
        do {
            System.out.println( "Menu\n"+
                                "1. Add Product\n"+
                                "2. Show Product\n"+
                                "3. Edit Product\n"+
                                "4. Search Product\n"+
                                "5. Sort Product\n"+
                                "6. Delete Product\n"+
                                "0. Exit\n");
            System.out.print("Your choice is : ");
            menu = Integer.parseInt(scanner.nextLine());
            switch (menu) {
                case 1:
                    list.addNewProduct();
                    break;
                case 2:
                    list.showProduct();
                    break;
                case 3:
                    list.editProduct();
                    break;
                case 4:
                    list.searchProductByName();
                    break;
                case 5:
                    list.sortPriceProduct();
                    break;
                case 6:
                    list.deleteProduct();
                    break;
                case 0:
                    flagMenu = false;
                    break;
                default:
                    break;
            }
        } while (flagMenu);
    }
}
