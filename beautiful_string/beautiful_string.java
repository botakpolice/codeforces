import java.io.*;
import java.util.*;

public class beautiful_string {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            String s = sc.nextLine();
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    res.add(i);
                }
            }

            System.out.println(res.size());
            StringBuilder sb = new StringBuilder();
            for (int x : res) {
                sb.append(x + 1).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
