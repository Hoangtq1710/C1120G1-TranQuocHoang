package session_12.practice.hashmap_treemap_linkedhashmap;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Hoàng");
        hashMap.put(2, "Quang");
        hashMap.put(3, "Thuần");
        hashMap.put(4, "Vi");
        hashMap.put(5, "Đông");

        System.out.println("Print element of HashMap");
        System.out.println(hashMap+"\n");

        Map<Integer,String> linkedMap = new LinkedHashMap<>();
        linkedMap.put(6,"Sang");
        linkedMap.put(7,"Đức");
        linkedMap.put(8,"Khoa");
        linkedMap.put(9,"Vân");
        linkedMap.put(10,"Nghĩa");

        System.out.println("Print element of LinkedHashMap");
        Set<Integer> keySet = linkedMap.keySet();
        for(Integer key : keySet) {
            System.out.println(key+" has name is "+linkedMap.get(key));
        }
        System.out.println();

        Map<Integer, String> tree = new TreeMap<>();
        tree.put(11,"Long");
        tree.put(12,"ATrung");
        tree.put(13,"AChanh");
        tree.put(14,"HoangVan");
        tree.put(15,"LeQuang");

        Set<Integer> keySetTree = tree.keySet();
        for(Integer key : keySetTree) {
            System.out.println(key+" in Tree has value is "+tree.get(key));
        }

    }
}
