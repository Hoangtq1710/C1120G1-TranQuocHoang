package session_12.exercise.product_management.array_list.services;

import session_12.exercise.product_management.array_list.models.Product;
import session_12.exercise.product_management.array_list.ultils.AscendingPriceComparator;
import session_12.exercise.product_management.array_list.ultils.DescendingPriceComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManagement{
    ArrayList<Product> arrProduct = new ArrayList<>();

    public void addProduct(Product product) {
        arrProduct.add(product);
    }
    public boolean isIdExist(int id) {
        for(Product pro : arrProduct) {
            if (id == pro.getId()){
                return true;
            }
        }
        return false;
    }
    public void editProduct(int id) {
        boolean editFlag = true;
        for(Product pro : arrProduct) {
            if (id == pro.getId()){
                boolean flag = true;
                do {
                    System.out.println( "Which information do you wanna change?"+
                            "\n 1. Name"+
                            "\n 2. Label"+
                            "\n 3. Price"+
                            "\n 0. Exit");
                    Scanner scanner = new Scanner(System.in);
                    int input;
                    String inputName;
                    String inputLabel;
                    int inputPrice;
                    do {
                        input = Integer.parseInt(scanner.nextLine());
                    } while (input < 0 || input > 3);
                    switch (input) {
                        case 1:
                            System.out.print("New Name : ");
                            inputName = scanner.nextLine();
                            pro.setName(inputName);
                            break;
                        case 2:
                            System.out.print("New Label : ");
                            inputLabel = scanner.nextLine();
                            pro.setLabel(inputLabel);
                            break;
                        case 3:
                            System.out.print("New Price : ");
                            inputPrice = Integer.parseInt(scanner.nextLine());
                            pro.setPrice(inputPrice);
                            break;
                        case 0:
                            flag = false;
                            break;
                        default:
                            System.out.println("Failed");
                            break;
                    }
                } while (!flag);
                editFlag = false;
            }
        }
        if (editFlag) {
            System.out.println("Wrong Id");
        }
    }
    public void deleteProduct(int id){
        boolean deleteFlag = true;
        for(Product pro : arrProduct) {
            if (id == pro.getId()){
                arrProduct.remove(pro);
                deleteFlag = false;
                break;
            }
        }
        if (deleteFlag) {
            System.out.println("Wrond ID");
        }
    }
    public void displayProduct() {
        for(Product pro : arrProduct) {
            System.out.println(pro);
        }
    }
    public void search(String searchName) {
        boolean flagSearch = true;
        for(Product pro : arrProduct) {
            if (pro.getName().contains(searchName)) {
                System.out.println(pro);
                flagSearch = false;
            }
        }
        if (flagSearch) {
            System.out.println("Oops, "+searchName+" is NOT in our list");
        }
    }
    public void ascendingSort() {
        AscendingPriceComparator ascenCompa = new AscendingPriceComparator();
        Collections.sort(arrProduct, ascenCompa);
        displayProduct();
    }
    public void descendingSort() {
        DescendingPriceComparator descenCompa = new DescendingPriceComparator();
        Collections.sort(arrProduct,descenCompa);
        displayProduct();
    }
}
