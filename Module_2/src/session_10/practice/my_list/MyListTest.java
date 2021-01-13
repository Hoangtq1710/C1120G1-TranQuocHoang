package session_10.practice.my_list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> integerMyList = new MyList<Integer>();
        integerMyList.add(3);
        integerMyList.add(2);
        integerMyList.add(9);
        integerMyList.add(4);
        integerMyList.add(0);

        System.out.println("Element 4 : "+integerMyList.get(4));
        System.out.println("Element 2 : "+integerMyList.get(2));
        System.out.println("Element 0 : "+integerMyList.get(0));

        integerMyList.get(1);
        System.out.println("Element 1 : "+integerMyList.get(1));
    }
}
