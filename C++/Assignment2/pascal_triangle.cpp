#include <iostream>
#include <iomanip>
using namespace std;

void pascal(int row=10)
{
	int table[row+1][row+1];
	int i,j;
	for(i=0;i<=row;i++)
		for(j=0;j<=row;j++)
		{
			if(j==0||i==j)
				table[i][j]=1;
			else if(i>0 && j>0)
				table[i][j]=table[i-1][j]+table[i-1][j-1];
		}
	for(i=0;i<row;i++){
		for(j=0;j<=row-i-2;j++)
			cout<<"  ";
		for(j=0;j<=i;j++)
			cout<<setw(4)<<table[i][j];
		cout<<endl;
	}
}

int main()
{
	pascal();
return 0;	
}