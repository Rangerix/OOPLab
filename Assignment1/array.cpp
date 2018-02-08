#include <iostream>
using namespace std;

class ARRAY
{
	int size;
	int *elem;
	public:
		ARRAY (int s=0,int v=0);
		ARRAY (const ARRAY &a);
		ARRAY (int s,int *arr);
		int getsize(){ return size; }
		ARRAY operator+(const ARRAY &a);
		ARRAY operator*(int x);
		friend ARRAY operator*(int x,const ARRAY& a);
		void operator=(const ARRAY &a);
		int &operator[](int i) const { return elem[i]; }
		void display();

};

ARRAY::ARRAY(int s,int v){
	size=s;
	if(size)
		elem=new int[size];
	for(int i=0;i<size;i++)
		elem[i]=v;
}

ARRAY::ARRAY (const ARRAY &a)
{
	size=a.size;
	if(size)
		elem=new int[size];
	for(int i=0;i<size;i++)
		elem[i]=a[i];
}
ARRAY::ARRAY (int s,int *arr)
{
	size=s;
	if(size){
		elem=new int[size];
		for(int i=0;i<size;i++)
			elem[i]=arr[i];
	}
}
ARRAY ARRAY::operator+(const ARRAY &a)
{
	int t;
	if(size<a.size)
		t=size;
	else
		t=a.size;
	ARRAY temp(t);
	for(int i=0;i<t;i++)
		temp[i]=elem[i]+a[i];
	return temp;
}

void ARRAY::operator=(const ARRAY& a)
{
	if(size)
		delete elem;
	size=a.size;
	if(size)
		elem=new int[size];
	for(int i=0;i<size;i++)
		elem[i]=a[i];
	//return *this;
}

ARRAY ARRAY::operator*(int x)
{
	int arr[size];
	//arr=new int[size];
	for(int i=0;i<size;i++)
		arr[i]=elem[i]*x;
	ARRAY temp(size,arr);
	return temp;
}

ARRAY operator*(int x,const ARRAY& a)
{
	ARRAY temp(a.size);
	for(int i=0;i<temp.getsize();i++)
		temp[i]=x*a[i];
	return temp;
}

void ARRAY::display()
{
	int i;
	for(i=0;i<size;i++)
		cout<<elem[i]<<" ";
	cout<<endl;
}

int main()
{
	ARRAY a,b,c,d,f;
	int size,e,test;
	int *arr1,*arr2;
	while(1)
	{
		cout<<"\n1. initialize two arrays with an element \n"
			<<"2. initialize an ARRAY with default array \n"
			<<"3. add two arrays\n"
			<<"4. multiply array with constant\n"
			<<"5. multiply constant with array\n"
			<<"6. access an element\n"
			<<"7. exit\n"
			<<"Enter your choice : ";
		cin>>test;
		
		{
			if(1==test){
				cout<<"size of 1st array : ";
				cin>>size;
				cout<<"element to initialize : ";
				cin>>e;
				ARRAY g(size,e);
				a=g;
				cout<<"size of 2nd array : ";
				cin>>size;
				cout<<"element to initialize : ";
				cin>>e;
				ARRAY h(size,e);
				b=h;
				//break;
			}
			else if(2==test){
				cout<<"size of the array : ";
				cin>>size;
				while(size<=0)
				{
					cout<<"Try again ... : ";
					cin>>size;
				}
				arr1=new int[size];
				cout<<"Enter elements : ";
				for(int i=0;i<size;i++)
					cin>>arr1[i];
				ARRAY g1(size,arr1);
				c=g1;
				//break;
			}
			else if (3==test){
				if(a.getsize()&&b.getsize()){
					d=a+b;
					cout<<"two array added \n";
					d.display();
				}
				if(a.getsize()&&c.getsize()){
					d=a+c;
					cout<<"another two added \n";
					d.display();
				}
				if(b.getsize()&&c.getsize())
				{
					d=b+c;
					cout<<"other arrays added \n";
					d.display();
				}
			}
			else if(4==test){
				cout<<"enter constant : ";
				cin>>e;
				if(a.getsize()){
					cout<<"multiplied with first"<<endl;
					d=a*e;
					d.display();
				}
				if(b.getsize()){
					cout<<"multiplied with another \n";
					d=b*e;
					d.display();
				}
				if(c.getsize()){
					cout<<"multiplied\n";
					d=c*e;
					d.display();
				}
			}	//break;
			else if (5==test){
				cout<<"enter constant : ";
				cin>>e;
				if(a.getsize()){
					cout<<"multiplied with first"<<endl;
					d=e*a;
					d.display();
				}
				if(b.getsize()){
					cout<<"multiplied with another \n";
					d=e*b;
					d.display();
				}
				if(c.getsize()){
					cout<<"multiplied\n";
					d=e*c;
					d.display();
				}
			}	//break;
			else if(6==test){
				int flag=0;
				while(1){
					cout<<"enter index : ";
					cin>>e;
					while(e<0){
						cout<<"try again : ";
						cin>>e;
					}
					if(e<a.getsize()){
						cout<<a[e]<<endl;
						if(a.getsize())flag++;
					}
					if(e<b.getsize()){
						cout<<b[e]<<endl;
						if(b.getsize())flag++;
					}
					if(e<c.getsize()){
						cout<<c[e]<<endl;
						if(c.getsize()) flag++;
					}
					if(flag) break;			//atleast one 
					else 
						cout<<"out of bound for all present arrays \n";
				}
			}	//break;
			else if(7==test){
				return 0;
			}
			else
				cout<<"Wrong choice ... try again ... \n";
		}
	}
return 0;
}