import java.io.*;
import java.util.*;

public class dungeon {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            TreeMap<Integer,Integer> a = new TreeMap<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                a.put(x, a.getOrDefault(x, 0) + 1);
            }
            st = new StringTokenizer(br.readLine());
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            int[] c = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                c[i] = Integer.parseInt(st.nextToken());
            }

            int[][] p = new int[m][2];
            for (int i = 0; i < m; i++) {
                p[i] = new int[]{ b[i], c[i] };
            }

            Arrays.sort(p, (x,y) -> x[0] - y[0] == 0 ? x[1] - y[1] : x[0] - y[0]);
            int res = 0;
            for (int i = 0; i < m; i++) {
                int[] currMonster = p[i];
                if (currMonster[1] == 0) {
                    continue;
                } else {
                    Integer x = a.ceilingKey(currMonster[0]);
                    if (x == null) {
                        break;
                    }
                    if (a.get(x) > 1) {
                        a.put(x, a.get(x) - 1);
                    } else {
                        a.remove(x);
                    }
                    int newSword = Math.max(x,currMonster[1]);
                    a.put(newSword, a.getOrDefault(newSword, 0) + 1);
                    res++;
                }
            }

            for (int i = 0; i < m; i++) {
                int[] currMonster = p[i];
                if (currMonster[1] == 0) {
                    Integer x = a.ceilingKey(currMonster[0]);
                    if (x == null) {
                        break;
                    }
                    if (a.get(x) > 1) {
                        a.put(x, a.get(x) - 1);
                    } else {
                        a.remove(x);
                    }
                    res++;
                }
            }

            System.out.println(res);

        }
    }
}
