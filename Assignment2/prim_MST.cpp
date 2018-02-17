#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;


typedef long int tt;
typedef pair<tt,tt> ii;

vector<tt> taken;
priority_queue<ii> pq;          //max heap by default; we have to use - sign for our work
vector<vector<ii> > AdjList;
void process(int vrtx)
{
    taken[vrtx]=1;
    for(tt i=0;i<AdjList[vrtx].size();i++){
        ii v = AdjList[vrtx][i];
        if(!taken[v.first])
            pq.push(ii(-v.second,-v.first));
    }
}

int main()
{
    tt vrtx,edge,i,j,a,b,w,s,u,v;
    cout<<"Enter how many vertex : ";
    cin>>vrtx;
    cout<<"Enter how many edges : ";
    cin>>edge;
    AdjList.assign(vrtx,vector<ii> () );
    cout<<"Enter start point , end point , and weight";
    for(i=0;i<edge;i++)
    {
        cin>>a>>b>>w;
        AdjList[a-1].push_back(ii(b-1,w));
        AdjList[b-1].push_back(ii(a-1,w));
    }
    vector<int> result;
    taken.assign(vrtx,0);
    cin>>s;                                         //Though no need of source; As we can strart with any vertex
    result.push_back(s-1);
    process(s-1);
    tt cost=0;
    
    while(!pq.empty())
    {
        ii tmp=pq.top();
        pq.pop();
        u = -tmp.second;
        w = -tmp.first;
        if(!taken[u]){
            result.push_back(u);
            cost += w;
            process(u);
        }
    }
    for(int result_count=0;result_count<result.size();result_count++)
        cout<<result[result_count]<<" ";
    cout<<endl;
    cout<<cost<<endl;
return 0;
}