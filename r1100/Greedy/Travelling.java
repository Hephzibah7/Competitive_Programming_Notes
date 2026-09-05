import java.io.*;
import java.util.*;
/*
if going from a to b, a->b is better than a->s->b, where s is a major city or ordinary city
Taking direct route is always better
But what if a->s s->t t->b where s and t are major cities, this can also be possible minimum route                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
*/
public class Travelling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str[] = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            int a = Integer.parseInt(str[2]);
            int b = Integer.parseInt(str[3]);
            int d = 0;
            long data[][] = new long[n][2];
            while (d < n) {
                String strarr[] = br.readLine().split(" ");
                data[d][0] = Long.parseLong(strarr[0]);
                data[d][1] = Long.parseLong(strarr[1]);
                d++;
            }
            
            long min=dist(data[a-1][0],data[a-1][1],data[b-1][0],data[b-1][1]);
            long minmajor1=Long.MAX_VALUE;
            for(int i=0; i<k; i++){
                minmajor1=Math.min(minmajor1,dist(data[a-1][0],data[a-1][1],data[i][0],data[i][1]));
            }
            long minmajor2=Long.MAX_VALUE;
             for(int i=0; i<k; i++){
                minmajor2=Math.min(minmajor2,dist(data[b-1][0],data[b-1][1],data[i][0],data[i][1]));
            }
            if(minmajor1==Long.MAX_VALUE || minmajor2==Long.MAX_VALUE) System.out.println(min);
            else System.out.println(Math.min(min,minmajor1+minmajor2));
        }

    }

    static long dist(long x1, long y1, long x2, long y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}

/*

Tle - O(n^2 log n)
 * import java.io.*;
 * import java.util.*;
 * // import r1100.BinarySearch.Pair;
 * 
 * public class template {
 * static public class Pair{
 * public int x;
 * public long y;
 * public Pair(int x, long y){
 * this.x=x;
 * this.y=y;
 * }
 * }
 * public static void main(String[] args) throws IOException {
 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * int t=Integer.parseInt(br.readLine());
 * while(t-- >0){
 * String str[]=br.readLine().split(" ");
 * int n=Integer.parseInt(str[0]);
 * int k=Integer.parseInt(str[1]);
 * int a=Integer.parseInt(str[2]);
 * int b=Integer.parseInt(str[3]);
 * int i=0;
 * long data[][]=new long[n][2];
 * while(i<n){
 * String strarr[]=br.readLine().split(" ");
 * data[i][0]=Long.parseLong(strarr[0]);
 * data[i][1]=Long.parseLong(strarr[1]);
 * i++;
 * }
 * PriorityQueue<Pair> pq=new PriorityQueue<>((p1,p2)->Long.compare(p1.y,
 * p2.y));
 * long dist[]=new long[n];
 * Arrays.fill(dist,Long.MAX_VALUE);
 * dist[a-1]=0;
 * pq.add(new Pair(a-1,0L));
 * while(!pq.isEmpty()){
 * Pair pair=pq.remove();
 * int station=pair.x;
 * long val=pair.y;
 * if(station==b-1) {
 * System.out.println(val);
 * break;
 * }
 * for(int next=0; next<n; next++){
 * if(next==station) continue;
 * long w=0;
 * if(station<=k-1 && next<=k-1) w=val;
 * else
 * w=val+Math.abs(data[station][0]-data[next][0])+Math.abs(data[station][1]-data
 * [next][1]);
 * if(dist[next]>w){
 * dist[next]=w;
 * pq.add(new Pair(next,w));
 * }
 * 
 * }
 * 
 * }
 * 
 * 
 * 
 * }
 * 
 * }
 * 
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
