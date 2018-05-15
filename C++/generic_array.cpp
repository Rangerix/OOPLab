#include <iostream>
using namespace std;

template <class X>
class myarray{
	X* arr;
	int size;
	public:
	myarray(int x=10){
		size=x;
		arr=new X[size];
	}
	myarray(myarray<X>& ma){
		size=ma.getsize();
		arr=new X[size];
	}
	int getsize(){
		return size;
	}
	template <class Y> friend ostream& operator<< (ostream& ,myarray<Y>& );
	template <class Y> friend istream& operator>> (istream& ,myarray<Y>& );
	myarray<X> operator+ (myarray<X>&);
	X& operator[](int i){
		return (arr[i]);
	}
};

template <class X>
myarray<X> myarray<X>::operator+(myarray<X>& a1){
	if(a1.getsize()!=size){
		cout<<"size error";
		myarray res(a1.getsize()+size);
		return res;
	}
	int size=a1.getsize();
	myarray<X> res(size);
	for(int i=0;i<size;i++){
		res[i]=a1[i]+arr[i];
	}
	return res;
}

template <class Y>
ostream& operator<< (ostream& myout, myarray<Y>& ma){
	int i=0;
	for(i=0;i<ma.getsize();i++)
		myout<<ma[i]<<" ";
	myout<<endl;
	return myout;
}
template <class Y>
istream& operator>> (istream& myin, myarray<Y>& ma){
	for (int i=0;i<ma.getsize();i++)
		myin>>ma[i];
	return myin;
}
int main()
{
	int z;
	cin>>z;
	myarray<int> example(z);
	cin>>example;
	cout<<"size = "<<example.getsize()<<endl;
	cout<<example;
return 0;
}