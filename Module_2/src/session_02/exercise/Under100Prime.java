package session_02.exercise;

import static session_02.exercise.First20Prime.isPrime;

public class Under100Prime {
    public static void main(String[] args) {
        System.out.println("Under 100 Prime");
        for (int i = 1; i < 100; i++) {
            if (isPrime(i)) {
                System.out.print(i+" ");
            }
        }
    }
}
