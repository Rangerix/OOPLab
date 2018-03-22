/* 
	Author : Kushal Kanti Ghosh
	Roll no: 28
	problem 4
	C++
*/
#include <iostream>
using namespace std;
#define MAX 10000

class item 
{
	string code;
	int quantity;
	string name;
	float rate;
	public:
		item (string c="",int q=0,string nm="",float r=0)
		{
			code=c;
			quantity=q;
			name=nm;
			rate=r;
		}
		void set_rate(float r)
		{
			rate=r;
		}
		float get_rate()
		{
			return rate;
		}
		void set_quantity(int q)
		{
			quantity=q;
		}
		int get_quantity()
		{
			return quantity;
		}
		string get_code()
		{
			return code;
		}
};

class itemlist
{
	item items[MAX];
	public:
		static int item_count;
		int existence(string c);		//returns the position if an element already exists; else -1
		void add_item(string c);		//adds a new item in the list
		void update_rate(string c);		//updates rate of an already existing item
		void update_quantity(string c);	//updates quantity of an already existing item
		void issue_item(string c);		//issues an item ; if possible
		void item_info(string c);		//displays relevant info of an item
		int check_availability(string c,int q);//availability of an item in a particular quantity is checked
		
};
int itemlist::item_count=0;
int itemlist::existence(string c)
{
	int i,flag=0;
	for(i=0;i<item_count;i++)
	{
		if(items[i].get_code()==c)
		{
			flag=1;
			break;
		}
	}
	if(flag)
		return i;
	else
		return -1;
}

void itemlist::add_item(string c)
{
	int i=existence(c);
	if(i!=-1){
		cout<<"item already exists ... "<<endl;		
		return ;
	}
	{
		string nm;
		int qty;
		float rt;
		cout<<"Enter item name : ";
		cin>>nm;
		cout<<"Quantity of the item : ";
		cin>>qty;
		cout<<"Rate : ";
		cin>>rt;
		item temp(c,qty,nm,rt);
		items[item_count++]=temp;
		cout<<"item succeessfully added ..."<<endl;
	}
}

void itemlist::update_quantity(string c)
{
	int i=existence(c);
	if(i==-1)
	{
		cout<<"item does not exist ... ";
		return ;
	}
	else
	{
		int q;
		cout<<"Enter updated quantity of the item : ";
		cin>>q;
		items[i].set_quantity(q);
		cout<<"Quantity updated successfully ... "<<endl;
	}
}

void itemlist::update_rate(string c)
{
	int i=existence(c);
	if(i==-1)
	{
		cout<<"item does not exist "<<endl;
		return ;
	}
	float f;
	cout<<"enter updated rate of the item : ";
	cin>>f;
	items[i].set_rate(f);
	cout<<"rate updated successfully ... "<<endl;
}

void itemlist::item_info(string c)
{
	int i=existence(c);
	if(i==-1)
	{
		cout<<"item does not exist "<<endl;
		return ;
	}
	cout<<"item quantity : "<<items[i].get_quantity()<<endl;
	cout<<"item rate : "<<items[i].get_rate()<<endl;
}

int itemlist::check_availability(string c,int q)
{
	int i=existence(c);
	if(i==-1)
	{
		cout<<"item does not exist "<<endl;
		return -1;
	}
	int q1=items[i].get_quantity();
	if(q1<q)
	{
		cout<<"sorry ... item shortage "<<endl;
		cout<<"availabile quantity : "<<q1<<endl;
		return q1;
	}
	cout<<"Okay ... ready to issue ... :-) "<<endl;
}

void itemlist::issue_item(string c)
{
	int i=existence(c);
	if(i==-1)
	{
		cout<<"item does not exist "<<endl;
		return ;
	}
	int q;
	cout<<"enter required quantity : ";
	cin>>q;
	if(items[i].get_quantity()<q){
		cout<<"item shortage "<<endl;
		return ;
	}
	items[i].set_quantity(items[i].get_quantity()-q);
	float cost=q*(items[i].get_rate());
	cout<<"Total cost : "<<cost<<endl;

}

int main()
{
	itemlist i;
	int test=0,qt;
	string str;
	while(1)
	{
		cout<<"1. Add item \n"
			<<"2. Issue item \n"
			<<"3. See item info\n"
			<<"4. check availability of an item \n"
			<<"5. update rate of an item \n"
			<<"6. update quantity of an item \n"
			<<"7. Exit ... \n"
			<<"Enter your choice : ";
		cin>>test;
		switch(test)
		{
			case 1:
				cout<<"Enter item code : ";
				cin>>str;
				i.add_item(str);
				break;
			case 2:
				cout<<"Enter item code : ";
				cin>>str;
				i.issue_item(str);
				break;
			case 3:
				cout<<"Enter item code : ";
				cin>>str;
				i.item_info(str);
				break;
			case 4:
				cout<<"Enter item code : ";
				cin>>str;
				cout<<"How many : ";
				cin>>qt;
				i.check_availability(str,qt);
				break;
			case 5:
				cout<<"Enter item code : ";
				cin>>str;
				i.update_rate(str);
				break;
			case 6:
				cout<<"Enter item code : ";
				cin>>str;
				i.update_quantity(str);
				break;
			case 7:
				return 0;
			default:
				cout<<"Bad input ... \nTRY AGAIN ... "<<endl;
		}
		cout<<endl;
	}

return 0;	
}