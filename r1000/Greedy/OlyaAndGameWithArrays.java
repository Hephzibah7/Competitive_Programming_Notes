// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.*;



//wrong logic in my code- not always in the array with great number of elements do we have to put all minimums
// public class OlyaAndGameWithArrays {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int t = Integer.parseInt(br.readLine());
//         while (t-- > 0) {
//             int n = Integer.parseInt(br.readLine());
//             ArrayList<ArrayList<Integer>> data = new ArrayList<>();
//             for (int i = 0; i < n; i++)
//                 data.add(new ArrayList<>());
//             ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//             for (int i = 0; i < n; i++)
//                 list.add(new ArrayList<>());
//             int i = 0;
//             while (i < n) {
//                 int m = Integer.parseInt(br.readLine());
//                 String strarr[] = br.readLine().split(" ");
//                 ArrayList<Integer> temp = data.get(i);
//                 for (int j = 0; j < m; j++) {
//                     temp.add(Integer.parseInt(strarr[j]));
//                 }
//                 Collections.sort(temp);
//                 ArrayList<Integer> sublist = list.get(i);
//                 sublist.add(temp.get(0));
//                 sublist.add(temp.get(1));
//                 sublist.add(m);
//                 i++;
//             }
//             Collections.sort(list, (a, b) -> {
//                 if (!a.get(2).equals(b.get(2))) {
//                     return Integer.compare(a.get(2), b.get(2));
//                 }
//                 return Integer.compare(b.get(1), a.get(1));
//             });
//             int min = 100000;
//             int sum = 0;
//             for (int j = 0; j < n; j++) {
//                 min = Math.min(min, list.get(j).get(0));
//                 if (j == n - 1) {
//                     sum += min;
//                 } else
//                     sum += list.get(j).get(1);

//             }
//             System.out.println(sum);

//         }

//     }
// }



//the logic here is the array which gets the minimum of all other array is that array which has lowest second minimum
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class OlyaAndGameWithArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<ArrayList<Long>> data = new ArrayList<>();
            for (int i = 0; i < n; i++)
                data.add(new ArrayList<>());
            ArrayList<ArrayList<Long>> list = new ArrayList<>();
            for (int i = 0; i < n; i++)
                list.add(new ArrayList<>());
            int i = 0;
            while (i < n) {
                int m = Integer.parseInt(br.readLine());
                String strarr[] = br.readLine().split(" ");
                ArrayList<Long> temp = data.get(i);
                for (int j = 0; j < m; j++) {
                    temp.add(Long.parseLong(strarr[j]));
                }
                Collections.sort(temp);
                ArrayList<Long> sublist = list.get(i);
                sublist.add(temp.get(0));
                sublist.add(temp.get(1));
                i++;
            }
            long sum=0;
            long min=Long.MAX_VALUE;
            long min2=Long.MAX_VALUE;
            for(int j=0; j<n; j++){
                min=Math.min(min, list.get(j).get(1));
                min2=Math.min(min2, list.get(j).get(0));
                sum+=list.get(j).get(1);
            }
            sum-=min;
            sum+=min2;
            System.out.println(sum);


        }

    }
}

