//open a file and read from it
#include <iostream>
#include <fstream>
using namespace std;

int main()
{
	ofstream myfile;
	myfile.open("File1.txt");
	myfile<<"This is just opening a file and writing in it\n\n";
	if(myfile.is_open())
		myfile.close();

return 0;
}