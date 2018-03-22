#include <iostream>
#include <queue>
using namespace std;

class myStack{
	int totalSize;
	int capacity;
	queue<float> q1,q2;
	public:

		myStack(){
			totalSize=0;
			capacity=(1<<30);
		}
		int push(float x){
			if(totalSize>=capacity)
				return 0;
			totalSize++;
			q2.push(x);
			while(!q1.empty()){
				q2.push(q1.front());
				q1.pop();
			}
			while(!q2.empty()){
				q1.push(q2.front());
				q2.pop();
			}
		}
		int pop(){
			if(totalSize<=0){
				cout<<"Empty queue...\n";
				return 0;
			}
			q1.pop();
			totalSize--;
		}
		int top(){
			if(totalSize<=0){
				cout<<"Empty queue...\n";
				return -99999;
			}	
			cout<<q1.front()<<endl;
		}
		int isEmpty(){
			if(totalSize<=0){
				cout<<"Empty queue\n";
				return 1;
			}
			cout<<"NOT empty\n";
			return 0;
		}
		int getSize(){
			cout<<"Number of elements = "<<totalSize<<endl;
			return totalSize;
		}
};

int main()
{
	int test;
	float elem;
	myStack st;
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
	}
	cout<<endl;
return 0;
}