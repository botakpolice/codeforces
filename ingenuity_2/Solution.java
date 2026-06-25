import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            char[] s = br.readLine().toCharArray();
            int up = 0;
            int down = 0;
            int left = 0;
            int right = 0;
            for (char c : s) {
                if (c == 'N') {
                    up++;
                } else if (c == 'S') {
                    down++;                    
                } else if (c == 'E') {
                    right++;
                } else {
                    left++;
                }
            }

            int xoffset = up - down;
            int yoffset = right - left;
            if (n == 2 && xoffset == 0 && yoffset == 0) {
                System.out.println("NO");
                continue;
            }
            if (xoffset % 2 != 0 || yoffset % 2 != 0) {
                System.out.println("NO");
            } else {
                char[] res = new char[n];
                for (int i = 0; i < n; i++) {
                    if (s[i] == 'N') {
                        if (up % 2 == 0) {
                            res[i] = 'R';
                        } else {
                            res[i] = 'H';
                        }
                        up--;
                    } else if (s[i] == 'S') {
                        if (down % 2 == 0) {
                            res[i] = 'R';
                        } else {
                            res[i] = 'H';                        
                        }
                        down--;
                    } else if (s[i] == 'W') {
                        if (left % 2 == 0) {
                            res[i] = 'H';
                        } else {
                            res[i] = 'R';
                        }
                        left--;
                    } else {
                        if (right % 2 == 0) {
                            res[i] = 'H';
                        } else {
                            res[i] = 'R';
                        }
                        right--;
                    }
                }

                System.out.println(new String(res));
            }

        }
    }

}
