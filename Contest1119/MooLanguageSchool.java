// package Contest1119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MooLanguageSchool {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str[]=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            int k=Integer.parseInt(str[1]);
            String s=br.readLine();
            int prefix[]=new int[n+1];
            for(int i=1; i<=n; i++) {
                prefix[i]=prefix[i-1];
                if(s.charAt(i-1)=='0') prefix[i]+=1;
            }
            int count=0;
            for(int i=k; i<=n; i+=k){
                int temp=prefix[i]-prefix[i-k];
                if(temp==0) count++;
            }
            System.out.println(count);

        }

    }
}
