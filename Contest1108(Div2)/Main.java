import java.io.*;
import java.util.*;

public class Main {

    static final long MOD = 1000000007L;

    static long modPow(long a,long b){
        long res=1;
        while(b>0){
            if((b&1)==1) res=res*a%MOD;
            a=a*a%MOD;
            b>>=1;
        }
        return res;
    }

    public static void main(String[] args)throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        while(T-->0){

            int n=Integer.parseInt(br.readLine());

            String[] s=br.readLine().split(" ");

            HashMap<Long,Integer> freq=new HashMap<>();

            for(String x:s){
                long v=Long.parseLong(x);
                freq.put(v,freq.getOrDefault(v,0)+1);
            }

            long ways=1;

            for(int f:freq.values()){
                ways=ways*modPow(2,f-1)%MOD;
            }

            if(!freq.containsKey(-1L)){
                System.out.println(ways);
                continue;
            }

            long ans=ways;

            ArrayList<Long> vals=new ArrayList<>();

            for(long x:freq.keySet()){
                if(x>0) vals.add(x);
            }

            Collections.sort(vals);

            for(int i=0;i+1<vals.size();i++){
                if(vals.get(i+1)==vals.get(i)+1){
                    ans+=ways;
                    if(ans>=MOD) ans-=MOD;
                }
            }

            System.out.println(ans);
        }
    }
}