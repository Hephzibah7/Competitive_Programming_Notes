// package r1100.Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThousandsTonsOfTNT {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String strarr[] = br.readLine().split(" ");
            long arr[] = new long[n];
            for (int i = 0; i < n; i++)
                arr[i] = Long.parseLong(strarr[i]);
            long prefix[] = new long[n + 1];
            for (int i = 1; i <= n; i++)
                prefix[i] = prefix[i - 1] + arr[i - 1];
            long diff = 0;
            for (int k = 1; k <= n / 2; k++) {
                if(n%k!=0) continue;
                long max = Long.MIN_VALUE;
                long min = Long.MAX_VALUE;
                for (int i = k; i <= n; i += k) {
                    min = Math.min(min, prefix[i] - prefix[i - k]);
                    max = Math.max(max, prefix[i] - prefix[i - k]);

                }
                diff = Math.max(diff, max - min);
            }
            System.out.println(diff);

        }

    }
}
