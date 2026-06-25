import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            String commands = br.readLine();
            TreeSet<Integer> whites = new TreeSet<>();
            TreeSet<Integer> blacks = new TreeSet<>();
            for (int i = 0; i < 2 * (n + m); i ++) {
                whites.add(i + 1);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());
                blacks.add(x);
                whites.remove(x);

            }

            int curr = 1;
            for (int i = 0; i < n; i++) {
                if (commands.charAt(i) == 'A') {
                    curr++;
                    if (whites.contains(curr)) {
                        whites.remove(curr);
                        blacks.add(curr);
                    }
                } else {
                    Integer next = whites.higher(curr);
                    whites.remove(next);
                    curr = whites.higher(curr);
                    blacks.add(next);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int x : blacks) {
                sb.append(x).append(" ");
            }

            System.out.println(blacks.size());
            System.out.println(sb.toString().trim());


        }

    }
}
