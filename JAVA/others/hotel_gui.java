import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class RPanel extends JPanel {
	double acd=200,acs=150,nacd=100,nacs=75;
	JRadioButton rb1,rb2,rb3,rb4;
	ButtonGroup bg;
	RPanel(){
		rb1=new JRadioButton("AC Deluxe");
		rb2=new JRadioButton("non-AC Deluxe");
		rb3=new JRadioButton("AC standard");
		rb4=new JRadioButton("non-AC standard");
		bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		bg.add(rb4);
		add(rb1);
		add(rb2);
		add(rb3);
		add(rb4);
	}		
	double return_room_charge(){
		double cost=0;
		if(rb1.isSelected())
			cost=acd;
		else if(rb2.isSelected())
			cost=nacd;
		else if(rb3.isSelected())
			cost=acs;
		else if(rb4.isSelected())
			cost=nacs;
		return cost;
	}
}

class SPanel extends JPanel {
	double food=200,water=100,chai=10,lassi=50;
	JCheckBox cb1,cb2,cb3,cb4;
	SPanel(){
		cb1=new JCheckBox("food");
		cb2=new JCheckBox("water");
		cb3=new JCheckBox("chai");
		cb4=new JCheckBox("lassi");
		add(cb1);
		add(cb2);
		add(cb3);
		add(cb4);
	}
	double return_service_charge(){
		double cost=0;
		if(cb1.isSelected())
			cost+=food;
		else if(cb2.isSelected())
			cost+=water;
		else if(cb3.isSelected())
			cost+=chai;
		else if(cb4.isSelected())
			cost+=lassi;
		return cost;
	}
}

class charge_calc extends JFrame{
	RPanel rp;
	SPanel sp;
	JLabel l;
	JTextField tf;
	JButton b1,b2;
	JPanel dp,bp;
	charge_calc(){
		super("Rate Calculator");
		rp=new RPanel();
		sp=new SPanel();
		builddisplaypanel();
		buildbuttonpanel();
		setLayout(new BorderLayout());
		add(rp,BorderLayout.WEST);
		add(sp,BorderLayout.CENTER);
		add(dp,BorderLayout.EAST);
		add(bp,BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,500);
		setVisible(true);
	}
	void buildbuttonpanel(){
		b1=new JButton("calulate");
		b2=new JButton("exit");
		bp=new JPanel();
		b1.addActionListener(new MyListener());
		b2.addActionListener(new MyListener());
		bp.add(b1);
		bp.add(b2);

	}
	void builddisplaypanel(){
		tf = new JTextField(10);
		l = new JLabel("Daily charge : \n");
		tf.setEditable(false);
		dp=new JPanel();
		dp.add(l);
		dp.add(tf);
	}
	class MyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae){
			if(ae.getSource()==b1){
				double cost=0;
				cost+= rp.return_room_charge();
				cost+= sp.return_service_charge();
				tf.setText(String.valueOf(cost));
			}
			else{
				System.exit(0);
			}
		}
	}
}
class hotel_gui{
	public static void main(String[] args) {
		new charge_calc();
	}
}