package extra_exercise.crud_product.controllers;

import extra_exercise.crud_product.services.ProductManagement;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void writeToCSVFile(){
        int number;
        String result = "";

        System.out.print("How many Product you wanna add? : ");
        number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.print("Enter ID of Product : ");
            result += Integer.parseInt(scanner.nextLine())+",";
            System.out.print("Enter Name of Product : ");
            result += scanner.nextLine()+",";
            System.out.print("Enter Label of Product : ");
            result += scanner.nextLine()+",";
            System.out.print("Enter price of Product : ");
            result += Integer.parseInt(scanner.nextLine())+"\n";
        }
    }
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

//                    System.out.print("Enter a Path of File : ");
//                    String path = scanner.nextLine();
//                    list.addProduct(list.productFromFile(path));
                    break;
                case 2:
                    list.showProduct();
                    break;
                case 3:
                    list.editProduct();
                    break;
                case 4:
                    list.searchProduct();
                    break;
                case 5:
                    list.sortProduct();
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
