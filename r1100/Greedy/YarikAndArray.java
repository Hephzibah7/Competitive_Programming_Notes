import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
testcases to be considered / missed testcases
array with negative elements
array containing no 0, should not give sum 0 <-this case has to be considered
*/
public class YarikAndArray {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            int n=Integer.parseInt(br.readLine());
            String strarr[]=br.readLine().split(" ");
            int arr[]=new int[n];
            for(int i=0; i<n; i++) arr[i]=Integer.parseInt(strarr[i]);
            int sum=0;
            int lastparity=-1;
            int max=-10000000;
            int currentparity=-1;
            int count=0;
            for(int i=0; i<n; i++){
                if(arr[i]==0) count++;
                if(arr[i]%2==0) currentparity=0;
                else currentparity=1;
                if(lastparity==-1 || lastparity!=currentparity) {
                    if(sum<0) sum=0;
                    sum+=arr[i];
                }
                else sum=arr[i];
                lastparity=currentparity;
                if(sum>0 || (sum==0 && count>0)) max=Math.max(max,sum);
                max=Math.max(max,arr[i]);
                
            }
            System.out.println(max);

        }
       
    }
}
