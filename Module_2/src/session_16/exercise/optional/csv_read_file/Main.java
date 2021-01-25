package session_16.exercise.optional.csv_read_file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String PATH = "src/session_16/exercise/optional/csv_read_file/country.csv";

    public static void readFileCSV(String fileName) {
        BufferedReader fileReader;
        try {
            List<String> coutries = new ArrayList<>();
            String line;

            fileReader = new BufferedReader(new FileReader(fileName));
            while ((line = fileReader.readLine()) != null) {
                String[] informations = line.split(",");
                if (informations.length != 0) {
                    coutries.add(informations[3]);
                    coutries.add(informations[5]);
                }
            }
            int count = 0;
            for (String word : coutries) {
                System.out.print(word);
                count++;
                if (count == 2) {
                    System.out.print("\n");
                    count = 0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readFileCSV(PATH);
    }
}
