//
// Created by Saanidhi Arora on 2020-08-07.
//

class Solution {
public:
    vector<vector<int>> verticalTraversal(TreeNode* root)
    {
        vector<vector<int> >ans;
        if(root==NULL)
        {
            return ans;
        }
        queue<pair<TreeNode *, int> > q;
        q.push(make_pair(root,0));
        map<int,vector<int>> mp;

        while(!q.empty())
        {
            set< pair<int, int>> temp;
            int len=q.size();
            for(int i=0;i<len;i++)
            {
                auto p=q.front();
                q.pop();
                temp.insert(make_pair(p.first->val,p.second));


                if(p.first->left!=NULL)
                {
                    q.push(make_pair(p.first->left,p.second-1));
                }

                if(p.first->right!=NULL)
                {
                    q.push(make_pair(p.first->right,p.second+1));
                }
            }
            for(auto it:temp)
            {
                mp[it.second].push_back(it.first);
            }
        }
        map< int,vector<int> > :: iterator it;
        for (it=mp.begin(); it!=mp.end(); it++)
        {
            ans.push_back(it->second);
        }
        return ans;
    }
};