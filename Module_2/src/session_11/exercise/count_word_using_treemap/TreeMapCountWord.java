package session_11.exercise.count_word_using_treemap;

import java.util.Set;
import java.util.TreeMap;

public class TreeMapCountWord {
    public static void countintWord(String str) {
        TreeMap<String, Integer> tree = new TreeMap<>();
        String[] arrayStr = str.split(" ");

        for (String word : arrayStr) {
            if (!tree.containsKey(word)) {
                tree.put(word, 1);
            } else {
                tree.put(word, (tree.get(word) + 1));
            }
        }
        Set<String> ketSet = tree.keySet();
        for(String key :ketSet) {
            System.out.println(key+" appear "+tree.get(key)+" times");
        }
    }

    public static void main(String[] args) {
        System.out.println("Counting Word in String Using TreeMap");
        String str = "Today is a good day and happy day";
        countintWord(str);
    }
}

