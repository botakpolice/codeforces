import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        char[] s = br.readLine().toCharArray();
        int n = s.length;
        int[] prefix = new int[n + 1];

        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (s[i] == '(' ? 1 : -1);
            pairs.add(new int[]{prefix[i], i});
        }
        pairs.sort((a,b) -> a[0] - b[0] == 0 ? b[1] - a[1] : a[0] - b[0]);
        StringBuilder sb = new StringBuilder();
        for (int[] p : pairs) {
            sb.append(s[p[1]]);
        }

        System.out.println(sb.toString());

    }

}
