import java.util.*;

class Solution {

    public static void main(String[] args) {

        // every day, panda may sneeze out 1 or 0 slime.
        // every night, all slimes split, doubles overnight
        // 0 slimes at day 1 
        // m slimes at day n
        
        Scanner sc = new Scanner(System.in);
        long[] l = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long n = l[0], m = l[1];
        System.out.println(Long.bitCount(m));

    }
}
