#include <iostream>
using namespace std;

class mystring
{
	int size;
	char *elem;
	public:
		mystring (int s=0,char v=' ');
		mystring (const mystring &a);
		mystring (int s,char *arr);
		int getsize(){ return size; }
		mystring operator+(const mystring &a);
		void operator=(const mystring &a);
		int operator==(const mystring &a);
		char &operator[](int i) const { return elem[i]; }
		void display();
};

mystring::mystring(int s,char v){
	size=s;
	if(size)
		elem=new char[size];
	for(int i=0;i<size;i++)
		elem[i]=v;
}

mystring::mystring (const mystring &a)
{
	size=a.size;
	if(size)
		elem=new char[size];
	for(int i=0;i<size;i++)
		elem[i]=a[i];
}
mystring::mystring (int s,char *arr)
{
	size=s;
	if(size){
		elem=new char[size];
		for(int i=0;i<size;i++)
			elem[i]=arr[i];
	}
}
void mystring::operator=(const mystring& a)
{
	if(size)
		delete elem;
	size=a.size;
	if(size)
		elem=new char[size];
	for(int i=0;i<size;i++)
		elem[i]=a[i];
	//return *this;
}

void mystring::display()
{
	int i;
	for(i=0;i<size;i++)
		cout<<elem[i];
	cout<<endl;
}

int mystring::operator==(const mystring &a){
	int flag=0;
	if(a.size!=size)
		return 0;
	for(int i=0;i<size;i++)
		if(elem[i]!=a[i])
			return 0;
	return 1;
}

mystring mystring::operator+(const mystring &a){
	mystring temp(size+a.size);
	int i,j=0;
	for(i=0;i<size;i++)
		temp[j++]=elem[i];
	for(i=0;i<a.size;i++)
		temp[j++]=a[i];
	return temp;
}

int main()
{
	mystring s1,s2;
	int i,test,l1,l2;
	char *a,*b;

	while(1){
		cout<<"\n1. initialize two strings \n"
			<<"2. copy one string into another\n"
			<<"3. concatenate two strings\n"
			<<"4. check whether two strings are identical\n"
			<<"5. Exit\n"
			<<"Enter your choice : ";
		cin>>test;
		if(test==1){
			do{
				cout<<"Enter length of a string : ";
				cin>>l1;
			}while(l1<=0);
			a=new char[l1];
			cout<<"Enter characters : ";
			for(i=0;i<l1;i++)
				cin>>a[i];
			mystring s3(l1,a);
			s1=s3;
			//s1.display();

			do{
				cout<<"Enter length of other string : ";
				cin>>l2;
			}while(l2<=0);
			b=new char[l2];
			cout<<"Enter characters : ";
			for(i=0;i<l2;i++)
				cin>>b[i];
			mystring s4(l2,b);
			s2=s4;
			//s2.display();
		}

		else if(test==2){
			if(s1.getsize()==0&&s2.getsize()==0) {
				cout<<"initialize strings first...\n";
				continue;
			}
			mystring s3,s4;
			if(s1.getsize()){
				s3=s1;
				cout<<"first string copied . \n";
				s3.display();
			}
			if(s2.getsize()){
				s4=s2;
				cout<<"second string copied . \n";
				s4.display();
			}
		}

		else if(test==3){
			if(s1.getsize()==0||s2.getsize()==0) {
				cout<<"initialize strings first...\n";
				continue;
			}
			mystring s3=s1+s2;
			s3.display();

		}
		else if(test==4){
			if(s1.getsize()==0||s2.getsize()==0) {
				cout<<"initialize strings first...\n";
				continue;
			}
			if(s1==s2)
				cout<<"Equal\n";
			else
				cout<<"NOT equal\n";
		}
		else if(test==5){
			cout<<"exitting ...";
			return 0;
		}
		else
			cout<<"Wrong choice ... try again... ";

	}


return 0;
}