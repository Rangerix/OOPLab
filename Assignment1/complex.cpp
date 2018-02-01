/*
	Author : Kushal Kanti Ghosh
	2nd year , 2nd sem
	OOP Lab
	Assignment 1
	Question 2
	C++
*/
#include <iostream>
#include <cstdio>
#include <iomanip>			//setw()
using namespace std;
class complex
{
		float real,imaginary;
	public:
		complex(int r=0,int im=0)
		{
			real=r;
			imaginary=im;
		}
		complex operator+(const complex &c2);				//overloading binary + operator
		complex operator-(const complex &c2);				//overloading binary - operator
		complex operator=(const complex &c2);				//overloading = operator
		friend ostream& operator << (ostream &out,const complex &c1); //overloading cout
		friend istream& operator >> (istream &in, complex &c1);			//overloading cin
};

complex complex::operator+(const complex &c2)
{
	complex temp;
	temp.real=real+c2.real;
	temp.imaginary=imaginary+c2.imaginary;
	return temp;
}

complex complex::operator-(const complex &c2)
{
	complex temp;
	temp.real=real-c2.real;
	temp.imaginary=imaginary-c2.imaginary;
	return temp;
}

complex complex::operator=(const complex &c2)
{
	real=c2.real;
	imaginary=c2.imaginary;
	return (*this);
}

ostream& operator << (ostream& out, const complex &c1)
{
	if(c1.real==0 && c1.imaginary==0){
		out<<0;
		return out;
	}
	if(c1.real)
		out<<c1.real;
	if(c1.imaginary<0)
		out<<"-j"<<-1*c1.imaginary;
	else if (c1.imaginary>0){
		if(c1.real) out<<"+";
		out<<"j"<<c1.imaginary;
							//no print when imaginary part is 0
	}
	return out;
}
istream& operator >> (istream& in, complex &c1)
{
	cout<<setw(30)<<"Enter real part : ";
	in>>c1.real;
	cout<<setw(30)<<"Enter imaginary part : ";
	in>>c1.imaginary;
	return in;
}


int main()
{
	int test=0,check;
	while(test!=3){
		complex c1,c2,c3;
		cout<<"\n1. Add two complex numbers \n2. Subtract two complex numbers \n3. Exit \nEnter your choice : ";
		cin>>test;
		//check=scanf("%d",&test);
		//if(!check) test = 99;			//to avoid string inputs
		switch (test)
		{
			case 1:
				cout<<"Enter 1st number : \n";
				cin>>c1;
				cout<<"Enter 2nd number : \n";
				cin>>c2;
				c3=c1+c2;
				cout<<"Result : \n";
				cout<<"( "<<c1<<" ) + ( "<<c2<<" ) = ( "<<c3<<" )"<<endl;
				break;
			case 2:
				cout<<"Enter 1st number : \n";
				cin>>c1;
				cout<<"Enter 2nd number : \n";
				cin>>c2;
				c3=c1-c2;
				cout<<"Result : \n";
				cout<<"( "<<c1<<" ) - ( "<<c2<<" ) = ( "<<c3<<" )"<<endl;
				break;
			case 3:
				cout<<"Exitting ... "<<endl;
				return 0;
			default:
				cout<<test;
				cout<<" Bad input ... ";
				cout<<"Try again ... ";
		}
	}


return 0;
}