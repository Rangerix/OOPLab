// determine size of a file
#include <iostream>
#include <fstream>
using namespace std;

int main()
{
	char name[100];
	cout<<"File name : ";
	cin>>name;
	fstream myfile(name);
	streampos beg_file,end_file;
	beg_file=myfile.tellg();
	myfile.seekg(0,ios::end);
	end_file=myfile.tellg();
	cout<<(end_file-beg_file)<<endl;

return 0;
}