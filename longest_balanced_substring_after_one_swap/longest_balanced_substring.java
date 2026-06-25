import java.io.*;
import java.util.*;

public class longest_balanced_substring {

    public static void main(String[] args) throws Exception {

        String s = "100001";
        System.out.println(solve(s));

    }

    static int solve(String s) {
        int n = s.length();
        int res = 0;
        int total0 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                total0++;
            }
        }
        int total1 = n - total0;
        Map<Integer,List<Integer>> first = new HashMap<>();
        first.put(0, new ArrayList<>(Arrays.asList(-1)));
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (s.charAt(i) == '1' ? 1 : -1);

            int[] targets = new int[] {sum , sum - 2, sum + 2};
            for (int target : targets) {
                if (!first.containsKey(target)) {
                    continue;
                }

                for (int l : first.get(target)) {
                    int len = i - l;
                    int diff = sum - target;

                    int ones = (len + diff) / 2;
                    int zeros = len - ones;

                    if (diff == 0 ||
                            (diff == 2 && total0 > zeros) ||
                            (diff == -2 && total1 > ones)) {
                        res = Math.max(res, len);
                        break;
                            }
                }
            }

            first.putIfAbsent(sum, new ArrayList<>());
            if (first.get(sum).size() < 2) {

                first.get(sum).add(i);
            }
        }

        return res;
    }
}
