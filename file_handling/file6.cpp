// reading and writing objects in a file in binary mode
#include <iostream>
#include <fstream>
#include <cstring>
#include <string>
using namespace std;

struct people{
	int age,salary;
	char name[100];
};

void takeinput(void)
{
	int x,a,b;
	string str;
	char name[100];
	fstream myfile;
	cout<<"File name : ";
	cin>>name;
	myfile.open(name,ios::in|ios::out|ios::trunc/*ios::binary|*/);
	if(!myfile.is_open()){
		cout<<"cannot open file\n";
		return;
	}
	cout<<"How many entries : ";
	cin>>x;
	struct people p1;
	cout<<"Enter name, age & salary :\n";
	while(x--){
		cin>>name;
		cin>>a>>b;
		strcpy(p1.name,name);
		p1.age=a;
		p1.salary=b;
		myfile.write((char *)&p1,sizeof(p1));
	}
	myfile.close();
}

void findmaxsalary(void)
{
	char name[100];
	ifstream myfile;
	cout<<"File name : ";
	cin>>name;
	myfile.open(name,ios::in/*|ios::binary*/);
	if(!myfile.is_open()){
		cout<<"cannot open file\n";
		return;
	}
	struct people p1;
	int maxsalary=-1;
	char holdername[100];
	while(!myfile.eof()){
		myfile.read((char*)&p1,sizeof(p1));
		if(!myfile) break;
		cout<<p1.name<<" "<<p1.salary<<" "<<p1.age<<endl;
		if(p1.salary>maxsalary) {
			maxsalary=p1.salary;
			strcpy(holdername,p1.name);
		}
	}
	myfile.close();
	cout<<"Max case : "<<maxsalary<<" "<<holdername<<endl;
}

int main()
{
	takeinput();
	findmaxsalary();
	return 0;
}