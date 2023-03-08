//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++
class Solution

{

    public:

    

    bool isvalid(int n,int k,int w,long long int maxi,vector<int> a)

    {

        for(int i=0;i<n;i++)

        {

            if(a[i]<maxi)

            {

                int temp=maxi-a[i];

                k-=temp;

                if(k<0) return false;

                for(int j=i+1;j<min(n,i+w);j++)

                {

                    a[j]+=temp;

                }

            }

        }

        return true;

    }

    

        long long int maximizeMinHeight(int n,int k,int w,vector <int> &a)

        {

            // code here

            int mini=1e9;

            int maxi;

            long long int ans=0;

            for(auto i:a)

            {

                mini=min(mini,i);

            }

            maxi=mini+k;

            

            while(mini<=maxi)

            {

                long long int mid=(mini+maxi)/2;

                if(isvalid(n,k,w,mid,a))

                {

                    ans=mid;

                    mini=mid+1;

                }

                else

                maxi=mid-1;

            }

            return ans;

            

        }

        

};

//{ Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n,k,w;
        cin>>n>>k>>w;
        vector <int> a(n);
        for(auto &j:a)
            cin>>j;
        Solution s;
        cout<<s.maximizeMinHeight(n,k,w,a)<<endl;
    }
    return 0;
}
// } Driver Code Ends