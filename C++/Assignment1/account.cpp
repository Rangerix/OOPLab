#include <iostream>
using namespace std;

#define SAVINGS_FLAG 10000
#define CURRENT_FLAG 20000

class account 
{
	protected:
		int ac_no;
		int index;		//record
		string name;
		int balance;
		int record[10000];
	public:
		int get_balance(){ return balance; };
		int get_acno(){ return ac_no; }
		void deposit(int x);
		virtual int issue(int x)=0;
		void show_history();
};

void account::deposit(int x)
{
	balance+=x;
	record[index++]=x;
	cout<<"successfully deposited amount "<<x<<endl;
}

void account::show_history()
{
	cout<<name<<endl;
	cout<<ac_no<<endl;
	cout<<balance<<endl;
	int i;
	for(i=0;i<index;i++)
		cout<<i+1<<"  "<<record[i]<<endl;
}
//savings account
class savings:public account
{
	public:
		savings(){};
		savings(string nm,int x,int ac){
			name=nm;
			index=0;
			balance=x;
			ac_no=SAVINGS_FLAG+ac;
			cout<<"account no = "<<ac_no<<endl;
		};
		int issue(int x);
};

int savings::issue(int x)
{
	if(balance-x<500){
		cout<<"NOT possible\n";
		return 0;
	}
	balance-=x;
	record[index++]=-x;
	cout<<"transaction successfully occurred ... \n";
	return 1;
}
//current account
class current:public account
{
	public:
		current(){};
		current(string nm,int x,int ac){
			name=nm;
			index=0;
			balance=x;
			ac_no=CURRENT_FLAG+ac;
			cout<<"account no = "<<ac_no<<endl;
		};
		int issue(int x);
};

int current::issue(int x)
{
	if(balance-x<-2000){
		cout<<"NOT possible\n";
		return 0;
	}
	balance-=x;
	record[index++]=-x;
	cout<<"transaction successfully occurred ... \n";
	return 1;
}

int main()
{
	savings s[9];
	current c[9];
	string name;
	int test,y,sno=0,cno=0;
	while(1)
	{
		cout<<"\n1. Open new saings account \n"
			<<"2. Open new current account\n"
			<<"3. Deposit money\n"
			<<"4. withdraw money\n"
			<<"5. see details\n"
			<<"6. Exit \n"
			<<"Enter your choice : ";
		cin>>test;
		if(test==1)
		{
			do{
				cout<<"Enter amount : ";
				cin>>y;
			}while(y<500);
			cout<<"Enter name: ";
			cin>>name;
			savings t(name,y,sno);
			s[sno++]=t;
		}
		else if(test==2)
		{
			do{
				cout<<"Enter amount : ";
				cin>>y;
			}while(y<-2000);
			cout<<"Enter name: ";
			cin>>name;
			current t(name,y,cno);
			c[cno++]=t;
		}
		else if(test==3)
		{
			int i;
			cout<<"enter account no : ";
			cin>>y;
			if(y<CURRENT_FLAG){
				for(i=0;i<sno;i++)
					if(s[i].get_acno()==y) break;
				if(i==sno)
					cout<<"NOT found";
				else{
					cout<<"Enter amount : ";
					cin>>y;
					s[i].deposit(y);
				}
			}
			else{
				for(i=0;i<cno;i++)
					if(c[i].get_acno()==y) break;
				if(i==cno)
					cout<<"NOT found";
				else{
					cout<<"Enter amount : ";
					cin>>y;
					c[i].deposit(y);
				}
			}
		}
		else if(test==4)
		{
			int i;
			cout<<"enter account no : ";
			cin>>y;
			int flag=0;
			if(y<CURRENT_FLAG){
				for(i=0;i<sno;i++)
					if(s[i].get_acno()==y){ 
						flag=1;
						break;
					}
				if(!flag)
					cout<<"NOT found";
				else{
					cout<<"Enter amount : ";
					cin>>y;
					s[i].issue(y);
				}
			}
			else{
				for(i=0;i<cno;i++)
					if(c[i].get_acno()==y){ 
						flag=1;
						break;
					}
				if(!flag)
					cout<<"NOT found";
				else{
					cout<<"Enter amount : ";
					cin>>y;
					c[i].issue(y);
				}
			}
		}
		else if(test==5)
		{
			int i;
			cout<<"enter account no : ";
			cin>>y;
			if(y<CURRENT_FLAG){
				for(i=0;i<sno;i++)
					if(s[i].get_acno()==y) break;
				if(i==sno)
					cout<<"NOT found";
				else{
					s[i].show_history();
				}
			}
			else{
				for(i=0;i<cno;i++)
					if(c[i].get_acno()==y) break;
				if(i==cno)
					cout<<"NOT found";
				else{
					c[i].show_history();
				}
			}
		}
		else if(test==6)
			return 0;
		else
			cout<<"Wrong entry ... try again ... : ";
	}
	return 0;
}