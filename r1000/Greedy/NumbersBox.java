// package r1000.Greedy;
/*
https://codeforces.com/problemset/problem/1447/B
If there are two negatives sharing  a side like the below-
2 1
-3 -4
They can help each other to be positive by multiplying each other
But the important thing to notice is, even if the two negatives are not sharing a side still, they will able to help each other 
to be positive lets see below-
-1 2 3
3 -4 1
2 9 8
Here -1 and -4 do not share a side but still they will be able to turn each other positive.
So,
if the number of negatives is even, so we get a sum which is equal to the total absolute sum of the elements,
if the number of negatives is odd, we need to leave a negative which so which value should be left?
In order to maximize the sum we will subtract the element with smallest negative value
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumbersBox {
     public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
           String str[]=br.readLine().split(" ");
           int n=Integer.parseInt(str[0]);
           int m=Integer.parseInt(str[1]);
           int arr[][]=new int[n][m];
           int count=0;
           int sum=0;
           int smallest=Integer.MAX_VALUE;
           for(int i=0; i<n; i++){
            String s[]=br.readLine().split(" ");
            for(int j=0; j<m; j++){
                arr[i][j]=Integer.parseInt(s[j]);
                sum+=Math.abs(arr[i][j]);
                smallest=Math.min(smallest,Math.abs(arr[i][j]));
                if(arr[i][j]<0) count++;

            }
           }
           if(count%2!=0) sum-=2*smallest;
           System.out.println(sum);

        }
       
    }
}
