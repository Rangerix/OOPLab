/*
	Author : Kushal Kanti Ghosh
	Roll no: 28
	Assignment 1
	Problem 1
	C++
*/
#include <iostream>
#include <string>
using namespace std;
class TIME
{
		int hour, minute, second;
		string ampm;
	public:
		TIME (int h=0,int m=0,int s=0,string ap="")
		{
			hour=h;
			minute=m;
			second=s;
			ampm=ap;
		}
		TIME convert12()
		{
			int th=hour;
			string ap="";
			if(th>=12)
			{
				if(th>12)
					th-=12;
				ap="pm";
			}
			else if(th==0)
			{
				th=12;
				ap="am";
			}
			else
				ap="am";
			TIME t2(th,minute,second,ap);
			return t2;
		}
		TIME convert24()
		{
			int th=hour;
			if(ampm=="am" || ampm=="AM")
			{
				if(hour==12)
					th=0;
			}
			else if(ampm=="pm" || ampm=="PM")
			{
				if(hour!=12)
					th+=12;
			}
			TIME t2(th,minute,second);
			return t2;
		}
		void display( )
		{
			if(hour<10)
				cout<<"0"<<hour<<":";
			else
				cout<<hour<<":";
			if(minute<10)
				cout<<"0"<<minute<<":";
			else
				cout<<minute<<":";
			if(second<10)
				cout<<"0"<<second;
			else
				cout<<second;
			cout<<ampm<<endl;
		}

		TIME addminute( )
		{
			int m;
			cout<<"Enter minutes to add : ";
			cin>>m;
			int tmin=minute+m;
			if(tmin>=60)
			{
				minute=tmin%60;
				hour+=tmin/60;
			}
			hour%=24;
			TIME t2(hour,tmin%60,second);
			return t2;
		}
		int getData()
		{
			string intime;
			cout<<"Enter time in 00:00:00 or 00:00:00am : "<<endl;
			cin>>intime;
			int h=0,m=0,s=0;
			string ap="";

			//Validating input
			if(intime.length()!=8 && intime.length()!=10)
			{
				cout<<"Invalid time format"<<endl;
				return 0;
			}

			//Validating for valid am or pm
			if(intime.length()==10)
			{
				if(intime[2]!=':' || intime[5]!=':')
				{
					cout<<"Invalid time format"<<endl;
					return 0;
				}

				//If time is given in 12 hr format
				ap=intime[8];
				ap+=intime[9];
				if(ampm!="am" && ampm!="pm")
				{
					cout<<"Invalid time format"<<endl;
					return 0;
				}
				else
				{
					h=10*(intime[0]-'0')+(intime[1]-'0');
					m=10*(intime[3]-'0')+(intime[4]-'0');
					s=10*(intime[6]-'0')+(intime[7]-'0');
					//Validating hour
					if(h<=0 || h>=12)
					{
						cout<<"Invalid time format"<<endl;
						return 0;
					}
					//Validating minute
					if(m<0 || m>=60)
					{
						cout<<"Invalid time format"<<endl;
						return 0;
					}
					//Validating second
					if(s<0 || s>=60)
					{
						cout<<"Invalid time format"<<endl;
						return 0;
					}

				}	
			}
			//Validating in 24-hour
			if(intime.length()==8)
			{
				if(intime[2]!=':' || intime[5]!=':')
				{
					cout<<"Invalid time format"<<endl;
					return 0;
				}

				h=10*(intime[0]-'0')+(intime[1]-'0');
				m=10*(intime[3]-'0')+(intime[4]-'0');
				s=10*(intime[6]-'0')+(intime[7]-'0');
				//Validating second
				if(s<0)
				{
					cout<<"Invalid time format"<<endl;
					return 0;
				}
				if(s>=60)
				{
					m+=s/60;
					s%=60;
				}
				//Validating minute
				if(m<0)
				{
					cout<<"Invalid time format"<<endl;
					return 0;
				}
				if(m>=60)
				{
					h+=m/60;
					m%=60;
				}
				//Validating hour
				if(h<0 || h>23)
				{
					cout<<"Invalid time format"<<endl;
					return 0;
				}
				
			}
			hour=h;
			minute=m;
			second=s;
			ampm=ap;
			return 1;

		}
};

int main()
{
	TIME t1,t2;
	int test=0,right;
	while(test!=5)
	{
		cout<<"1. Input time \n2. Convert to 24-hour format \n";
		cout<<"3. Convert to 12-hour format \n4. Add minute \n5. Exit \n";
		cout<<"Enter choice : ";
		cin>>test;
		switch(test)
		{
			case 1:
				do
					right=t1.getData();
				while(!right);
				break;
			case 2:
				t2=t1.convert24();
				t2.display();
				break;
			case 3:
				t2=t1.convert12();
				t2.display();
				break;
			case 4:
				t2=t1.addminute();
				t2.display();
				break;
			case 5:
				return 0;
			default:
				cout<<"Bad input ... ";
				cout<<"	TRY AGAIN ...\n";
		}
	}

return 0;
}