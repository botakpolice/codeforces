import java.util.*;


class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int y = Integer.parseInt(sc.nextLine());
        // leap year : divisible by 4
        // except divisible by 100 is not a leap year
        // divisible by 400 is a leap year
        
        // mother's day on 2nd sunday in may
        // father's day on 3rd sunday in june
        int dayOfFirstMay = dayOfWeek(y, 5, 1);
        int motherDay = (7 - dayOfFirstMay) % 7 + 7;
        int dayOfFirstJune = dayOfWeek(y, 6, 1);
        int fatherDay = (7 - dayOfFirstJune) % 7 + 14;
        int weeks = (fatherDay + 31 - motherDay) / 7;
        System.out.println(String.format("%d weeks", weeks));

    }

    public static int dayOfWeek(int y, int m, int d) {
        int[] t = new int[] {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        if (m < 3) {
            y -= 1;
        }
        return (y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;
    }


}
