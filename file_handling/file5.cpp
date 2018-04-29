//read from binary file and display
#include <iostream>
#include <fstream>
using namespace std;

int main()
{
	fstream myfile;
	char name[100];
	/*cout<<"File name : ";
	cin.get(name,100,'\n');
	myfile.open(name,ios::in|ios::out|ios::binary);*/
	myfile.open("File1.txt",ios::in|ios::out|ios::binary);
	if(!myfile.is_open()){
		cout<<"Cannot open file\n";
		return 0;
	}
	myfile.seekg(0,ios::end);
	int size=(int)myfile.tellg();
	cout<<size<<endl;
	char * mybuffer;
	mybuffer=new char[size];
	myfile.seekg(0,ios::beg);
	myfile.read(mybuffer,size);
	cout<<"mybuffer : "<<mybuffer;
	myfile.close();


return 0;
}
