// package r1000.BitManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Learnt a new method to find xor from 0 to n, in O(1)-
refer findxor function

also if I have a, I want b such that a^b=x,
then what should be b?
so b will be,
b=a^x  //simple xor observation
*/
public class MEXorMixup {
     public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            String str[]=br.readLine().split(" ");
            int a=Integer.parseInt(str[0]);
            int b=Integer.parseInt(str[1]);
            int val=findxor(a-1);
            int count=a;
            if(val==b) count=count;
            else if((val^b)!=a) count++;
            else count+=2;
            System.out.println(count);

        }
       
    }
    static int findxor(int n){
        int rem=n%4;
        if(rem==1) return 1;
        else if(rem==2) return (n+1);
        else if(rem==3) return 0;
        else return n;
    }
}
