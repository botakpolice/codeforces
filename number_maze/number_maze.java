import java.io.*;
import java.util.*;

public class number_maze {

    static HashMap<String, List<String>> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        // preprocess
        String s1 = "12";
        String s2 = "123";
        String s3 = "1234";

        map.put(s1, generatePerms(s1));
        map.put(s2, generatePerms(s2));
        map.put(s3, generatePerms(s3));

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] s = sc.nextLine().split(" ");
            List<String> perms = map.get(s[0]);
            int i = Integer.parseInt(s[1]) - 1;
            int j = Integer.parseInt(s[2]) - 1;
            String a = perms.get(i);
            String b = perms.get(j);
            int x = 0;
            for (int k = 0; k < s[0].length(); k++) {
                if (a.charAt(k) == b.charAt(k)) {
                    x++;
                }
            }
            int y = s[0].length() - x;
            System.out.println(x + "A" + y + "B");
        }

    }

    static List<String> generatePerms(String s) {

        List<String> perms = new ArrayList<>();
        generate(s.toCharArray(), 0, perms);
        Collections.sort(perms);
        return perms;
    }

    static void generate(char[] arr, int idx, List<String> res) {
        if (idx == arr.length) {
            res.add(new String(arr));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            generate(arr, idx + 1, res);
            swap(arr, idx, i);
        }
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
