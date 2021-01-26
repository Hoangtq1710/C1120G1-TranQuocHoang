package extra_exercise.crud_product.services;

import extra_exercise.crud_product.models.Product;
import extra_exercise.crud_product.validation.AscendingPriceSorting;
import extra_exercise.crud_product.validation.DescendingPriceSorting;

import java.util.*;

public class ProductManagement {
    static Scanner scanner = new Scanner(System.in);

    public void addNewProduct(){
        List<Product> listProduct = new ArrayList<>();
        try {
            System.out.print("Enter ID of Product : ");
            int id;
            do {
                id = Integer.parseInt(scanner.nextLine());
                if (isIdExist(id)) {
                    System.out.println("Id already exist!");
                }
            } while (isIdExist(id));
            System.out.print("Enter Name of Product : ");
            String name = scanner.nextLine();
            System.out.print("Enter Label of Product : ");
            String label = scanner.nextLine();
            System.out.print("Enter price of Product : ");
            int price = Integer.parseInt(scanner.nextLine());

            Product product = new Product(id,name,label,price);
            listProduct.add(product);
            ReadAndWriteFunction.writeProduct(listProduct,true);

        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
            e.printStackTrace();
        }

    }
    public boolean isIdExist(int id) {
        List<Product> listProduct = ReadAndWriteFunction.readProduct();
        for(Product product : listProduct) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public void showProduct(){
        List<Product> listProduct = ReadAndWriteFunction.readProduct();
        for (int i = 0; i < listProduct.size(); i++) {
            System.out.println((i+1)+". "+listProduct.get(i));
        }
    }
    public void editProduct(){
        List<Product> listProduct = ReadAndWriteFunction.readProduct();
        showProduct();
        System.out.print("\nWhich product do you wanna edit? : ");
        int indexEdit = Integer.parseInt(scanner.nextLine());
        boolean flagEdit = true;
        do {
            System.out.println( "1. Name : "+listProduct.get(indexEdit -1).getName()+"\n"+
                                "2. Label : "+listProduct.get(indexEdit -1).getLabel()+"\n"+
                                "3. Price : "+listProduct.get(indexEdit -1).getPrice()+"\n"+
                                "0. Back");
            System.out.print("Which information do you wanna edit? : ");
            int inforEdit = Integer.parseInt(scanner.nextLine());
            switch (inforEdit) {
                case 1:
                    System.out.print("Enter new Name : ");
                    String editName = scanner.nextLine();
                    listProduct.get(indexEdit -1).setName(editName);
                    break;
                case 2:
                    System.out.print("Enter new Label : ");
                    String editLabel = scanner.nextLine();
                    listProduct.get(indexEdit -1).setName(editLabel);
                    break;
                case 3:
                    System.out.print("Enter new Price : ");
                    int editPrice = Integer.parseInt(scanner.nextLine());
                    listProduct.get(indexEdit -1).setPrice(editPrice);
                    break;
                case 0:
                    flagEdit = false;
                    break;
                default:
                    System.out.println("Failed");
                    break;
            }

        } while (flagEdit);
        ReadAndWriteFunction.writeProduct(listProduct,false);
    }
    public void searchProductByName(){
        List<Product> listProduct = ReadAndWriteFunction.readProduct();
        System.out.print("\nEnter a Name to Search : ");
        String nameSearch = scanner.nextLine();
        for(Product product : listProduct) {
            if (product.getName().contains(nameSearch)) {
                System.out.println(product);
            }
        }
    }
    public void sortPriceProduct(){
        System.out.println( "\nSort Price by\n"+
                            "1. Ascending Sort\n"+
                            "2. Descending Sort");
        int indexSort;
        do {
            System.out.print("Which one? : ");
            indexSort = Integer.parseInt(scanner.nextLine());
            if (indexSort != 1 && indexSort != 2) {
                System.out.println("Just choose 1 or 2!");
            }
        } while (indexSort != 1 && indexSort != 2);
        switch (indexSort) {
            case 1:
                ascending();
                break;
            case 2:
                descending();
                break;
            default:
                System.out.println("Failed");
                break;
        }
    }
    public void ascending(){
        List<Product> listProduct = ReadAndWriteFunction.readProduct();
        AscendingPriceSorting ascend = new AscendingPriceSorting();
        listProduct.sort(ascend);
        ReadAndWriteFunction.writeProduct(listProduct,false);
        showProduct();
    }
    public void descending(){
        List<Product> listProduct = ReadAndWriteFunction.readProduct();
        DescendingPriceSorting descend = new DescendingPriceSorting();
        listProduct.sort(descend);
        ReadAndWriteFunction.writeProduct(listProduct,false);
        showProduct();
    }
    public void deleteProduct(){
        List<Product> listProduct = ReadAndWriteFunction.readProduct();
        showProduct();
        int indexDelete;
        do {
            System.out.print("\nWhich product you wanna delete : ");
            indexDelete = Integer.parseInt(scanner.nextLine());
            if (indexDelete <= 0 || indexDelete > (listProduct.size())) {
                System.out.println("Invalid");
            }
        } while (indexDelete <= 0 || indexDelete > (listProduct.size()));

        listProduct.remove(indexDelete -1);
        ReadAndWriteFunction.writeProduct(listProduct,false);
        showProduct();
    }
}
