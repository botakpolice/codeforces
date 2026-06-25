import java.util.*;

class Solution {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int[] _sun = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] _moon = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int n1 = -_sun[0];
        int n2 = -_moon[0];
        
        while (n1 != n2) {
            if (n1 == n2) {
                break;
            } else if (n1 < n2) {
                n1 += _sun[1];
            } else {
                n2 += _moon[1];
            }
            
        }
        
        System.out.println(n1);
    }
}
