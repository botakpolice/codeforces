import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            Stack<Integer> stk = new Stack<>();
            List<int[]> ops  = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (a[i] == 0) {
                    if (i == n - 1) {
                        ops.add(new int[] {stk.size(), stk.size() + 1});
                    } else {
                        ops.add(new int[]{stk.size() + 1, stk.size() + 2});
                        stk.push(1);
                        i++;
                    }
                } else {
                    stk.push(1);
                }
            }
            ops.add(new int[]{1, stk.size()});
            System.out.println(ops.size());
            for (int[] op : ops) {
                System.out.println(op[0] + " " + op[1]);
            }
        }

    }
}
