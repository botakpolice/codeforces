import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {
            char[] s1 = br.readLine().toCharArray();
            char[] s2 = br.readLine().toCharArray();

            int n = s1.length;
            // 0 for s1, 1 for s2;            
            int i = 0;
            while(i < n && s1[i] == s2[i]) {
                i++;
            }

            if (i == n) {
                System.out.println(new String(s1));
                System.out.println(new String(s2));
                continue;
            }
            boolean s1Bigger = s1[i] > s2[i];
            for (int j = i + 1; j < n; j++) {
                if (s1[j] > s2[j]) {
                    if (s1Bigger) {
                        char temp = s2[j];
                        s2[j] = s1[j];
                        s1[j] = temp;
                    }                                             
                } else {
                    if (!s1Bigger) {
                        char temp = s1[j];
                        s1[j] = s2[j];
                        s2[j] = temp;
                    }
                }                
            }

            System.out.println(new String(s1));
            System.out.println(new String(s2));
        }
    }

}
