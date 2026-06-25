import java.util.*;

class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] tea_price = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(sc.nextLine());
        int[] toppings_price = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] c = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j < c.length; j++) {
                int topping_num = c[j] - 1;
                int topping_cost = toppings_price[topping_num];
                int total_cost = tea_price[i] + topping_cost;
                min = Math.min(min, total_cost);
            }
        }
        int money = Integer.parseInt(sc.nextLine());
        int cups = money / min;

        System.out.println(Math.max(0, cups - 1));
    }
}
