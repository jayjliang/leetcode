class Solution {
public:
    int rob(vector<int> &num) {
        int n=num.size();
        if(n==0)
            return 0;
        if(n==1)
            return num[0];
        if(n==1)
            return max(num[0], num[1]);
        int *dp = new int[n];
        dp[0] = num[0];
        dp[1] = max(num[0], num[1]);
        for(int i=2;i<n;i++) {
            dp[i] = max(num[i]+dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }
};

class Solution {
public:
    int rob(vector<int> &num) {
        int n=num.size();
        if(n==0)
            return 0;
        if(n==1)
            return num[0];
        if(n==2)
            return max(num[0], num[1]);
        int pre2 = num[0];
        int pre1 = max(num[0], num[1]);
        int cur;
        for(int i=2;i<n;i++) {
            cur  = max(pre2+num[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return cur;
    }
};

class Solution {
public:
    int rob(vector<int> &num) {
        int dp0 = 0;
        int dp1 = 0;
        for (int i = 0; i < num.size(); i++) {
           int tmp = dp0;
           dp0 = max(dp1, dp0);
            dp1 = tmp+num[i];
         }
        return max(dp0, dp1);
        
    }
};
