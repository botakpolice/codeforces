import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] t = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long a = t[0], b = t[1];
        System.out.println(Math.min(a % b, b - a % b));
    }
}
