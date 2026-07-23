// package r1000.Constructive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class ShoeShuffling {
     public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            int n=Integer.parseInt(br.readLine());
            String str[]=br.readLine().split(" ");
            long arr[]=new long[n];
            for(int i=0; i<n; i++) arr[i]=Long.parseLong(str[i]);
            HashMap<Long, Integer> map=new HashMap<>();
            for(int i=0; i<n; i++) map.put(arr[i],  map.getOrDefault(arr[i],0)+1);
            boolean check=true;
            for(long key:map.keySet()){
                if(map.get(key)==1) check=false;
            }
            if(check==false) {
                System.out.println(-1);
                continue;
            }
           
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=1; i<=n; i++) list.add(i);
            int l=0;
            int r=0;
            while(l<=r && r<n){
                if(arr[l]==arr[r]) r++;
                else{
                    Collections.rotate(list.subList(l, r), -1);
					l = r;
                }
            }
           
            Collections.rotate(list.subList(l, r), -1);
            StringBuilder sb=new StringBuilder();
            for(int i=0; i<n; i++){
                sb.append(list.get(i)+" ");
            }
            sb.trimToSize();
            System.out.println(sb);

        }
       
    }
}
