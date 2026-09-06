import java.io.*;
import java.util.*;

public class CountingOrders {

    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++)
                a[i] = fs.nextInt();

            for (int i = 0; i < n; i++)
                b[i] = fs.nextInt();

            Arrays.sort(a);
            Arrays.sort(b);

            long ans = 1;
            int j = 0;

            /*
             * j = number of b elements strictly smaller than a[i]
             *
             * Since a is sorted ascending, j only moves forward.
             */
            for (int i = 0; i < n; i++) {

                while (j < n && b[j] < a[i]) {
                    j++;
                }

                int choices = j - i;

                if (choices <= 0) {
                    ans = 0;
                    break;
                }

                ans = (ans * choices) % MOD;
            }

            out.append(ans).append('\n');
        }

        System.out.print(out);
    }

    static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {

            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0)
                    return -1;
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {

            int c;
            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            int num = 0;

            while (c > ' ') {
                num = num * 10 + (c - '0');
                c = read();
            }

            return num * sign;
        }
    }
}