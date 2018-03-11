#include <iostream>
#include <cstdlib>
#include <cstring>
#include <string>
#include <ctime>
#include <iomanip>
#include <sstream>
#define CAPA 50
#define MAX_supplyS 50
#define STD_M 2
using namespace std;

class lib;
class date {
	int day, month, year;
	public:
	date() {
		day=1;
		month=1;
		year=1970;
	}
	date(int dd, int mm, int yy) {
		day=dd;
		month=mm;
		year=yy;
	}
	friend ostream& operator<<(ostream&,date);
	static bool is_valid_date(date); 
	static date get_system_date();
	static int days_elapsed(date,date);
};
ostream& operator<<(ostream& out, date dat) {
	out << setfill('0') << setw(2) << dat.day << "/" << setfill('0') << setw(2) << dat.month << "/" << setfill('0') << setw(4) << dat.year;
	return out;
}
date date::get_system_date() {
	time_t rawtime;
	struct tm *timeinfo;
	char buffer[12];
	int dd, mm, yy;
	date sysdate;
	time (&rawtime);
	timeinfo = localtime(&rawtime);
	strftime(buffer,12,"%d/%m/%Y",timeinfo); // estract system time
	string cur_date(buffer);
	dd=atoi(cur_date.substr(0,2).c_str()); // extract day
	mm=atoi(cur_date.substr(3,2).c_str()); // extract month
	yy=atoi(cur_date.substr(6).c_str()); // extract year
	sysdate=date(dd,mm,yy);
	return sysdate;
}
bool date::is_valid_date(date dat) {
	date sysdate=date::get_system_date();
	if (dat.year<1970 || dat.year>2079) return false; // invalid year
	else if (dat.month<1 || dat.month>12) return false; // invalid month
	int days[13]={0,31,28,31,30,31,30,31,31,30,31,30,31};
	bool leap=false;
	if (dat.year%400==0 || (dat.year%100!=0 && dat.year%4==0)) leap=true; // check leap year
	if (leap) days[2]++;
	if (dat.day<1 || dat.day>days[dat.month]) return false;
	if (dat.year>sysdate.year || (dat.year==sysdate.year && dat.month>sysdate.month) || (dat.year==sysdate.year && dat.month==sysdate.month && dat.day>sysdate.day)) // future date
	return false;
	return true;
}
int date::days_elapsed(date beg, date end) {
	int sd=beg.day, sm=beg.month, sy=beg.year;
	int fd=end.day, fm=end.month, fy=end.year;
	int days=0;
	int mnth[13]={0,31,28,31,30,31,30,31,31,30,31,30,31};
	if (sy%400==0 || (sy%100!=0 && sy%4==0)) mnth[2]=29;
	else mnth[2]=28;
	while (!(sd==fd && sm==fm && sy==fy)) {
		sd++;
		if (sd>mnth[sm]) {
			sm++;
			sd=1;
			if (sm>12) {
				sm==1;
				sy++;
				if (sy%400==0 || (sy%100!=0 && sy%4==0)) mnth[2]=29;
				else mnth[2]=28;
			}
		}
		days++;
	}
	return days;
}		
class book {
	string name, code;
	void set_details();
	public:
	void show_details() const;
	friend class lib;
};
class journal {
	string name,journ_supply_no;
	date date_of_publish;
	int volume_no;
	void set_details();
	public:
	void show_details() const;
	friend class lib;
};


class supply {
	int supply_no, no_days, returned;
	date supply_date;
	double fine;
	char supply_type, supplyd_by;
	string b_code, j_code;
	public:
	supply(){no_days=30; returned=0; fine=0.0;}
	void submit_slip();
	void set_fine();
	friend class lib;
};
class lib {
	int no_books, no_journals, no_supplys;
	supply supplys[MAX_supplyS];
	book books[CAPA];
	int book_quantity[CAPA];
	journal journals[CAPA];
	public:
	lib() {
		no_books=0; no_journals=0; no_supplys=0;
	}
	void init_lib();
	int search_book(string) const;
	int search_supply(int) const;
	int search_journal(string) const;
	void supply_book(char);
	void return_book();
	void supply_journal();
};

