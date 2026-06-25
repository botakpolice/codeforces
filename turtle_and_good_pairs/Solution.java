import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int[] charCnt = new int[26];
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                charCnt[c - 'a']++;
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
            for (int i = 0; i < 26; i++) {
                if (charCnt[i] > 0) {
                    pq.add(new int[] {charCnt[i], i});
                }
            }

            StringBuilder sb = new StringBuilder();
            while (pq.size() > 1) {
                int[] first = pq.poll();
                int[] second = pq.poll();

                char firstC = (char) (first[1] + 'a');
                char secondC = (char) (second[1] + 'a');

                sb.append(firstC).append(secondC);
                if (first[0] > 1) {
                    first[0]--;
                    pq.add(first);
                }

                if (second[0] > 1) {
                    second[0]--;
                    pq.add(second);
                }
            }

            // pq size == 1
            if (!pq.isEmpty()) {
                int[] last = pq.poll();
                for (int i = 0; i < last[0]; i++) {
                    char c = (char) (last[1] + 'a');
                    sb.append(c);
                }
            }


            System.out.println(sb.toString());
        }

    }
}
