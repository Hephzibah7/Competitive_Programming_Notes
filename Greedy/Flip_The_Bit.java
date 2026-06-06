import java.io.*;
import java.util.*;

/*
Boundary Element pattern
Remember- one toggle remembers one boundary, confused? lets discuss....
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



