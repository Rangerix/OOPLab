// reading and writing objects in a file in binary mode using class
#include <iostream>
#include <fstream>
#include <cstring>
#include <string>
using namespace std;

class people{
	int age,salary;
	char name[100];
	public:
		people(char *ch,int a,int s){
			strcpy(name,ch);
			age=a;
			salary=s;
		}
		people(){};
		void setsalary(int a){
			salary=a;
		}
		void setage(int a){
			age=a;
		}
		void setname(char *str){
			strcpy(name,str);
		}
		int getsalary(){
			return salary;
		}
		int getage(){
			return age;
		}
		char* getname(){
			return name;
		}
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
	people p1;
	cout<<"Enter name, age & salary :\n";
	while(x--){
		cin>>name;
		cin>>a>>b;
		p1.setname(name);
		p1.setage(a);
		p1.setsalary(b);
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
	people p1;
	int maxsalary=-1;
	char holdername[100];
	while(!myfile.eof()){
		myfile.read((char*)&p1,sizeof(p1));
		if(!myfile) break;
		cout<<p1.getname()<<" "<<p1.getsalary()<<" "<<p1.getage()<<endl;
		if(p1.getsalary()>maxsalary) {
			maxsalary=p1.getsalary();
			strcpy(holdername,p1.getname());
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