package extra_exercise.crud_product.services;

import extra_exercise.crud_product.models.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductManagement {
    private static final String PATH = "src\\extra_exercise\\crud_product\\repository\\";
    List<Product> listProduct = new ArrayList<>();

    public ArrayList<Product> productFromFile(String nameFile) {
        BufferedReader fileReader;
        ArrayList<Product> inputList = new ArrayList<>();
        try {
            String line;
            String[] arrProduct;

            fileReader = new BufferedReader(new FileReader(new File(PATH,nameFile)));
            while ((line = fileReader.readLine()) != null) {
                arrProduct = line.split(",");
                Product product = new Product(  Integer.parseInt(arrProduct[0]),arrProduct[1],
                                                arrProduct[2],Integer.parseInt(arrProduct[3]));
                inputList.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputList;
    }

    public void addProduct(ArrayList<Product> product){
        listProduct.addAll(product);
        System.out.println("Done");
    }
    public void showProduct(){ // can truyen vao 1 list hoac ArrayList
        for(Product product : listProduct) {
            System.out.println(product);
        }
    }
    public void editProduct(){ // can them tham so co ghi de hay k?

    }
    public void searchProduct(){

    }
    public void sortProduct(){

    }
    public void deleteProduct(){

    }
}
