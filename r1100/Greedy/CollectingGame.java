import java.io.*;
import java.util.*;

public class CollectingGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long arr[] = new long[n];
            String strarr[] = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Long.parseLong(strarr[i]);
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++)
                list.add(i);
            Collections.sort(list, (a, b) -> Long.compare(arr[b], arr[a]));

            ArrayList<Long> temp = new ArrayList<>();
            for (int i = 0; i < n; i++)
                temp.add(arr[list.get(i)]); // temp is now sorted in descending order
            long prefix[] = new long[n];
            prefix[n - 1] = temp.get(n - 1);
            for (int i = n - 2; i >= 0; i--)
                prefix[i] = prefix[i + 1] + temp.get(i);
            int k = n - 2;
            int j = k - 1;
           
            HashMap<Long, Long> map=new HashMap<>();
             map.put(temp.get(n-1),0L);
            for (int i = n - 2; i >= 0; i--) {
                while (j >= 0 && prefix[k] >= temp.get(j)) {
                    j--;
                    k--;
                }
                map.put(temp.get(i),(n-2-j)*1L);
                if (k == i) {
                    k--;
                    j = k - 1;
                }
            }

            long res[] = new long[n];
            for (int i = 0; i < n; i++)
                res[i] = map.get(arr[i]);
            for (int i = 0; i < n; i++)
                System.out.print(res[i] + " ");
            System.out.println();

        }

    }

}
