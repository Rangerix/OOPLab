// get and getline
#include <iostream>
#include <fstream>
using namespace std;
void delay(){
	long long int i=99999999;
	while(i--);
}
int main()
{
	fstream myfile;
	char name[100];
	cout<<"File name : ";
	cin>>name;
	myfile.open(name);
	char word[100];
	
	while(!myfile.eof())
	{
		//delay();
		myfile.get (word,100,' ');
		cout<<word<<endl;
		myfile.ignore();		//ignore whitespace
	}
	cout<<"End here ... \n";
	myfile.close();

return 0;
}