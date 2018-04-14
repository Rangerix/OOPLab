#include <iostream>
#include <algorithm>
#include <queue>
#include <stack>
#include <vector>
using namespace std;


typedef pair<int,int> ii;
int store[10000][3]={0};
int global_index=0;

vector<int> taken;
int index[10000]={0};
priority_queue<pair<int,ii> > pq;          //max heap by default; we have to use - sign for our work
vector<vector<ii> > AdjList;
void process(int vrtx)
{
    taken[vrtx]=1;
    for(int i=0;i<AdjList[vrtx].size();i++){
        ii p = AdjList[vrtx][i];
        int w=-p.second;
        int v=p.first;
        ii p1=make_pair(vrtx,v);
        if(!taken[v]){
            pq.push(make_pair(w,p1));
        }
    }
}

int main()
{
    int vrtx,edge,i,j,a,b,w,s,u,v;
    cout<<"Enter how many vertex : ";
    cin>>vrtx;
    cout<<"Enter how many edges : ";
    cin>>edge;
    AdjList.assign(vrtx,vector<ii> () );
    cout<<"Enter start point , end point , and weight : "<<endl;
    for(i=0;i<edge;i++)
    {
        cin>>a>>b>>w;
        AdjList[a].push_back(ii(b,w));
        AdjList[b].push_back(ii(a,w));
    }
    int cost=0;
    taken.assign(vrtx,0);
    process(0);
    cout<<endl;
    while(!pq.empty()){
        pair<int,ii> temp=pq.top();
        pq.pop();
        int w=-temp.first;
        ii p=temp.second;
        int u=p.first;
        int v=p.second;
        if(!taken[v]){
            cost+=w;
            cout<<u<<" - "<<v<<" : "<<w<<endl;
            process(v);
        }
    }
    cout<<"\nTotal cost : "<<cost<<endl;

return 0;
}