void book::set_details() {
	cout << "Enter name of the book:" << endl;
	cin.ignore(256,'\n');
	getline(cin,name);
	cout << "Enter code of the book:" << endl;
	cin >> code;
}
void book::show_details() const {
	cout << "Book Name: " << name << endl;
	cout << "Book Code: " << code << endl;
}
void journal::set_details() {
	string publ;
	int dd, mm, yy;
	cout << "Enter name of the journal:" << endl;
	cin.ignore(256,'\n');
	getline(cin,name);
	cout << "Enter supply number of the journal:" << endl;
	cin >> journ_supply_no;
	cout << "Enter volume number: " << endl;
	cin >> volume_no;
	cout << "Enter date of publication: " << endl;
	cin.ignore(256,'\n');
	getline(cin,publ);
	dd=atoi(publ.substr(0,2).c_str());
	mm=atoi(publ.substr(3,2).c_str());
	yy=atoi(publ.substr(6).c_str());
	date_of_publish=date(dd,mm,yy);
}
void journal::show_details() const {
	cout << "Journal Name: " << name << endl;
	cout << "Journal supply Number: " << journ_supply_no << endl;
	cout << "Journal Volume Number: " << volume_no << endl;
	cout << "Journal Publication Date: " << date_of_publish << endl;
}
void supply::set_fine() {
	fine=0.0;
	date cur=date::get_system_date();
	int days=date::days_elapsed(supply_date,cur);
	cout << days << endl;
	if (supplyd_by=='S') {
		fine=1.0*(days-30);
		if (fine<0) fine=0.0;
	}
}	
void lib::init_lib() {
	int ch, quant, flag=1;
	book bk; journal jn;
	while (flag) {
		cout << "1.add books.\n2. add journals\nPress any other key to stop" << endl;
		cin >> ch;
		switch (ch) {
			case 1: bk.set_details();
					books[no_books]=bk;
					cout << "Enter quantity: " << endl;
					cin >> quant;
					book_quantity[no_books]=quant;
					no_books++;
					break;
			case 2: jn.set_details();
					journals[no_journals]=jn;
					no_journals++;
					break;
			default: flag=0;
					 break;
		}
	}
}
int lib::search_book(string bcode) const{
	int pos=-1;
	for (int i=0; i<no_books; i++) {
		if (bcode.compare(books[i].code)==0) {
			pos=i;
			break;
		}
	}
	return pos;
}
int lib::search_journal(string jcode) const{
	int pos=-1;
	for (int i=0; i<no_journals; i++) {
		if (jcode.compare(journals[i].journ_supply_no)==0) {
			pos=i;
			break;
		}
	}
	return pos;
}
int lib::search_supply(int ino) const{
	int pos=-1;
	for (int i=0; i<no_supplys; i++) {
		if (ino==supplys[i].supply_no) {
			pos=i;
			break;
		}
	}
	return pos;
}
void lib::supply_book(char iss_by) {
	string bcode;
	cout << "Enter code of book to be supplyd: " << endl;
	cin >> bcode;
	int pos=search_book(bcode);
	if (pos==-1) {
		cout << "Book not in stock" << endl;
		//cout << "Try again later!" << endl;
	}
	else {
		book supplyd=books[pos];
		if (book_quantity[pos]==0) {
			cout << "Not enough books in stock! " << endl;
			return;
		}
		supplyd.show_details(); // correct
		//cout << "found" << endl;
		supplys[no_supplys]=supply();		
		supply &temp=supplys[no_supplys];
		temp.supply_no=no_supplys+1;
		temp.supply_type='B';
		temp.supplyd_by=iss_by;
		temp.supply_date=date::get_system_date();
		temp.b_code=bcode;
		book_quantity[pos]--;
		cout << "Book supplyd" << endl;
		cout << "supply Number: " << temp.supply_no << endl;
		if (iss_by=='S')
		cout << "Return within 30 days" << endl;
		no_supplys++;
	}
}
void lib::return_book() {
	int icode;
	cout << "Enter supply number of book to be returned: " << endl;
	cin >> icode;
	int pos=search_supply(icode);
	if (pos==-1) {
		cout << "Invalid supply" << endl;
	}
	else {
		supply& temp=supplys[pos];
		temp.returned=1;
		temp.set_fine();
		int pos_bk=search_book(temp.b_code);
		book_quantity[pos_bk]++;
		cout << "Book Returned" << endl;
		if (temp.supplyd_by=='S')
		cout << "Fine: Rs. " << temp.fine << endl;
	}
}
void lib::supply_journal() {
	string jcode;
	cout << "Enter supply number of journal to be supplyd: " << endl;
	cin >> jcode;
	int pos=search_journal(jcode);
	if (pos==-1) {
		cout << "Journal not in stock" << endl;
		cout << "Try again later!" << endl;
	}
	else {
		journal supplyd=journals[pos];
		supplyd.show_details(); // correct
		//cout << "found" << endl;
		supplys[no_supplys]=supply();		
		supply &temp=supplys[no_supplys];
		temp.supply_no=no_supplys+1;
		temp.supply_type='J';
		temp.supplyd_by='F';
		temp.supply_date=date::get_system_date();
		temp.j_code=jcode;
		cout << "Journal supplyd" << endl;
		cout << "supply Number: " << temp.supply_no << endl;
		no_supplys++;
	}
}

int main(void) {
	lib lib;
	cout << "input books and journal: " << endl;
	lib.init_lib();
	int next=0, stop, choice, flag=1, i;
	char type;
	string rno;
	while (flag) {
		cout << "1.issue Book\n2.issue Journal\n3. Return Book\n0. Exit\n" << endl;
		cout << "Enter Your Choice:" << endl;
		cin >> choice;
		switch(choice) {
			case 1: cout << "Enter user type: Student/Faculty (S/F) " << endl;
					cin >> type;
					if (type=='S') {
						cout << "Maximum 2 books can be supplyd at a time" << endl;
						for (i=1; i<=2; i++) {
							cout << "Pess 1 to supply more. Press 0 to stop" << endl;
							cin >> stop;
							if (stop==0) break;
							lib.supply_book('S');
						}
						
					}
					else if (type=='F') {
						cout << "Maximum 10 books can be supplyd at a time" << endl;
						for (i==1; i<=10; i++) {
							cout << "Press 1 to supply more. Press 0 to stop" << endl;
							cin >> stop;
							if (stop==0) break;
							lib.supply_book('F');
						}
					}
					break;
			case 2: lib.supply_journal();
					break;
			case 3: lib.return_book();
					break;
			case 0: flag=0;
					break;
			default: cout << "Invalid Choice" << endl;
		}
	}
	return 0;
}
