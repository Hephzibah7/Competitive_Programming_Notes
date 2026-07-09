import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HelmetsInNightLife{
      public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
         String str[]=br.readLine().split(" ");
         int n=Integer.parseInt(str[0]);
         int p=Integer.parseInt(str[1]);
         String strarr[]=br.readLine().split(" ");
         int a[]=new int[n];
         for(int i=0; i<n; i++) a[i]=Integer.parseInt(strarr[i]);
         String strprr[]=br.readLine().split(" ");
         int c[]=new int[n];
         for(int i=0; i<n; i++) c[i]=Integer.parseInt(strprr[i]);
         int x=0;
         for(int i=0; i<n; i++){
            if(c[i]<p) x++;
         }
         Integer[] objarray=new Integer[n];
         for(int i=0; i<n; i++) objarray[i]=i;
         Arrays.sort(objarray, (z, y) -> Integer.compare(c[z],c[y]));
         HashMap<Integer, Integer> map=new HashMap<>();
         for(int i=0;  i<n; i++) map.put(i,c[i]);
         int i=0;
         long ans=0;
         int temp=0;
         while(i<x){
            if(temp==0){
                ans+=p;
                n-=1;
                temp++;
            }
            if(n==0) break;
            int give=Math.min(n, a[objarray[i]]);
            temp+=give;
            ans+=1L*map.get(objarray[i])*give;
            n-=give;
            temp--;
            i++;  
         }
         if(n>0) ans+=1L*n*p;
        
         
         System.out.println(ans);


        }
       
    }
}