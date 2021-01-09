package ExtraExer;

import java.util.Scanner;

public class Ex18_CountWordInString {
    public static int countWord(String str){
        int word = 0;
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        } else {
            char[] array = str.toCharArray();

            for (int i = 0; i < array.length -1; i++) {
                if ((Character.toString(array[i]).equals(" ")) && (Character.toString(array[i+1]).compareTo(" ") != 0)) {
                    word++; // dùng equals() hay compareTo() đều được nếu biến đổi từ Character.toString
                }
            }
            return (word + 1);
        }
    }
    public static void main(String[] args) {
        System.out.println("Counting Word in a String");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your string : ");

        String str = scanner.nextLine();
        System.out.println("Words in String : "+countWord(str));
    }
}
