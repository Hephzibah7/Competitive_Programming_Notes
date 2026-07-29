package r1000.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DoubleEndedStrings {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(br.readLine());
        while(t-- >0){
            String str1=br.readLine();
            String str2=br.readLine();
            int n=str1.length();
            int m=str2.length();
            int dp[][]=new int[n+1][m+1];
            dp[0][0]=0;
            for(int i=1; i<=n; i++){
                for(int j=1; j<=m; j++){
                    if(str1.charAt(i-1)==str2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                }
            }
            int max=0;
            for(int i=0; i<=n; i++){
                for(int j=0; j<=m; j++) max=Math.max(max, dp[i][j]);
            }
            int total=m+n;
            int same=max*2;
            System.out.println(total-same);

        }
       
    }
}
