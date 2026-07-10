import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
take the reminders for each elements with the k, because each elements are ultimately going to be resuced to the remainder
formed when divided by k, check this-
when k=3
[2,8,3,5]->[2,5,3,5]->[2,2,3,5]->[2,2,3,2]->    [2,2,0,2]
so which one after this state, i mean after last state shown, who will die first, the one whose remainder are greater,
so we will sort this in descending order but, if the number %k==0, then this is the greatest number and should be killed first, here
in this case its 3, so the elements whose remainder is 0, convert it to k again, so that when sorted it appears first.
and the elments whose mod is same, sort it in ascending order of index.
 */

public class Monsters {
     public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
         String str[]=br.readLine().split(" ");
         int n=Integer.parseInt(str[0]);
         long k=Long.parseLong(str[1]);
         String strarr[]=br.readLine().split(" ");
         long arr[]=new long[n];
         for(int i=0; i<n; i++) arr[i]=Long.parseLong(strarr[i]);
         ArrayList<Pair> list=new ArrayList<>();
         for(int i=0; i<n; i++){
            long rem=arr[i]%k==0?k:arr[i]%k;
            list.add(new Pair(i,rem));
         }
        
         Collections.sort(list,(a,b)->{
            if(a.val!=b.val) return Long.compare(b.val,a.val);
            return a.index-b.index;
         });
         int ans[]=new int[n];
         for(int i=0; i<n; i++) ans[i]=list.get(i).index;
         for(int i=0; i<n-1; i++) System.out.print(ans[i]+1+" ");
         System.out.println(ans[n-1]+1);

        }
       
    }
}
class Pair{
    int index;
    long val;
    Pair(int index, long val){
        this.index=index;
        this.val=val;
    }
}
