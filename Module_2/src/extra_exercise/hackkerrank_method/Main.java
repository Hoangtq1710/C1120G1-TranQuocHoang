package extra_exercise.hackkerrank_method;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int m = -1;
        int max = 0;
        boolean flag = true;
        for (int keyboard : keyboards) {
            for (int drive : drives) {
                if (keyboard + drive <= b) {
                    m = keyboard + drive;
                    flag = false;
                }
                if (m >= max) {
                    max = m;
                }
            }
        }
        if (flag) {
            return m;
        } else {
            return max;
        }
    }

    static String catAndMouse(int x, int y, int z) {
        if (Math.abs(x - z) > Math.abs(y - z)) {
            return "Cat B";
        } else if (Math.abs(x - z) < Math.abs(y - z)) {
            return "Cat A";
        } else {
            return "Mouse C";
        }
    }

    static int hurdleRace(int k, int[] height) {
        int max = height[0];
        for (int jump : height) {
            if (jump >= max) {
                max = jump;
            }
        }
        if (k < max) {
            return (max - k);
        } else {
            return 0;
        }
    }

    static int designerPdfViewer(int[] h, String word) {
        int size = word.length();
        int[] arr = new int[size];
        int first = 97;
        char[] arrChar = word.toCharArray();
        for (int i = 0; i < size; i++) {
            arr[i] = h[(int) arrChar[i] - first];
        }
        int max = arr[0];
        for (int element : arr) {
            if (element > max) {
                max = element;
            }
        }
        return (max * size);
    }

    static int beautifulDays(int i, int j, int k) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (int l = i; l <= j; l++) {
            char[] arr = Integer.toString(l).toCharArray();
            for (char c : arr) {
                stack.push(c);
            }
            StringBuilder result = new StringBuilder();
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }
            int reverse = Integer.parseInt(result.toString());
            if (Math.abs(l - reverse) % k == 0) {
                count++;
            }
        }
        return count;
    }

    static int viralAdvertising(int n) {
        int shared = 5;
        int cumulative = 0;
        for (int i = 0; i < n; i++) {
            int liked = shared / 2;
            shared = liked * 3;
            cumulative += liked;
        }
        return cumulative;
    }

    static int saveThePrisoner(int n, int m, int s) {
        return ((s - 1 + m - 1) % n + 1);
    }

    public static int pickingNumbers(List<Integer> a) {
        int max = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < a.size(); i++) {
            list.offer(a.get(i));
            for (int j = i + 1; j < a.size(); j++) {
                boolean flag = true;
                for (int element : list) {
                    if (Math.abs((element - a.get(j))) > 1) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    list.offer(a.get(j));
                }
            }
            if (list.size() > max) {
                max = list.size();
            }
            list.clear();
        }
        return max;
    }  //error

    private static boolean canConvert(String s, String t, int k) {
        /* Case 1 */
        if (s.length() + t.length() <= k) {
            return true;
        }

        /* Case 2 */
        int i = 0; // represents index of 1st non-matching character
        for (; i < s.length() && i < t.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                break;
            }
        }
        int minOperations = (s.length() - i) + (t.length() - i);
        return k >= minOperations && (k - minOperations) % 2 == 0;
    }
}
