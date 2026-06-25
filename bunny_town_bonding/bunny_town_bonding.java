import java.util.*;
import java.io.*;


class Solution {

    public static void main(String[] args) throws IOException {

        // n seats
        // b represents occupied
        // e represent empty
        // find the min num of moves such that
        // all bunnies are sitting together
        // EBBEBEEEB
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'B') {
                positions.add(i);
            }
        }

        int k = positions.size();
        int[] compressed = new int[k];
        for (int i = 0; i < k; i++) {
            compressed[i] = positions.get(i) - i;
        }

        Arrays.sort(compressed); // not sure if needed;

        int med = compressed[k / 2];
        int moves = 0;
        for (int i = 0; i < k; i++) {
            moves += Math.abs(compressed[i] - med);
        }

        System.out.println(moves);

        
    }

}
