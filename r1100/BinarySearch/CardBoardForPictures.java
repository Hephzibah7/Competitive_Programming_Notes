import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CardBoardForPictures {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str[]=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            long c=Long.parseLong(str[1]);
            String strarr[]=br.readLine().split(" ");
            long arr[]=new long[n];
            for(int i=0; i<n; i++) arr[i]=Long.parseLong(strarr[i]);
            long low=0L;
            long high=1000000000L;
            long ans=0;
            while(low<=high){
                long mid=(1L*(low+high))/2;
                long temp=calc(mid,arr,c);
                if(temp<=c){
                    ans=mid/2;
                    low=mid+1;
                }
                else high=mid-1;
            }
            System.out.println(ans);

        }

    }
    static long calc(long x, long[] arr, long c){
        long sum=0;
        for(int i=0; i<arr.length; i++) {
            sum+=1L*(arr[i]+x)*(arr[i]+x);
            if(sum>c) return c+1; //this line is imp since if sum crosses the max value of long that is 10^18, then any futher sum
            //gives us negative value and thus we can get wrong answer
        }
        return sum;
    }
}
