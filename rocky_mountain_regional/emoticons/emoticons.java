import java.util.*;
import java.util.regex.Pattern;

class Solution {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();

        HashSet<String> emojis = new HashSet<>();
        emojis.add(":)");
        emojis.add(":-)");
        emojis.add(":-(");
        emojis.add(";-)");
        emojis.add("xD");
        emojis.add("^_^");
        emojis.add("-_-");
        emojis.add("^o^");
        emojis.add("^^;");
        emojis.add("(..)");

        char[] replaceBy = new char[] {':', '-', ')', '(', ';', 'x', 'D', '^','_','-','o','.'};

        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            String temp = s.replaceAll(Pattern.quote("" + s.charAt(i)) , "a");
            maxLength = Math.max(maxLength, getLength(temp, emojis));
            for (char c : replaceBy) {
                String temp2 = s.replaceAll(Pattern.quote("" + s.charAt(i)), ""+c);
                int len = getLength(temp2, emojis);
                minLength = Math.min(minLength, len );


            }
        }

        System.out.println(String.format("%d %d", minLength, maxLength));
    }

    static int getLength(String temp, HashSet<String> emojis) {

        int k = 0;
        int currLength = 0;
        int n = temp.length();
        while (k < n) {
            
            String a = temp.substring(k, Math.min(k + 4, n));
            String b = temp.substring(k, Math.min(k + 3, n));
            String c = temp.substring(k, Math.min(k + 2, n));
            if (emojis.contains(a)) {
                k += 4;
            } else if (emojis.contains(b)) {
                k += 3;
            } else if (emojis.contains(c)) {
                k += 2;
            } else {
                k += 1;
            }
            
            currLength++;
        }

        return currLength;

    }
}
