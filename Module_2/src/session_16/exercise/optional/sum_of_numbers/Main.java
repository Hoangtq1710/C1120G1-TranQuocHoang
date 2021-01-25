package session_16.exercise.optional.sum_of_numbers;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static final String PATH = "src/session_16/exercise/optional/sum_of_numbers/";
    public static void readFileTxt(String nameFile) {
        try {
            File file = new File(PATH+nameFile);
            if (!file.exists()) {
                throw new FileNotFoundException("File NOT found");
            } else {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line;
                int sum = 0;
                boolean flag = true;
                while ((line = bufferedReader.readLine()) != null) {
                    for (int i = 0; i < line.length(); i++) {
                        if (!Character.isDigit(line.charAt(i))) {
                            flag = false;
                            break;
                        }
                    }
                    sum += Integer.parseInt(line);
                }
                if (flag) {
                    System.out.println("Sum of digits in "+nameFile+" is "+sum);
                } else {
                    throw new NumberFormatException();
                }
                bufferedReader.close();
            }
        } catch (FileNotFoundException e){
            System.out.println("File NOT found");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("File Error");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a file : ");
        String nameOfFile = scanner.nextLine();

        readFileTxt(nameOfFile);
    }
}
