import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;

class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashSet<String> seen = new HashSet<>();

        int n = Integer.parseInt(sc.nextLine());
        boolean leftBlue = false, rightBlue = false;
        for (int i = 0; i < n; i++) {
            String[] l = sc.nextLine().trim().split(" ");
            String tooth = l[0], state = l[1];
            if (state.equals("b")) {
                if (Character.isDigit(tooth.charAt(0))) {
                    rightBlue = true;
                } else {
                    leftBlue = true;
                }
            }

            seen.add(tooth);

        }

        boolean missingUpperLeft = true, missingUpperRight = true;
        boolean missingLowerLeft = true, missingLowerRight = true;
        for (int i = 1; i <= 8; i++) {
            String upperRightTooth = String.valueOf(i) + "+";
            String upperLeftTooth = "+" + String.valueOf(i); 
            String lowerRightTooth = String.valueOf(i) + "-";
            String lowerLeftTooth = "-" + String.valueOf(i);
            if(!seen.contains(upperLeftTooth)) {
                missingUpperLeft = false;
            }

            if (!seen.contains(upperRightTooth)) {
                missingUpperRight = false;
            }

            if (!seen.contains(lowerLeftTooth)) {
                missingLowerLeft = false;
            }

            if (!seen.contains(lowerRightTooth)) {
                missingLowerRight = false;
            }
        }

        boolean leftUsable = true, rightUsable = true;
        if (leftBlue || missingUpperLeft || missingLowerLeft) {
            leftUsable = false;
        }

        if (rightBlue || missingUpperRight || missingLowerRight) {
            rightUsable = false;
        }
        
        if (!leftUsable && !rightUsable) {
            System.out.println(2);
        } else if (leftUsable) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
} 
