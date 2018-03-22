/*
	Author : Kushal Kanti Ghosh
	Roll no: 28
	Assignment 1
	Problem 3
	C++
*/
#include <iostream>
using namespace std;
class TOLLTAX
{
	int cars;
	float totaltoll;
	public:
		TOLLTAX (int c=0,float tax=0)
		{
			cars=c;
			totaltoll=tax;
		}
		void collect_toll()
		{
			float toll;
			cout<<"Enter toll amount : ";
			cin>>toll;
			totaltoll+=toll;
			cars++;
		}
		int display_cars()
		{
			cout<<"Total number of cars that crossed the bridge : ";
			cout<<cars<<endl;
			return cars;
		}
		float display_toll()
		{
			cout<<"Total amount of toll collected : ";
			cout<<totaltoll<<endl;
			return totaltoll;
		}
};

int main()
{
	int test=0;
	TOLLTAX t;
	while(1)
	{
		cout<<"1. Recieve toll \n2. display total cars passed\n"
			<<"3. display total toll collected \n"
			<<"4. Exit\n"
			<<"Enter choice : ";
		cin>>test;
		switch(test)
		{
			case 1:
				t.collect_toll();
				break;
			case 2:
				t.display_cars();
				break;
			case 3:
				t.display_toll();
				break;
			case 4:
				return 0;
			default:
				cout<<"Bad input ..."
					<<"TRY AGAIN ...\n";
		}
		cout<<endl;
	}

return 0;	
}