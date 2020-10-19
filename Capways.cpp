//
// Created by Saanidhi Arora on 2019-02-20.
//

#include<bits/stdc++.h>
using namespace std;

int countways(vector<vector<int>> pcmap,int ctmask,int p)
{
    if (p == pcmap.size())
    {
        return 1;
    }
    int mycount = 0;

    for (int j = 0; j < pcmap[p].size(); j++)
    {
        if ((ctmask&(1<<pcmap[p][j])) == 0)
        {
            ctmask ^= pcmap[p][j];
            int rcount = countways(pcmap, ctmask, p + 1);
            mycount += rcount;
            ctmask ^= pcmap[p][j];
        }

    }

    return mycount;
}
int main()

{
    int person=3;
    int caps=32;
    bool capstaken[caps+1];
    vector<vector<int>> pcmap={ { 5, 7, 31 },
                                { 2, 7 },
                                { 31,5 } };
    cout<<countways(pcmap,1,0);
    return 0;
}


