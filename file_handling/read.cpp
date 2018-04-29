//read from an existing file
#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main()
{
	ifstream mystr;
	char nname[20];
	cin>>nname;
	mystr.open(nname);
	//mystr.open("File1.txt");
	if(!mystr.is_open()){
		cout<<"Unable to open file\n";
		return 0;
	}
	string s;
	while(1){
		s="";			//in case of whilespace, this holds the previous value
		mystr>>s;		//this type of input operation avoids any whitespace
		cout<<mystr.tellg();
		cout<<s<<endl;
		if(mystr.eof()) break;
	}
	mystr.close();
	return 0;
}
