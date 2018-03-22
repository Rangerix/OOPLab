/*
	Author : Kushal Kanti Ghosh
	Roll no: 28
	Assignment 1
	Problem 5
	C++
*/
#include <iostream>
#include <cstdio>
using namespace std;
#define MAX 20000
class date
{
	int dd,mm,yyyy;
	public:
		date (int d=1,int m=1,int y=2000)
		{
			dd=d;
			mm=m;
			yyyy=y;
		}
		int get_date()
		{
			int d,m,y;
			cout<<"Enter admission date : ";
			int check=scanf("%d-%d-%d",&d,&m,&y);
			if(check!=3) return 0;
			if(!isValid(d,m,y))
				return 0;
			dd=d;
			mm=m;
			yyyy=y;
			return 1;
		}

		int isValid(int day,int month,int year)
		{
			int days[12] = {31,28,31,30,31,30,31,31,30,31,30,31};
			if((year%100==0 && year%400==0) || (year%100!=0 && year%4==0))//leap year
				days[1]=29;
			if(month<1 || month>12)			//validating month
				return 0;
			if(day<0 || day>days[month-1])//validating date
				return 0;
		}
		
};

class student
{
	string name,stream;
	int roll,marks[5];
	date admi_dt;
	public:
		static int count;
		void admission();
		void set_marks();
		void marksheet();
		void date_admission();
		int get_roll();
};

int student::count=0;
void student::admission()
{
	cout<<"Enter student name : ";
	cin.ignore();
	getline(cin,name);
	cout<<"Enter stream : ";
	cin>>stream;
	while(admi_dt.get_date()==0);
	count++;
	roll=100000+count;
	cout<<"Admitted successfully ... \n";
	cout<<"Roll no : "<<roll<<endl;
}

void student::set_marks()
{
	cout<<"Enter marks : \n";
	for(int i=0;i<5;)
	{
		cin>>marks[i];
		if(marks[i]<0||marks[i]>100)
			cout<<"Bad input ... TRY AGAIN ... :";
		else
			i++;
	}
}

void student::marksheet()
{
	cout<<"NAME : "<<name<<endl;
	cout<<"ROLL : "<<roll<<endl;
	cout<<"SUBJECT\t\t\tMARKS\t\n";
	for(int i=0;i<5;i++)
		cout<<"SUBJECT"<<i+1<<"\t\t\t"<<marks[i]<<endl;
}

int student::get_roll()
{
	return roll;
}

int main()
{
	student students[MAX];
	int test,roll_no,flag,i;
	while(1)
	{
		cout<<"1. New Admission \n"
			<<"2. Receive marks \n"
			<<"3. Print marksheet\n"
			<<"4. total admission \n"
			<<"5. Exit\n"
			<<"Enter your choice : ";
		cin>>test;
		switch (test)
		{
			case 1:
				students[student::count].admission();
				break;
			case 2:
				cout<<"Enter roll : ";
				do{
					cin>>roll_no;
					flag=0;
					for(i=0;i<student::count;i++)
					{
						if(students[i].get_roll()==roll_no)
						{
							flag=1;
							break;
						}
					}
					if(flag==0)
					{
						cout<<"Invalid roll no ...\nRe-enter : ";
					}
				}while(flag==0);
				students[i].set_marks();
				break;
			case 3:
				cout<<"Enter roll : ";
				do{
					cin>>roll_no;
					flag=0;
					for(i=0;i<student::count;i++)
					{
						if(students[i].get_roll()==roll_no)
						{
							flag=1;
							break;
						}
					}
					if(flag==0)
					{
						cout<<"Invalid roll no ...\nRe-enter : ";
					}
				}while(flag==0);
				students[i].marksheet();
				break;
			case 4:
				cout<<"Total students admitted : "<<student::count<<endl;
				break;
			case 5:
				cout<<"Exitting ... ";
				return 0;
			default:
				cout<<"Bad input ... ";
				cout<<"TRY AGAIN ... \n";
		}
		cout<<endl;
	}
	return 0;
}