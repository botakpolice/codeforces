import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            if (s == null || s.length() == 0) {
                System.out.println(0);
                continue;
            }

            System.out.println(Math.min(solve(s, 'a'), solve(s, 'b')));
        }

    }

    static long solve(String s, char target) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == target) {
                positions.add(i);
            }
        }

        if (positions.isEmpty()) {
            return 0;
        }

        int size = positions.size();
        int medIdx = size / 2;
        int medVal = positions.get(medIdx);

        long totalSwaps = 0;
        for (int i = 0; i < size; i++) {

            int relativePos = medVal - (medIdx - i);
            totalSwaps += Math.abs(positions.get(i) - relativePos);
        }

        return totalSwaps;
    }
}
