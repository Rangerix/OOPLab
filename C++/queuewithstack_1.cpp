//IMPLEMENT A QUEUE WITH TWO STACKS using STL <stack>
#include <iostream>
#include <stack>
using namespace std;

template<typename T>
class myQueue{
	stack<T> s1,s2;											//two stacks are used ... 
	int size;													//elements present
	int capacity;												//highest number of elements can be allocated
	public:
		myQueue(int l=1000){
			capacity=l;
			size=0;
		}
		void Enqueue(T x){
			if(size==capacity){
				cout<<"Queue is full";
				return;
			}													//numbers are stored in s1 in proper order
			while(!s1.empty()){									//s2 is used to maintain this order
				s2.push(s1.top());
				s1.pop();
			}
			s1.push(x);
			while(!s2.empty()){									//s2 is kept empty
				s1.push(s2.top());
				s2.pop();
			}
			size++;
		}
		void displayFirstElem(){
			if(size<1){
				cout<<"Queue is empty \n";
				return ;
				//return -9999;
			}
			cout<<"Element : "<<s1.top()<<endl;
			//return s1.top();
		}
		void Dequeue(){
			if(size<1){
				cout<<"Queue is empty \n";
				return ;
			}
			cout<<"Element : "<<s1.top()<<endl;
			s1.pop();
			size--;
		}
		int isEmpty(){
			if(size<1){
				cout<<"Empty Queue\n";
				return 1;
			}
			cout<<"NOT empty\n";
			return 0;
		}

		int getsize(){
			cout<<"Queue size : "<<size<<endl;
			return size;
		}
};



int main()
{
	myQueue<float> q;
	float x;
	int test;
	while(1){
		cout<<"1. Enqueue Element\n"
			<<"2. Dequeue Element\n"
			<<"3. Check Front Element\n"
			<<"4. Check size\n"
			<<"5. Check if empty\n"
			<<"6. Quit\n"
			<<"Enter choice : ";
		cin>>test;
		if(1==test){
			cout<<"Enter Element : ";
			cin>>x;
			q.Enqueue(x);
		}
		else if(2==test){
			q.Dequeue();
		}
		else if(3==test){
			q.displayFirstElem();
		}
		else if(4==test){
			q.getsize();
		}
		else if(5==test){
			q.isEmpty();
		}
		else if(6==test){
			cout<<"opted for quit \n";
			break;
		}
		else
			cout<<"Invalid input... try again...\n";
		cout<<endl;
	}


return 0;
}