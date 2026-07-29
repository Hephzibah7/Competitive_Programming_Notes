package r1000.Maths;
/*
https://codeforces.com/problemset/status?my=on
Following are the observations-
1) First increasing b to optimal value is better then dividing increasing diving increasing (common sense)
2) If the addition itself is more than the previous total operation than no use of going further,
that means the max no of operations can be=log(a) base 2 alright?
Now if addition of the elements takes more than max no operations than is it better going afar?
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddAndDivide {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            String str[]=br.readLine().split(" ");
            int a=Integer.parseInt(str[0]);
            int b=Integer.parseInt(str[1]);
            int times=(int)(Math.log(a)/Math.log(2))+1;
            int min=10000;
            for(int i=0; i<=times; i++){
                if(i==0 && b==1) continue; 
                int temp=b+i;
                int copy=a;
                int x=0;
                while(copy>0){ //manually dividing is better than using maths.log since it gives appropriate values for some and wrong for some
                    copy=copy/temp;
                    x++;
                }
                int val=x+(temp-b);
                min=Math.min(min, val);
            }
            System.out.println(min);


        }
       
    }
}
