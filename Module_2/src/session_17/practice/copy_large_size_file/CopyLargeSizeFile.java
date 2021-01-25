package session_17.practice.copy_large_size_file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
//G:\keywords.rar
//G:\C1120G1-TranQuocHoang\Module_2\src\session_17\practice\copy_large_size_file\testoutput.rar
public class CopyLargeSizeFile {
    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            try {
                is.close();
                os.close();
            } catch (NullPointerException ignored) {

            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter source file : ");
        String sourcePath = scanner.nextLine();
        System.out.print("Enter destination file : ");
        String destPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            //copyFileUsingJava7Files(sourceFile, destFile);
            copyFileUsingStream(sourceFile, destFile);
            System.out.println("Copy completed");
        } catch (IOException ioe) {
            System.out.println("Can't copy that file");
            System.out.println(ioe.getMessage());
        }
    }
}
