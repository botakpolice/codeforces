import java.util.*;

class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            set.add(sc.nextLine().trim());
        }
        System.out.println(set.size());
    }
}
