import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] validDigits = new String[]{
                "***   * *** *** * * *** *** *** *** ***", 
                "* *   *   *   * * * *   *     * * * * *",
                "* *   * *** *** *** *** ***   * *** ***",
                "* *   * *     *   *   * * *   * * *   *",
                "***   * *** ***   * *** ***   * *** ***" 
        };

        int n = validDigits.length, m = validDigits[0].length();
        StringBuilder[] code = new StringBuilder[10];
        for (int i = 0; i < 10; i++) {
            code[i] = new StringBuilder();
        }
        for (int i = 0; i < n; i++) {
            String s = validDigits[i];
            for (int j = 0; j < m; j++) {
                if (j % 4 == 3) {
                    continue;
                }
                
                int k = j / 4;
                code[k].append(s.charAt(j));

            }
        }

        HashMap<String,Integer> mapping = new HashMap<>();
        for (int i = 0; i < code.length; i++) {
            String s = code[i].toString();
            mapping.put(s,i);
        }

        String[] ascii = new String[n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            ascii[i] = s;
        }

        int numDigits = ascii[0].length() / 4 + 1;
        StringBuilder[] toDecode = new StringBuilder[numDigits];
        for (int i = 0; i < numDigits; i++) {
            toDecode[i] = new StringBuilder();
        }

        for (int i = 0; i < n; i++) {

            String s = ascii[i];
            for (int j = 0; j < ascii[0].length(); j++) {
                if (j % 4 == 3) {
                    continue;
                }

                int k = j / 4;
                toDecode[k].append(s.charAt(j));
            }
        }

        int res = 0;
        for (int i = 0; i < numDigits; i++) {
            String s = toDecode[i].toString();
            if (mapping.get(s) == null) {
                System.out.println("BOOM!!");
                return;
            } else {
                res = res * 10 + mapping.get(s);
            }
        }

        if (res % 6 == 0) {
            System.out.println("BEER!!");
        } else {
            System.out.println("BOOM!!");
        }




    }
}
