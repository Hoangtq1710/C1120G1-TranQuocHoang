package extra_exercise.crud_product.services;

import extra_exercise.crud_product.models.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFunction {
    static final String PATH_FILE =    "src\\extra_exercise\\crud_product\\repository\\product.csv";
    static File file = new File(PATH_FILE);

    public static List<Product> readProduct() {
        List<Product> list = new ArrayList<>();
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] arrProduct;
            while ((line = bufferedReader.readLine()) != null) {
                arrProduct = line.split(",");
                Product product = new Product(  Integer.parseInt(arrProduct[0]),arrProduct[1],
                                                arrProduct[2],Integer.parseInt(arrProduct[3]));
                list.add(product);
            }
        } catch (FileNotFoundException e){
            System.out.println("File NOT found!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    public static void writeProduct(List<Product> list, boolean override) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, override);
            bufferedWriter = new BufferedWriter(fileWriter);
            for(Product product : list) {
                bufferedWriter.write(product.getInfo());
                bufferedWriter.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Error to write file");
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
