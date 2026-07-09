import java.io.*;
import java.util.*;

/*
Boundary Element pattern
Remember- one toggle remembers one boundary, confused? lets discuss....
Always when question says you can toggle the bit-think about boundary pattern
Boundary is when the adjacent elements have different bits.
ex-
0 1 2 3
1 0 1 1

here boundary are-0 and 1, 1 and 2
so if my intention is to make all the elements of the array equal to 1, by flipping all elements from that element 
which is 0 (index 1) in this case to the end of the array, then -
1 0 1 1 -> 1 1 0 0 -> 1 1 1 1 ->2 operations right? (2 boundaries so 2 operations)
which means 1 operation resolves only one boundary
so our target is to resolve all the boundaries, and also in this problem, in one operation you can resolve boundary 
in the left and right of the pivot.
So the ans becomes max(left,right)
 */
public class Flip_The_Bit {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
         String str[]=br.readLine().split(" ");
         int n=Integer.parseInt(str[0]);
         String strarr[]=br.readLine().split(" ");
         int arr[]=new int[n];
         for(int i=0; i<n; i++) arr[i]=Integer.parseInt(strarr[i]);
         int p=Integer.parseInt(br.readLine());
         int x1=0;
         int x2=0;
         int temp[]=new int[n+2];
         temp[0]=1;
         temp[n+1]=1;
         int j=1;
         for(int i=0; i<n; i++){
            if(arr[i]==arr[p-1]) temp[j]=1;
            j++;
         }
        
         for(int i=0; i<p; i++){
            if(temp[i]!=temp[i+1]) x1++;
         }
         for(int i=p; i<temp.length-1; i++){
            if(temp[i]!=temp[i+1]) x2++;
         }
         System.out.println(Math.max(x1,x2));


        }
       
    }
    
   
    
}



