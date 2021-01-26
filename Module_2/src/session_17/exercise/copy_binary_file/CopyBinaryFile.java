package session_17.exercise.copy_binary_file;

import java.io.*;
import java.util.Scanner;
//G:\input.dat
//G:\C1120G1-TranQuocHoang\Module_2\src\session_17\exercise\copy_binary_file\binary_file.dat
public class CopyBinaryFile {
    public static void copyFileWithStream(File sourceFile, File destFile) throws IOException {
        InputStream fis = null;
        OutputStream fos = null;
        try{
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer = new byte[1024];
            int length;
            int countByte = 0;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
                countByte++;
            }
            System.out.println("We already used "+(countByte * 1024)+" bytes");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (NullPointerException ignored) {

            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Copy a Binary File");
        System.out.print("Enter a source file : ");
        String source = scanner.nextLine();
        System.out.print("Enter a destination file : ");
        String dest = scanner.nextLine();

        try{
            copyFileWithStream(new File(source), new File(dest));
            System.out.println("Copied file "+source);
        } catch (IOException e) {
            System.out.println("Can not copy that file");
            e.printStackTrace();
        }
    }
}
