import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();
        String t = br.readLine();

        int n = s.length();
        int m = t.length();

        int[] firstInS = new int[26];
        int[] lastInT = new int[26];

        int INF = (int)1e9;
        Arrays.fill(firstInS, INF);
        Arrays.fill(lastInT, -1);
        for (int i = 1; i < n; i++) {
            int c = s.charAt(i) - 'a';
            firstInS[c] = Math.min(firstInS[c], i);
        }

        for (int j = 0; j < m - 1; j++) {
            int c = t.charAt(j) - 'a';
            lastInT[c] = Math.max(lastInT[c], j);
        }


        String best = null;
        int bestLen = INF;

        for (int c = 0; c < 26; c++) {
            if (firstInS[c] == INF || lastInT[c] == -1) {
                continue;
            }

            int i = firstInS[c];
            int j = lastInT[c];

            String candidate = s.substring(0, i + 1) + t.substring(j + 1);

            if (candidate.length() < bestLen) {
                bestLen = candidate.length();
                best = candidate;
            }
        }

        if (best == null) {
            System.out.println(-1);
        } else {
            System.out.println(best);
        }

    }
}
