// make a student class, which contains roll,name,score. store them in a file. acces must be for: search a student with
// roll, change score and display all students

#include <iostream>
#include <fstream>
#include <cstring>
using namespace std;

class student
{
	//static int rollflag;
	char name[100];
	int roll;
	float score;
	public:
		student(){};
		student(char* nm,int r,float f)
		{
			strcpy(name,nm);
			roll=r;
			score=f;
		}
		/*~student(){
			delete (name);
		}*/
		int getroll(){
			return roll;
		}
		void display(void){
			cout<<"name : "<<name<<" "<<"\nroll : "<<roll<<" "<<"\nscore : "<<score<<endl;
		}
		void setscore(float f){
			score=f;
		}
};

class studentlist
{
	char filename[100];
	//fstream myfile;
	public:
		studentlist()
		{
			cout<<"Enter file name : ";
			cin>>filename;
		}
		void addstudent()
		{
			ofstream outstr(filename,ios::out|ios::app);
			if(!outstr.is_open()){
				cout<<"cannot open file";
				return ;
			}
			int x;
			cout<<"enter roll : ";
			cin>>x;
			int flag=findstudent(x);
			if(flag!=-1){
				cout<<"already exists"<<endl;
				return;
			}
			cout<<"enter name : \n";
			char nm[100];
			cin.ignore();
			cin.getline(nm,100,'\n');
			cout<<"enter score : ";
			float f;
			cin>>f;
			student s(nm,x,f);
			outstr.write((char*)&s,sizeof(s));
			outstr.close();
		}
		int findstudent(int roll)
		{
			student s;
			ifstream instr(filename);
			if(!instr){
				cout<<"cannot open file\n";
				return -1;
			}
			int found=0;
			while(!instr.eof())
			{
				instr.read((char*)&s,sizeof(s));
				if(!instr) {
					found= -1;
					break;
				}
				if(roll==s.getroll()){
					found=instr.tellg();
					//cout<<"found at : "<<found<<endl;
					break;
				}
			}
			instr.close();
			return found;
		}
		void displaydetails()
		{
			int x;
			cout<<"enter roll : ";
			cin>>x;
			int pos=findstudent(x);
			if(pos==-1){
				cout<<"not found\n";
				return;
			}
			student s;
			ifstream instr(filename);
			instr.seekg((streampos)(pos-sizeof(s)),ios::beg);
			instr.read((char*)&s,sizeof(s));
			s.display();
			instr.close();
		}
		void modifyscore()
		{
			int r;
			cout<<"enter roll : ";
			cin>>r;
			int x=findstudent(r);
			if(x==-1){
				cout<<"not found \n";
				return ;
			}
			student s;
			fstream iostr(filename);
			iostr.seekg((streampos)(x-sizeof(s)),ios::beg);
			iostr.read((char*)&s,sizeof(s));
			//s.display();
			cout<<"enter new score : ";
			float f;
			cin>>f;
			s.setscore(f);
			iostr.seekp((streampos)(x-sizeof(s)),ios::beg);
			iostr.write((char*)&s,sizeof(s));
		}
		void displayall()
		{
			student s;
			ifstream instr(filename);
			if(!instr){
				cout<<"cannot open file\n";
				return ;
			}
			cout<<endl;
			while(!instr.eof())
			{
				instr.read((char*)&s,sizeof(s));
				if(!instr) {
					break;
				}
				s.display();
			}
			instr.close();
		}

};

int main()
{
	studentlist sl;
	int i;
	while(1){
		cout<<"1. Add student \n"
			<<"2. modify score\n"
			<<"3. search student\n"
			<<"4. display all\n"
			<<"5. exit\n"
			<<"Enter choice : ";
		cin>>i;
		cout<<endl;
		if(1==i)
			sl.addstudent();
		//sl.displayall();
		else if(2==i)
			sl.modifyscore();
		else if(3==i)
			sl.displaydetails();
		else if(4==i)
			sl.displayall();
		else if(5==i)
			return 0;
		else
			cout<<"wrong entry...\n";
		cout<<endl;
	}
return 0;
}