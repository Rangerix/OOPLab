#include <iostream>
using namespace std;

class mystring
{
	int length;
	char *str;
	public:
		mystring (char c,int l=0)
		{
			length=l;
			if(l){
				str=new char[l];
				for(int i=0;i<l;i++)
					str[i]=c;
			}
		}
		mystring (mystring &s)
		{
			length=s.getlength();
			if(length)
			{
				str=new char[length];
				for(int i=0;i<length;i++)
					str[i]=s[i];
			}
		}
		int getlength()
		{
			return length;
		}
};