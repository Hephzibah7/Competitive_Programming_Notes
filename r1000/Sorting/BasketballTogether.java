    // package r1000.Sorting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BasketballTogether {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        long D = Long.parseLong(str[1]);
        String strarr[] = br.readLine().split(" ");
        long arr[] = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(strarr[i]);
        Arrays.sort(arr);
        //wrong solution, the below solution is not optimal
        // int count=0;
        // long sum=0;
        // int index=-1;
        // for(int i=0; i<n; i++){
        // sum=arr[i]*(i-(index));
        // if(sum>D){
        // count++;
        // index=i;
        // }
        // }
        // System.out.println(count);
    

        //In order to save maximum power players we try to put teams with weak players and maximum power player optimally,
        //In order to save maximum power player as much as possible we try to
        /*
        according to me in order to get maximum wins I need to make maximum teams such that there total power is <D,
        since the ability to increase the power depens only on maximum power person and not number of powers,
        I would try to save as many maximum power person as possible,
        since 2,4,5,9=
        */

        int left=-1;
        int right=n-1;
        int teamsize=1;
        int count=0;
        while(left<right){
            if(left<right && 1L*arr[right]*teamsize<=D){
                left++;
                teamsize++;
            }
            else{
                count++;
                right--;
                teamsize=1;
            }
        }
        System.out.println(count);
    }
}
