import java.util.*;

class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int[] t = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = t[0], n = t[1];
        String[] allStrings = new String[n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine().trim();
            allStrings[i] = s;
        }

        Arrays.sort(allStrings, (a,b) -> a.length() - b.length());
        String minString = allStrings[0];
        HashSet<String> res = new HashSet<>();
        dfs(minString, "", 0, k, allStrings, res);
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>(res);
        ans.sort(String::compareTo);
        for (String s : ans) {
            sb.append(s).append("\n");
        }

        System.out.println(res.size());
        if (res.size() > 0) {
            System.out.println(sb.toString());
        }

    }

    static void dfs(String minString, String currString, int i, int k, String[] allStrings, HashSet<String> res) {

        int currentLength = currString.length();
        if (currentLength == k) {
            if (isSubsequence(currString, allStrings)) {
                res.add(currString);
            }

            return;
        }

        for (int j = i; j <= minString.length() - (k - currentLength); j++) {

            String newString = currString + minString.charAt(j);

            if (isSubsequence(newString, allStrings)) {
                dfs(minString, newString, j + 1, k, allStrings, res);
            }

        }



    }

    static boolean isSubsequence(String s, String[] allStrings) {

        for (int i = 0; i < allStrings.length; i++) {
            if (!valid(s, allStrings[i])) {
                return false;
            }
        }
        return true;
    }

    static boolean valid(String s, String t) {

        // this will check whether 
        int i = 0, j = 0;
        while (j < t.length()) {
            if (i == s.length()) {
                return true;
            }
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i == s.length();
    }
}
