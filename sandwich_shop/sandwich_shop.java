import java.util.*;

class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0 ; i < n; i++) {
            String s = sc.nextLine();
            StringBuilder res = new StringBuilder();
            for (char c : s.toCharArray()) {
                int k = Character.toLowerCase(c) - 'a';
                int num = k / 3 + 2;
                if (k >= 15 && k <= 18) {
                    num = 7;
                } else if (k >= 19 && k <= 21) {
                    num = 8;
                } else if (k >= 22) {
                    num = 9;
                }

                res.append("" + num);
            }

            System.out.println(res);
        }


    }
}
