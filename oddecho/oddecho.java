import java.util.*;


class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String nextLine = sc.nextLine();
            if (i % 2 == 0) {
                sb.append(nextLine + "\n");
            }
        }
        
        System.out.println(sb.toString());
    }
}
