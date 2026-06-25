import java.util.*;

class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {

            String s = sc.nextLine().trim();
            int cnt = 1;
            char lastChar = s.charAt(0);
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(i -1)) {
                    sb.append(cnt);
                    sb.append(lastChar);
                    lastChar = s.charAt(i);
                    cnt = 0;
                }
                cnt++;
            }

            if (cnt > 0) {
                sb.append(cnt);
                sb.append(lastChar);
            }
            System.out.println(sb.toString());
        }
    }
}
