//IMPLEMENT A STACK USING TWO QUEUE 
#include <iostream>
#include <queue>
using namespace std;

template< typename T>
class myStack{
	int size;
	int capacity;
	queue<T> q1,q2;												//two queues are used to implement stack
	public:
		myStack(int l=1000){
			size=0;
			capacity=l;
		}
		int push(T x){
			if(size>=capacity)
				return 0;
			size++;
			q2.push(x);
			while(!q1.empty()){									//q1 is maintained in proper order of stack elements
				q2.push(q1.front());							//q2 is used to maintain the order
				q1.pop();
			}													//q2 is kept empty
			while(!q2.empty()){
				q1.push(q2.front());
				q2.pop();
			}
		}
		void pop(){
			if(size<=0){
				cout<<"Empty...\n";
				return ;
			}
			cout<<"Removed element : "<<q1.front()<<endl;
			q1.pop();
			size--;
		}
		int top(){
			if(size<=0){
				cout<<"Empty ...\n";
				return -99999;
			}	
			cout<<q1.front()<<endl;
		}
		int isEmpty(){
			if(size<=0){
				cout<<"Empty \n";
				return 1;
			}
			cout<<"NOT empty\n";
			return 0;
		}
		int getSize(){
			cout<<"Number of elements = "<<size<<endl;
			return size;
		}
};

int main()
{
	int test;
	float elem;
	myStack<float> st;
	while(1){
		cout<<"1. push element\n"
			<<"2. get top element\n"
			<<"3. pop element\n"
			<<"4. check if empty\n"
			<<"5. check size\n"
			<<"6. quit\n"
			<<"Enter choice : ";
		cin>>test;
		if(1==test){
			cout<<"Enter element : ";
			cin>>elem;
			st.push(elem);
		}
		else if(2==test){
			st.top();
		}
		else if(3==test){
			st.pop();
		}
		else if(4==test){
			st.isEmpty();
		}
		else if(5==test){
			st.getSize();
		}
		else if(6==test){
			cout<<"Opted for exit ... \n";
			break;
		}
		else{
			cout<<"Wrong entry, try again ... \n";
		}
		cout<<endl;
	}
	cout<<endl;
return 0;
}