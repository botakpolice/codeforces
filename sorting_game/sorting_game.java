import java.io.*;
import java.util.*;

public class sorting_game {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            String s = br.readLine();
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            if (s.equals(sorted)) {
                System.out.println("Bob");
            } else {
                System.out.println("Alice");
                StringBuilder sb = new StringBuilder();
                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) != sorted.charAt(i)) {
                        cnt++;
                        sb.append(i + 1).append(" ");
                    }
                }
                System.out.println(cnt);
                System.out.println(sb.toString());
            }

        }
    }
}
