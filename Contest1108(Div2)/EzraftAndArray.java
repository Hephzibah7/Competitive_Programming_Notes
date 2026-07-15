import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Problem- for n give the size of the array such that all the distinct elements in the array divides the sum of the array.
This question helped me come to many conclusions that many a times I didnt notices-
1- If a is a multiple of b, so what is the minimum possible value of a? ans-b
2- If a is a multiple of b, and b is a multiple of a, then what is a and b? a=b

In this problem when n==2, ans is not possible why?
when n=2, the suppose there is a and b in the array,
suppose a|(a+b), then a should also divide b,
suppose b|(a+b), then b should also divide a,
which  means a is a multiple of b and b is multiple of a, but as we discussed earlier, this is only possible if a equals b, which clearly is 
not possible in this problem, because the problem clearly mentions that the lements in the array should be distinct
what if for those cases where n is not equal to 2,
when n=1, then arr={1}
when n=3, then arr={1,2,3}
when n=4, then arr={1,2,3,6} add previous sum that is 1+2+3
and ocntinue n=4 then arr={1,2,3,6,12} why this works?
suppose a+b+c=S
a divides S, b|S, c|S
so when I add S to the sequence , the new sum becomes sum=S+S, since this is slready divisible the elements in the array that is a,b,S,
this pattern works.
*/
public class EzraftAndArray {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
         int n=Integer.parseInt(br.readLine());
         if(n==2) {
            System.out.println(-1);
            continue;
         }
         else if(n==1){
            System.out.println(1);
            continue;
         }
         long arr[]=new long[n+1];
         arr[0]=1;
         arr[1]=2;
         long sum=3;
         for(int i=2; i<=n; i++) {
            arr[i]=sum;
            sum=1L*sum*2;
         }
         for(int i=0; i<n-1; i++) System.out.print(arr[i]+" ");
         System.out.println(arr[n-1]);


        }
       
    }
}
