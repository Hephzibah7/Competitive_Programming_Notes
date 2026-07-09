package r1000.Maths;
import java.io.*;
import java.util.*;

public class Raspberries {
     public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            String str[]=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            int k=Integer.parseInt(str[1]);
            String strarr[]=br.readLine().split(" ");
            int arr[]=new int[n];
            for(int i=0; i<n; i++) arr[i]=Integer.parseInt(strarr[i]);
           

            //Exception- when k=4, x*y=z where z is multiple of 4, here it is not required for x and y to be divisble by 4 like other numbers,
            //Example- 2*6=12, although 2 and 6 are not multiple of 4 but still there product is divisble by 4,
            //2*2=4,2*6=12,2*6*2=24 ->so minimum 2 even numbers should be there to get a multiple of 2, so it you could create atleast
            //2 even elements than the two elements will give you product which is multiple of 4, and altogether gives us the product of all
            //elements that is divisible by 4.

            //Target- when k=4, create atleast 2 even elements with minimum operations.
            int min=Integer.MAX_VALUE;
            if(k==4){
                //make sure n>=2 then only multiple of 4 is possible since it requires atleast 2 even factors
                int temp[]=new int[2];
                for(int i=0; i<n; i++) {
                    temp[arr[i]%2]++;
                    if(arr[i]%4==0) min=0; //if i get atleast 1 number divisble by 4
                    min=Math.min(min,k-arr[i]%4); //if i can make atleast 1 number divisible by 45
                }
                if(temp[0]>=2) min=Math.min(min,0);
                else if(temp[0]==1 && temp[1]>=1) min=Math.min(min,1);
                else if(temp[0]==0) min=Math.min(min,2);
            }
            else{
            for(int i=0; i<n; i++) {
                if(arr[i]%k==0) min=0;
                min=Math.min(min,k-(arr[i]%k));
            }  //it gives the distance between the multiple of k and the current number
            }
            System.out.println(min);

            

        }
       
    }
}
