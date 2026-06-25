import java.util.Scanner;

class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // ww ee ll c   
        
        // "welcome to code jam welcome to code jam"
        
        int n = Integer.parseInt(sc.nextLine());
        String target = "welcome to code jam";
        for (int i = 0; i < n; i ++) {
            String s = sc.nextLine();
            long[][] dp = new long[target.length() + 1][s.length() + 1];
            for (int j = 0; j < s.length(); j++) {
                dp[0][j] = 1;
            }
            
            for (int j = 0; j < target.length(); j++) {
                for (int k = 0; k < s.length(); k++) {
                    if (target.charAt(j) == s.charAt(k)) {
                        dp[j+1][k+1] = dp[j][k] + dp[j+1][k];
                    } else {
                        dp[j+1][k+1] = dp[j+1][k];
                    }
                }
            }
            
            System.out.println(String.format("Case #%d: %04d", i, dp[target.length()][s.length()] % 10000));
        }
    }
}
