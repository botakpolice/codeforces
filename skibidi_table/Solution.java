import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int q = Integer.parseInt(br.readLine());

            while (q-- > 0) {
                String[] line = br.readLine().split(" ");
                if (line[0].equals("->")) {
                    int r = Integer.parseInt(line[1]);
                    int c = Integer.parseInt(line[2]);
                    System.out.println(findXY(r,c,1,1,1L << n, 1));
                } else {
                    long d = Long.parseLong(line[1]);
                    long[] p = findD(d, 1,1, 1L << n, 1);
                    System.out.println(p[0] + " " + p[1]);
                }
            }
        }

    }

    static long[] findD(long d, long x, long y, long sz, long val) {
        if (sz == 1) {
            return new long[] {x, y};
        }

        long total = sz * sz;
        long subTotal = total / 4;
        long nextSz = sz / 2;
        for (int i = 0; i < 4; i++) {
            if (d >= val + subTotal * i && d < val + subTotal * (i + 1)) {
                long nextVal = val + subTotal * i;
                if (i == 0) {
                    return findD(d, x, y, nextSz, nextVal);
                }

                if (i == 1) {
                    return findD(d, x + nextSz, y + nextSz, nextSz, nextVal);
                }
                if (i == 2) {
                    return findD(d, x + nextSz, y, nextSz, nextVal);
                }
                if (i == 3) {
                    return findD(d, x, y + nextSz, nextSz, nextVal);
                }
            }
        }

        return new long[] {-1, -1};
    }

    static long findXY(long r, long c, long x, long y, long sz, long val) {
        if (sz == 1) {
            return val;
        }

        long total = sz * sz;
        long subTotal = total / 4;
        long nextSz = sz / 2;
        long rx = r - x;
        long ry = c - y;

        long[] dx = new long[] {0, nextSz, nextSz, 0};
        long[] dy = new long[] {0, nextSz, 0, nextSz};
        for (int i = 0; i < 4; i++) {
            // find which quadrant x,y belongs to
            if (rx >= dx[i] && rx < dx[i] + nextSz && 
                ry >= dy[i] && ry < dy[i] + nextSz) {
                long nextVal = val+ subTotal * i;
                return findXY(r, c, x + dx[i], y + dy[i], nextSz, nextVal);
            }
        }

        return -1;
    }
}
