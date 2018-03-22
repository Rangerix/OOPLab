#include <iostream>
#include <ctime>
#include <cstdlib>
using namespace std;

int simulator(void)
{
	clock_t t=clock();
	srand((int)t+456);		//just random number
	int r=rand()%2;			//even or odd
	return r;
}

void coin_flip(void)
{
	int total_count=0,head_count=0,flag;
	while(head_count<3)
	{
		flag=simulator();
		if(flag){
			cout<<"head\n";
			head_count++;
		}
		else
			cout<<"tail\n";
		total_count++;
	}
	cout<<head_count<<" heads occurred after "<<total_count<<" total flips \n";
}

int main()
{
	int test=1;
	while(1)
	{
		cout<<"Flip coin ? (1 for yes, 0 for no) : ";
		cin>>test;
		if(!test) break;
		coin_flip();
		cout<<endl;
	}
	return 0;
}