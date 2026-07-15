import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class ArrayMerging {
     public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
         int n=Integer.parseInt(br.readLine());
         String strarr1[]=br.readLine().split(" ");
         String strarr2[]=br.readLine().split(" ");
         int nums1[]=new int[n];
         int nums2[]=new int[n];
         for(int i=0; i<n; i++){
            nums1[i]=Integer.parseInt(strarr1[i]);
            nums2[i]=Integer.parseInt(strarr2[i]);
         }
         int max1[]=new int[n];
         int max2[]=new int[n];
         max1[n-1]=1;
         max2[n-1]=1;
         for(int i=n-2; i>=0; i--){
            if(nums1[i]==nums1[i+1]) max1[i]=max1[i+1]+1;
            else max1[i]=1;
         }
         for(int i=n-2; i>=0; i--){
            if(nums2[i]==nums2[i+1]) max2[i]=max2[i+1]+1;
            else max2[i]=1;
         }
         HashMap<Integer, Integer> map1=new HashMap<>();
         HashMap<Integer, Integer> map2=new HashMap<>();
         for(int i=0; i<n; i++){
            if(!map1.containsKey(nums1[i])) map1.put(nums1[i],max1[i]);
            else map1.put(nums1[i],Math.max(map1.get(nums1[i]),max1[i]));
         }
         for(int i=0; i<n; i++){
             if(!map2.containsKey(nums2[i])) map2.put(nums2[i],max2[i]);
            else map2.put(nums2[i],Math.max(map2.get(nums2[i]),max2[i]));
         }
       
         int max=0;
         for(int temp:map1.keySet()){
            int x=map1.get(temp);
            int y=(map2.containsKey(temp))?map2.get(temp):0;
            max=Math.max(max,x+y);
         }
         for(int temp:map2.keySet()){
            int x=map2.get(temp);
            int y=(map1.containsKey(temp))?map1.get(temp):0;
            max=Math.max(max,x+y);
         }
         System.out.println(max);

        }
       
    }
}
