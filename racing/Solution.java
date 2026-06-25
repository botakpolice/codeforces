import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] d = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                d[i] = Integer.parseInt(st.nextToken());
            }

            int[] l = new int[n];
            int[] r = new int[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                l[i] = Integer.parseInt(st.nextToken());
                r[i] = Integer.parseInt(st.nextToken());
            }

            int left = 0;
            Stack<Integer> last = new Stack<>();
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if (d[i] == -1) {
                    last.push(i);
                } else {
                    left += d[i];
                }

                while (left < l[i]) {
                    if (last.isEmpty()) {
                        ok = false;
                        break;
                    }
                    d[last.pop()] = 1;
                    left++;
                }

                if (!ok) {
                    break;
                }

                while(left + last.size() > r[i]) {
                    if (last.isEmpty()) {
                        ok = false;
                        break;
                    }

                    d[last.pop()] = 0;
                }

                if (!ok) {
                    break;
                }
            }

            if (!ok) {
                System.out.println(-1);
                continue;
            }

            StringBuilder sb = new StringBuilder();
            for (int x : d) {
                sb.append(Math.max(x, 0)).append(" ");
            }
            System.out.println(sb.toString().trim());
        }

    }
}
