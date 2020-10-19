//
// Created by Saanidhi Arora on 2020-07-31.
//

class Solution {
public:
    int maxProfit(vector<int>& prices)
    {

        int n=prices.size();
        if(n==0 || n==1)
        {
            return 0;
        }
        vector<int> start(n,0);
        vector<int> end(n,0);

        int maxe=INT_MIN;
        int mins=INT_MAX;

        for(int i=0;i<n;i++)
        {
            if(i==0)
            {
                start[i]=0;
                mins=prices[i];
            }

            else{

                if(prices[i]<mins)
                {
                    mins=prices[i];
                    start[i]=start[i-1];
                }
                else
                {
                    start[i]=max(prices[i]-mins,start[i-1]);
                }
            }

        }


        for(int i=n-1;i>=0;i--)
        {    if(i==n-1)
            {
                end[i]=0;
                maxe=prices[i];
            }
            else{

                if(prices[i]>maxe)
                {
                    maxe=prices[i];
                    end[i]=end[i+1];
                }
                else
                {
                    end[i]=max(maxe-prices[i],end[i+1]);
                }
            }
            cout<<end[i]<<endl;
        }

        int ans=INT_MIN;
        for(int i=0;i<n-2;i++)
        {
            ans=max(ans, start[i]+end[i+1]);
        }
        for(int i=0;i<n;i++)
        {
            ans=max(ans, start[i]);
        }
        return ans;
    }
};