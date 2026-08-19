import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BogoSort {
     public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            int n=Integer.parseInt(br.readLine());
            String str[]=br.readLine().split(" ");
            int arr[]=new int[n];
            for(int i=0; i<n; i++) arr[i]=Integer.parseInt(str[i]);
            Arrays.sort(arr);
            StringBuilder sb=new StringBuilder();
            for(int i=n-1; i>=0; i--) sb.append(arr[i]+" ");
            sb.trimToSize();
            System.out.println(sb);


        }
       
    }
}
