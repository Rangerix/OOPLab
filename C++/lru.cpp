//DESIGN A SIMPLE LRU CACHE
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	int size,query,i,x;
	cin>>size;
	cin>>query;
	string str;
	vector<int> lru,ans;
	for(i=0;i<size;i++)
		lru.push_back(i);
	while(query--){
		cin>>str;
		if(str=="REFERENCE"){
			cin>>x;
			remove(lru.begin(),lru.end(),x);
			lru.push_back(x);
		}
		else if(str=="OUTPUT"){
			cout<<"Least Recently Used : "<<lru[0]<<endl;
			ans.push_back(lru[0]);
		}
	}
	cout<<endl;
	for(i=0;i<ans.size();i++)
		cout<<ans[i]<<endl;

return 0;
}