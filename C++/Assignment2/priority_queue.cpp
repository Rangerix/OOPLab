/* 		C++ program to implement  priority queue with linked list
		Kushal Kanti Ghosh
		Roll - 28
		Assignment 2
*/
#include <iostream>
#include <cstdlib>
#include <iomanip>
using namespace std;

typedef struct Node
{
	int data;
	int priority;
	struct Node* next;
} node ;

node* newnode(int d,int p)
{
	node* temp=(node*)malloc(sizeof(node));
	temp->data=d;
	temp->priority=p;
	temp->next=NULL;
	return temp;
}

class Priority_Queue
{
	node* front;
	public:
		Priority_Queue(){
			front=NULL;
		}
		void p_insert(int,int);
		void p_top();
		void p_pop();
		int psize();
		int isempty(){
			if(front==NULL) return 1;
			return 0;
		}
		void pdisplay();

};

void Priority_Queue::p_pop()
{
	if(front!=NULL){
		node *temp;
		temp=front;
		front=front->next;
		cout<<"removed item : "<<temp->data<<"\npriority : "<<temp->priority<<endl;
		free(temp);
	}
}

void Priority_Queue::p_top()
{
	/*if(front!=NULL)
		return front->data;*/
	if(front==NULL)
		cout<<"No data \n";
	else
		cout<<"Data = "<<front->data<<"\nPriority = "<<front->priority<<endl;

}

void Priority_Queue::p_insert(int d,int p)
{
	node* q;
	node* temp=newnode(d,p);
	if(front==NULL){
		front=temp;
	}
	else if(front->priority<p)
	{
		temp->next=front;
		front=temp;
	}
	else {
		q=front;
		while(q->next!=NULL && q->next->priority >= p)
			q=q->next;
		temp->next=q->next;
		q->next=temp;
	}
}

int Priority_Queue::psize()
{
	node* temp;
	int count=0;
	temp=front;
	while(temp!=NULL){
		temp=temp->next;
		count++;
	}
	return count;
}

void Priority_Queue::pdisplay()
{
	node* temp;
	if(front==NULL)
	{
		cout<<"Priority_Queue is Empty"<<endl;
		return;
	}
	temp=front;
	cout<<"Item Priority\n";
	while(temp!=NULL)
	{
		cout<<setw(4)<<temp->data;
		cout<<setw(9)<<temp->priority;
		cout<<endl;
		temp=temp->next;
	}
}

int main()
{
	Priority_Queue pq;
	int test;
	int i,j,a,b;
	while(1)
	{
		cout<<"\n1. Add \n"
			<<"2. see top most item\n"
			<<"3. remove top item\n"
			<<"4. display \n"
			<<"5. check if empty\n"
			<<"6. check size\n"
			<<"7. exit\n"
			<<"Enter choice : ";
		cin>>test;
		if(test==1)
		{
			cout<<"enter item : ";
			cin>>a;
			cout<<"enter priority:";
			cin>>b;
			pq.p_insert(a,b);
		}
		else if(test==2)
		{
			pq.p_top();
		}
		else if(test==3)
		{
			pq.p_pop();
		}
		else if(test==4)
		{
			pq.pdisplay();
		}
		else if(test==5)
		{
			if(pq.isempty())
				cout<<"empty \n";
			else
				cout<<"NOT empty\n";
		}
		else if(test==6)
		{
			cout<<pq.psize()<<endl;
		}
		else if(test==7)
			return 0;
		else
			cout<<"Wrong choice ... Try again ... \n";
	}
return 0;
}